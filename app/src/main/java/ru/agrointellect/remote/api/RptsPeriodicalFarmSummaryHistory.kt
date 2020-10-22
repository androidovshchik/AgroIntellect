@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.bean.PeriodicalDataTable

class RptsPeriodicalFarmSummaryHistory : ListFarmSummaryHistory<PeriodicalDataTable>() {

    @SerializedName("data_table")
    @Expose
    override lateinit var data: PeriodicalDataTable

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("DefaultLocale")
    override fun rowsBy(name: String): List<Row> {
        val method = PeriodicalDataTable::class.java.getMethod("get${name.capitalize()}")
        val list = method.invoke(data) as List<String>
        return data.date.mapIndexed { i, date -> Row(date, list.getOrNull(i)) }
    }
}