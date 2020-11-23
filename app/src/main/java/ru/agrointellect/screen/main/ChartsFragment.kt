package ru.agrointellect.screen.main

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.remote.api.ChtDesc
import ru.agrointellect.remote.api.Period

@Suppress("SpellCheckingInspection")
class ChartsFragment : ReportsFragment() {

    override val defaultList: List<ChtDesc>
        get() = listOf(
            ChtDesc("rpt_herd_distribution", "Поголовье: фуражное, дойное, стельное", 2),
            ChtDesc("rpt_herd_lactation_graph", "График лактации поголовья", 0),
            ChtDesc("rpt_milk_events_kpi", "Надой, события, кормление", 2),
            ChtDesc("rpt_fresh_disease", "Послеотельные заболевания", 2),
            ChtDesc("rpt_farm_summary_history", "Валовой надой + KPI", 2),
            ChtDesc(
                "rpt_farm_summary_history",
                "Поголовье: фуражное, дойное, стельное",
                2,
                "cht_farm_summary_history2"
            ),
            ChtDesc(
                "rpt_farm_summary_history",
                "Кетозы",
                2,
                "cht_farm_summary_history3"
            ),
            ChtDesc(
                "rpt_farm_summary_history",
                "График послеотельных осложнений",
                2,
                "cht_farm_summary_history4"
            ),
            ChtDesc(
                "rpt_farm_summary_history",
                "Продажа коров всего + продажа нетелей + продажа телок",
                2,
                "cht_farm_summary_history5"
            ),
            ChtDesc(
                "rpt_farm_summary_history",
                "Падеж коров всего + падеж нетелей + падеж телок",
                2,
                "cht_farm_summary_history6"
            ),
            ChtDesc(
                "rpt_out_cows_main_reasons",
                "Основные причины выбытия коров",
                2,
                period = Period.TOTAL
            ),
            ChtDesc(
                "rpt_out_heif_main_reasons",
                "Основные причины выбытия молодняка",
                2,
                period = Period.TOTAL
            ),
            ChtDesc("rpt_sold_animals", "Продажа", 2),
            ChtDesc("rpt_died_animals", "Падеж", 2)
        )

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите график"
        }
        return inflater.inflate(R.layout.fragment_reports, root, false)
    }
}