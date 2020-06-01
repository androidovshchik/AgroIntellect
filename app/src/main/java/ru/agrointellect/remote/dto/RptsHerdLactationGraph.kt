package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import de.siegmar.fastcsv.reader.CsvReader
import java.io.StringReader

/**
 * График лактации поголовья
 */
@Suppress("SpellCheckingInspection")
class RptsHerdLactationGraph : Table {

    private val csvReader = CsvReader()

    override val columns: List<Column>
        get() {
            val source = """
                ${items[0].lactationDays}
                ${items[0].averageLactationDailyMilk}
                ${items[0].lactation1DailyMilk}
                ${items[0].lactation2DailyMilk}
                ${items[0].lactationOver2DailyMilk}
                ${items[0].sampleLactation7500Per305MilkingDaysDailyMilk}
            """.trimIndent()
            val csv = csvReader.read(StringReader(source))
            val days = csv.getRow(0)
            return listOf(
                Column(
                    "Средняя лактация",
                    csv.getRow(1).fields.mapIndexed { i, value ->
                        Row("${days.getField(i)} день доения", value)
                    }
                ),
                Column(
                    "Лактация 1",
                    csv.getRow(2).fields.mapIndexed { i, value ->
                        Row("${days.getField(i)} день доения", value)
                    }
                ),
                Column(
                    "Лактация 2",
                    csv.getRow(3).fields.mapIndexed { i, value ->
                        Row("${days.getField(i)} день доения", value)
                    }
                )
                /*listOf(
                    Column(
                        "Средняя лактация",
                        items.mapIndexed { i, rptHerdLactationGraph ->
                            Row(
                                "$i день доения",
                                it.hrdCowsAll ?: "0"
                            )
                        }),
                    Column("Лактация 1", items.map { Row(it.date, it.hrdCowsLactAll ?: "0") }),
                    Column("Лактация 2", items.map { Row(it.date, it.hrdCowsLactAll ?: "0") }),
                    Column("Лактация > 2", items.map { Row(it.date, it.hrdCowsPregAll ?: "0") }),
                    Column(
                        "Образец 7500 за 305 дней",
                        items.map { Row(it.date, it.hrdCowsPregAll ?: "0") })
                )*/
            )
        }

    @SerializedName("rpt_herd_lactation_graph")
    @Expose
    lateinit var items: List<RptHerdLactationGraph>
}