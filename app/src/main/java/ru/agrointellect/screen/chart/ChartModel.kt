package ru.agrointellect.screen.chart

import androidx.lifecycle.MutableLiveData
import ru.agrointellect.remote.dto.ChtDesc
import ru.agrointellect.remote.dto.RptDesc
import ru.agrointellect.screen.report.ReportModel

class ChartModel : ReportModel() {

    private lateinit var chtDesc: ChtDesc

    override fun setDesc(desc: RptDesc) {
        chtDesc = desc as ChtDesc
    }

    override fun getDesc() = chtDesc

    val toggleChanged = MutableLiveData<Int>()
}