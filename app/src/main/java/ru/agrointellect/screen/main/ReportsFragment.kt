package ru.agrointellect.screen.main

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
import kotlinx.android.synthetic.main.item_report.view.*
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

class ReportHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val button: RadioButton = itemView.rb_report
}

open class ReportsFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    private lateinit var mainModel: MainModel

    private val navController by lazy {
        findNavController()
    }

    private val dataSource = dataSourceTypedOf<RptDesc>()

    @Suppress("SpellCheckingInspection")
    protected open val defaultList: List<RptDesc>
        get() = listOf(
            RptDesc("rpt_herd_distribution", "Поголовье: фуражное, дойное, стельное", 2),
            RptDesc(
                "rpt_herd_alignment_now",
                "Распределение поголовья по группам на текущий момент",
                0
            ),
            RptDesc("rpt_herd_alignment_history", "История распределения поголовья по группам", 1),
            RptDesc("rpt_herd_lactation_graph", "График лактации поголовья", 0),
            RptDesc("rpt_milk_events_kpi", "Надой, события, кормление", 2),
            RptDesc("rpt_breed_effectivity", "Воспроизводство", 2),
            RptDesc("rpt_fresh_disease", "Послеотельные заболевания", 2),
            RptDesc("rpt_farm_summary_history", "Сводный отчет", 2),
            RptDesc("rpt_herd_forecast", "Прогноз", 0),
            RptDesc("rpt_sold_animals", "Продажа", 2),
            RptDesc("rpt_died_animals", "Падеж", 2),
            RptDesc("rpt_last_updates", "Даты актуальности данных", 0)
        )

    private val thisClass
        get() = javaClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите отчёт"
        }
        return inflater.inflate(R.layout.fragment_reports, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val grayColor = ContextCompat.getColor(requireContext(), R.color.colorRowGray)
        tv_farm.text = mainModel.farm?.name.toString()
        sl_reports.setOnRefreshListener {
            loadReports()
        }
        rv_reports.apply {
            setup {
                withDataSource(dataSource)
                withItem<RptDesc, ReportHolder>(R.layout.item_report) {
                    onBind(::ReportHolder) { i, item ->
                        itemView.setBackgroundColor(if (i % 2 != 0) grayColor else Color.TRANSPARENT)
                        button.setChecked(item.isSelected, false)
                        button.text = item.name
                    }
                    onClick { i ->
                        dataSource.toList().forEachIndexed { j, report ->
                            if (i == j) {
                                report.isSelected = true
                                dataSource.invalidateAt(i)
                            } else if (report.isSelected) {
                                report.isSelected = false
                                dataSource.invalidateAt(j)
                            }
                        }
                        navController.navigate(
                            if (thisClass == ReportsFragment::class.java) {
                                R.id.reportActivity
                            } else {
                                R.id.chartActivity
                            }, bundleOf("farm" to mainModel.farm, "desc" to item)
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