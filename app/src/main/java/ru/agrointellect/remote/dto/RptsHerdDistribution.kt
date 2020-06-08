package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.ChartData
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asFloat
import kotlin.math.max

@Suppress("SpellCheckingInspection")
class RptsHerdDistribution : Table, ChartBase {

    override val legends: List<String>
        get() = listOf("Фуражных коров", "Дойных коров всего", "Стельных коров")

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { Row(it.date, it.hrdCowsAll) }),
                Column(legends[1], items.map { Row(it.date, it.hrdCowsLactAll) }),
                Column(legends[2], items.map { Row(it.date, it.hrdCowsPregAll) })
            )
        }

    override val data: ChartData<*>
        get() = BarData(
            BarDataSet(items.map {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = max(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = max(0f, it.hrdCowsAll.asFloat - val2 - val1)
                newGroupBarEntry(it.date, floatArrayOf(val1, val2, val3))
            }, null)
        )

    @SerializedName("rpt_herd_distribution")
    @Expose
    lateinit var items: List<RptHerdDistribution>
}