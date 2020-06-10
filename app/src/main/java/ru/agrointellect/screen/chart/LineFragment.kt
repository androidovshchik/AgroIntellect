package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.ChtDesc
import ru.agrointellect.remote.dto.GraphData

class LineFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = LineChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
            xAxis.valueFormatter = DateFormatter()
        }
        return chart
    }

    override fun setData(data: GraphData) {
        (data as LineData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                val graphColor = getGraphColor(i)
                (dataSet as LineDataSet).apply {
                    mode = desc.lineMode
                    setDrawCircles(false)
                    lineWidth = 1.5f
                    color = graphColor
                }
            }
        }
        super.setData(data)
    }

    companion object {

        fun newInstance(desc: ChtDesc): LineFragment {
            return LineFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("desc", desc)
                }
            }
        }
    }
}