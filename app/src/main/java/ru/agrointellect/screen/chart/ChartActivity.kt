package ru.agrointellect.screen.chart

import android.os.Bundle
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity

class ChartActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chart)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
