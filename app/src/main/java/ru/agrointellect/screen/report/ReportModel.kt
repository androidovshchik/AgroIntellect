package ru.agrointellect.screen.report

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report

open class ReportModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var report: Report.Default

    var dateFrom: String? = null

    var dateTo: String? = null
}