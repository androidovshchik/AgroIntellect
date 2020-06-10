package ru.agrointellect.screen.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.RptDesc
import java.util.*

class ReportModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var desc: RptDesc

    var dateFrom: Date? = null

    var dateTo: Date? = null

    val datesChanged = MutableLiveData<Boolean>()
}