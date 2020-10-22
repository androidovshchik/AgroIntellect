@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.bean

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
class AllDataTable : PeriodicalDataTable() {

    @SerializedName("farm_name")
    @Expose
    lateinit var farmName: List<String>
}