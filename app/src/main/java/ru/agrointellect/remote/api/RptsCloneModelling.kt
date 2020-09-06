@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptCloneModelling : Table {

    override val columns: List<Column>
        get() = TODO("Not yet implemented")

    @SerializedName("model_parameters")
    @Expose
    var modelParameters: ModelParameters? = null

    @SerializedName("data_table")
    @Expose
    var dataTable: DataTable? = null
}

class ModelParameters {
    @SerializedName("mlk_prod_pcnt_chng_l1_f0")
    @Expose
    var mlkProdPcntChngL1F0: Int? = null

    @SerializedName("mlk_prod_pcnt_chng_lo1_f0")
    @Expose
    var mlkProdPcntChngLo1F0: Int? = null

    @SerializedName("mlk_prod_pcnt_chng_l1_f1")
    @Expose
    var mlkProdPcntChngL1F1: Int? = null

    @SerializedName("mlk_prod_pcnt_chng_lo1_f1")
    @Expose
    var mlkProdPcntChngLo1F1: Int? = null

    @SerializedName("mlk_prod_pcnt_chng_l1_f2")
    @Expose
    var mlkProdPcntChngL1F2: Int? = null

    @SerializedName("mlk_prod_pcnt_chng_lo1_f2")
    @Expose
    var mlkProdPcntChngLo1F2: Int? = null

    @SerializedName("first_insem_age_heifers")
    @Expose
    var firstInsemAgeHeifers: Int? = null

    @SerializedName("first_insem_dim_cows")
    @Expose
    var firstInsemDimCows: Int? = null

    @SerializedName("insem_int_days_heifers")
    @Expose
    var insemIntDaysHeifers: Int? = null

    @SerializedName("insem_int_days_cows")
    @Expose
    var insemIntDaysCows: Int? = null

    @SerializedName("brd_conc_rate_heif")
    @Expose
    var brdConcRateHeif: Int? = null

    @SerializedName("brd_conc_rate_cow")
    @Expose
    var brdConcRateCow: Int? = null

    @SerializedName("heifers_abort_coeff")
    @Expose
    var heifersAbortCoeff: Int? = null

    @SerializedName("cows_abort_coeff")
    @Expose
    var cowsAbortCoeff: Int? = null

    @SerializedName("calv_dead_coeff")
    @Expose
    var calvDeadCoeff: Int? = null

    @SerializedName("calv_heifer_coeff")
    @Expose
    var calvHeiferCoeff: Int? = null

    @SerializedName("out_cows_lact_1_0_30_coeff")
    @Expose
    var outCowsLact1030Coeff: Float? = null

    @SerializedName("out_cows_lact_1_31_60_coeff")
    @Expose
    var outCowsLact13160Coeff: Float? = null

    @SerializedName("out_cows_lact_1_61_120_coeff")
    @Expose
    var outCowsLact161120Coeff: Float? = null

    @SerializedName("out_cows_lact_1_o120_coeff")
    @Expose
    var outCowsLact1O120Coeff: Float? = null

    @SerializedName("out_cows_lact_2_0_30_coeff")
    @Expose
    var outCowsLact2030Coeff: Float? = null

    @SerializedName("out_cows_lact_2_31_60_coeff")
    @Expose
    var outCowsLact23160Coeff: Float? = null

    @SerializedName("out_cows_lact_2_61_120_coeff")
    @Expose
    var outCowsLact261120Coeff: Float? = null

    @SerializedName("out_cows_lact_2_o120_coeff")
    @Expose
    var outCowsLact2O120Coeff: Float? = null

    @SerializedName("out_cows_lact_o2_0_30_coeff")
    @Expose
    var outCowsLactO2030Coeff: Float? = null

    @SerializedName("out_cows_lact_o2_31_60_coeff")
    @Expose
    var outCowsLactO23160Coeff: Float? = null

    @SerializedName("out_cows_lact_o2_61_120_coeff")
    @Expose
    var outCowsLactO261120Coeff: Float? = null

    @SerializedName("out_cows_lact_o2_o120_coeff")
    @Expose
    var outCowsLactO2O120Coeff: Float? = null

    @SerializedName("out_heifers_0_2_coeff")
    @Expose
    var outHeifers02Coeff: Float? = null

    @SerializedName("out_heifers_2_6_coeff")
    @Expose
    var outHeifers26Coeff: Float? = null

    @SerializedName("out_heifers_6_12_coeff")
    @Expose
    var outHeifers612Coeff: Float? = null

    @SerializedName("out_heifers_o12_coeff")
    @Expose
    var outHeifersO12Coeff: Float? = null

    @SerializedName("out_pheifers_coeff")
    @Expose
    var outPheifersCoeff: Float? = null

    @SerializedName("usr_hrd_phfrs_diff_0_caption")
    @Expose
    var usrHrdPhfrsDiff0Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_0")
    @Expose
    var usrHrdPhfrsDiff0: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_1_caption")
    @Expose
    var usrHrdPhfrsDiff1Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_1")
    @Expose
    var usrHrdPhfrsDiff1: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_2_caption")
    @Expose
    var usrHrdPhfrsDiff2Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_2")
    @Expose
    var usrHrdPhfrsDiff2: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_3_caption")
    @Expose
    var usrHrdPhfrsDiff3Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_3")
    @Expose
    var usrHrdPhfrsDiff3: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_4_caption")
    @Expose
    var usrHrdPhfrsDiff4Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_4")
    @Expose
    var usrHrdPhfrsDiff4: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_5_caption")
    @Expose
    var usrHrdPhfrsDiff5Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_5")
    @Expose
    var usrHrdPhfrsDiff5: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_6_caption")
    @Expose
    var usrHrdPhfrsDiff6Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_6")
    @Expose
    var usrHrdPhfrsDiff6: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_7_caption")
    @Expose
    var usrHrdPhfrsDiff7Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_7")
    @Expose
    var usrHrdPhfrsDiff7: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_8_caption")
    @Expose
    var usrHrdPhfrsDiff8Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_8")
    @Expose
    var usrHrdPhfrsDiff8: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_9_caption")
    @Expose
    var usrHrdPhfrsDiff9Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_9")
    @Expose
    var usrHrdPhfrsDiff9: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_10_caption")
    @Expose
    var usrHrdPhfrsDiff10Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_10")
    @Expose
    var usrHrdPhfrsDiff10: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_11_caption")
    @Expose
    var usrHrdPhfrsDiff11Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_11")
    @Expose
    var usrHrdPhfrsDiff11: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_12_caption")
    @Expose
    var usrHrdPhfrsDiff12Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_12")
    @Expose
    var usrHrdPhfrsDiff12: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_13_caption")
    @Expose
    var usrHrdPhfrsDiff13Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_13")
    @Expose
    var usrHrdPhfrsDiff13: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_14_caption")
    @Expose
    var usrHrdPhfrsDiff14Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_14")
    @Expose
    var usrHrdPhfrsDiff14: Int? = null

    @SerializedName("usr_hrd_phfrs_diff_15_caption")
    @Expose
    var usrHrdPhfrsDiff15Caption: String? = null

    @SerializedName("usr_hrd_phfrs_diff_15")
    @Expose
    var usrHrdPhfrsDiff15: Int? = null

    @SerializedName("preg_month_phfrs_diff")
    @Expose
    var pregMonthPhfrsDiff: Int? = null
}

class DataTable {
    @SerializedName("yyyy_mm")
    @Expose
    var yyyyMm: List<String>? = null

    @SerializedName("hrd_cows_all")
    @Expose
    var hrdCowsAll: List<String>? = null

    @SerializedName("hrd_cows_lact_all")
    @Expose
    var hrdCowsLactAll: List<String>? = null

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    var hrdCowsLactAllPcnt: List<String>? = null

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    var hrdCowsLact1All: List<String>? = null

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    var hrdCowsLact1Pcnt: List<String>? = null

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    var hrdCowsLact1030: List<String>? = null

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    var hrdCowsLact13160: List<String>? = null

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    var hrdCowsLact161120: List<String>? = null

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    var hrdCowsLact1O120: List<String>? = null

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    var hrdCowsLact2All: List<String>? = null

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    var hrdCowsLact2Pcnt: List<String>? = null

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    var hrdCowsLact2030: List<String>? = null

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    var hrdCowsLact23160: List<String>? = null

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    var hrdCowsLact261120: List<String>? = null

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    var hrdCowsLact2O120: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    var hrdCowsLactO2All: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    var hrdCowsLactO2Pcnt: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    var hrdCowsLactO2030: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    var hrdCowsLactO23160: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    var hrdCowsLactO261120: List<String>? = null

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    var hrdCowsLactO2O120: List<String>? = null

    @SerializedName("hrd_cows_preg_all")
    @Expose
    var hrdCowsPregAll: List<String>? = null

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    var hrdCowsPregPcnt: List<String>? = null

    @SerializedName("hrd_cows_dry_all")
    @Expose
    var hrdCowsDryAll: List<String>? = null

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    var hrdCowsDryPcnt: List<String>? = null

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    var hrdCowsDryF1: List<String>? = null

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    var hrdCowsDryF2: List<String>? = null

    @SerializedName("hrd_heifers_all")
    @Expose
    var hrdHeifersAll: List<String>? = null

    @SerializedName("hrd_heifers_0_2")
    @Expose
    var hrdHeifers02: List<String>? = null

    @SerializedName("hrd_heifers_2_6")
    @Expose
    var hrdHeifers26: List<String>? = null

    @SerializedName("hrd_heifers_6_12")
    @Expose
    var hrdHeifers612: List<String>? = null

    @SerializedName("hrd_heifers_o12")
    @Expose
    var hrdHeifersO12: List<String>? = null

    @SerializedName("hrd_pheifers_all")
    @Expose
    var hrdPheifersAll: List<String>? = null

    @SerializedName("hrd_pheifers_f2")
    @Expose
    var hrdPheifersF2: List<String>? = null

    @SerializedName("hrd_bulls")
    @Expose
    var hrdBulls: List<String>? = null

    @SerializedName("evt_insem_cows")
    @Expose
    var evtInsemCows: List<String>? = null

    @SerializedName("evt_insem_heifers")
    @Expose
    var evtInsemHeifers: List<String>? = null

    @SerializedName("evt_got_preg_cows")
    @Expose
    var evtGotPregCows: List<String>? = null

    @SerializedName("evt_got_preg_heifers")
    @Expose
    var evtGotPregHeifers: List<String>? = null

    @SerializedName("evt_dry_cows")
    @Expose
    var evtDryCows: List<String>? = null

    @SerializedName("evt_calv_total")
    @Expose
    var evtCalvTotal: List<String>? = null

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    var evtCalvTotalPheifers: List<String>? = null

    @SerializedName("evt_calv_total_cows")
    @Expose
    var evtCalvTotalCows: List<String>? = null

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    var evtCalvAliveHeifers: List<String>? = null

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    var evtCalvAliveBulls: List<String>? = null

    @SerializedName("evt_out_cows_total")
    @Expose
    var evtOutCowsTotal: List<String>? = null

    @SerializedName("evt_out_cows_lact_1_total")
    @Expose
    var evtOutCowsLact1Total: List<String>? = null

    @SerializedName("evt_out_cows_lact_1_0_30")
    @Expose
    var evtOutCowsLact1030: List<String>? = null

    @SerializedName("evt_out_cows_lact_1_31_60")
    @Expose
    var evtOutCowsLact13160: List<String>? = null

    @SerializedName("evt_out_cows_lact_1_61_120")
    @Expose
    var evtOutCowsLact161120: List<String>? = null

    @SerializedName("evt_out_cows_lact_1_o120")
    @Expose
    var evtOutCowsLact1O120: List<String>? = null

    @SerializedName("evt_out_cows_lact_2_total")
    @Expose
    var evtOutCowsLact2Total: List<String>? = null

    @SerializedName("evt_out_cows_lact_2_0_30")
    @Expose
    var evtOutCowsLact2030: List<String>? = null

    @SerializedName("evt_out_cows_lact_2_31_60")
    @Expose
    var evtOutCowsLact23160: List<String>? = null

    @SerializedName("evt_out_cows_lact_2_61_120")
    @Expose
    var evtOutCowsLact261120: List<String>? = null

    @SerializedName("evt_out_cows_lact_2_o120")
    @Expose
    var evtOutCowsLact2O120: List<String>? = null

    @SerializedName("evt_out_cows_lact_o2_total")
    @Expose
    var evtOutCowsLactO2Total: List<String>? = null

    @SerializedName("evt_out_cows_lact_o2_0_30")
    @Expose
    var evtOutCowsLactO2030: List<String>? = null

    @SerializedName("evt_out_cows_lact_o2_31_60")
    @Expose
    var evtOutCowsLactO23160: List<String>? = null

    @SerializedName("evt_out_cows_lact_o2_61_120")
    @Expose
    var evtOutCowsLactO261120: List<String>? = null

    @SerializedName("evt_out_cows_lact_o2_o120")
    @Expose
    var evtOutCowsLactO2O120: List<String>? = null

    @SerializedName("evt_out_heifers_total")
    @Expose
    var evtOutHeifersTotal: List<String>? = null

    @SerializedName("evt_out_heifers_0_2")
    @Expose
    var evtOutHeifers02: List<String>? = null

    @SerializedName("evt_out_heifers_2_6")
    @Expose
    var evtOutHeifers26: List<String>? = null

    @SerializedName("evt_out_heifers_6_12")
    @Expose
    var evtOutHeifers612: List<String>? = null

    @SerializedName("evt_out_heifers_o12")
    @Expose
    var evtOutHeifersO12: List<String>? = null

    @SerializedName("evt_out_pheifers")
    @Expose
    var evtOutPheifers: List<String>? = null

    @SerializedName("evt_out_bulls")
    @Expose
    var evtOutBulls: List<String>? = null

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    var mlkMilkSumYield: List<String>? = null

    @SerializedName("mlk_milk_per_cow")
    @Expose
    var mlkMilkPerCow: List<String>? = null

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    var mlkMilkPerLactCow: List<String>? = null
}