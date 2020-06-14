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
        val count = data?.getDataSetByIndex(0)?.entryCount ?: 0
        if (drawBackground && count > 0) {
            val x = mLeftAxisTransformer.getPixelForValues(xChartMin, 0f).x.toFloat()
            val width = mLeftAxisTransformer.getPixelForValues(xChartMin + xRange / count, 0f)
                .x.toFloat() - x
            (0 until ((xChartMax - xChartMin) / GraphFragment.DAY).toInt() + 1).forEach {
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
}