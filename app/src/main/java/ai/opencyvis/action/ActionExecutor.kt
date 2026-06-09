package ai.opencyvis.action

import android.content.Context
import android.graphics.Point
import ai.opencyvis.backend.PrivilegeBackend
import ai.opencyvis.backend.SystemBackend
import ai.opencyvis.capture.ImageUtil
import ai.opencyvis.engine.StepResult
import ai.opencyvis.input.InputInjector
import kotlinx.coroutines.delay

/**
 * Dispatches Action objects to InputInjector / AppLauncher and returns StepResults.
 * Ported from Python ActionExecutor.
 *
 * @param displayId Target display (0 for physical, >0 for virtual)
 * @param displaySize Fixed display size (for virtual displays with known resolution)
 */
class ActionExecutor(
    private val context: Context,
    private val displayId: Int = 0,
    displaySize: Point? = null,
    private val onOpenAppSuccess: ((packageName: String) -> Unit)? = null,
    backend: PrivilegeBackend = SystemBackend(),
    private val blacklistedPackages: Set<String> = emptySet()
) {

    private val inputInjector = InputInjector(context, displayId, displaySize, backend)
    private val appLauncher = AppLauncher(context, displayId, backend)
    private val launcherPackage: String? by lazy {
        val intent = android.content.Intent(android.content.Intent.ACTION_MAIN)
            .addCategory(android.content.Intent.CATEGORY_HOME)
        context.packageManager.resolveActivity(intent, 0)?.activityInfo?.packageName
    }

    /**
     * Swipe direction -> (startNx, startNy, endNx, endNy).
     * Ported from Python SWIPE_DIRECTIONS.
     */
    private val swipeDirections = mapOf(
        "up" to intArrayOf(500, 700, 500, 300),
        "down" to intArrayOf(500, 300, 500, 700),
        "left" to intArrayOf(700, 500, 300, 500),
        "right" to intArrayOf(300, 500, 700, 500)
    )

    /**
     * Execute an action and return a StepResult.
     */

    suspend fun execute(action: Action, step: Int): StepResult {
        val startTime = System.currentTimeMillis()
        val completed = false  // will be overridden by caller based on LLM response

        if (displayId != 0 && (action is Action.Tap || action is Action.Swipe || action is Action.LongPress)) {
            if (isLauncherOnTop()) {
                val elapsed = System.currentTimeMillis() - startTime
                return StepResult(step, action.typeName,
                    "Cannot tap/swipe on home launcher. Use open_app to launch apps, or list_apps to search.", false,
                    "Action blocked: launcher is the foreground app on virtual display. Use open_app or list_apps instead.", elapsed, false)
            }
        }

        val (success, detail) = try {
            // Apply coordinate compensation for virtual displays that use a top bezel/offset.
            // The AI sees a screenshot that has been shifted down by TOP_BEZEL_Y_PERCENT (6%).
            // y_AI = y_real + offset. Therefore, y_real = y_AI - offset.
            // Since it is a translation (shifting) and NOT scaling, we simply subtract the offset.
            val offsetUnits = if (displayId == 0) 0 else (ImageUtil.TOP_BEZEL_Y_PERCENT * 1000).toInt()
            
            when (action) {
                is Action.Tap -> {
                    var realY = if (offsetUnits > 0) {
                        if (action.y >= offsetUnits) {
                            action.y - offsetUnits
                        } else 0
                    } else action.y
                    
                    // Extra compensation for bottom area (e.g. WeChat/Meituan bottom buttons)
                    // If AI clicks near bottom (y > 900), ensure it doesn't undershoot
                    if (displayId != 0 && action.y > 900) {
                        realY = Math.min(1000, realY + 5)
                    }

                    val ok = inputInjector.tap(action.x, realY)
                    val baseDetail = "Tapped at (${action.x}, ${action.y}) [Compensated Y: $realY]"
                    ok to baseDetail
                }

                is Action.LongPress -> {
                    var realY = if (offsetUnits > 0) {
                        if (action.y >= offsetUnits) {
                            action.y - offsetUnits
                        } else 0
                    } else action.y
                    
                    if (displayId != 0 && action.y > 900) {
                        realY = Math.min(1000, realY + 5)
                    }

                    val ok = inputInjector.longPress(action.x, realY)
                    ok to "Long pressed at (${action.x}, ${action.y}) [Compensated Y: $realY]"
                }

                is Action.OpenApp -> {
                    val result = appLauncher.launch(action.appName)
                    val ok = result.packageName != null
                    if (ok && result.packageName in blacklistedPackages) {
                        false to "Cannot open protected app: ${action.appName}"
                    } else {
                        if (ok) {
                            onOpenAppSuccess?.invoke(result.packageName!!)
                        }
                        ok to result.description
                    }
                }

                is Action.Swipe -> {
                    val coords = swipeDirections[action.direction.lowercase()]
                    if (coords != null) {
                        val ok = inputInjector.swipe(
                            coords[0], coords[1], coords[2], coords[3]
                        )
                        ok to "Swiped ${action.direction}"
                    } else {
                        false to "Unknown swipe direction: ${action.direction}"
                    }
                }

                is Action.KeyEvent -> {
                    val ok = inputInjector.keyEvent(action.key)
                    ok to "Key event: ${action.key}"
                }

                is Action.TypeText -> {
                    val ok = inputInjector.typeText(action.text)
                    ok to "Typed: ${action.text}"
                }

                is Action.Wait -> {
                    delay(2000)
                    true to "Waited 2s"
                }

                is Action.Finish -> {
                    true to "Task finished"
                }

                is Action.Fail -> {
                    false to "Task failed: ${action.reason}"
                }

                is Action.AskUser -> {
                    // Intercepted by AgentEngine before reaching here
                    true to "Asking user: ${action.question}"
                }

                is Action.HandoffUser -> {
                    // Intercepted by AgentEngine before reaching here
                    true to "Handing off to user: ${action.reason}"
                }

                is Action.Note -> {
                    // Intercepted by AgentEngine before reaching here
                    true to "Note: ${action.note}"
                }

                is Action.Remember -> {
                    // Intercepted by AgentEngine before reaching here
                    true to "Remembered: ${action.key}"
                }

                is Action.ListApps -> {
                    val apps = appLauncher.listApps(action.keyword.ifBlank { null })
                    val kw = if (action.keyword.isNotBlank()) " matching '${action.keyword}'" else ""
                    if (apps.isEmpty() && action.keyword.isNotBlank()) {
                        true to "No apps found matching '${action.keyword}'. Try a different keyword, or use list_apps without keyword to see all apps."
                    } else {
                        true to "Installed apps$kw (${apps.size}): ${apps.joinToString(", ")}"
                    }
                }

                is Action.SaveRoutine -> {
                    true to "Routine saved: ${action.routineName}"
                }
            }
        } catch (e: Exception) {
            false to "Error: ${e.message}"
        }

        val duration = System.currentTimeMillis() - startTime

        return StepResult(
            step = step,
            actionType = action.typeName,
            thought = action.thought,
            success = success,
            detail = detail,
            durationMs = duration,
            completed = completed
        )
    }

    fun getTopPackageName(taskId: Int): String? {
        return try {
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            val tasks = am.getRunningTasks(100)
            tasks.find { it.id == taskId }?.topActivity?.packageName
        } catch (e: Exception) {
            android.util.Log.w("ActionExecutor", "Failed to get package for task $taskId: ${e.message}")
            null
        }
    }

    private fun isLauncherOnTop(): Boolean {
        if (displayId == 0) return false
        val pkg = launcherPackage ?: return false
        
        // 尝试通过 ActivityManager 获取任务栈（如果反射被拦截，则回退）
        return try {
            val am = context.getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
            // 注意：在现代 Android 上，getRunningTasks(1) 仅对系统应用或当前应用有效
            // 但在 Virtual Display 环境下，ActivityTaskManager 的行为不同
            val tasks = am.getRunningTasks(1)
            val topPackage = tasks.firstOrNull()?.topActivity?.packageName
            topPackage == pkg
        } catch (e: Exception) {
            // 如果权限或反射彻底失败，我们假设不在 Launcher 上，让动作继续执行
            // 以免阻塞正常的智能体流程
            android.util.Log.w("ActionExecutor", "Failed to check top activity: ${e.message}")
            false
        }
    }
}
