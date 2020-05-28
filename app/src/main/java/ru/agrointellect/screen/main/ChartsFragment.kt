package ru.agrointellect.screen.main

import ru.agrointellect.remote.dto.Report
import ru.agrointellect.remote.dto.Reports

class ChartsFragment : ReportsFragment() {

    override fun Reports.filteredReports(): List<Report> {
        return reports.filter { it.hasChart }
    }
}