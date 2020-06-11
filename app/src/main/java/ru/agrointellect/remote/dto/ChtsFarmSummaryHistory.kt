@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import ru.agrointellect.extension.asFloat
import kotlin.math.max

/**
 * График: Поголовье: фуражное, дойное, стельное
 */
class ChtsFarmSummaryHistory2 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Фуражных коров", "Дойных коров всего", "Стельных коров")

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
        get() = listOf("Кетозов всего")

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
        get() = listOf("Отелов всего", "Задержаний последа всего", "Парезов всего")

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
        get() = listOf("Продажа коров всего", "Продажа телок всего", "Продажа нетелей")

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
        get() = listOf("Падеж коров всего", "Падеж телок всего", "Падеж нетелей")

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadPheifers) }, null)
        )
}