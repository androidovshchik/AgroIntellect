package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.BarChart
import ru.agrointellect.screen.base.BaseFragment

class BarFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return BarChart(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}