package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsMilkEventsKpi : Table, Graph {

    override val legends: List<Option>
        get() = listOf(
            Option("Надой 1 ф/к"),
            Option("Надой 1 д/к"),
            Option("Осеменений коров"),
            Option("Выявлено стельных коров"),
            Option("Запущено коров"),
            Option("Переводов коров"),
            Option("Вакцинация коров"),
            Option("Расчистка копыт коров"),
            Option("KPI кормления")
        )

    override val columns: List<Column>
        get() {
            val legends = legends
            return listOf(
                Column("Валовой надой", rowsByField("mlkMilkSumYield")),
                Column(legends[0].name, rowsByField("mlkMilkPerCow")),
                Column(legends[1].name, rowsByField("mlkMilkPerLactCow")),
                Column(legends[2].name, rowsByField("evtInsemCows")),
                Column(legends[3].name, rowsByField("evtGotPregCows")),
                Column(legends[4].name, rowsByField("evtDryCows")),
                Column(legends[5].name, rowsByField("evtMoveCows")),
                Column(legends[6].name, rowsByField("evtVaccCows")),
                Column(legends[7].name, rowsByField("evtFootrimCows")),
                Column(legends[8].name, rowsByField("feedKpi"))
            )
        }

    override val data: GraphData
        get() = LineData(
            mutableListOf<ILineDataSet>(
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