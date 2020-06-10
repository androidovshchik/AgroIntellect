package ru.agrointellect.screen.chart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.ChtDesc
import ru.agrointellect.remote.dto.Farm
import java.util.*

class ChartModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var desc: ChtDesc

    var dateFrom: Date? = null

    var dateTo: Date? = null

    val datesChanged = MutableLiveData<Boolean>()
}