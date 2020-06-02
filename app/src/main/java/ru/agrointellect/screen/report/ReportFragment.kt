package ru.agrointellect.screen.report

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readObject
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Table
import ru.agrointellect.screen.base.BaseFragment

class ReportFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private lateinit var reportModel: ReportModel

    private lateinit var adapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reportModel = ViewModelProvider(requireActivity()).get(ReportModel::class.java)
        adapter = TableAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Отчёт"
        }
        return inflater.inflate(R.layout.fragment_report, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_report.text = reportModel.report.name
        tv_farm.text = reportModel.farm.name
        sl_data.setOnRefreshListener {
            loadReport()
        }
        rv_data.also {
            it.adapter = adapter
        }
        mb_export.setOnClickListener {

        }
        waitDialog.show()
        loadReport()
    }

    override fun showError(e: Throwable) {
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
                    })
                }
                response.readObject<Table>(gson, 1, farmId, reportId)
            }
            sl_data.isVisible = true
            adapter.setAll(data.columns)
            adapter.notifyDataSetChanged()
            if (adapter.singleHeader) {
                adapter.toggleGroup(0)
            }
            waitDialog.hide()
            sl_data.isRefreshing = false
        }
    }
}