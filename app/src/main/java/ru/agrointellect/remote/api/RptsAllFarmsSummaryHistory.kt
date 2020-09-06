@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptAllFarmsSummaryHistory : ListFarmSummaryHistory<AllDataTable>() {

    @SerializedName("data_table")
    @Expose
    override lateinit var data: AllDataTable

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("DefaultLocale")
    override fun rowsBy(name: String): List<Row> {
        val method = AllDataTable::class.java.getMethod("get${name.capitalize()}")
        val list = method.invoke(data) as List<String>
        return data.farmName.mapIndexed { i, farm -> Row(farm, list.getOrNull(i)) }
    }
}

class AllDataTable : PeriodicalDataTable() {

    @SerializedName("farm_name")
    @Expose
    lateinit var farmName: List<String>
}