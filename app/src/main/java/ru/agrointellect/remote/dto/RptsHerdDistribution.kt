package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdDistribution : Table, ChartBar {

    override val legends: List<String>
        get() = listOf(
            "Фуражных коров",
            "Дойных коров всего",
            "Стельных коров"
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { Row(it.date, it.hrdCowsAll) }),
                Column(legends[1], items.map { Row(it.date, it.hrdCowsLactAll) }),
                Column(legends[2], items.map { Row(it.date, it.hrdCowsPregAll) })
            )
        }

    override val barData: BarData
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll?.toFloatOrNull() ?: 0f
                val val2 = it.hrdCowsLactAll?.toFloatOrNull()?.minus(val1) ?: 0f
                val val3 = it.hrdCowsAll?.toFloatOrNull()?.minus(val1 + val2) ?: 0f
                BarEntry(parseDate(it.date), floatArrayOf(val1, val2, val3))
            }, null)
        )

    @SerializedName("rpt_herd_distribution")
    @Expose
    lateinit var items: List<RptHerdDistribution>
}