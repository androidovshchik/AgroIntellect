package ru.agrointellect.screen.report

import android.content.res.Configuration
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import io.ktor.client.HttpClient
import org.kodein.di.generic.instance
import ru.agrointellect.local.Preferences
import ru.agrointellect.screen.DatesDialog
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

abstract class DataFragment : BaseFragment() {

    protected val client by instance<HttpClient>()

    protected val preferences by instance<Preferences>()

    protected val gson by instance<Gson>()

    protected lateinit var reportModel: ReportModel

    private val datesDelegate = lazy {
        DatesDialog.newInstance()
    }
    protected val datesDialog by datesDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java)
        if (reportModel.report.hasSingleDate) {
            reportModel.dateTo = Calendar.getInstance().apply {
                add(Calendar.DAY_OF_MONTH, -1)
            }.time
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (datesDelegate.isInitialized()) {
            datesDialog.dismiss()
        }
    }

    override fun onDestroyView() {
        if (datesDelegate.isInitialized()) {
            datesDialog.dismiss()
        }
        super.onDestroyView()
    }

    companion object {

        val apiFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        val userFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
    }
}