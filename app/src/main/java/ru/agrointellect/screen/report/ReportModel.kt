package ru.agrointellect.screen.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.api.RptDesc
import ru.agrointellect.remote.dto.Farm
import java.util.*

open class ReportModel : ViewModel() {

    lateinit var farm: Farm

    private var rptDesc: RptDesc? = null

    val farmReportIds: String
        get() = "${farm.id}-${getDesc().id}"

    open fun setDesc(desc: RptDesc) {
        rptDesc = desc
    }

    open fun getDesc() = rptDesc!!

    var dateFrom: Date? = null

    var dateTo: Date? = null

    var period: String? = null

    val paramsChanged = MutableLiveData<Boolean>()
}