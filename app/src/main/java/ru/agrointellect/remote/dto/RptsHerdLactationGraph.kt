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
            val columns = arrayOf(
                "Средняя лактация",
                "Лактация 1",
                "Лактация 2",
                "Лактация > 2"
            )
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
            return columns.mapIndexed { i, column ->
                Column(column, csv.getRow(i + 1).fields.mapIndexed { j, value ->
                    Row("${days.getField(j)} день доения", value)
                })
            }
        }

    @SerializedName("rpt_herd_lactation_graph")
    @Expose
    lateinit var items: List<RptHerdLactationGraph>
}