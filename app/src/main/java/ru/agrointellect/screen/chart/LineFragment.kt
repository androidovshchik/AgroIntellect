package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.dto.GraphData
import kotlin.math.max
import kotlin.math.min

class LineFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = LineChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
        }
        return chart
    }

    override fun setData(data: GraphData) {
        val lines = reportModel.getDesc().rightAxisLines
        (data as LineData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                (dataSet as LineDataSet).apply {
                    mode = reportModel.getDesc().lineMode
                    setDrawCircles(false)
                    lineWidth = 1.5f
                    color = pickColor(i)
                    if (i in lines) {
                        axisDependency = YAxis.AxisDependency.RIGHT
                        chart.axisRight.apply {
                            axisMinimum = min(axisMinimum, yMin - 1)
                            axisMaximum = max(axisMaximum, yMax + 1)
                        }
                    } else {
                        axisDependency = YAxis.AxisDependency.LEFT
                    }
                }
            }
        }
        chart.apply {
            axisRight.isEnabled = lines.isNotEmpty()
        }
        super.setData(data)
    }

    companion object {

        fun newInstance(): LineFragment {
            return LineFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }
}