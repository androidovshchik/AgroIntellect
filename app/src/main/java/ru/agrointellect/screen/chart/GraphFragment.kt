package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.data.ChartData
import ru.agrointellect.screen.base.BaseFragment

abstract class GraphFragment : BaseFragment() {

    protected lateinit var chart: Chart<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chart.apply {
            legend.isEnabled = false
        }
    }

    open fun setData(data: ChartData<*>) {
        chart.data = data
        chart.invalidate()
    }
}