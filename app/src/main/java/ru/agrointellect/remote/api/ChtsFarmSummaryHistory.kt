@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import ru.agrointellect.extension.asFloat
import ru.agrointellect.local.D
import kotlin.math.max

/**
 * График: Поголовье: фуражное, дойное, стельное
 */
class ChtsFarmSummaryHistory2 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf(D["hrd_cows_all"], D["hrd_cows_lact_all"], D["hrd_cows_preg_all"])

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = max(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = max(0f, it.hrdCowsAll.asFloat - val2 - val1)
                newBarEntry(it.date, floatArrayOf(val1, val2, val3))
            }, null)
        )
}

/**
 * График: Кетозы
 */
class ChtsFarmSummaryHistory3 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf(D["evt_ketos_total"])

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtKetosTotal) }, null)
        )
}

/**
 * График: График послеотельных осложнений
 */
class ChtsFarmSummaryHistory4 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf(D["evt_calv_total"], D["evt_ret_plac_total"], D["evt_pares_total"])

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtCalvTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtRetPlacTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtParesTotal) }, null)
        )
}

/**
 * График: Продажа коров всего + продажа нетелей + продажа телок
 */
class ChtsFarmSummaryHistory5 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf(
            D["evt_sold_cows_total"],
            D["evt_sold_heifers_total"],
            D["evt_sold_pheifers"]
        )

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldPheifers) }, null)
        )
}

/**
 * График: Падеж коров всего + падеж нетелей + падеж телок
 */
class ChtsFarmSummaryHistory6 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf(
            D["evt_dead_cows_total"],
            D["evt_dead_heifers_total"],
            D["evt_dead_pheifers"]
        )

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadPheifers) }, null)
        )
}