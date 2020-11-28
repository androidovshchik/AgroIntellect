package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import ru.agrointellect.remote.api.GraphData
import ru.agrointellect.remote.api.PieBackDataSet

class PieFragment : GraphFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        chart = PieChart(requireContext()).apply {
            layoutParams = ViewGroup.MarginLayoutParams(matchParent, matchParent).apply {
                topMargin = dip(16)
            }
        }
        return chart
    }

    override fun setData(data: GraphData) {
        with(data as PieData) {
            with(dataSet as PieBackDataSet) {
                colors = pickColors(entryCount)
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