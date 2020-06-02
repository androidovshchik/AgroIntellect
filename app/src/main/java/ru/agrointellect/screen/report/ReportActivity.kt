package ru.agrointellect.screen.report

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.R
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report
import ru.agrointellect.screen.base.BaseActivity

class ReportActivity : BaseActivity() {

    private lateinit var reportModel: ReportModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(this).get(ReportModel::class.java).also {
            it.farm = intent.getSerializableExtra("farm") as Farm
            it.report = intent.getSerializableExtra("report") as Report.Default
        }
        setContentView(R.layout.activity_report)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
