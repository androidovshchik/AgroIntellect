package ru.agrointellect.screen.main

import androidx.lifecycle.ViewModel
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Report

class MainModel : ViewModel() {

    val farm: Farm?
        get() = farms.firstOrNull { it.selected }

    val farms = mutableListOf<Farm>()

    val reports = mutableListOf<Report>()
}