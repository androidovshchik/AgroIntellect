package ru.agrointellect.screen.chart

import android.os.Bundle
import ru.agrointellect.R
import ru.agrointellect.screen.report.DateActivity

class ChartActivity : DateActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
    }
}