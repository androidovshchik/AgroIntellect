package ru.agrointellect.remote.bean

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.api.formatDate

@Keep
@Suppress("SpellCheckingInspection")
class RptMilkEventsKpi {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    @JvmField
    var mlkMilkSumYield: String? = null

    @SerializedName("mlk_milk_per_cow")
    @Expose
    @JvmField
    var mlkMilkPerCow = ""

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    @JvmField
    var mlkMilkPerLactCow = ""

    @SerializedName("evt_insem_cows")
    @Expose
    @JvmField
    var evtInsemCows: String? = null

    @SerializedName("evt_preg_check_cows")
    @Expose
    @JvmField
    var evtPregCheckCows: String? = null

    @SerializedName("evt_dry_cows")
    @Expose
    @JvmField
    var evtDryCows: String? = null

    @SerializedName("evt_move_cows")
    @Expose
    @JvmField
    var evtMoveCows: String? = null

    @SerializedName("evt_vacc_cows")
    @Expose
    @JvmField
    var evtVaccCows: String? = null

    @SerializedName("evt_footrim_cows")
    @Expose
    @JvmField
    var evtFootrimCows: String? = null

    @SerializedName("feed_kpi")
    @Expose
    @JvmField
    var feedKpi: String? = null
}