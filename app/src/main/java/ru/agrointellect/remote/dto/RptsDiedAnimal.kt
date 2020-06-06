package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsDiedAnimal : Table, ChartBar {

    override val legends = listOf(
        "Падеж коров всего",
        "Падеж нетелей",
        "Падеж телок всего",
        "Падеж быков"
    )

    override val columns: List<Column>
        get() = listOf(
            Column(legends[0], items.map { Row(it.date, it.evtDeadCowsTotal) }),
            Column(legends[1], items.map { Row(it.date, it.evtDeadPheifers) }),
            Column(legends[2], items.map { Row(it.date, it.evtDeadHeifersTotal) }),
            Column(legends[3], items.map { Row(it.date, it.evtDeadBulls) })
        )

    override val barData: BarData
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