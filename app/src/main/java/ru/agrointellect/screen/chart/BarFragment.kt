package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.GraphData

class BarFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = BarChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            setFitBars(true)
            if (reportModel.getDesc().isStackedBarChart) {
                xAxis.apply {
                    spaceMin = 86400f * 7 / 8
                    spaceMax = 86400f * 7 / 8
                }
            } else if (reportModel.getDesc().isGroupedBarChart) {
                xAxis.setCenterAxisLabels(true)
            }
        }
        return chart
    }

    /**
     * https://weeklycoding.com/mpandroidchart-documentation/setting-data
     * 86400 = (w + s) * n + S <=> x * n + x
     * 86400 = x * (n + 1) => x = 86400 / (n + 1)
     * w + s = S = 86400 / (n + 1)
     * w = s = S / 2 = 86400 / (n + 1) / 2
     */
    override fun setData(data: GraphData) {
        (data as BarData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                (dataSet as BarDataSet).apply {
                    if (reportModel.getDesc().isStackedBarChart) {
                        barWidth = 86400f / 4
                        if (entryCount > 0) {
                            colors = pickColors(getEntryForIndex(0).yVals.size)
                        }
                    } else {
                        barWidth = 86400f / (dataSetCount + 1) / 2
                        color = pickColor(i)
                    }
                }
            }
            if (reportModel.getDesc().isGroupedBarChart) {
                if (dataSetCount > 1) {
                    groupBars(xMin - barWidth * 3 / 2, barWidth * 3 / 2, barWidth)
                }
            }
        }
        super.setData(data)
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