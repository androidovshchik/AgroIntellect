package ru.agrointellect.screen.report

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.borax12.materialdaterangepicker.date.DatePickerDialog
import kotlinx.android.synthetic.main.include_toolbar.*
import ru.agrointellect.extension.transactLegacy
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report
import ru.agrointellect.screen.base.BaseActivity
import java.util.*

@Suppress("DEPRECATION")
abstract class DataActivity : BaseActivity(), DatePickerDialog.OnDateChangedListener {

    protected lateinit var reportModel: ReportModel

    private val datesDelegate = lazy {
        val now = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
        }
        val dialog = DatePickerDialog.newInstance(
            null,
            now[Calendar.YEAR],
            now[Calendar.MONTH],
            now[Calendar.DAY_OF_MONTH]
        )
        dialog.also {
            it.registerOnDateChangedListener(this)
        }
    }
    protected val datesDialog by datesDelegate

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

    fun showDatePicker() {
        if (!datesDialog.isAdded) {
            fragmentManager.transactLegacy(false) {
                datesDialog.show(this, PICKER_TAG)
            }
        }
    }

    override fun onDateChanged() {

    }

    override fun onDestroy() {
        if (datesDelegate.isInitialized()) {
            datesDialog.unregisterOnDateChangedListener(this)
            datesDialog.dismiss()
        }
        super.onDestroy()
    }

    companion object {

        const val PICKER_TAG = "date_picker"
    }
}
