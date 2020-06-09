package ru.agrointellect.screen.chart

import android.app.Activity
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
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
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.readObject
import ru.agrointellect.extension.setAll
import ru.agrointellect.extension.transact
import ru.agrointellect.remote.dto.ChartBase
import ru.agrointellect.screen.report.DataFragment
import ru.agrointellect.screen.report.DateActivity

class LegendHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val circle: CircleView = itemView.iv_circle
    val legend: TextView = itemView.tv_legend
}

class OptionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val caption: TextView = itemView.tv_caption
    val switch: SwitchButton = itemView.sm_item
}

class ChartFragment : DataFragment() {

    private lateinit var graphFragment: GraphFragment

    private val dataSource = dataSourceTypedOf<String>()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "График"
        }
        return inflater.inflate(R.layout.fragment_chart, root, false)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        tv_farm.isVisible = !landscape
        iv_excel.isVisible = !landscape
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val grayColor = ContextCompat.getColor(requireContext(), R.color.colorRowGray)
        tv_report.text = reportModel.report.name
        tv_farm.text = reportModel.farm.name
        ll_dates.isVisible = reportModel.report.datesCount > 0
        ll_dates.setOnClickListener {
            context?.activityCallback<DateActivity> {
                showDateDialog()
            }
        }
        graphFragment = if (reportModel.report.hasLineChart) {
            LineFragment.newInstance()
        } else {
            BarFragment.newInstance()
        }
        childFragmentManager.transact {
            add(R.id.fl_container, graphFragment)
        }
        rv_info.apply {
            setup {
                withDataSource(dataSource)
                if (reportModel.report.hasGroupedBarChart) {
                    withItem<String, LegendHolder>(R.layout.item_legend) {
                        onBind(::LegendHolder) { i, item ->
                            circle.color = graphColors[i]
                            legend.text = item
                        }
                    }
                } else {
                    withItem<String, OptionHolder>(R.layout.item_option) {
                        onBind(::OptionHolder) { i, item ->
                            itemView.setBackgroundColor(if (i % 2 == 0) grayColor else Color.TRANSPARENT)
                            caption.text = item
                            switch.color = graphColors[i]
                            switch.isCheckedProgrammatically = true
                        }
                    }
                }
            }
        }
        waitDialog.show()
        loadReport()
    }

    fun toggleScroll(disallow: Boolean) {
        nsv_graph.requestDisallowInterceptTouchEvent(disallow)
    }

    override fun showError(e: Throwable) {
        if (e is NoDataException) {
            dataSource.clear()
            dataSource.invalidateAll()
            sl_info.isVisible = false
        }
        super.showError(e)
        sl_info.isRefreshing = false
    }

    private fun loadReport() {
        val farmId = reportModel.farm.id
        val reportId = reportModel.report.id
        val reportUid = reportModel.report.uid
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
                            if (reportModel.report.datesCount == 1) {
                                set("report_date_from", apiFormatter.format(it))
                            }
                            append("report_date_to", apiFormatter.format(it))
                        }
                    })
                }
                response.readObject<ChartBase>(gson, reportUid, farmId)
            }
            val graphData = data.data
            graphFragment.setData(graphData)
            dataSource.setAll(data.legends)
            dataSource.invalidateAll()
            sl_info.isVisible = true
            waitDialog.dismiss()
            sl_info.isRefreshing = false
        }
    }
}