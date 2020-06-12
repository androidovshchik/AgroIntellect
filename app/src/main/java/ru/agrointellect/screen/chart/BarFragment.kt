package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.CombinedData
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.GraphData
import ru.agrointellect.remote.dto.newBarEntry

class BarFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = BarChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            setFitBars(true)
            when {
                reportModel.getDesc().isStackedBarChart -> {
                    xAxis.apply {
                        spaceMin = 86400f * 7 / 8
                        spaceMax = 86400f * 7 / 8
                    }
                }
                reportModel.getDesc().isGroupedBarChart -> {
                    xAxis.setCenterAxisLabels(true)
                    xAxis.setLabelCount(7, true)
                }
            }
        }
        return chart
    }

    /**
     * https://weeklycoding.com/mpandroidchart-documentation/setting-data
     * 86400 = (w + s) * n + S <=> x * n + 0.75 * x
     * 86400 = x * (n + 0.75) => x = 86400 / (n + 0.75)
     * w + s = S / 0.75 = 86400 / (n + 0.75)
     * w = s = S / 1.5 = 86400 / (n + 0.75) / 2
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
                        barWidth = 86400f / (dataSetCount + 0.75f) / 2
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
        val combinedData = CombinedData().apply {
            setData(
                BarData(
                    BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtCalvTotal) }, null),
                    BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtRetPlacTotal) }, null),
                    BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtParesTotal) }, null)
                )
            )
            setData(data)
        }
        super.setData(combinedData)
        chart.apply {
            //getXAxis().setAxisMinimum(data.xMin);
            getXAxis().setAxisMaximum(data.xMin + data.dataSetCount * 86400f);
            setVisibleXRange(7f * 86400, 7f * 86400)
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