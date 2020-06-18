package ru.agrointellect.screen.chart

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.BarLineChartBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.renderer.XAxisRenderer
import com.github.mikephil.charting.utils.Transformer
import com.github.mikephil.charting.utils.ViewPortHandler

const val DAY = 86400f

const val WEEK = 7 * DAY

fun BarLineChartBase<*>.setDateLabels(centerLabels: Boolean) {
    setXAxisRenderer(
        DateLabelsXAxisRenderer(
            viewPortHandler,
            xAxis,
            getTransformer(axisLeft.axisDependency),
            centerLabels
        )
    )
}

private class DateLabelsXAxisRenderer(
    viewPortHandler: ViewPortHandler,
    xAxis: XAxis,
    transformer: Transformer,
    var centerLabels: Boolean
) : XAxisRenderer(viewPortHandler, xAxis, transformer) {

    override fun computeAxisValues(min: Float, max: Float) {
        with(mAxis) {
            val count = (mAxisRange / DAY).toInt()
            val extra = if (centerLabels) 0.5f else 0f
            if (mEntries.size != count) {
                mEntries = FloatArray((mAxisRange / DAY).toInt()) {
                    mAxisMinimum + (it + extra) * DAY
                }
            } else {
                mEntries.indices.forEach {
                    mEntries[it] = mAxisMinimum + (it + extra) * DAY
                }
            }
            mEntryCount = mEntries.size
            computeSize()
        }
    }
}

class BarGraph @JvmOverloads constructor(
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
            val xPx = xAxisToPixels(xChartMin)
            val width = xAxisToPixels(xChartMin + DAY) - xPx
            (0 until (xRange / DAY).toInt()).forEach {
                if (it % 2 != 0) {
                    canvas.drawRect(
                        xPx + it * width,
                        contentRect.top,
                        xPx + (it + 1) * width,
                        contentRect.bottom,
                        backgroundPaint
                    )
                }
            }
        }
        super.onDraw(canvas)
    }

    private fun xAxisToPixels(x: Float): Float {
        return mLeftAxisTransformer.getPixelForValues(x, 0f).x.toFloat()
    }
}