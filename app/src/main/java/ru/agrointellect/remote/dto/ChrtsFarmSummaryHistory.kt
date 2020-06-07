package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asFloat

/**
 * График: Валовой надой + KPI
 */
@Suppress("SpellCheckingInspection")
open class ChrtsFarmSummaryHistory1 : ChartBase {

    override val legends: Collection<String>
        get() = listOf(
            "Валовой надой",
            "KPI кормления"
        )

    override val data: ChartData<*>
        get() = LineData(
            listOf(
                LineDataSet(mapByField("mlkMilkSumYield"), null),
                LineDataSet(mapByField("feedKpi"), null)
            )
        )

    protected fun mapByField(name: String): List<Entry> {
        val field = RptFarmSummaryHistory::class.java.getField(name)
        return items.map { Entry(parseDate(it.date), field.get(it).asFloat) }
    }

    @SerializedName("rpt_farm_summary_history")
    @Expose
    lateinit var items: List<RptFarmSummaryHistory>
}

/**
 * Грфик: Поголовье: фуражное, дойное, стельное
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory2 : ChrtsFarmSummaryHistory1() {

    override val legends: Collection<String>
        get() = listOf(
            "Фуражных коров",
            "Дойных коров всего",
            "Стельных коров"
        )

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll?.toFloatOrNull() ?: 0f
                val val2 = it.hrdCowsLactAll?.toFloatOrNull()?.minus(val1) ?: 0f
                val val3 = it.hrdCowsAll?.toFloatOrNull()?.minus(val1 + val2) ?: 0f
                BarEntry(parseDate(it.date), floatArrayOf(val1, val2, val3))
            }, null)
        )
}