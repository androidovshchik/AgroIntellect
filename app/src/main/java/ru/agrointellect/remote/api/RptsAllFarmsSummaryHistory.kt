@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.dto.RptAllDataTable

class RptsAllFarmsSummaryHistory : RptsBaseFarmSummaryHistory<RptAllDataTable>() {

    @SerializedName("data_table")
    @Expose
    override lateinit var data: RptAllDataTable

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("DefaultLocale")
    override fun rowsBy(name: String): List<Row> {
        val method = RptAllDataTable::class.java.getMethod("get${name.capitalize()}")
        val list = method.invoke(data) as List<String>
        return data.farmName.mapIndexed { i, farm -> newRow(farm, list.getOrNull(i)) }
    }
}