package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import de.siegmar.fastcsv.reader.CsvReader
import java.io.StringReader

@Suppress("SpellCheckingInspection")
class RptsHerdLactationGraph : Table, ChartLine {

    private val data: LinkedHashMap<String, String>
        get() {
            val data = linkedMapOf<String, String>()
            items[0].averageLactationDailyMilk?.let {
                data["Средняя лактация"] = it
            }
            items[0].lactation1DailyMilk?.let {
                data["Лактация 1"] = it
            }
            items[0].lactation2DailyMilk?.let {
                data["Лактация 2"] = it
            }
            items[0].lactationOver2DailyMilk?.let {
                data["Лактация > 2"] = it
            }
            items[0].sampleLactations.forEach {
                val lactation = it.key.indexOf("_lactation_")
                val per = it.key.indexOf("_per_", lactation)
                val milking = it.key.indexOf("_milking_", per)
                if (lactation > 0 && per > 0 && milking > 0) {
                    val number = it.key.substring(lactation + "_lactation_".length, per)
                    val days = it.key.substring(per + "_per_".length, milking)
                    data["Образец $number за $days дней"] = it.value.toString()
                }
            }
            return data
        }

    override val legends: MutableSet<String>
        get() = data.keys

    override val columns: List<Column>
        get() {
            val data = data
            val columns = mutableListOf<String>()
            val text = StringBuilder()
            text.appendln(items[0].lactationDays)
            val csvReader = CsvReader()
            val csv = csvReader.read(StringReader(data.toString().trim()))
            val days = csv.getRow(0)
            return columns.mapIndexed { i, column ->
                Column(column, csv.getRow(i + 1).fields.mapIndexed { j, value ->
                    Row("${days.getField(j)} день доения", value)
                })
            }
        }

    override val lineData: LineData
        get() = LineData(
            listOf(
                LineDataSet(
                    listOf(
                        Entry(0f, 0f)
                    ), null
                )
            )
        )

    @SerializedName("rpt_herd_lactation_graph")
    @Expose
    lateinit var items: List<RptHerdLactationGraph>
}