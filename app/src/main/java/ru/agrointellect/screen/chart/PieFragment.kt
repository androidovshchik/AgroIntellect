package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.api.GraphData

class PieFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = PieChart(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(matchParent, matchParent)
        }
        return chart
    }

    override fun setData(data: GraphData) {
        (data as PieData).apply {
            dataSets.forEachIndexed { i, dataSet ->
                (dataSet as PieDataSet).apply {
                    color = pickColor(i)
                }
            }
        }
        super.setData(data)
    }

    companion object {

        fun newInstance(): PieFragment {
            return PieFragment().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }
}