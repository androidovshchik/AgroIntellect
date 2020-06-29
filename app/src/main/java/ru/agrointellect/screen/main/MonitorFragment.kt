package ru.agrointellect.screen.main

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_reports.*
import kotlinx.android.synthetic.main.item_monitor.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readArray
import ru.agrointellect.extension.setAll
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Report
import ru.agrointellect.remote.dto.RptDesc
import ru.agrointellect.screen.base.BaseFragment

class MonitorHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val about: TextView = itemView.tv_about
    val value: TextView = itemView.tv_value
    val arrow: ImageView = itemView.iv_arrow
    val valueUp: TextView = itemView.tv_value_up
    val valueDown: TextView = itemView.tv_value_down
}

class MonitorFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private lateinit var mainModel: MainModel

    private val navController by lazy {
        findNavController()
    }

    private val dataSource = dataSourceTypedOf<RptDesc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Монитор"
        }
        return inflater.inflate(R.layout.fragment_monitor, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_farm.text = mainModel.farm?.name.toString()
        sl_reports.setOnRefreshListener {
            loadReports()
        }
        rv_reports.apply {
            setup {
                withDataSource(dataSource)
                withItem<RptDesc, ReportHolder>(R.layout.item_monitor) {
                    onBind(::ReportHolder) { i, item ->
                        bindDesc(i, item)
                    }
                    onClick { i ->
                        notifyItemSelected(i)
                        navController.navigate(
                            R.id.reportActivity,
                            bundleOf("farm" to mainModel.farm, "desc" to item)
                        )
                    }
                }
            }
        }
        if (mainModel.reports.isNotEmpty()) {
            dataSource.setAll(defaultList.filter { item -> mainModel.reports.any { item.id == it.id } })
            dataSource.invalidateAll()
        } else {
            waitDialog.show()
            loadReports()
        }
    }

    private fun ReportHolder.bindDesc(i: Int, item: RptDesc) {
        itemView.setBackgroundColor(if (i % 2 != 0) grayColor else Color.TRANSPARENT)
        button.setCheckedManually(item.isSelected)
        button.text = item.name
    }

    private fun notifyItemSelected(i: Int) {
        dataSource.toList().forEachIndexed { j, report ->
            if (i == j) {
                report.isSelected = true
                dataSource.invalidateAt(i)
            } else if (report.isSelected) {
                report.isSelected = false
                dataSource.invalidateAt(j)
            }
        }
    }

    override fun showError(e: Throwable) {
        super.showError(e)
        sl_reports.isRefreshing = false
    }

    private fun loadReports() {
        val farmId = mainModel.farm?.id.toString()
        job.cancelChildren()
        launch {
            val data = withContext(Dispatchers.IO) {
                val response = client.post<HttpResponse>(BuildConfig.API_URL) {
                    body = FormDataContent(Parameters.build {
                        append("uid", preferences.getHash().toString())
                        append("farm_id", farmId)
                        append("report_id", "rpt_monitor")
                    })
                }
                response.readArray<Report>(gson, farmId, "reports")
            }
            mainModel.reports.setAll(data)
            dataSource.setAll(defaultList.filter { item -> data.any { item.id == it.id } })
            dataSource.invalidateAll()
            waitDialog.dismiss()
            sl_reports.isRefreshing = false
        }
    }
}