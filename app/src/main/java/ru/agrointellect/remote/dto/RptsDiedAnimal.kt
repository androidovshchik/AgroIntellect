package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsDiedAnimal : Table, ChartBar {

    override val columns: List<Column>
        get() = listOf(
            Column("Падеж коров всего", items.map { Row(it.date, it.evtDeadCowsTotal) }),
            Column("Падеж нетелей", items.map { Row(it.date, it.evtDeadPheifers) }),
            Column("Падеж телок всего", items.map { Row(it.date, it.evtDeadHeifersTotal) }),
            Column("Падеж быков", items.map { Row(it.date, it.evtDeadBulls) })
        )

    override val data: BarData
        get() = BarData(
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadCowsTotal?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadPheifers?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadHeifersTotal?.toFloatOrNull() ?: 0f)
            }, null),
            BarDataSet(items.map {
                BarEntry(parseDate(it.date), it.evtDeadBulls?.toFloatOrNull() ?: 0f)
            }, null)
        )

    @SerializedName("rpt_died_animals")
    @Expose
    lateinit var items: List<RptDiedAnimal>
}