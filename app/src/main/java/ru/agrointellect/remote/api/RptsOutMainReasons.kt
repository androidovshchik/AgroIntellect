package ru.agrointellect.remote.api

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.asNullableString
import ru.agrointellect.extension.getOrNull
import ru.agrointellect.extension.orDash

class RptsOutMainReasons : Table {

    override val columns: List<Column>
        get() {
            val dates = data.getAsJsonArray("date")
            return data.keySet().filter { it != "date" }.map {
                Column(it, data.getAsJsonArray(it).mapIndexed { i, value ->
                    newRow(dates.getOrNull(i)?.asNullableString.orDash(), value.asString)
                })
            }
        }

    @SerializedName("data_table")
    @Expose
    lateinit var data: JsonObject
}