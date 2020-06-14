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
import timber.log.Timber
import kotlin.math.abs

fun BarLineChartBase<*>.setSpecificLabels() {
    setXAxisRenderer(
        SpecificLabelsXAxisRenderer(viewPortHandler, xAxis, getTransformer(axisLeft.axisDependency))
    )
}

private class SpecificLabelsXAxisRenderer(
    viewPortHandler: ViewPortHandler,
    xAxis: XAxis,
    transformer: Transformer
) : XAxisRenderer(viewPortHandler, xAxis, transformer) {

    override fun computeAxisValues(min: Float, max: Float) {
        /*Timber.e("min ${min.toLong()} max ${max.toLong()} ${((max - min) / GraphFragment.DAY).toInt()}")
        mAxis.apply {
            mEntries = FloatArray(((max - min) / GraphFragment.DAY).toInt()) {
                Timber.e("!$it ${(min + it * GraphFragment.DAY).toLong()}")
                min + it * GraphFragment.DAY
            }
            mEntryCount = mEntries.size
            setCenterAxisLabels(false)
        }*/
        with(mAxis) {
            val range = abs(max - min)
            if (labelCount == 0 || range <= 0 || java.lang.Float.isInfinite(range)) {
                mEntries = floatArrayOf()
                mCenteredEntries = floatArrayOf()
                mEntryCount = 0
                return
            }
            if (false) {
                super.computeAxisValues(min, max)
            }
            mEntries = FloatArray((range / GraphFragment.DAY).toInt()) {
                Timber.e("!$it ${(min + it * GraphFragment.DAY).toLong()}")
                min + it * GraphFragment.DAY
            }
            mEntryCount = mEntries.size
            setCenterAxisLabels(false)
            computeSize()
        }
    }
}

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