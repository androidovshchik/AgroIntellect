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
            val first = "_lactation_"
            items[0].sampleLactations.forEach {
                val start = it.key.indexOf(first)
                val end = it.key.indexOf("_per_")
                if (start in 0 until end) {
                    val num = it.key.substring(start + first.length, end)
                    columns.add("Образец $num за 305 дней")
                    text.appendln(it.value)
                }
            }
            val csvReader = CsvReader()
            val csv = csvReader.read(StringReader(text.toString().trim()))
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