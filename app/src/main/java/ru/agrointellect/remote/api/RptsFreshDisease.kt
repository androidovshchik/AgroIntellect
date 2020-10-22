package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.bean.RptFreshDisease

@Suppress("SpellCheckingInspection")
class RptsFreshDisease : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            D["evt_calv_total"],
            D["evt_ret_plac_total"],
            D["evt_pares_total"],
            D["evt_ketos_total"],
            D["evt_metrit"]
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