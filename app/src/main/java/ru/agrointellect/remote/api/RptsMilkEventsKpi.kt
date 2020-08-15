package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsMilkEventsKpi : Table, Graph {

    override val legends: List<String>
        get() = listOf(
            "Надой 1 д/к",
            "Осеменений коров",
            "Проверено на стельность коров",
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
                Column("Надой 1 ф/к", rowsByField("mlkMilkPerCow")),
                Column(legends[0], rowsByField("mlkMilkPerLactCow")),
                Column(legends[1], rowsByField("evtInsemCows")),
                Column(legends[2], rowsByField("evtPregCheckCows")),
                Column(legends[3], rowsByField("evtDryCows")),
                Column(legends[4], rowsByField("evtMoveCows")),
                Column(legends[5], rowsByField("evtVaccCows")),
                Column(legends[6], rowsByField("evtFootrimCows")),
                Column(legends[7], rowsByField("feedKpi"))
            )
        }

    override val data: GraphData
        get() = LineData(
            mutableListOf<ILineDataSet>(
                LineDataSet(entriesByField("mlkMilkPerLactCow"), null),
                LineDataSet(entriesByField("evtInsemCows"), null),
                LineDataSet(entriesByField("evtPregCheckCows"), null),
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