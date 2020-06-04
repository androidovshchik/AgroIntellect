package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import de.siegmar.fastcsv.reader.CsvReader
import timber.log.Timber

/**
 * График лактации поголовья
 */
@Suppress("SpellCheckingInspection")
class RptsHerdLactationGraph : Table {

    override val columns: List<Column>
        get() {
            val columns = mutableListOf<String>()
            val text = StringBuilder()
            text.appendln(items[0].lactationDays)
            items[0].averageLactationDailyMilk?.let {
                columns.add("Средняя лактация")
                text.appendln(it)
            }
            items[0].lactation1DailyMilk?.let {
                columns.add("Лактация 1")
                text.appendln(it)
            }
            items[0].lactation2DailyMilk?.let {
                columns.add("Лактация 2")
                text.appendln(it)
            }
            items[0].lactationOver2DailyMilk?.let {
                columns.add("Лактация > 2")
                text.appendln(it)
            }
            items[0].sampleLactations.forEach {
                val first = "lactation_"
                val start = it.key.indexOf(first)
                val end = it.key.indexOf("_per_")
                if (start in 0 until end) {
                    columns.add(
                        "Образец ${it.key.substring(
                            start + first.length,
                            end
                        )} за 305 дней"
                    )
                    text.appendln(it.value)
                }
            }
            Timber.e(columns.toString())
            val csvReader = CsvReader()
            /*val source = """
                ${items[0].lactationDays}
                ${items[0].averageLactationDailyMilk}
                ${items[0].lactation1DailyMilk}
                ${items[0].lactation2DailyMilk}
                ${items[0].lactationOver2DailyMilk}
                ${items[0].sampleLactation7500Per305MilkingDaysDailyMilk}
            """.trimIndent()
            val csv = csvReader.read(StringReader(source))
            val days = csv.getRow(0)
            return columns.mapIndexedNotNull { i, column ->
                Column(column, csv.getRow(i + 1).fields.mapIndexed { j, value ->
                    Row("${days.getField(j)} день доения", value)
                })
            }*/
            return emptyList()
        }

    @SerializedName("rpt_herd_lactation_graph")
    @Expose
    lateinit var items: List<RptHerdLactationGraph>
}