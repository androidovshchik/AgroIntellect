package ru.agrointellect.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.appeaser.sublimepickerlibrary.SublimePicker
import com.appeaser.sublimepickerlibrary.datepicker.SelectedDate
import com.appeaser.sublimepickerlibrary.helpers.SublimeListenerAdapter
import com.appeaser.sublimepickerlibrary.helpers.SublimeOptions
import com.appeaser.sublimepickerlibrary.recurrencepicker.SublimeRecurrencePicker
import org.jetbrains.anko.wrapContent
import ru.agrointellect.screen.base.BaseDialogFragment
import ru.agrointellect.screen.report.ReportModel
import java.text.SimpleDateFormat
import java.util.*

class DatesDialog : BaseDialogFragment() {

    private lateinit var reportModel: ReportModel

    private val listener = object : SublimeListenerAdapter() {

        override fun onDateTimeRecurrenceSet(
            sublimeMaterialPicker: SublimePicker?,
            selectedDate: SelectedDate,
            hourOfDay: Int,
            minute: Int,
            recurrenceOption: SublimeRecurrencePicker.RecurrenceOption?,
            recurrenceRule: String?
        ) {
            reportModel.apply {
                dateFrom = selectedDate.startDate?.let {
                    formatter.format(it.time)
                }
                dateTo = selectedDate.endDate?.let {
                    formatter.format(it.time)
                }
            }
            dismiss()
        }

        override fun onCancelled() {
            dismiss()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return SublimePicker(requireContext()).apply {
            layoutParams = ViewGroup.LayoutParams(wrapContent, wrapContent)
            initializePicker(SublimeOptions().apply {
                pickerToShow = SublimeOptions.Picker.DATE_PICKER
                setDisplayOptions(SublimeOptions.ACTIVATE_DATE_PICKER)
                setCanPickDateRange(true)
            }, listener)
        }
    }

    companion object {

        val TAG = DatesDialog::class.java.simpleName

        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        fun newInstance(): DatesDialog {
            return DatesDialog().apply {
                arguments = Bundle().apply {
                }
            }
        }
    }
}