package ru.agrointellect.screen.chart

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarLineChartBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.ValueFormatter
import ru.agrointellect.remote.dto.GraphData
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.sign

private val graphColors = listOf(
    Color.parseColor("#5899da"),
    Color.parseColor("#e8743b"),
    Color.parseColor("#19a979"),
    Color.parseColor("#ed4a7b"),
    Color.parseColor("#945ecf"),
    Color.parseColor("#13a4b4"),
    Color.parseColor("#525df4"),
    Color.parseColor("#bf399e"),
    Color.parseColor("#6c8893"),
    Color.parseColor("#ee6868"),
    Color.parseColor("#2f6497")
)

fun getGraphColor(index: Int): Int {
    var i = index
    while (i >= graphColors.size) {
        i -= graphColors.size
    }
    return graphColors[i]
}

class DateFormatter : ValueFormatter() {

    private val formatter = SimpleDateFormat("dd.MM", Locale.ENGLISH)

    override fun getFormattedValue(value: Float): String {
        return formatter.format(value.toLong() * 1000)
    }
}

abstract class GraphFragment : BaseFragment() {

    protected lateinit var reportModel: ChartModel

    protected lateinit var chart: BarLineChartBase<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ChartModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val colorLine = Color.parseColor("#67C3C6CD")
        val colorText = Color.parseColor("#506482")
        val font = Typeface.createFromAsset(requireContext().assets, "font/Ubuntu-Light.ttf")
        chart.apply {
            axisLeft.apply {
                gridColor = colorLine
                gridLineWidth = 1f
                setDrawAxisLine(false)
                textSize = 10f
                textColor = colorText
                typeface = font
            }
            axisRight.isEnabled = false
            xAxis.apply {
                setDrawGridLines(false)
                position = XAxis.XAxisPosition.BOTTOM
                axisLineColor = colorLine
                textSize = 10f
                textColor = colorText
                typeface = font
                if (reportModel.getDesc().useDateFormatter) {
                    valueFormatter = DateFormatter()
                    granularity = 86400f
                }
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
        reportModel.toggleChanged.observe(viewLifecycleOwner, Observer {
            val i = abs(it)
            chart.data.getDataSetByIndex(if (i == Option.MAX_INDEX) 0 else i)?.isVisible =
                it.sign > 0
            chart.invalidate()
        })
    }

    open fun setData(data: GraphData) {
        chart.data = data.apply {
            setDrawValues(false)
            isHighlightEnabled = false
        }
        chart.fitScreen()
        chart.invalidate()
    }

    fun clearData() {
        chart.clearValues()
    }
}