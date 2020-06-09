package ru.agrointellect.screen.chart

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

class DateFormatter : ValueFormatter() {

    private val formatter = SimpleDateFormat("dd.MM", Locale.ENGLISH)

    override fun getFormattedValue(value: Float): String {
        return formatter.format(value.toLong() * 1000)
    }
}

abstract class GraphFragment : BaseFragment() {

    protected lateinit var chart: BarLineChartBase<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chart.apply {
            axisRight.isEnabled = false
            xAxis.apply {
                setDrawGridLines(false)
                position = XAxis.XAxisPosition.BOTTOM
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
            setHighlightEnabled(false)
        }
        chart.invalidate()
    }
}