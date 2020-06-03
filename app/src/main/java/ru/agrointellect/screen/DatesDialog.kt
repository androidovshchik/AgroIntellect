package ru.agrointellect.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.dialog_dates.*
import kotlinx.android.synthetic.main.layout_calendar_container.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseDialogFragment
import ru.agrointellect.screen.report.ReportModel
import java.text.SimpleDateFormat
import java.util.*

class DatesDialog : BaseDialogFragment() {

    private lateinit var reportModel: ReportModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        return inflater.inflate(R.layout.dialog_dates, root, false)
    }

    @Suppress("UNNECESSARY_SAFE_CALL")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        toolbar.apply {
            setNavigationIcon(R.drawable.ic_arrow_back)
            setNavigationOnClickListener {
                dismiss()
            }
            inflateMenu(R.menu.menu_dates)
            setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.action_done) {
                    reportModel.apply {
                        dateFrom = cv_dates.startDate?.let {
                            formatter.format(it.time)
                        }
                        dateTo = cv_dates.endDate?.let {
                            formatter.format(it.time)
                        }
                    }
                    dismiss()
                }
                return@setOnMenuItemClickListener true
            }
        }
        rlHeaderCalendar.isVisible = false
        imgVNavLeft.isVisible = false
        imgVNavRight.isVisible = false
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