package ru.agrointellect.screen.chart

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.github.mikephil.charting.charts.BarLineChartBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.ValueFormatter
import ru.agrointellect.remote.dto.GraphData
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

val graphColors = listOf(
    Color.parseColor("#F44336"),
    Color.parseColor("#2196F3"),
    Color.parseColor("#8BC34A"),
    Color.parseColor("#FF5722"),
    Color.parseColor("#E91E63"),
    Color.parseColor("#03A9F4"),
    Color.parseColor("#CDDC39"),
    Color.parseColor("#795548"),
    Color.parseColor("#9C27B0"),
    Color.parseColor("#00BCD4"),
    Color.parseColor("#FFEB3B"),
    Color.parseColor("#9E9E9E"),
    Color.parseColor("#673AB7"),
    Color.parseColor("#009688"),
    Color.parseColor("#FFC107"),
    Color.parseColor("#607D8B"),
    Color.parseColor("#3F51B5"),
    Color.parseColor("#4CAF50"),
    Color.parseColor("#FF9800")
)

class DateFormatter : ValueFormatter() {

    private val formatter = SimpleDateFormat("dd.MM", Locale.ENGLISH)

    override fun getFormattedValue(value: Float): String {
        return formatter.format(value.toLong() * 1000)
    }
}

abstract class GraphFragment : BaseFragment() {

    protected lateinit var chart: BarLineChartBase<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val lineColor = Color.parseColor("#67C3C6CD")
        chart.apply {
            axisLeft.apply {
                gridColor = lineColor
                gridLineWidth = 1f
                setDrawAxisLine(false)
            }
            axisRight.isEnabled = false
            xAxis.apply {
                setDrawGridLines(false)
                position = XAxis.XAxisPosition.BOTTOM
                axisLineColor = lineColor
            }
            legend.isEnabled = false
            description.isEnabled = false
            setOnTouchListener { _, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        parentCallback<ChartFragment> {
                            toggleScroll(true)
                        }
                    }
                    MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
                        parentCallback<ChartFragment> {
                            toggleScroll(false)
                        }
                    }
                }
                false
            }
        }
    }

    open fun setData(data: GraphData) {
        chart.data = data.apply {
            setDrawValues(false)
        }
        chart.invalidate()
    }

    fun clearData() {
        chart.clearValues()
    }
}