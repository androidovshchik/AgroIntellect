package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
@Suppress("SpellCheckingInspection")
class RptBreedEffectivity {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("avg_lact_num")
    @Expose
    var avgLactNum: String? = null

    @SerializedName("avg_days_in_milk")
    @Expose
    var avgDaysInMilk: String? = null

    @SerializedName("avg_open_days")
    @Expose
    var avgOpenDays: String? = null

    @SerializedName("avg_dry_days")
    @Expose
    var avgDryDays: String? = null

    @SerializedName("avg_pregnant_days_cows")
    @Expose
    var avgPregnantDaysCows: String? = null

    @SerializedName("avg_pregnant_days_heifers")
    @Expose
    var avgPregnantDaysHeifers: String? = null

    @SerializedName("avg_calv_int_days")
    @Expose
    var avgCalvIntDays: String? = null

    @SerializedName("avg_insem_int_days_cows")
    @Expose
    var avgInsemIntDaysCows: String? = null

    @SerializedName("avg_insem_int_days_heifers")
    @Expose
    var avgInsemIntDaysHeifers: String? = null

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    var avgFirstInsemDimCows: String? = null

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    var avgFirstInsemAgeHeifers: String? = null

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    var avgFirstCalvAge1Lact: String? = null

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    lateinit var hrdCowsLactAllPcnt: String

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    lateinit var hrdCowsPregPcnt: String

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    lateinit var hrdCowsDryPcnt: String

    @SerializedName("evt_calv_alive_heifers_all_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersAllPcnt: String

    @SerializedName("evt_calv_alive_heifers_pheifers_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersPheifersPcnt: String

    @SerializedName("evt_calv_alive_heifers_cows_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersCowsPcnt: String

    @SerializedName("evt_calv_dead_all_pcnt")
    @Expose
    lateinit var evtCalvDeadAllPcnt: String

    @SerializedName("evt_calv_dead_pheifers_pcnt")
    @Expose
    lateinit var evtCalvDeadPheifersPcnt: String

    @SerializedName("evt_calv_dead_cows_pcnt")
    @Expose
    lateinit var evtCalvDeadCowsPcnt: String

    @SerializedName("brd_heat_det_rate_cow")
    @Expose
    var brdHeatDetRateCow: String? = null

    @SerializedName("brd_heat_det_rate_heif")
    @Expose
    var brdHeatDetRateHeif: String? = null

    @SerializedName("brd_conc_rate_cow")
    @Expose
    var brdConcRateCow: String? = null

    @SerializedName("brd_conc_rate_heif")
    @Expose
    var brdConcRateHeif: String? = null

    @SerializedName("brd_preg_rate_cow")
    @Expose
    var brdPregRateCow: String? = null

    @SerializedName("brd_preg_rate_heif")
    @Expose
    var brdPregRateHeif: String? = null

    @SerializedName("brd_straws_per_preg_cow")
    @Expose
    var brdStrawsPerPregCow: String? = null

    @SerializedName("brd_straws_per_preg_heif")
    @Expose
    var brdStrawsPerPregHeif: String? = null
}