package ru.agrointellect.remote.dto

import android.text.TextUtils
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import de.siegmar.fastcsv.reader.CsvReader
import ru.agrointellect.extension.asFloat
import java.io.StringReader

@Suppress("SpellCheckingInspection", "ReplaceManualRangeWithIndicesCalls")
class RptsHerdLactationGraph : Table, Graph {

    private val map: Map<String, String>
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
                    data["Образец $number за $days дней"] = it.value ?: return@forEach
                }
            }
            return data
        }

    override val legends: Set<String>
        get() = map.keys

    override val columns: List<Column>
        get() {
            val map = map
            val text = StringBuilder()
            text.appendln(items[0].lactationDays)
            text.append(TextUtils.join("\n", map.values))
            val reader = CsvReader()
            val csv = reader.read(StringReader(text.toString()))
            val days = csv.getRow(0)
            return map.keys.mapIndexed { i, key ->
                Column(key, csv.getRow(i + 1).fields.mapIndexed { j, value ->
                    Row("${days.getField(j)} день доения", value)
                })
            }
        }

    override val data: GraphData
        get() {
            val map = map
            val text = StringBuilder()
            text.appendln(items[0].lactationDays)
            text.append(TextUtils.join("\n", map.values))
            val reader = CsvReader()
            val csv = reader.read(StringReader(text.toString()))
            val days = csv.getRow(0)
            return LineData((0 until map.size).mapNotNull {
                try {
                    LineDataSet(csv.getRow(it + 1).fields.mapIndexed { j, value ->
                        Entry(days.getField(j).asFloat, value.asFloat)
                    }, null)
                } catch (ignored: Throwable) {
                    null
                }
            })
        }

    @SerializedName("rpt_herd_lactation_graph")
    @Expose
    lateinit var items: List<RptHerdLactationGraph>
}