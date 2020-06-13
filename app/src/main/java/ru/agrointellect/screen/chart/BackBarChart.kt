package ru.agrointellect.screen.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart
import kotlin.math.roundToInt

class BackBarChart @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : BarChart(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#99F2F2F2")
    }

    var drawBackground = false

    override fun onDraw(canvas: Canvas) {
        if (drawBackground) {
            val min = mLeftAxisTransformer.getPixelForValues(xChartMin, yMin)
            val max = mLeftAxisTransformer.getPixelForValues(xChartMin + GraphFragment.DAY, yMax)
            val width = (max.x - min.x).toFloat()
            (0 until ((xChartMax - xChartMin) / GraphFragment.DAY).roundToInt()).forEach {
                if (it % 2 != 0) {
                    canvas.drawRect(
                        min.x.toFloat() + it * width,
                        min.y.toFloat(),
                        min.x.toFloat() + width * (it + 1),
                        max.y.toFloat(),
                        paint
                    )
                }
            }
        }
        super.onDraw(canvas)
    }
}