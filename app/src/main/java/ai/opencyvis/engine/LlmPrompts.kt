package ai.opencyvis.engine

import java.util.Locale

object LlmPrompts {

    fun isChinese(): Boolean {
        val lang = Locale.getDefault().language
        return lang == "zh"
    }

    fun systemPrompt(): String = if (isChinese()) SYSTEM_PROMPT_ZH else SYSTEM_PROMPT_EN

    fun toolDescription(): String = if (isChinese()) TOOL_DESC_ZH else TOOL_DESC_EN

    fun paramDescription(key: String): String {
        val map = if (isChinese()) PARAM_DESCS_ZH else PARAM_DESCS_EN
        return map[key] ?: key
    }

    fun guardFeedback(key: String): String {
        val map = if (isChinese()) GUARD_ZH else GUARD_EN
        return map[key] ?: key
    }

    fun agentFeedback(key: String): String {
        val map = if (isChinese()) AGENT_FEEDBACK_ZH else AGENT_FEEDBACK_EN
        return map[key] ?: key
    }

    // ── System prompts ──────────────────────────────────────────────────

    private const val SYSTEM_PROMPT_EN = """You are an Android control agent. Observe screenshots and output MINIMAL JSON.

Rules:
1. Coordinate system: 0-1000 normalized, (0,0)=top-left, (1000,1000)=bottom-right
2. Output ONLY a valid JSON object. No explanation, no markdown.
3. Keep 'thought' field under 10 words and ONLY for finish/fail/ask_user/handoff_user. Omit it for intermediate taps/swipes.
4. When finished, use finish and put the result in 'thought'.

Efficiency:
- Use type_text for all content at once; tap the field first to focus.
- Use open_app(app_name) directly instead of swiping to find icons.
- [CRITICAL] Never tap launcher UI (app drawer/search bar). Use open_app.
- If the screen hasn't changed after two steps, change strategy.

Actions: tap(x,y), open_app(app_name), list_apps(keyword), swipe(direction), key_event(key), type_text(text), wait, finish, fail, ask_user(question), handoff_user(reason), note, remember(key,value,category)
- note: 'key: value' to track data (e.g. 'Price: 599').

Example: {"action_type":"tap","x":500,"y":500}"""

    private const val SYSTEM_PROMPT_ZH = """你是 Android 操控助手。通过截图进行极简 JSON 决策。

【回复规范】
- 必须且仅输出一个合法的 JSON 对象。
- 严禁任何解释、思考、Markdown 标签。
- 极速响应：'thought' 字段仅限 finish/fail/ask_user/handoff_user 使用（限20字内），中间步骤严禁输出 thought 以节省 Token。

【高效原则】
1. 坐标系：0-1000 归一化。状态栏区域 (y < 60) 禁止点击。
2. 输入文字：必须先 tap 点击输入框，点击后即使屏幕无变化（如未见键盘）也应立即执行 type_text。
3. 微信专项：找不到联系人点右上角搜索图标，输入全名并点击结果。发消息必须严格执行“点击输入框 -> type_text -> 点击发送按钮”。即便看到历史记录有相同内容，也必须重新发送，严禁提前终止。如果没看到发送按钮，尝试 key_event("enter")。
4. 容错：连续两步屏幕无变化须更换策略。不要点击主屏幕图标，优先用 open_app。

【操作说明】
可用操作：tap(x,y), open_app(app_name), list_apps(keyword), swipe(direction), key_event(key), type_text(text), wait, finish, fail, ask_user(question), handoff_user(reason), note, remember(key,value,cat)
- note：记录关键信息（如 '价格: 599元'），在后续步骤可见。

示例：{"action_type":"tap","x":500,"y":500}"""

    // ── Tool descriptions ───────────────────────────────────────────────

    private const val TOOL_DESC_EN = "Perform phone actions. Choose the appropriate action based on the current screen state."
    private const val TOOL_DESC_ZH = "执行手机操作。根据当前屏幕状态选择合适的操作。"

    private val PARAM_DESCS_EN = mapOf(
        "thought" to "Analysis of the current screen and reasoning for the decision",
        "action_type" to "Action type",
        "x" to "Tap x-coordinate, 0-1000 normalized",
        "y" to "Tap y-coordinate, 0-1000 normalized",
        "app_name" to "App name to open (for open_app), e.g. settings",
        "keyword" to "Keyword to search installed apps (for list_apps), e.g. weather",
        "direction" to "Swipe direction (for swipe)",
        "key" to "Key name (for key_event)",
        "text" to "Text to input (for type_text)",
        "reason" to "Failure reason (for fail)",
        "question" to "Question for the user when clarification or confirmation is needed (for ask_user)",
        "handoff_reason" to "Explanation when the user needs to input passwords, PINs, payment passwords, lock screen passwords, or other sensitive information on the device directly (for handoff_user). Do not ask the user to tell the agent sensitive information.",
        "note" to "Temporary note for the current task (e.g., key info like prices, model numbers), format 'key: value' (e.g., 'JD price: 5999 yuan'). Visible in subsequent steps of this task. Can be used together with any action_type, or alone with action_type=note to only record without performing an action.",
        "memory_key" to "Unique key for long-term memory (for remember), e.g. 'default city', 'user dietary preferences'",
        "memory_value" to "Long-term memory content (for remember)",
        "memory_category" to "Long-term memory category (for remember), e.g. preference, profile, workflow",
        "routine_name" to "Short name for the routine (2-5 words), e.g. 'Check emails'",
        "routine_icon" to "Single emoji icon for the routine, e.g. '📧'",
        "routine_instruction" to "The instruction to save. If omitted, the current conversation's original instruction is used",
        "schedule_type" to "Schedule type: time (fixed daily/weekly time), interval (every N minutes), geofence (location-based trigger)",
        "schedule_time" to "Time in HH:MM format, e.g. '08:00' (for schedule_type=time)",
        "schedule_repeat" to "Repeat pattern: 'daily', 'weekdays', or comma-separated days '1,3,5' where Mon=1..Sun=7 (for schedule_type=time)",
        "schedule_interval" to "Interval in minutes, e.g. 30 (for schedule_type=interval)",
        "schedule_location" to "Location name, e.g. 'office', 'home' (for schedule_type=geofence). Uses current location coordinates.",
        "schedule_on_enter" to "true=trigger on arrival, false=trigger on departure (for schedule_type=geofence)",
        "suggested_routine_name" to "When finishing a repeatable task, suggest a short routine name (2-5 chars). Omit for one-off tasks.",
        "suggested_routine_icon" to "When finishing a repeatable task, suggest a single emoji icon. Omit for one-off tasks."
    )

    private val PARAM_DESCS_ZH = mapOf(
        "thought" to "对当前屏幕的分析和决策理由",
        "action_type" to "操作类型",
        "x" to "点击的x坐标，0-1000归一化",
        "y" to "点击的y坐标，0-1000归一化",
        "app_name" to "要打开的应用名（open_app时使用），如 settings",
        "keyword" to "搜索已安装应用的关键词（list_apps时使用），如 天气",
        "direction" to "滑动方向（swipe时使用）",
        "key" to "按键名（key_event时使用）",
        "text" to "要输入的文本（type_text时使用）",
        "reason" to "失败原因（fail时使用）",
        "question" to "当需要用户澄清或确认时的问题（ask_user时使用）",
        "handoff_reason" to "当需要用户亲自在设备上输入密码、PIN、支付密码、锁屏密码等敏感信息时的说明（handoff_user时使用）。不要请求用户把敏感信息告诉agent。",
        "note" to "当前任务内临时笔记（如价格、型号等关键信息），格式为 'key: value'（如 '京东价格: 5999元'）。会在本任务后续步骤可见。可与任何 action_type 同时使用，也可单独用 action_type=note 只记录不操作。",
        "memory_key" to "长期记忆的唯一键名（remember时使用），例如 '默认城市'、'用户饮食偏好'",
        "memory_value" to "长期记忆内容（remember时使用）",
        "memory_category" to "长期记忆分类（remember时使用），例如 preference、profile、workflow",
        "routine_name" to "例行任务的简短名称（2-5个字），如 '查邮件'",
        "routine_icon" to "例行任务的 emoji 图标，如 '📧'",
        "routine_instruction" to "要保存的指令。省略时使用当前对话的原始指令",
        "schedule_type" to "定时类型：time（固定时间）、interval（间隔重复）、geofence（位置触发）",
        "schedule_time" to "时间，HH:MM 格式，如 '08:00'（schedule_type=time 时使用）",
        "schedule_repeat" to "重复模式：'daily'（每天）、'weekdays'（工作日）、或自定义 '1,3,5'，周一=1..周日=7",
        "schedule_interval" to "间隔分钟数，如 30（schedule_type=interval 时使用）",
        "schedule_location" to "地点名称，如 '公司'、'家'（schedule_type=geofence 时使用）",
        "schedule_on_enter" to "true=到达时触发，false=离开时触发（schedule_type=geofence 时使用）",
        "suggested_routine_name" to "完成可重复任务时，建议一个简短的例行任务名称（2-5字）。一次性任务不需要。",
        "suggested_routine_icon" to "完成可重复任务时，建议一个 emoji 图标。一次性任务不需要。"
    )

    // ── ActionRepeatGuard feedback ──────────────────────────────────────

    private val GUARD_EN = mapOf(
        "repeated_type_text" to "The same text was already typed in the previous step. Do not repeat the same input.",
        "repeated_submit" to "The same submit key was already pressed in the previous step, and the screen has not changed significantly.",
        "repeated_tap" to "Nearly the same position was already tapped in the previous step, and the screen has not changed significantly.",
        "escalation_high" to " If there might be a system confirmation, permission, installation, or external dialog not visible in the virtual display, please use ask_user to ask the user for help.",
        "escalation_low" to " Please try a different strategy; if you need user confirmation, use ask_user."
    )

    private val GUARD_ZH = mapOf(
        "repeated_type_text" to "上一步已经输入过相同文本，不要重复执行同一输入。",
        "repeated_submit" to "上一步已经执行过相同的提交按键，当前屏幕没有明显变化。",
        "repeated_tap" to "上一步已经点击过几乎相同的位置，当前屏幕没有明显变化。",
        "escalation_high" to " 如果可能存在虚拟显示器看不到的系统确认、权限、安装或外部弹窗，请使用 ask_user 向用户求助。",
        "escalation_low" to " 请换一种策略；如果需要用户确认，请使用 ask_user。"
    )

    // ── AgentEngine runtime feedback ────────────────────────────────────

    private val AGENT_FEEDBACK_EN = mapOf(
        "vd_blank_hint" to "(Note: this is a screenshot of the virtual display. If you're not sure which app to open, use list_apps(keyword) first to check available apps. Then use open_app with the exact name. Do NOT tap or swipe on the home screen.)",
        "handoff_default_reason" to "The app requires you to input sensitive information on the device directly",
        "handoff_completed" to "The user has completed the sensitive input takeover and returned control (%s). Please re-observe the current screen and continue the task; if sensitive input is still needed, continue using handoff_user, do not ask for passwords.",
        "action_failed" to "Previous action failed: %s",
        "screen_unchanged" to "The screen content is unchanged after your %s action. Your previous action may not have had the intended effect. Try a different approach — do not repeat the same action.",
        "screen_stuck" to "The screen has not changed for multiple consecutive steps. Your repeated actions are having no visible effect. STOP repeating the same approach. If you were trying to tap an input field, try type_text directly — the field may already be focused even though you cannot see the keyboard. If tap is not working at all, try a completely different strategy.",
        "max_steps_reached" to "Max steps reached (%d)",
        "user_answer_prefix" to "User's answer: %s\nPlease continue completing the task based on the user's answer: ",
        "system_feedback_prefix" to "[System Feedback] %s\nPlease adjust your strategy based on the feedback; if needed, use ask_user to ask the user for help.\n\n",
        "ui_elements_header" to "\n\n### Current UI Elements ###\n",
        "user_supplement_header" to "\n\n### User Supplemental Info ###\n",
        "global_memory_header" to "\n\n### Global Memory ###\n",
        "notes_header" to "\n\n### Recorded Notes (Memory) ###\n"
    )

    private val AGENT_FEEDBACK_ZH = mapOf(
        "vd_blank_hint" to "（注意：这是虚拟显示器的截图。如果不确定要打开哪个应用，先用 list_apps(keyword) 搜索已安装应用，再用 open_app 打开。不要点击或滑动主屏幕。）",
        "handoff_default_reason" to "需要你亲自在设备上输入敏感信息",
        "handoff_completed" to "用户已完成敏感输入接管并交还控制（%s）。请重新观察当前屏幕继续任务；如果仍然需要敏感输入，继续使用 handoff_user，不要询问密码。",
        "action_failed" to "上一步操作失败：%s",
        "action_success" to "上一步操作成功：%s",
        "screen_unchanged" to "执行 %s 操作后屏幕内容没有变化。上一步操作可能未生效，请换一种方式操作，不要重复相同的动作。",
        "screen_stuck" to "屏幕已连续多步没有变化，你重复的操作没有产生任何可见效果。立即停止重复相同的方式。如果你一直在尝试点击输入框，请直接使用 type_text —— 输入框可能已经获得焦点，只是键盘没有显示在截图中。如果点击完全无效，请尝试完全不同的策略。",
        "max_steps_reached" to "已达到最大步数限制 (%d)",
        "user_answer_prefix" to "用户回答：%s\n请根据用户回答继续完成任务：",
        "system_feedback_prefix" to "【系统反馈】%s\n请根据反馈调整策略，必要时用 ask_user 向用户求助。\n\n",
        "ui_elements_header" to "\n\n### 当前界面元素 (UI Elements) ###\n",
        "user_supplement_header" to "\n\n### 用户补充信息 ###\n",
        "global_memory_header" to "\n\n### 全局记忆 ###\n",
        "notes_header" to "\n\n### 已记录的笔记 (Memory) ###\n"
    )
}
