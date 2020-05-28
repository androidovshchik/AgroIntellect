package ru.agrointellect.screen.main

import ru.agrointellect.remote.dto.Report

class ChartsFragment : ReportsFragment() {

    override fun List<Report>.filtered(): List<Report> {
        return filter { it.hasChart }
    }
}