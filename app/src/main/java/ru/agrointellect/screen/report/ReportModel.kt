package ru.agrointellect.screen.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.RptDesc
import java.util.*

open class ReportModel : ViewModel() {

    lateinit var farm: Farm

    private var rptDesc: RptDesc? = null

    open fun setDesc(desc: RptDesc) {
        rptDesc = desc
    }

    open fun getDesc() = rptDesc!!

    var dateFrom: Date? = null

    var dateTo: Date? = null

    val datesChanged = MutableLiveData<Boolean>()
}