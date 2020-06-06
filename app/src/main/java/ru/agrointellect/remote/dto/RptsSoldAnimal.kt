package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsSoldAnimal : Table, ChartBar {

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

    override val barData: BarData
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