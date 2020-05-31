package ru.agrointellect.screen.main

import ru.agrointellect.remote.dto.Report

class ChartsFragment : ReportsFragment() {

    override val defaultList = listOf(
        Report.Default("rpt_herd_distribution", "Поголовье: фуражное, дойное, стельное", 2),
        Report.Default("rpt_herd_lactation_graph", "График лактации поголовья", 0),
        Report.Default("rpt_milk_events_kpi", "Надой, события, кормление", 2),
        Report.Default("rpt_farm_summary_history", "Валовой надой + KPI", 2),
        Report.Default("rpt_farm_summary_history", "Поголовье: фуражное, дойное, стельное", 2),
        Report.Default("rpt_farm_summary_history", "Кетозы", 2),
        Report.Default("rpt_farm_summary_history", "График послеотельных осложнений", 2),
        Report.Default(
            "rpt_farm_summary_history",
            "Продажа коров всего + продажа нетелей + продажа телок",
            2
        ),
        Report.Default(
            "rpt_farm_summary_history",
            "Падеж коров всего + падеж нетелей + падеж телок",
            2
        ),
        Report.Default("rpt_sold_animals", "Продажа", 2),
        Report.Default("rpt_died_animals", "Падеж", 2)
    )
}