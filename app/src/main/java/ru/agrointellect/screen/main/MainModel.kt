package ru.agrointellect.screen.main

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.api.Farm
import ru.agrointellect.remote.api.Report

class MainModel : ViewModel() {

    val farm: Farm?
        get() = farms.firstOrNull { it.isSelected }

    val farms = mutableListOf<Farm>()

    val reports = mutableListOf<Report>()
}