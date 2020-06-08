package ru.agrointellect.screen.chart

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_chart.*
import kotlinx.android.synthetic.main.item_legend.view.*
import kotlinx.android.synthetic.main.item_option.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readObject
import ru.agrointellect.extension.setAll
import ru.agrointellect.extension.transact
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.ChartBase
import ru.agrointellect.screen.DatesDialog
import ru.agrointellect.screen.base.BaseFragment
import ru.agrointellect.screen.report.ReportFragment
import ru.agrointellect.screen.report.ReportModel

class LegendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val circle: ImageView = itemView.iv_circle
    val legend: TextView = itemView.tv_legend
}

class OptionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val switch: SwitchMaterial = itemView.sm_item
}

class ChartFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private lateinit var reportModel: ReportModel

    private lateinit var dataFragment: DataFragment

    private val dataSource = dataSourceTypedOf<String>()

    private val datesDelegate = lazy {
        DatesDialog.newInstance()
    }
    private val datesDialog by datesDelegate

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "График"
        }
        return inflater.inflate(R.layout.fragment_chart, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataFragment = if (reportModel.report.isLine) {
            LineFragment.newInstance()
        } else {
            BarFragment.newInstance()
        }
        rv_info.apply {
            setup {
                withDataSource(dataSource)
                if (reportModel.report.isGroupedBar) {
                    withItem<String, LegendHolder>(R.layout.item_legend) {
                        onBind(::LegendHolder) { i, item ->

                        }
                    }
                } else {
                    withItem<String, OptionHolder>(R.layout.item_option) {
                        onBind(::OptionHolder) { i, item ->

                        }
                    }
                }
            }
        }
        childFragmentManager.transact {
            add(R.id.fl_container, dataFragment)
        }
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
                            append("report_date_from", ReportFragment.apiFormatter.format(it))
                        }
                        reportModel.dateTo?.let {
                            if (reportModel.report.dates == 1) {
                                set("report_date_from", ReportFragment.apiFormatter.format(it))
                            }
                            append("report_date_to", ReportFragment.apiFormatter.format(it))
                        }
                    })
                }
                response.readObject<ChartBase>(gson, 1, farmId, reportId)
            }
            dataFragment.setData(data.data)
            dataSource.setAll(data.legends)
            dataSource.invalidateAll()
            if (columns.isNotEmpty()) {
                sl_info.isVisible = true
            }
            waitDialog.dismiss()
            sl_info.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        if (datesDelegate.isInitialized()) {
            datesDialog.dismiss()
        }
        super.onDestroyView()
    }
}