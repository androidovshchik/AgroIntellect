package ru.agrointellect.screen.report

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report

class ReportModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var report: Report.Default
}