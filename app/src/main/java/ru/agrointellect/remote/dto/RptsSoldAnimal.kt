package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsSoldAnimal : Table, Graph {

    override val legends: List<Option>
        get() = listOf(
            Option("Продажа коров всего"),
            Option("Продажа нетелей"),
            Option("Продажа телок всего"),
            Option("Продажа быков")
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0].name, items.map { Row(it.date, it.evtSoldCowsTotal) }),
                Column(legends[1].name, items.map { Row(it.date, it.evtSoldPheifers) }),
                Column(legends[2].name, items.map { Row(it.date, it.evtSoldHeifersTotal) }),
                Column(legends[3].name, items.map { Row(it.date, it.evtSoldBulls) })
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