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
                Column("Валовой надой", rowsBy("mlkMilkSumYield")),
                Column("Надой 1 ф/к", rowsBy("mlkMilkPerCow")),
                Column(legends[0], rowsBy("mlkMilkPerLactCow")),
                Column(legends[1], rowsBy("evtInsemCows")),
                Column(legends[2], rowsBy("evtPregCheckCows")),
                Column(legends[3], rowsBy("evtDryCows")),
                Column(legends[4], rowsBy("evtMoveCows")),
                Column(legends[5], rowsBy("evtVaccCows")),
                Column(legends[6], rowsBy("evtFootrimCows")),
                Column(legends[7], rowsBy("feedKpi"))
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
        return items.map { Row(it.date, field.get(it)?.toString()) }
    }

    private fun entriesBy(name: String): List<Entry> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.mapNotNull { newEntry(it.date, field.get(it)?.toString()) }
    }

    @SerializedName("rpt_milk_events_kpi")
    @Expose
    lateinit var items: List<RptMilkEventsKpi>
}