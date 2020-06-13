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

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.parseColor("#99F2F2F2")
    }

    var drawBackground = false

    override fun onDraw(canvas: Canvas) {
        if (drawBackground) {
            var x = xChartMin + GraphFragment.DAY
            while (x < xChartMax) {
                val bl = mLeftAxisTransformer.getPixelForValues(x, yMin)
                val tr = mLeftAxisTransformer.getPixelForValues(x + GraphFragment.DAY, yMax)
                canvas.drawRect(
                    bl.x.toFloat(),
                    tr.y.toFloat(),
                    tr.x.toFloat(),
                    bl.y.toFloat(),
                    paint
                )
                x += GraphFragment.DAY * 2
            }
        }
        super.onDraw(canvas)
    }
}