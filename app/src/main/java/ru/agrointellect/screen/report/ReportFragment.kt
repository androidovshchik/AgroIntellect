package ru.agrointellect.screen.report

import android.app.Activity
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.android.synthetic.main.fragment_report.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.extension.*
import ru.agrointellect.local.writeFile
import ru.agrointellect.remote.api.Column
import ru.agrointellect.remote.api.Table
import java.io.File

class ReportFragment : DataFragment() {

    override val reportModel by lazy {
        ViewModelProvider(requireActivity()).get(ReportModel::class.java)
    }

    private lateinit var adapter: TableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TableAdapter(requireContext(), reportModel.getDesc().uid == "rpt_last_updates")
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
            if (!checkPermissions()) {
                return@setOnClickListener
            }
            saveExcel(fileManager.getExcelStorageFile(reportModel.farmReportIds), false)
        }
        mb_send.setOnClickListener {
            saveExcel(fileManager.getExcelExternalFile(reportModel.farmReportIds), true)
        }
        reportModel.paramsChanged.observe(viewLifecycleOwner, {
            loadReport()
        })
        loadReport()
    }

    @Suppress("UNCHECKED_CAST")
    private fun saveExcel(file: File, share: Boolean) {
        waitDialog.show()
        launch {
            val reportId = reportModel.getDesc().id
            val columns = adapter.groups as MutableList<Column>
            val isExported = withContext(Dispatchers.IO) {
                val workbook = XSSFWorkbook()
                with(workbook.createSheet(reportId)) {
                    setCellValue(0, 0, "")
                    columns.forEachIndexed { i, column ->
                        setCellValue(0, i + 1, column.title)
                        column.items.forEachIndexed { j, row ->
                            if (i == 0) {
                                setCellValue(j + 1, 0, row.key)
                            }
                            setCellValue(j + 1, i + 1, row.value)
                        }
                    }
                    adjustWidth()
                }
                writeFile(file) {
                    workbook.write(it)
                }
            }
            waitDialog.dismiss()
            if (share) {
                shareFile(file)
            } else if (isExported) {
                context?.scanFile(file.path)
                showMessage("Экспортировано в Excel")
            }
        }
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
                        reportModel.period?.let {
                            append("report_fragmentation", it)
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

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_WRITE) {
            mb_export?.performClick()
        }
    }
}