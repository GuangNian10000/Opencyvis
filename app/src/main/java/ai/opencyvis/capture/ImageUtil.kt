package ai.opencyvis.capture

import android.graphics.Bitmap
import android.graphics.Matrix
import android.util.Base64
import java.io.ByteArrayOutputStream

/**
 * Bitmap manipulation utilities: resize, rotate, convert to JPEG base64.
 */
object ImageUtil {

    private const val MAX_WIDTH = 512
    private const val JPEG_QUALITY = 60

    /**
     * Resize bitmap so its width does not exceed [maxWidth], preserving aspect ratio.
     */
    fun resizeToMaxWidth(bitmap: Bitmap, maxWidth: Int = MAX_WIDTH): Bitmap {
        if (bitmap.width <= maxWidth) return bitmap
        val scale = maxWidth.toFloat() / bitmap.width
        val newHeight = (bitmap.height * scale).toInt()
        return Bitmap.createScaledBitmap(bitmap, maxWidth, newHeight, true)
    }

    /**
     * Rotate bitmap by [degrees].
     */
    fun rotate(bitmap: Bitmap, degrees: Float): Bitmap {
        if (degrees == 0f) return bitmap
        val matrix = Matrix().apply { postRotate(degrees) }
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
    }

    /**
     * Convert RGBA bitmap to RGB by drawing onto an RGB_565 or ARGB_8888 canvas
     * without alpha, then encode as JPEG.
     */
    fun convertToRgb(bitmap: Bitmap): Bitmap {
        if (bitmap.config == Bitmap.Config.RGB_565) return bitmap
        val rgbBitmap = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(rgbBitmap)
        canvas.drawColor(android.graphics.Color.WHITE)
        canvas.drawBitmap(bitmap, 0f, 0f, null)
        return rgbBitmap
    }

    fun toJpegBytes(bitmap: Bitmap, quality: Int = JPEG_QUALITY): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, quality, stream)
        return stream.toByteArray()
    }

    fun toJpegBase64(bitmap: Bitmap, quality: Int = JPEG_QUALITY): String {
        return Base64.encodeToString(toJpegBytes(bitmap, quality), Base64.NO_WRAP)
    }

    /**
     * Top offset (bezel) to avoid status bar overlap. 
     * Shifting the app content down so system icons don't block app buttons.
     * This 6% margin (60 units in 0-1000 scale) provides a safe "status bar" area.
     */
    const val TOP_BEZEL_Y_PERCENT = 0.06f

    fun processScreenshotToBytes(bitmap: Bitmap, applyBezel: Boolean = true): ByteArray {
        val resized = resizeToMaxWidth(bitmap)
        val rgb = convertToRgb(resized)
        
        val finalBitmap = if (applyBezel) {
            // Create a new bitmap with a "bezel" at the top.
            // Scale the app content to fit in the remaining height to avoid cutting off the bottom.
            val bezelBitmap = Bitmap.createBitmap(rgb.width, rgb.height, Bitmap.Config.ARGB_8888)
            val canvas = android.graphics.Canvas(bezelBitmap)
            canvas.drawColor(android.graphics.Color.BLACK) // Bezel color
            
            val offsetPx = rgb.height * TOP_BEZEL_Y_PERCENT
            val destRect = android.graphics.RectF(0f, offsetPx, rgb.width.toFloat(), rgb.height.toFloat())
            // Draw scaled content to preserve all app pixels within the visible area
            val paint = android.graphics.Paint(android.graphics.Paint.FILTER_BITMAP_FLAG)
            canvas.drawBitmap(rgb, null, destRect, paint)
            bezelBitmap
        } else {
            rgb
        }
        
        val bytes = toJpegBytes(finalBitmap)
        
        if (finalBitmap !== rgb) finalBitmap.recycle()
        if (rgb !== resized) rgb.recycle()
        if (resized !== bitmap) resized.recycle()
        return bytes
    }

    fun processScreenshot(bitmap: Bitmap, applyBezel: Boolean = true): String {
        return Base64.encodeToString(processScreenshotToBytes(bitmap, applyBezel), Base64.NO_WRAP)
    }
}
