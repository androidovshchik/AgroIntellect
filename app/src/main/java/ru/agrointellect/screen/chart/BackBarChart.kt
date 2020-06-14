package ru.agrointellect.screen.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart

class BackBarChart @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BarChart(context, attrs, defStyleAttr) {

    private val backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#99F2F2F2")
    }

    var drawBackground = false

    override fun onDraw(canvas: Canvas) {
        if (drawBackground) {
            val x = toPixels(xChartMin)
            val width = toPixels(xChartMin + GraphFragment.DAY) - x
            (0 until (xRange / GraphFragment.DAY).toInt() + 1).forEach {
                if (it % 2 != 0) {
                    canvas.drawRect(
                        x + it * width,
                        contentRect.top,
                        x + (it + 1) * width,
                        contentRect.bottom,
                        backgroundPaint
                    )
                }
            }
        }
        super.onDraw(canvas)
    }

    private fun toPixels(x: Float): Float {
        return mLeftAxisTransformer.getPixelForValues(x, 0f).x.toFloat()
    }
}