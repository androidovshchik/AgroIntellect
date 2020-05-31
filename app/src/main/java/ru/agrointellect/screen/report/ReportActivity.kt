package ru.agrointellect.screen.report

import android.os.Bundle
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity

class ReportActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
