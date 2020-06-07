package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asFloat
import kotlin.math.min

/**
 * График: Валовой надой + KPI
 */
@Suppress("SpellCheckingInspection")
open class ChrtsFarmSummaryHistory1 : ChartBase {

    override val legends: Collection<String>
        get() = listOf("Валовой надой", "KPI кормления")

    override val data: ChartData<*>
        get() = LineData(
            listOf(
                LineDataSet(entryByField("mlkMilkSumYield"), null),
                LineDataSet(entryByField("feedKpi"), null)
            )
        )

    protected fun entryByField(name: String): List<Entry> {
        val field = RptFarmSummaryHistory::class.java.getField(name)
        return items.map { Entry(parseDate(it.date), field.get(it).asFloat) }
    }

    @SerializedName("rpt_farm_summary_history")
    @Expose
    lateinit var items: List<RptFarmSummaryHistory>
}

/**
 * График: Поголовье: фуражное, дойное, стельное
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory2 : ChrtsFarmSummaryHistory1() {

    override val legends: Collection<String>
        get() = listOf("Фуражных коров", "Дойных коров всего", "Стельных коров")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = min(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = min(0f, it.hrdCowsAll.asFloat - val2 - val1)
                BarEntry(parseDate(it.date), floatArrayOf(val1, val2, val3))
            }, null)
        )
}

/**
 * График: Кетозы
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory3 : ChrtsFarmSummaryHistory1() {

    override val legends: Collection<String>
        get() = listOf("Кетозов всего")

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map { BarEntry(parseDate(it.date), it.evtKetosTotal.asFloat) }, null)
        )
}