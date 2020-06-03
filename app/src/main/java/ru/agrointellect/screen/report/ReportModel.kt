package ru.agrointellect.screen.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report
import java.util.*

open class ReportModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var report: Report.Default

    var dateFrom: Date? = null

    var dateTo: Date? = null

    val datesChanged = MutableLiveData<Boolean>()
}