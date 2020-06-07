package ru.agrointellect.screen.chart

import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.data.ChartData
import ru.agrointellect.screen.base.BaseFragment

abstract class DataFragment : BaseFragment() {

    protected lateinit var chart: Chart<*>

    open fun setData(data: ChartData<*>) {
        chart.data = data
        chart.invalidate()
    }
}