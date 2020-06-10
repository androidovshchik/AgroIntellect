package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsMilkEventsKpi : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            "Надой 1 ф/к",
            "Надой 1 д/к",
            "Осеменений коров",
            "Выявлено стельных коров",
            "Запущено коров",
            "Переводов коров",
            "Вакцинация коров",
            "Расчистка копыт коров",
            "KPI кормления"
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column("Валовой надой", rowsByField("mlkMilkSumYield")),
                Column(legends[0], rowsByField("mlkMilkPerCow")),
                Column(legends[1], rowsByField("mlkMilkPerLactCow")),
                Column(legends[2], rowsByField("evtInsemCows")),
                Column(legends[3], rowsByField("evtGotPregCows")),
                Column(legends[4], rowsByField("evtDryCows")),
                Column(legends[5], rowsByField("evtMoveCows")),
                Column(legends[6], rowsByField("evtVaccCows")),
                Column(legends[7], rowsByField("evtFootrimCows")),
                Column(legends[8], rowsByField("feedKpi"))
            )
        }

    override val data: GraphData
        get() = LineData(
            listOf(
                LineDataSet(entriesByField("mlkMilkPerCow"), null),
                LineDataSet(entriesByField("mlkMilkPerLactCow"), null),
                LineDataSet(entriesByField("evtInsemCows"), null),
                LineDataSet(entriesByField("evtGotPregCows"), null),
                LineDataSet(entriesByField("evtDryCows"), null),
                LineDataSet(entriesByField("evtMoveCows"), null),
                LineDataSet(entriesByField("evtVaccCows"), null),
                LineDataSet(entriesByField("evtFootrimCows"), null),
                LineDataSet(entriesByField("feedKpi"), null)
            )
        )

    private fun rowsByField(name: String): List<Row> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.map { Row(it.date, field.get(it)?.toString()) }
    }

    private fun entriesByField(name: String): List<Entry> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.mapNotNull { newEntry(it.date, field.get(it)?.toString()) }
    }

    @SerializedName("rpt_milk_events_kpi")
    @Expose
    lateinit var items: List<RptMilkEventsKpi>
}