package ru.agrointellect.screen.chart

import android.os.Bundle
import android.view.View
import com.github.mikephil.charting.charts.BarLineChartBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData
import ru.agrointellect.screen.base.BaseFragment

abstract class GraphFragment : BaseFragment() {

    protected lateinit var chart: BarLineChartBase<*>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chart.apply {
            axisRight.isEnabled = false
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            legend.isEnabled = false
            description.isEnabled = false
        }
    }

    open fun setData(data: BarLineScatterCandleBubbleData<*>) {
        chart.data = data
        chart.invalidate()
    }
}