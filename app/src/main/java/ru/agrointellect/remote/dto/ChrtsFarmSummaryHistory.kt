@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.ChartData
import ru.agrointellect.extension.f
import kotlin.math.max

/**
 * График: Поголовье: фуражное, дойное, стельное
 */
class ChrtsFarmSummaryHistory2 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Фуражных коров", "Дойных коров всего", "Стельных коров")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll.f
                val val2 = max(0f, it.hrdCowsLactAll.f - val1)
                val val3 = max(0f, it.hrdCowsAll.f - val2 - val1)
                BarEntry(parseDate(it.date), floatArrayOf(val1, val2, val3))
            }, null)
        )
}

/**
 * График: Кетозы
 */
class ChrtsFarmSummaryHistory3 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Кетозов всего")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtKetosTotal.f) }, null)
        )
}

/**
 * График: График послеотельных осложнений
 */
class ChrtsFarmSummaryHistory4 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Отелов всего", "Задержаний последа всего", "Парезов всего")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtCalvTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtRetPlacTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtParesTotal.f) }, null)
        )
}

/**
 * График: Продажа коров всего + продажа нетелей + продажа телок
 */
class ChrtsFarmSummaryHistory5 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Продажа коров всего", "Продажа телок всего", "Продажа нетелей")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtSoldCowsTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtSoldHeifersTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtSoldPheifers.f) }, null)
        )
}

/**
 * График: Падеж коров всего + падеж нетелей + падеж телок
 */
class ChrtsFarmSummaryHistory6 : RptsFarmSummaryHistory() {

    override val legends: List<String>
        get() = listOf("Падеж коров всего", "Падеж телок всего", "Падеж нетелей")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtDeadCowsTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtDeadHeifersTotal.f) }, null),
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtDeadPheifers.f) }, null)
        )
}