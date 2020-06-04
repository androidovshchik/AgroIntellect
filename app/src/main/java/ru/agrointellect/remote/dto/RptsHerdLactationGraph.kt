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
            items[0].sampleLactations.forEach {
                val lactation = it.key.indexOf("_lactation_")
                val per = it.key.indexOf("_per_", lactation)
                val milking = it.key.indexOf("_milking_", per)
                if (lactation > 0 && per > 0 && milking > 0) {
                    val number = it.key.substring(lactation + "_lactation_".length, per)
                    val days = it.key.substring(per + "_per_".length, milking)
                    columns.add("Образец $number за $days дней")
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