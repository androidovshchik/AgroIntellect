package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.ChartData
import ru.agrointellect.extension.asFloat
import kotlin.math.max

/**
 * График: Поголовье: фуражное, дойное, стельное
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory2 : RptsFarmSummaryHistory() {

    override val legends: Collection<String>
        get() = listOf("Фуражных коров", "Дойных коров всего", "Стельных коров")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = max(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = max(0f, it.hrdCowsAll.asFloat - val2 - val1)
                BarEntry(parseDate(it.date), floatArrayOf(val1, val2, val3))
            }, null)
        )
}

/**
 * График: Кетозы
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory3 : RptsFarmSummaryHistory() {

    override val legends: Collection<String>
        get() = listOf("Кетозов всего")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtKetosTotal.asFloat) }, null)
        )
}

/**
 * График: График послеотельных осложнений
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory4 : RptsFarmSummaryHistory() {

    override val legends: Collection<String>
        get() = listOf("Отелов всего", "Задержаний последа всего", "Парезов всего")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtCalvTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtRetPlacTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtParesTotal.asFloat)
            }, null)
        )
}

/**
 * График: Продажа коров всего + продажа нетелей + продажа телок
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory5 : RptsFarmSummaryHistory() {

    override val legends: Collection<String>
        get() = listOf("Продажа коров всего", "Продажа телок всего", "Продажа нетелей")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldCowsTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldHeifersTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldPheifers.asFloat)
            }, null)
        )
}

/**
 * График: Падеж коров всего + падеж нетелей + падеж телок
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory6 : RptsFarmSummaryHistory() {

    override val legends: Collection<String>
        get() = listOf("Падеж коров всего", "Падеж телок всего", "Падеж нетелей")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadCowsTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadHeifersTotal.asFloat)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadPheifers.asFloat)
            }, null)
        )
}