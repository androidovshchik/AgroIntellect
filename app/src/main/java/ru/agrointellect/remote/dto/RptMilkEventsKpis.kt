package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Надой, события, кормление
 */
@Suppress("SpellCheckingInspection")
class RptMilkEventsKpis : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Валовой надой", mapByField("mlkMilkSumYield")),
            Column("Надой 1 ф/к", mapByField("mlkMilkPerCow")),
            Column("Надой 1 д/к", mapByField("mlkMilkPerLactCow")),
            Column("Осеменений коров", mapByField("evtInsemCows")),
            Column("Выявлено стельных коров", mapByField("evtGotPregCows")),
            Column("Запущено коров", mapByField("evtDryCows")),
            Column("Переводов коров", mapByField("evtMoveCows")),
            Column("Вакцинация коров", mapByField("evtVaccCows")),
            Column("Расчистка копыт коров", mapByField("evtFootrimCows")),
            Column("KPI кормления", mapByField("feedKpi"))
        )

    private fun mapByField(name: String): List<Row> {
        val field = RptMilkEventsKpi::class.java.getField(name)
        return items.map { Row(it.date, field.get(it)?.toString() ?: "0") }
    }

    @SerializedName("rpt_milk_events_kpi")
    @Expose
    lateinit var items: List<RptMilkEventsKpi>
}