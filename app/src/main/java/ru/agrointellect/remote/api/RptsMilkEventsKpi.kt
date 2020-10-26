package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.bean.RptMilkEventsKpi

@Suppress("SpellCheckingInspection")
class RptsMilkEventsKpi : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            D["mlk_milk_per_lact_cow"],
            D["evt_insem_cows"],
            D["evt_preg_check_cows"],
            D["evt_dry_cows"],
            D["evt_move_cows"],
            D["evt_vacc_cows"],
            D["evt_footrim_cows"],
            D["feed_kpi"]
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column(D["mlk_milk_sum_yield"], rowsBy("mlkMilkSumYield")),
                Column(D["mlk_milk_per_cow"], rowsBy("mlkMilkPerCow")),
                Column(legends[0], rowsBy("mlkMilkPerLactCow")),
                Column(legends[1], rowsBy("evtInsemCows")),
                Column(legends[2], rowsBy("evtPregCheckCows")),
                Column(legends[3], rowsBy("evtDryCows")),
                Column(legends[4], rowsBy("evtMoveCows")),
                Column(legends[5], rowsBy("evtVaccCows")),
                Column(legends[6], rowsBy("evtFootrimCows")),
                Column(legends[7], rowsBy("feedKpi")),
                Column(D["feed_cost_1kg_milk_total"], rowsBy("feedCost1kgMilkTotal")),
                Column(D["feed_cost_1kg_milk_cows_all"], rowsBy("feedCost1kgMilkCowsAll")),
                Column(D["feed_cost_1kg_milk_cows_lact"], rowsBy("feedCost1kgMilkCowsLact"))
            )
        }

    override val data: GraphData
        get() = LineData(
            mutableListOf<ILineDataSet>(
                LineDataSet(entriesBy("mlkMilkPerLactCow"), null),
                LineDataSet(entriesBy("evtInsemCows"), null),
                LineDataSet(entriesBy("evtPregCheckCows"), null),
                LineDataSet(entriesBy("evtDryCows"), null),
                LineDataSet(entriesBy("evtMoveCows"), null),
                LineDataSet(entriesBy("evtVaccCows"), null),
                LineDataSet(entriesBy("evtFootrimCows"), null),
                LineDataSet(entriesBy("feedKpi"), null)
            )
        )

    private fun rowsBy(name: String): List<Row> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.map { newRow(it.date, field.get(it)?.toString()) }
    }

    private fun entriesBy(name: String): List<Entry> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.mapNotNull { newEntry(it.date, field.get(it)?.toString()) }
    }

    @SerializedName("rpt_milk_events_kpi")
    @Expose
    lateinit var items: List<RptMilkEventsKpi>
}