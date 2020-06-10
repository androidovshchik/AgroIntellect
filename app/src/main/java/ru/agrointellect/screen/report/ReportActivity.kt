package ru.agrointellect.screen.report

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.agrointellect.R

class ReportActivity : DateActivity() {

    override val reportModel by lazy {
        ViewModelProvider(this).get(ReportModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
    }
}
