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

    override val legends: List<Option>
        get() = listOf(
            Option("Фуражных коров"),
            Option("Дойных коров всего"),
            Option("Стельных коров")
        )

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = max(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = max(0f, it.hrdCowsAll.asFloat - val2 - val1)
                newGroupBarEntry(it.date, floatArrayOf(val1, val2, val3))
            }, null)
        )
}

/**
 * График: Кетозы
 */
class ChtsFarmSummaryHistory3 : RptsFarmSummaryHistory() {

    override val legends: List<Option>
        get() = listOf(Option("Кетозов всего"))

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtKetosTotal) }, null)
        )
}

/**
 * График: График послеотельных осложнений
 */
class ChtsFarmSummaryHistory4 : RptsFarmSummaryHistory() {

    override val legends: List<Option>
        get() = listOf(
            Option("Отелов всего"),
            Option("Задержаний последа всего"),
            Option("Парезов всего")
        )

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

    override val legends: List<Option>
        get() = listOf(
            Option("Продажа коров всего"),
            Option("Продажа телок всего"),
            Option("Продажа нетелей")
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

    override val legends: List<Option>
        get() = listOf(
            Option("Падеж коров всего"),
            Option("Падеж телок всего"),
            Option("Падеж нетелей")
        )

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadPheifers) }, null)
        )
}