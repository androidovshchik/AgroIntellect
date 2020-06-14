package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.GraphData
import timber.log.Timber

class BarFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = BackBarChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            //setFitBars(true)
            when {
                reportModel.getDesc().isStackedBarChart -> {
                    xAxis.apply {
                        // 3/4 + 1/8
                        spaceMin = DAY * 7 / 8
                        spaceMax = DAY * 7 / 8
                    }
                }
                reportModel.getDesc().isGroupedBarChart -> {
                    //setScaleEnabled(false)
                    //xAxis.setCenterAxisLabels(true)
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
        (data as BarData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                (dataSet as BarDataSet).apply {
                    (0 until entryCount).forEach {
                        val e = getEntryForIndex(it)
                        Timber.e("e $it ${e.x.toLong()} ${e.y.toLong()}")
                    }
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
                //chart.xAxis.axisMinimum = xMin + barWidth
                Timber.e("xmin $xMin barWidth $barWidth")
                Timber.e("= ${barWidth * 2 * (5 + 1)}")
            }
        }
        (chart as BackBarChart).drawBackground = reportModel.getDesc().isGroupedBarChart
        chart.apply {
            xAxis.axisMinimum = data.xMin
        }
        super.setData(data)
        chart.apply {
            setVisibleXRangeMaximum(WEEK)
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