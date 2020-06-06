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
        get() {
            return BarData(
                BarDataSet(items.mapNotNull {
                    it.evtDeadCowsTotal?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Падеж коров всего"),
                BarDataSet(items.mapNotNull {
                    it.evtDeadPheifers?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Падеж нетелей"),
                BarDataSet(items.mapNotNull {
                    it.evtDeadHeifersTotal?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Падеж телок всего"),
                BarDataSet(items.mapNotNull {
                    it.evtDeadBulls?.toFloatOrNull()?.let { value ->
                        BarEntry(parseDate(it.date), value)
                    }
                }, "Падеж быков")
            )
        }

    @SerializedName("rpt_died_animals")
    @Expose
    lateinit var items: List<RptDiedAnimal>
}