package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
@Suppress("SpellCheckingInspection")
class RptHerdForecast {

    @SerializedName("yyyy_mm")
    @Expose
    lateinit var yyyyMm: String

    @SerializedName("hrd_cows_all")
    @Expose
    lateinit var hrdCowsAll: String

    @SerializedName("hrd_cows_lact_all")
    @Expose
    lateinit var hrdCowsLactAll: String

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    lateinit var hrdCowsLactAllPcnt: String

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    lateinit var hrdCowsLact1All: String

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    lateinit var hrdCowsLact1Pcnt: String

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    lateinit var hrdCowsLact1030: String

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    lateinit var hrdCowsLact13160: String

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    lateinit var hrdCowsLact161120: String

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    lateinit var hrdCowsLact1O120: String

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    lateinit var hrdCowsLact2All: String

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    lateinit var hrdCowsLact2Pcnt: String

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    lateinit var hrdCowsLact2030: String

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    lateinit var hrdCowsLact23160: String

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    lateinit var hrdCowsLact261120: String

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    lateinit var hrdCowsLact2O120: String

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    lateinit var hrdCowsLactO2All: String

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    lateinit var hrdCowsLactO2Pcnt: String

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    lateinit var hrdCowsLactO2030: String

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    lateinit var hrdCowsLactO23160: String

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    lateinit var hrdCowsLactO261120: String

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    lateinit var hrdCowsLactO2O120: String

    @SerializedName("hrd_cows_preg_all")
    @Expose
    lateinit var hrdCowsPregAll: String

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    lateinit var hrdCowsPregPcnt: String

    @SerializedName("hrd_cows_dry_all")
    @Expose
    lateinit var hrdCowsDryAll: String

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    lateinit var hrdCowsDryPcnt: String

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    lateinit var hrdCowsDryF1: String

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    lateinit var hrdCowsDryF2: String

    @SerializedName("hrd_heifers_all")
    @Expose
    lateinit var hrdHeifersAll: String

    @SerializedName("hrd_heifers_0_2")
    @Expose
    lateinit var hrdHeifers02: String

    @SerializedName("hrd_heifers_2_6")
    @Expose
    lateinit var hrdHeifers26: String

    @SerializedName("hrd_heifers_6_12")
    @Expose
    lateinit var hrdHeifers612: String

    @SerializedName("hrd_heifers_o12")
    @Expose
    lateinit var hrdHeifersO12: String

    @SerializedName("hrd_pheifers_all")
    @Expose
    lateinit var hrdPheifersAll: String

    @SerializedName("hrd_pheifers_f2")
    @Expose
    lateinit var hrdPheifersF2: String

    @SerializedName("hrd_bulls")
    @Expose
    lateinit var hrdBulls: String

    @SerializedName("evt_insem_cows")
    @Expose
    lateinit var evtInsemCows: String

    @SerializedName("evt_insem_heifers")
    @Expose
    lateinit var evtInsemHeifers: String

    @SerializedName("evt_got_preg_cows")
    @Expose
    lateinit var evtGotPregCows: String

    @SerializedName("evt_got_preg_heifers")
    @Expose
    lateinit var evtGotPregHeifers: String

    @SerializedName("evt_dry_cows")
    @Expose
    lateinit var evtDryCows: String

    @SerializedName("evt_calv_total")
    @Expose
    lateinit var evtCalvTotal: String

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    lateinit var evtCalvTotalPheifers: String

    @SerializedName("evt_calv_total_cows")
    @Expose
    lateinit var evtCalvTotalCows: String

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    lateinit var evtCalvAliveHeifers: String

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    lateinit var evtCalvAliveBulls: String

    @SerializedName("evt_out_cows_total")
    @Expose
    lateinit var evtOutCowsTotal: String

    @SerializedName("evt_out_cows_lact_1_total")
    @Expose
    lateinit var evtOutCowsLact1Total: String

    @SerializedName("evt_out_cows_lact_1_0_30")
    @Expose
    lateinit var evtOutCowsLact1030: String

    @SerializedName("evt_out_cows_lact_1_31_60")
    @Expose
    lateinit var evtOutCowsLact13160: String

    @SerializedName("evt_out_cows_lact_1_61_120")
    @Expose
    lateinit var evtOutCowsLact161120: String

    @SerializedName("evt_out_cows_lact_1_o120")
    @Expose
    lateinit var evtOutCowsLact1O120: String

    @SerializedName("evt_out_cows_lact_2_total")
    @Expose
    lateinit var evtOutCowsLact2Total: String

    @SerializedName("evt_out_cows_lact_2_0_30")
    @Expose
    lateinit var evtOutCowsLact2030: String

    @SerializedName("evt_out_cows_lact_2_31_60")
    @Expose
    lateinit var evtOutCowsLact23160: String

    @SerializedName("evt_out_cows_lact_2_61_120")
    @Expose
    lateinit var evtOutCowsLact261120: String

    @SerializedName("evt_out_cows_lact_2_o120")
    @Expose
    lateinit var evtOutCowsLact2O120: String

    @SerializedName("evt_out_cows_lact_o2_total")
    @Expose
    lateinit var evtOutCowsLactO2Total: String

    @SerializedName("evt_out_cows_lact_o2_0_30")
    @Expose
    lateinit var evtOutCowsLactO2030: String

    @SerializedName("evt_out_cows_lact_o2_31_60")
    @Expose
    lateinit var evtOutCowsLactO23160: String

    @SerializedName("evt_out_cows_lact_o2_61_120")
    @Expose
    lateinit var evtOutCowsLactO261120: String

    @SerializedName("evt_out_cows_lact_o2_o120")
    @Expose
    lateinit var evtOutCowsLactO2O120: String

    @SerializedName("evt_out_heifers_total")
    @Expose
    lateinit var evtOutHeifersTotal: String

    @SerializedName("evt_out_heifers_0_2")
    @Expose
    lateinit var evtOutHeifers02: String

    @SerializedName("evt_out_heifers_2_6")
    @Expose
    lateinit var evtOutHeifers26: String

    @SerializedName("evt_out_heifers_6_12")
    @Expose
    lateinit var evtOutHeifers612: String

    @SerializedName("evt_out_heifers_o12")
    @Expose
    lateinit var evtOutHeifersO12: String

    @SerializedName("evt_out_pheifers")
    @Expose
    lateinit var evtOutPheifers: String

    @SerializedName("evt_out_bulls")
    @Expose
    lateinit var evtOutBulls: String

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    lateinit var mlkMilkSumYield: String

    @SerializedName("mlk_milk_per_cow")
    @Expose
    lateinit var mlkMilkPerCow: String

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    lateinit var mlkMilkPerLactCow: String
}