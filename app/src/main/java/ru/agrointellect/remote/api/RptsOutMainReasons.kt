package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asNullableString
import ru.agrointellect.extension.getOrNull
import ru.agrointellect.extension.orDash

class RptsOutMainReasons : Table, Graph {

    override val legends: Collection<String>
        get() = table.keySet().filter { it != "date" }

    override val columns: List<Column>
        get() {
            val dates = table.getAsJsonArray("date")
            return table.keySet().filter { it != "date" }.map {
                Column(it, table.getAsJsonArray(it).mapIndexed { i, value ->
                    newRow(dates.getOrNull(i)?.asNullableString.orDash(), value.asString)
                })
            }
        }

    override val data: GraphData
        get() = PieData(
            PieDataSet(table.entrySet().map { newPieEntry(it.value.asNullableString) }, null)
        )

    @SerializedName("data_table")
    @Expose
    lateinit var table: JsonObject
}