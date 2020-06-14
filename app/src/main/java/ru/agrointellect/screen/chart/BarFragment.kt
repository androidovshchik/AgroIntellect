package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.GraphData
import kotlin.math.max

class BarFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = BackBarChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            if (reportModel.getDesc().isStackedBarChart) {
                setFitBars(true)
                xAxis.apply {
                    // 3/4 + 1/8
                    spaceMin = DAY * 7 / 8
                    spaceMax = DAY * 7 / 8
                }
            }
        }
        return chart
    }

    /**
     * https://weeklycoding.com/mpandroidchart-documentation/setting-data
     * 86400 = (w + s) * n + S <=> 2x * n + 2x
     * 86400 = 2x * (n + 1) => x = 86400 / (n + 1) / 2
     */
    override fun setData(data: GraphData) {
        var count = 0
        (data as BarData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                (dataSet as BarDataSet).apply {
                    count = max(count, entryCount)
                    when {
                        reportModel.getDesc().isStackedBarChart -> {
                            barWidth = DAY / 4
                            if (entryCount > 0) {
                                colors = pickColors(getEntryForIndex(0).yVals.size)
                            }
                        }
                        reportModel.getDesc().isGroupedBarChart -> {
                            barWidth = DAY / (dataSetCount + 1) / 2
                            color = pickColor(i)
                        }
                    }
                }
            }
            if (reportModel.getDesc().isGroupedBarChart) {
                if (dataSetCount > 1) {
                    groupBars(xMin - barWidth * 3 / 2, barWidth * 2, barWidth)
                }
            }
        }
        (chart as BackBarChart).apply {
            if (reportModel.getDesc().isGroupedBarChart) {
                drawBackground = true
                xAxis.axisMaximum = data.xMin
                xAxis.axisMaximum = data.xMin + count * DAY
            }
        }
        super.setData(data)
        chart.apply {
            if (reportModel.getDesc().isGroupedBarChart) {
                setVisibleXRangeMaximum(WEEK)
            }
        }
    }

    companion object {

        fun newInstance(): BarFragment {
            return BarFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }
}