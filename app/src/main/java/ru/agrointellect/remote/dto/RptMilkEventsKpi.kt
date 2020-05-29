package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptMilkEventsKpi {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    var mlkMilkSumYield: String? = null

    @SerializedName("mlk_milk_per_cow")
    @Expose
    var mlkMilkPerCow: String? = null

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    var mlkMilkPerLactCow: String? = null

    @SerializedName("evt_insem_cows")
    @Expose
    var evtInsemCows: String? = null

    @SerializedName("evt_got_preg_cows")
    @Expose
    var evtGotPregCows: String? = null

    @SerializedName("evt_dry_cows")
    @Expose
    var evtDryCows: String? = null

    @SerializedName("evt_move_cows")
    @Expose
    var evtMoveCows: String? = null

    @SerializedName("evt_vacc_cows")
    @Expose
    var evtVaccCows: String? = null

    @SerializedName("evt_footrim_cows")
    @Expose
    var evtFootrimCows: String? = null

    @SerializedName("feed_kpi")
    @Expose
    var feedKpi: String? = null
}