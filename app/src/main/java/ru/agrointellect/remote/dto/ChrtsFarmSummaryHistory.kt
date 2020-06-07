package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.ChartData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Грфик: Поголовье: фуражное, дойное, стельное
 */
@Suppress("SpellCheckingInspection")
class ChrtsFarmSummaryHistory2 : ChartBase {

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

    @SerializedName("rpt_farm_summary_history")
    @Expose
    lateinit var items: List<RptFarmSummaryHistory>
}