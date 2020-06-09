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
            xAxis.valueFormatter = DateFormatter()
        }
        return chart
    }

    override fun setData(data: GraphData) {
        (data as BarData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                val graphColor = graphColors[i]
                (dataSet as BarDataSet).apply {
                    barWidth = 20f
                    color = graphColor
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