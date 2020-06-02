package ru.agrointellect.screen.chart

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report

class ChartModel : ViewModel() {

    lateinit var farm: Farm

    lateinit var report: Report.Default
}