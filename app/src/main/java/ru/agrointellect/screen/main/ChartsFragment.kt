package ru.agrointellect.screen.main

import ru.agrointellect.remote.dto.Report

class ChartsFragment : ReportsFragment() {

    override val defaultList = listOf(
        Report.Default("rpt_herd_distribution", "Поголовье: фуражное, дойное, стельное", true),
        Report.Default("rpt_herd_lactation_graph", "График лактации поголовья", false),
        Report.Default("rpt_milk_events_kpi", "Надой, события, кормление", true),
        Report.Default("rpt_farm_summary_history", "Валовой надой + KPI", true),
        Report.Default("rpt_farm_summary_history", "Поголовье: фуражное, дойное, стельное", true),
        Report.Default("rpt_farm_summary_history", "Кетозы", true),
        Report.Default("rpt_farm_summary_history", "График послеотельных осложнений", true),
        Report.Default(
            "rpt_farm_summary_history",
            "Продажа коров всего + продажа нетелей + продажа телок",
            true
        ),
        Report.Default(
            "rpt_farm_summary_history",
            "Падеж коров всего + падеж нетелей + падеж телок",
            true
        ),
        Report.Default("rpt_sold_animals", "Продажа", true),
        Report.Default("rpt_died_animals", "Падеж", true)
    )
}