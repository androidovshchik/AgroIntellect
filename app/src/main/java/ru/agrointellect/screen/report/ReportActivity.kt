package ru.agrointellect.screen.report

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        if (reportModel.getDesc().hasPeriod) {
            menuInflater.inflate(R.menu.menu_period, menu)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return with(reportModel) {
            when (item.itemId) {
                R.id.period_day -> {
                    item.isChecked = true
                    if (period != "day") {
                        period = "day"
                        paramsChanged.value = true
                    }
                    true
                }
                R.id.period_week -> {
                    item.isChecked = true
                    if (period != "week") {
                        period = "week"
                        paramsChanged.value = true
                    }
                    true
                }
                R.id.period_month -> {
                    item.isChecked = true
                    if (period != "month") {
                        period = "month"
                        paramsChanged.value = true
                    }
                    true
                }
                R.id.period_year -> {
                    item.isChecked = true
                    if (period != "year") {
                        period = "year"
                        paramsChanged.value = true
                    }
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }
    }
}
