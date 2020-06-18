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
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.adjustWidth
import ru.agrointellect.extension.readObject
import ru.agrointellect.extension.setCellValue
import ru.agrointellect.local.writeFile
import ru.agrointellect.remote.dto.Column
import ru.agrointellect.remote.dto.Table

class ReportFragment : DataFragment() {

    override val reportModel by lazy {
        ViewModelProvider(requireActivity()).get(ReportModel::class.java)
    }

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

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tv_report.text = reportModel.getDesc().name
        tv_farm.text = reportModel.farm.name
        ll_dates.isVisible = reportModel.getDesc().datesCount > 0
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
        mb_export.setOnClickListener {
            val farmId = reportModel.farm.id
            val reportId = reportModel.getDesc().id
            waitDialog.show()
            launch {
                val columns = adapter.groups as MutableList<Column>
                val isExported = withContext(Dispatchers.IO) {
                    val workbook = XSSFWorkbook()
                    with(workbook.createSheet(reportId)) {
                        setCellValue(0, 0, "")
                        var fillVertically = true
                        columns.forEachIndexed { i, column ->
                            if (i == 0) {
                                fillVertically = columns.size <= column.items.size
                            }
                            if (fillVertically) {
                                setCellValue(i + 1, 0, column.title)
                            } else {
                                setCellValue(0, i + 1, column.title)
                            }
                            column.items.forEachIndexed { j, row ->
                                if (i == 0) {
                                    if (fillVertically) {
                                        setCellValue(0, j + 1, row.key)
                                    } else {
                                        setCellValue(j + 1, 0, row.key)
                                    }
                                }
                                if (fillVertically) {
                                    setCellValue(i + 1, j + 1, row.value)
                                } else {
                                    setCellValue(j + 1, i + 1, row.value)
                                }
                            }
                        }
                        adjustWidth()
                    }
                    writeFile(fileManager.getExcelFile("$farmId-$reportId")) {
                        workbook.write(it)
                    }
                }
                waitDialog.dismiss()
                if (isExported) {
                    showMessage("Экспортировано в excel")
                }
            }
        }
        mb_send.setOnClickListener {
            val farmId = reportModel.farm.id
            val reportId = reportModel.getDesc().id
            shareFile(fileManager.getExcelFile("$farmId-$reportId"))
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
        val reportId = reportModel.getDesc().id
        val reportUid = reportModel.getDesc().uid
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
                            if (reportModel.getDesc().datesCount == 1) {
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