package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.api.formatDate

@Suppress("SpellCheckingInspection")
class RptLastUpdate {

    @SerializedName("last_herd_file_date")
    @Expose
    var lastHerdFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_evts_file_date")
    @Expose
    var lastEvtsFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_cows_cr_file_date")
    @Expose
    var lastCowsCrFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_cows_pr_file_date")
    @Expose
    var lastCowsPrFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_heif_cr_file_date")
    @Expose
    var lastHeifCrFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_heif_pr_file_date")
    @Expose
    var lastHeifPrFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_milk_sum_file_date")
    @Expose
    var lastMilkSumFileDate: String? = null
        get() = formatDate(field)

    @SerializedName("last_feed_kpi_file_date")
    @Expose
    var lastFeedKpiFileDate: String? = null
        get() = formatDate(field)
}