package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsFreshDisease : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            "Отелов всего",
            "Задержаний последа всего",
            "Парезов всего",
            "Кетозов всего",
            "Метритов"
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(legends[0], items.map { Row(it.date, it.evtCalvTotal) }),
                Column(legends[1], items.map { Row(it.date, it.evtRetPlacTotal) }),
                Column(legends[2], items.map { Row(it.date, it.evtParesTotal) }),
                Column(legends[3], items.map { Row(it.date, it.evtKetosTotal) }),
                Column(legends[4], items.map { Row(it.date, it.evtMetrit) })
            )
        }

    override val data: GraphData
        get() = BarData(
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtCalvTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtRetPlacTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtParesTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtKetosTotal) }, null),
            BarDataSet(items.mapNotNull { newBarEntry(it.date, it.evtMetrit) }, null)
        )

    @SerializedName("rpt_fresh_disease")
    @Expose
    lateinit var items: List<RptFreshDisease>
}