package ru.agrointellect.screen.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_reports.*
import kotlinx.android.synthetic.main.item_report.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Report
import ru.agrointellect.remote.dto.Reports
import ru.agrointellect.screen.base.BaseFragment

class ReportHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val button: RadioButton = itemView.rb_report
}

class ReportsFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private val dataSource = dataSourceTypedOf<Report>()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите отчёт"
        }
        return inflater.inflate(R.layout.fragment_reports, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sl_reports.setOnRefreshListener {
            loadReports()
        }
        rv_reports.apply {
            setup {
                withDataSource(dataSource)
                withItem<Report, ReportHolder>(R.layout.item_report) {
                    onBind(::ReportHolder) { _, item ->

                    }
                    onClick {

                    }
                }
            }
        }
        waitDialog.show()
        loadReports()
    }

    override fun showError(e: Throwable) {
        super.showError(e)
        sl_reports.isRefreshing = false
    }

    private fun loadReports() {
        job.cancelChildren()
        launch {
            val data = withContext(Dispatchers.IO) {
                val json = client.post<String>(BuildConfig.API_URL) {
                    body = FormDataContent(Parameters.build {
                        append("uid", preferences.hash.toString())
                        append("farm_id", "")
                    })
                }
                val jsonObject = JSONObject(json)
                val reports = jsonObject.getJSONObject("")
                gson.fromJson(reports.toString(), Reports::class.java)
            }
            dataSource.clear()
            dataSource.addAll(data.reports)
            dataSource.invalidateAll()
            waitDialog.hide()
            sl_reports.isRefreshing = false
        }
    }
}