package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.LineChart
import ru.agrointellect.screen.base.BaseFragment

class LineFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return LineChart(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}