@file:Suppress("DEPRECATION")

package ru.agrointellect.screen.report

import android.app.Dialog
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.extension.getDate
import ru.agrointellect.extension.transact
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.RptDesc
import ru.agrointellect.screen.base.BaseActivity
import ru.agrointellect.screen.base.BaseDialog
import java.util.*

class OneDateDialog : DatePickerDialog() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BaseDialog(requireActivity())
    }
}

abstract class DateActivity : BaseActivity(), DatePickerDialog.OnDateSetListener,
    TwoDatesDialog.OnDateSetListener {

    abstract val reportModel: ReportModel

    private val oneDateDelegate = lazy {
        val calendar = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
        }
        OneDateDialog().also {
            it.initialize(this, calendar)
            it.accentColor = Color.parseColor("#2EC0D1")
        }
    }
    private val oneDateDialog by oneDateDelegate

    private val twoDatesDelegate = lazy {
        val calendar = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
        }
        TwoDatesDialog().also {
            it.initialize(
                this,
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            )
            it.accentColor = Color.parseColor("#2EC0D1")
        }
    }
    private val twoDatesDialog by twoDatesDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel.apply {
            farm = intent.getSerializableExtra("farm") as Farm
            setDesc(intent.getSerializableExtra("desc") as RptDesc)
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
        if (reportModel.getDesc().datesCount == 1) {
            if (!oneDateDialog.isAdded) {
                supportFragmentManager.transact(false) {
                    oneDateDialog.show(this, DIALOG_TAG)
                }
            }
        } else {
            if (!twoDatesDialog.isAdded) {
                supportFragmentManager.transact(false) {
                    twoDatesDialog.show(this, DIALOG_TAG)
                }
            }
        }
    }

    override fun onDateSet(view: DatePickerDialog?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
        reportModel.apply {
            dateTo = getDate(year, monthOfYear, dayOfMonth)
            datesChanged.value = true
        }
    }

    override fun onDateSet(
        view: TwoDatesDialog?,
        year: Int,
        monthOfYear: Int,
        dayOfMonth: Int,
        yearEnd: Int,
        monthOfYearEnd: Int,
        dayOfMonthEnd: Int
    ) {
        val startDate = getDate(year, monthOfYear, dayOfMonth)
        val endDate = getDate(yearEnd, monthOfYearEnd, dayOfMonthEnd)
        reportModel.apply {
            if (endDate.after(startDate)) {
                dateFrom = startDate
                dateTo = endDate
            } else {
                dateTo = startDate
                dateFrom = endDate
            }
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

        const val DIALOG_TAG = "date_picker"
    }
}
