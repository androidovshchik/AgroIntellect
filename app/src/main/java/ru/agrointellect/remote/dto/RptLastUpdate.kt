package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptLastUpdate {

    @SerializedName("last_herd_file_date")
    @Expose
    lateinit var lastHerdFileDate: String

    @SerializedName("last_evts_file_date")
    @Expose
    lateinit var lastEvtsFileDate: String

    @SerializedName("last_cows_cr_file_date")
    @Expose
    lateinit var lastCowsCrFileDate: String

    @SerializedName("last_cows_pr_file_date")
    @Expose
    lateinit var lastCowsPrFileDate: String

    @SerializedName("last_heif_cr_file_date")
    @Expose
    lateinit var lastHeifCrFileDate: String

    @SerializedName("last_heif_pr_file_date")
    @Expose
    lateinit var lastHeifPrFileDate: String

    @SerializedName("last_milk_sum_file_date")
    @Expose
    lateinit var lastMilkSumFileDate: String

    @SerializedName("last_feed_kpi_file_date")
    @Expose
    lateinit var lastFeedKpiFileDate: String
}