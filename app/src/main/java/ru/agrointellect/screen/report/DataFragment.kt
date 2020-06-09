package ru.agrointellect.screen.report

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import io.ktor.client.HttpClient
import org.kodein.di.generic.instance
import ru.agrointellect.local.Preferences
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
abstract class DataFragment : BaseFragment() {

    protected val client by instance<HttpClient>()

    protected val preferences by instance<Preferences>()

    protected val gson by instance<Gson>()

    protected lateinit var reportModel: ReportModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java).also {
            if (it.report.datesCount == 1) {
                it.dateTo = Calendar.getInstance().apply {
                    add(Calendar.DAY_OF_MONTH, -1)
                }.time
            }
        }
    }

    protected fun TextView.updateDates() {
        val dateTo = userFormatter.format(reportModel.dateTo ?: return)
        text = if (reportModel.report.datesCount > 1) {
            val dateFrom = userFormatter.format(reportModel.dateFrom ?: return)
            "Даты: $dateFrom – $dateTo"
        } else {
            "Дата: $dateTo"
        }
    }

    companion object {

        val apiFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        val userFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
    }
}