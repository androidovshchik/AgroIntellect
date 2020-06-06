package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsSoldAnimal : Table, ChartBar {

    override val columns: List<Column>
        get() = listOf(
            Column("Продажа коров всего", items.map { Row(it.date, it.evtSoldCowsTotal) }),
            Column("Продажа нетелей", items.map { Row(it.date, it.evtSoldPheifers) }),
            Column("Продажа телок всего", items.map { Row(it.date, it.evtSoldHeifersTotal) }),
            Column("Продажа быков", items.map { Row(it.date, it.evtSoldBulls) })
        )

    override val data: BarData
        get() = BarData(
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldCowsTotal?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldPheifers?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldHeifersTotal?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtSoldBulls?.toFloatOrNull() ?: 0f)
            }, null)
        )

    @SerializedName("rpt_sold_animals")
    @Expose
    lateinit var items: List<RptSoldAnimal>
}