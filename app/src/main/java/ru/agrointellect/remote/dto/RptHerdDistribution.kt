package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptHerdDistribution {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("hrd_cows_all")
    @Expose
    var hrdCowsAll: String? = null

    @SerializedName("hrd_cows_lact_all")
    @Expose
    var hrdCowsLactAll: String? = null

    @SerializedName("hrd_cows_preg_all")
    @Expose
    var hrdCowsPregAll: String? = null
}