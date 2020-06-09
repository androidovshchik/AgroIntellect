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
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readObject
import ru.agrointellect.remote.dto.Table

class ReportFragment : DataFragment() {

    private lateinit var adapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TableAdapter(requireContext())
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val isLandscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        tv_farm.isVisible = !isLandscape
        iv_excel.isVisible = !isLandscape
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
        ll_dates.isVisible = reportModel.report.datesCount > 0
        ll_dates.setOnClickListener {
            context?.activityCallback<DateActivity> {
                showDateDialog()
            }
        }
        sl_data.setOnRefreshListener {
            loadReport()
        }
        rv_data.also {
            it.adapter = adapter
        }
        reportModel.datesChanged.observe(viewLifecycleOwner, Observer {
            loadReport()
        })
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
        val reportUid = reportModel.report.uid
        job.cancelChildren()
        tv_dates.updateDates()
        waitDialog.show()
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
                            if (reportModel.report.datesCount == 1) {
                                set("report_date_from", apiFormatter.format(it))
                            }
                            append("report_date_to", apiFormatter.format(it))
                        }
                    })
                }
                response.readObject<Table>(gson, reportUid, farmId)
            }
            val columns = data.columns
            if (columns.isNotEmpty()) {
                adapter.setAll(columns)
                adapter.notifyDataSetChanged()
                sl_data.isVisible = true
                adapter.toggleGroup(0)
            }
            waitDialog.dismiss()
            sl_data.isRefreshing = false
        }
    }
}