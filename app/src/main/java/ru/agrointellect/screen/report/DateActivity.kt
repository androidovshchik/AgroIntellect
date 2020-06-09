package ru.agrointellect.screen.report

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.extension.getDate
import ru.agrointellect.extension.transact
import ru.agrointellect.extension.transactLegacy
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report
import ru.agrointellect.screen.base.BaseActivity
import java.util.*

private typealias OneDatePickerDialog = com.wdullaer.materialdatetimepicker.date.DatePickerDialog

private typealias OneDateSetListener = com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener

private typealias TwoDatesPickerDialog = com.borax12.materialdaterangepicker.date.DatePickerDialog

private typealias TwoDatesSetListener = com.borax12.materialdaterangepicker.date.DatePickerDialog.OnDateSetListener

@Suppress("DEPRECATION")
abstract class DateActivity : BaseActivity(), OneDateSetListener, TwoDatesSetListener {

    protected lateinit var reportModel: ReportModel

    private val oneDateDelegate = lazy {
        val now = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
        }
        val dialog = OneDatePickerDialog.newInstance(
            this,
            now[Calendar.YEAR],
            now[Calendar.MONTH],
            now[Calendar.DAY_OF_MONTH]
        )
        dialog.also {
            it.accentColor = Color.parseColor("#2EC0D1")
        }
    }
    private val oneDateDialog by oneDateDelegate

    private val twoDatesDelegate = lazy {
        val now = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
        }
        val dialog = TwoDatesPickerDialog.newInstance(
            this,
            now[Calendar.YEAR],
            now[Calendar.MONTH],
            now[Calendar.DAY_OF_MONTH]
        )
        dialog.also {
            it.accentColor = Color.parseColor("#2EC0D1")
        }
    }
    private val twoDatesDialog by twoDatesDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(this).get(ReportModel::class.java).also {
            it.farm = intent.getSerializableExtra("farm") as Farm
            it.report = intent.getSerializableExtra("report") as Report.Default
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        super.onPostCreate(savedInstanceState)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (oneDateDelegate.isInitialized()) {
            oneDateDialog.dismiss()
        }
        if (twoDatesDelegate.isInitialized()) {
            twoDatesDialog.dismiss()
        }
    }

    fun showDateDialog() {
        if (reportModel.report.datesCount == 1) {
            if (!oneDateDialog.isAdded) {
                supportFragmentManager.transact(false) {
                    oneDateDialog.show(this, PICKER_TAG)
                }
            }
        } else {
            if (!twoDatesDialog.isAdded) {
                fragmentManager.transactLegacy(false) {
                    twoDatesDialog.show(this, PICKER_TAG)
                }
            }
        }
    }

    override fun onDateSet(
        view: OneDatePickerDialog?,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int
    ) {
        reportModel.apply {
            dateTo = getDate(year, monthOfYear, dayOfMonth)
            datesChanged.value = true
        }
    }

    override fun onDateSet(
        view: TwoDatesPickerDialog?,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int,
        yearEnd: Int,
        monthOfYearEnd: Int,
        dayOfMonthEnd: Int
    ) {
        reportModel.apply {
            dateFrom = getDate(year, monthOfYear, dayOfMonth)
            dateTo = getDate(yearEnd, monthOfYearEnd, dayOfMonthEnd)
            datesChanged.value = true
        }
    }

    override fun onDestroy() {
        if (oneDateDelegate.isInitialized()) {
            oneDateDialog.apply {
                onDateSetListener = null
                dismiss()
            }
        }
        if (twoDatesDelegate.isInitialized()) {
            twoDatesDialog.apply {
                setOnDateSetListener(null)
                dismiss()
            }
        }
        super.onDestroy()
    }

    companion object {

        const val PICKER_TAG = "date_picker"
    }
}
