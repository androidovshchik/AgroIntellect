package ru.agrointellect.screen.chart

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.TextUtils
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarLineChartBase
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import kotlinx.android.synthetic.main.item_marker.view.*
import ru.agrointellect.R
import ru.agrointellect.remote.api.GraphData
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs
import kotlin.math.roundToLong
import kotlin.math.sign

private val formatter = SimpleDateFormat("dd.MM", Locale.ENGLISH)

private fun formatDate(value: Float): String {
    return formatter.format(value.roundToLong() * 1000)
}

@SuppressLint("ViewConstructor")
class GraphMarker(context: Context, private val useDate: Boolean) :
    MarkerView(context, R.layout.item_marker) {

    @SuppressLint("SetTextI18n")
    override fun refreshContent(e: Entry, highlight: Highlight?) {
        val x = if (useDate) formatDate(e.x) else e.x.toString()
        tv_marker.text = when {
            e is BarEntry && e.isStacked -> "$x: ${TextUtils.join(",", e.yVals.toList())}"
            else -> "$x: ${e.y}"
        }
        super.refreshContent(e, highlight)
    }

    override fun getOffset() = MPPointF(-width.toFloat() / 2, -height.toFloat())
}

class DateFormatter : ValueFormatter() {

    override fun getFormattedValue(value: Float): String {
        return formatDate(value)
    }
}

abstract class GraphFragment : BaseFragment() {

    protected lateinit var reportModel: ChartModel

    protected lateinit var chart: BarLineChartBase<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ChartModel::class.java)
    }

    @SuppressLint("ClickableViewAccessibility")
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
            axisRight.apply {
                setDrawGridLines(false)
                setDrawAxisLine(false)
                textSize = 10f
                textColor = colorText
                typeface = font
                isEnabled = false
            }
            xAxis.apply {
                setDrawGridLines(false)
                position = XAxis.XAxisPosition.BOTTOM
                axisLineColor = colorLine
                textSize = 10f
                textColor = colorText
                typeface = font
                if (reportModel.getDesc().useDateFormatter) {
                    labelCount = 7
                    granularity = DAY
                    valueFormatter = DateFormatter()
                }
            }
            setDrawMarkers(true)
            marker = GraphMarker(context, reportModel.getDesc().useDateFormatter)
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
            val index = if (abs(it) == Option.MAX_INDEX) 0 else abs(it)
            chart.apply {
                data?.getDataSetByIndex(index)?.isVisible = it.sign > 0
                invalidate()
            }
        })
    }

    open fun setData(data: GraphData) {
        chart.apply {
            this.data = data.apply {
                setDrawValues(false)
            }
            highlightValue(null)
            fitScreen()
        }
    }

    fun clearData() {
        chart.clearValues()
    }
}