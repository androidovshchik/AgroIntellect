package ru.agrointellect.screen.main

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report

class MainModel : ViewModel() {

    val farm: Farm?
        get() = farms.firstOrNull { it.isSelected }

    val farms = mutableListOf<Farm>()

    val reports = mutableListOf<Report>()
}