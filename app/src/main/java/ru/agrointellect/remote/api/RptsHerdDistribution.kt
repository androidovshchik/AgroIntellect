package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asFloat
import ru.agrointellect.local.D
import kotlin.math.max

@Suppress("SpellCheckingInspection")
class RptsHerdDistribution : Table, Graph {

    override val legends: List<String>
        get() = listOf(D["hrd_cows_all"], D["hrd_cows_lact_all"], D["hrd_cows_preg_all"])

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { Row(it.date, it.hrdCowsAll) }),
                Column(legends[1], items.map { Row(it.date, it.hrdCowsLactAll) }),
                Column(legends[2], items.map { Row(it.date, it.hrdCowsPregAll) })
            )
        }

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull {
                val val1 = it.hrdCowsPregAll.asFloat
                val val2 = max(0f, it.hrdCowsLactAll.asFloat - val1)
                val val3 = max(0f, it.hrdCowsAll.asFloat - val2 - val1)
                newBarEntry(it.date, floatArrayOf(val1, val2, val3))
            }, null)
        )

    @SerializedName("rpt_herd_distribution")
    @Expose
    lateinit var items: List<RptHerdDistribution>
}