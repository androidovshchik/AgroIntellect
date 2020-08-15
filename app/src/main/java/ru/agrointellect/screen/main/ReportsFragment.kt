package ru.agrointellect.screen.main

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import kotlinx.android.synthetic.main.fragment_reports.*
import kotlinx.android.synthetic.main.item_report.view.*
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.setAll
import ru.agrointellect.remote.api.ChtDesc
import ru.agrointellect.remote.api.RptDesc

class ReportHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val button: RadioButton = itemView.rb_report
}

open class ReportsFragment : MainFragment() {

    private val dataSource = dataSourceTypedOf<RptDesc>()

    private var grayColor = 0

    private val thisClass
        get() = javaClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        grayColor = ContextCompat.getColor(requireContext(), R.color.colorRowGray)
    }

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите отчёт"
        }
        return inflater.inflate(R.layout.fragment_reports, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_farm.text = mainModel.farm?.name.toString()
        sl_reports.setOnRefreshListener {
            loadReports()
        }
        rv_reports.apply {
            setup {
                withDataSource(dataSource)
                if (thisClass == ReportsFragment::class.java) {
                    withItem<RptDesc, ReportHolder>(R.layout.item_report) {
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
                } else {
                    withItem<ChtDesc, ReportHolder>(R.layout.item_report) {
                        onBind(::ReportHolder) { i, item ->
                            bindDesc(i, item)
                        }
                        onClick { i ->
                            notifyItemSelected(i)
                            navController.navigate(
                                R.id.chartActivity,
                                bundleOf("farm" to mainModel.farm, "desc" to item)
                            )
                        }
                    }
                }
            }
        }
        if (mainModel.reports.isNotEmpty()) {
            dataSource.setAll(defaultList.filter { item -> mainModel.reports.any { it.id == item.id } })
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
            val data = loadReports(farmId)
            mainModel.reports.setAll(data)
            dataSource.setAll(defaultList.filter { item -> data.any { it.id == item.id } })
            dataSource.invalidateAll()
            waitDialog.dismiss()
            sl_reports.isRefreshing = false
        }
    }
}