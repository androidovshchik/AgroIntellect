package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsSoldAnimal : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            "Продажа коров всего",
            "Продажа нетелей",
            "Продажа телок всего",
            "Продажа быков"
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { Row(it.date, it.evtSoldCowsTotal) }),
                Column(legends[1], items.map { Row(it.date, it.evtSoldPheifers) }),
                Column(legends[2], items.map { Row(it.date, it.evtSoldHeifersTotal) }),
                Column(legends[3], items.map { Row(it.date, it.evtSoldBulls) })
            )
        }

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldPheifers) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtSoldBulls) }, null)
        )

    @SerializedName("rpt_sold_animals")
    @Expose
    lateinit var items: List<RptSoldAnimal>
}