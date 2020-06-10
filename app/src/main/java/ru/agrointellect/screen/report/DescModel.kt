package ru.agrointellect.screen.report

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.RptDesc
import java.util.*

abstract class DescModel<T : RptDesc> : ViewModel() {

    lateinit var farm: Farm

    lateinit var desc: T

    var dateFrom: Date? = null

    var dateTo: Date? = null

    val datesChanged = MutableLiveData<Boolean>()
}