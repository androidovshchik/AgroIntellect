package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.dto.RptDiedAnimal

@Suppress("SpellCheckingInspection")
class RptsDiedAnimal : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            D["evt_dead_cows_total"],
            D["evt_dead_pheifers"],
            D["evt_dead_heifers_total"],
            D["evt_dead_bulls"]
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { newRow(it.date, it.evtDeadCowsTotal) }),
                Column(legends[1], items.map { newRow(it.date, it.evtDeadPheifers) }),
                Column(legends[2], items.map { newRow(it.date, it.evtDeadHeifersTotal) }),
                Column(legends[3], items.map { newRow(it.date, it.evtDeadBulls) })
            )
        }

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadCowsTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadPheifers) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadHeifersTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtDeadBulls) }, null)
        )

    @SerializedName("rpt_died_animals")
    @Expose
    lateinit var items: List<RptDiedAnimal>
}