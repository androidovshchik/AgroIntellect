package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
@Suppress("SpellCheckingInspection")
class RptBreedEffectivity {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("avg_lact_num")
    @Expose
    lateinit var avgLactNum: String

    @SerializedName("avg_days_in_milk")
    @Expose
    lateinit var avgDaysInMilk: String

    @SerializedName("avg_open_days")
    @Expose
    lateinit var avgOpenDays: String

    @SerializedName("avg_dry_days")
    @Expose
    lateinit var avgDryDays: String

    @SerializedName("avg_pregnant_days_cows")
    @Expose
    lateinit var avgPregnantDaysCows: String

    @SerializedName("avg_pregnant_days_heifers")
    @Expose
    lateinit var avgPregnantDaysHeifers: String

    @SerializedName("avg_calv_int_days")
    @Expose
    lateinit var avgCalvIntDays: String

    @SerializedName("avg_insem_int_days_cows")
    @Expose
    lateinit var avgInsemIntDaysCows: String

    @SerializedName("avg_insem_int_days_heifers")
    @Expose
    lateinit var avgInsemIntDaysHeifers: String

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    lateinit var avgFirstInsemDimCows: String

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    lateinit var avgFirstInsemAgeHeifers: String

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    lateinit var avgFirstCalvAge1Lact: String

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
    lateinit var brdHeatDetRateCow: String

    @SerializedName("brd_heat_det_rate_heif")
    @Expose
    lateinit var brdHeatDetRateHeif: String

    @SerializedName("brd_conc_rate_cow")
    @Expose
    lateinit var brdConcRateCow: String

    @SerializedName("brd_conc_rate_heif")
    @Expose
    lateinit var brdConcRateHeif: String

    @SerializedName("brd_preg_rate_cow")
    @Expose
    lateinit var brdPregRateCow: String

    @SerializedName("brd_preg_rate_heif")
    @Expose
    lateinit var brdPregRateHeif: String

    @SerializedName("brd_straws_per_preg_cow")
    @Expose
    lateinit var brdStrawsPerPregCow: String

    @SerializedName("brd_straws_per_preg_heif")
    @Expose
    lateinit var brdStrawsPerPregHeif: String
}