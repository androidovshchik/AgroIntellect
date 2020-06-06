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
        get() {
            return BarData(
                BarDataSet(items.mapNotNull {
                    it.evtSoldCowsTotal?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Продажа коров всего"),
                BarDataSet(items.mapNotNull {
                    it.evtSoldPheifers?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Продажа нетелей"),
                BarDataSet(items.mapNotNull {
                    it.evtSoldHeifersTotal?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Продажа телок всего"),
                BarDataSet(items.mapNotNull {
                    it.evtSoldBulls?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Продажа быков")
            )
        }

    @SerializedName("rpt_sold_animals")
    @Expose
    lateinit var items: List<RptSoldAnimal>
}