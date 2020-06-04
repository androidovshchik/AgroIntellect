package ru.agrointellect.screen.report

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readObject
import ru.agrointellect.extension.transact
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Table
import ru.agrointellect.screen.DatesDialog
import ru.agrointellect.screen.base.BaseFragment
import java.text.SimpleDateFormat
import java.util.*

class ReportFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private lateinit var reportModel: ReportModel

    private lateinit var adapter: TableAdapter

    private val datesDelegate = lazy {
        DatesDialog.newInstance()
    }
    private val datesDialog by datesDelegate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java)
        adapter = TableAdapter(requireContext())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        tv_farm.isVisible = !landscape
        iv_excel.isVisible = !landscape
        if (datesDelegate.isInitialized()) {
            datesDialog.dismiss()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Отчёт"
        }
        return inflater.inflate(R.layout.fragment_report, root, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_report.text = reportModel.report.name
        tv_farm.text = reportModel.farm.name
        ll_dates.isVisible = reportModel.report.supportDates
        ll_dates.setOnClickListener {
            if (!datesDialog.isAdded) {
                childFragmentManager.transact(false) {
                    datesDialog.show(this, DatesDialog.TAG)
                }
            }
        }
        sl_data.setOnRefreshListener {
            loadReport()
        }
        rv_data.also {
            it.adapter = adapter
        }
        reportModel.datesChanged.observe(viewLifecycleOwner, Observer {
            datesDialog.dismiss()
            val dateFrom = userFormatter.format(reportModel.dateFrom!!)
            val dateTo = userFormatter.format(reportModel.dateTo!!)
            tv_dates.text = when (reportModel.report.id) {
                "rpt_herd_alignment_history" -> "Дата: $dateTo"
                else -> "Даты: $dateFrom – $dateTo"
            }
            waitDialog.show()
            loadReport()
        })
        waitDialog.show()
        loadReport()
    }

    override fun showError(e: Throwable) {
        if (e is NoDataException) {
            adapter.clear()
            adapter.notifyDataSetChanged()
            sl_data.isVisible = false
        }
        super.showError(e)
        sl_data.isRefreshing = false
    }

    private fun loadReport() {
        val farmId = reportModel.farm.id
        val reportId = reportModel.report.id
        job.cancelChildren()
        launch {
            val data = withContext(Dispatchers.IO) {
                val response = client.post<HttpResponse>(BuildConfig.API_URL) {
                    body = FormDataContent(Parameters.build {
                        append("uid", preferences.getHash().toString())
                        append("farm_id", farmId)
                        append("report_id", reportId)
                        reportModel.dateFrom?.let {
                            append("report_date_from", apiFormatter.format(it))
                        }
                        reportModel.dateTo?.let {
                            if (reportModel.report.id == "rpt_herd_alignment_history") {
                                set("report_date_from", apiFormatter.format(it))
                            }
                            append("report_date_to", apiFormatter.format(it))
                        }
                    })
                }
                response.readObject<Table>(gson, 1, farmId, reportId)
            }
            val columns = data.columns
            adapter.setAll(data.columns)
            adapter.notifyDataSetChanged()
            if (columns.isNotEmpty()) {
                sl_data.isVisible = true
                adapter.toggleGroup(0)
            }
            waitDialog.hide()
            sl_data.isRefreshing = false
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