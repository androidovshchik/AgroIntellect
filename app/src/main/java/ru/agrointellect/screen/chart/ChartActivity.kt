package ru.agrointellect.screen.chart

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.agrointellect.R
import ru.agrointellect.screen.report.DateActivity

class ChartActivity : DateActivity() {

    override val reportModel by lazy {
        ViewModelProvider(this).get(ChartModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
    }
}