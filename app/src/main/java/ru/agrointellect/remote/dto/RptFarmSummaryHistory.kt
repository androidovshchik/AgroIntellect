package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptFarmSummaryHistory {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("avg_lact_num")
    @Expose
    var avgLactNum: String? = null

    @SerializedName("avg_days_in_milk")
    @Expose
    var avgDaysInMilk: String? = null

    @SerializedName("avg_days_in_milk_1_lact")
    @Expose
    var avgDaysInMilk1Lact: String? = null

    @SerializedName("avg_days_in_milk_2_lact")
    @Expose
    var avgDaysInMilk2Lact: String? = null

    @SerializedName("avg_days_in_milk_over_2_lact")
    @Expose
    var avgDaysInMilkOver2Lact: String? = null

    @SerializedName("avg_open_days")
    @Expose
    var avgOpenDays: String? = null

    @SerializedName("avg_open_days_1_lact")
    @Expose
    var avgOpenDays1Lact: String? = null

    @SerializedName("avg_open_days_2_lact")
    @Expose
    var avgOpenDays2Lact: String? = null

    @SerializedName("avg_open_days_over_2_lact")
    @Expose
    var avgOpenDaysOver2Lact: String? = null

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

    @SerializedName("avg_in_hosp_days")
    @Expose
    var avgInHospDays: String? = null

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    var avgFirstInsemDimCows: String? = null

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    var avgFirstInsemAgeHeifers: String? = null

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    var avgFirstCalvAge1Lact: String? = null

    @SerializedName("avg_milk_peak_days")
    @Expose
    var avgMilkPeakDays: String? = null

    @SerializedName("avg_milk_peak_days_1_lact")
    @Expose
    var avgMilkPeakDays1Lact: String? = null

    @SerializedName("avg_milk_peak_days_2_lact")
    @Expose
    var avgMilkPeakDays2Lact: String? = null

    @SerializedName("avg_milk_peak_days_over_2_lact")
    @Expose
    var avgMilkPeakDaysOver2Lact: String? = null

    @SerializedName("hrd_cows_all")
    @Expose
    var hrdCowsAll: String? = null

    @SerializedName("hrd_cows_lact_all")
    @Expose
    var hrdCowsLactAll: String? = null

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    var hrdCowsLactAllPcnt: String? = null

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    var hrdCowsLact1All: String? = null

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    var hrdCowsLact1Pcnt: String? = null

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    var hrdCowsLact1030: String? = null

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    var hrdCowsLact13160: String? = null

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    var hrdCowsLact161120: String? = null

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    var hrdCowsLact1O120: String? = null

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    var hrdCowsLact2All: String? = null

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    var hrdCowsLact2Pcnt: String? = null

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    var hrdCowsLact2030: String? = null

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    var hrdCowsLact23160: String? = null

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    var hrdCowsLact261120: String? = null

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    var hrdCowsLact2O120: String? = null

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    var hrdCowsLactO2All: String? = null

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    var hrdCowsLactO2Pcnt: String? = null

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    var hrdCowsLactO2030: String? = null

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    var hrdCowsLactO23160: String? = null

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    var hrdCowsLactO261120: String? = null

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    var hrdCowsLactO2O120: String? = null

    @SerializedName("hrd_cows_preg_all")
    @Expose
    var hrdCowsPregAll: String? = null

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    var hrdCowsPregPcnt: String? = null

    @SerializedName("hrd_cows_dry_all")
    @Expose
    var hrdCowsDryAll: String? = null

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    var hrdCowsDryPcnt: String? = null

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    var hrdCowsDryF1: String? = null

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    var hrdCowsDryF2: String? = null

    @SerializedName("hrd_heifers_all")
    @Expose
    var hrdHeifersAll: String? = null

    @SerializedName("hrd_heifers_0_2")
    @Expose
    var hrdHeifers02: String? = null

    @SerializedName("hrd_heifers_2_6")
    @Expose
    var hrdHeifers26: String? = null

    @SerializedName("hrd_heifers_6_12")
    @Expose
    var hrdHeifers612: String? = null

    @SerializedName("hrd_heifers_o12")
    @Expose
    var hrdHeifersO12: String? = null

    @SerializedName("hrd_pheifers_all")
    @Expose
    var hrdPheifersAll: String? = null

    @SerializedName("hrd_pheifers_f2")
    @Expose
    var hrdPheifersF2: String? = null

    @SerializedName("hrd_bulls")
    @Expose
    var hrdBulls: String? = null

    @SerializedName("evt_insem_cows")
    @Expose
    var evtInsemCows: String? = null

    @SerializedName("evt_insem_heifers")
    @Expose
    var evtInsemHeifers: String? = null

    @SerializedName("evt_got_preg_cows")
    @Expose
    var evtGotPregCows: String? = null

    @SerializedName("evt_got_preg_heifers")
    @Expose
    var evtGotPregHeifers: String? = null

    @SerializedName("evt_dry_cows")
    @Expose
    var evtDryCows: String? = null

    @SerializedName("evt_calv_total")
    @Expose
    var evtCalvTotal: String? = null

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    var evtCalvAliveHeifers: String? = null

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    var evtCalvAliveBulls: String? = null

    @SerializedName("evt_calv_dead_heifers")
    @Expose
    var evtCalvDeadHeifers: String? = null

    @SerializedName("evt_calv_dead_bulls")
    @Expose
    var evtCalvDeadBulls: String? = null

    @SerializedName("evt_calv_dead_all_pcnt")
    @Expose
    var evtCalvDeadAllPcnt: String? = null

    @SerializedName("evt_calv_alive_heifers_all_pcnt")
    @Expose
    var evtCalvAliveHeifersAllPcnt: String? = null

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    var evtCalvTotalPheifers: String? = null

    @SerializedName("evt_calv_alive_heifers_pheifers")
    @Expose
    var evtCalvAliveHeifersPheifers: String? = null

    @SerializedName("evt_calv_alive_bulls_pheifers")
    @Expose
    var evtCalvAliveBullsPheifers: String? = null

    @SerializedName("evt_calv_dead_heifers_pheifers")
    @Expose
    var evtCalvDeadHeifersPheifers: String? = null

    @SerializedName("evt_calv_dead_bulls_pheifers")
    @Expose
    var evtCalvDeadBullsPheifers: String? = null

    @SerializedName("evt_calv_dead_pheifers_pcnt")
    @Expose
    var evtCalvDeadPheifersPcnt: String? = null

    @SerializedName("evt_calv_alive_heifers_pheifers_pcnt")
    @Expose
    var evtCalvAliveHeifersPheifersPcnt: String? = null

    @SerializedName("evt_calv_total_cows")
    @Expose
    var evtCalvTotalCows: String? = null

    @SerializedName("evt_calv_alive_heifers_cows")
    @Expose
    var evtCalvAliveHeifersCows: String? = null

    @SerializedName("evt_calv_alive_bulls_cows")
    @Expose
    var evtCalvAliveBullsCows: String? = null

    @SerializedName("evt_calv_dead_heifers_cows")
    @Expose
    var evtCalvDeadHeifersCows: String? = null

    @SerializedName("evt_calv_dead_bulls_cows")
    @Expose
    var evtCalvDeadBullsCows: String? = null

    @SerializedName("evt_calv_dead_cows_pcnt")
    @Expose
    var evtCalvDeadCowsPcnt: String? = null

    @SerializedName("evt_calv_alive_heifers_cows_pcnt")
    @Expose
    var evtCalvAliveHeifersCowsPcnt: String? = null

    @SerializedName("evt_abort_cows")
    @Expose
    var evtAbortCows: String? = null

    @SerializedName("evt_abort_heifers")
    @Expose
    var evtAbortHeifers: String? = null

    @SerializedName("evt_mast_for_month_cows")
    @Expose
    var evtMastForMonthCows: String? = null

    @SerializedName("evt_lame_for_month_cows")
    @Expose
    var evtLameForMonthCows: String? = null

    @SerializedName("evt_lame_for_month_heifers")
    @Expose
    var evtLameForMonthHeifers: String? = null

    @SerializedName("evt_ret_plac_lact_1")
    @Expose
    var evtRetPlacLact1: String? = null

    @SerializedName("evt_ret_plac_lact_1_pcnt")
    @Expose
    var evtRetPlacLact1Pcnt: String? = null

    @SerializedName("evt_ret_plac_lact_o1")
    @Expose
    var evtRetPlacLactO1: String? = null

    @SerializedName("evt_ret_plac_lact_o1_pcnt")
    @Expose
    var evtRetPlacLactO1Pcnt: String? = null

    @SerializedName("evt_ret_plac_total")
    @Expose
    var evtRetPlacTotal: String? = null

    @SerializedName("evt_ret_plac_total_pcnt")
    @Expose
    var evtRetPlacTotalPcnt: String? = null

    @SerializedName("evt_pares_lact_1")
    @Expose
    var evtParesLact1: String? = null

    @SerializedName("evt_pares_lact_1_pcnt")
    @Expose
    var evtParesLact1Pcnt: String? = null

    @SerializedName("evt_pares_lact_o1")
    @Expose
    var evtParesLactO1: String? = null

    @SerializedName("evt_pares_lact_o1_pcnt")
    @Expose
    var evtParesLactO1Pcnt: String? = null

    @SerializedName("evt_pares_total")
    @Expose
    var evtParesTotal: String? = null

    @SerializedName("evt_pares_total_pcnt")
    @Expose
    var evtParesTotalPcnt: String? = null

    @SerializedName("evt_ketos_lact_1")
    @Expose
    var evtKetosLact1: String? = null

    @SerializedName("evt_ketos_lact_1_pcnt")
    @Expose
    var evtKetosLact1Pcnt: String? = null

    @SerializedName("evt_ketos_lact_o1")
    @Expose
    var evtKetosLactO1: String? = null

    @SerializedName("evt_ketos_lact_o1_pcnt")
    @Expose
    var evtKetosLactO1Pcnt: String? = null

    @SerializedName("evt_ketos_total")
    @Expose
    var evtKetosTotal: String? = null

    @SerializedName("evt_ketos_total_pcnt")
    @Expose
    var evtKetosTotalPcnt: String? = null

    @SerializedName("evt_metrit")
    @Expose
    var evtMetrit: String? = null

    @SerializedName("evt_metrit_pcnt")
    @Expose
    var evtMetritPcnt: String? = null

    @SerializedName("evt_move_cows")
    @Expose
    var evtMoveCows: String? = null

    @SerializedName("evt_move_heifers")
    @Expose
    var evtMoveHeifers: String? = null

    @SerializedName("evt_vacc_cows")
    @Expose
    var evtVaccCows: String? = null

    @SerializedName("evt_vacc_heifers")
    @Expose
    var evtVaccHeifers: String? = null

    @SerializedName("evt_footrim_cows")
    @Expose
    var evtFootrimCows: String? = null

    @SerializedName("evt_footrim_heifers")
    @Expose
    var evtFootrimHeifers: String? = null

    @SerializedName("evt_sold_cows_lact_1_0_10")
    @Expose
    var evtSoldCowsLact1010: String? = null

    @SerializedName("evt_sold_cows_lact_1_11_30")
    @Expose
    var evtSoldCowsLact11130: String? = null

    @SerializedName("evt_sold_cows_lact_1_31_60")
    @Expose
    var evtSoldCowsLact13160: String? = null

    @SerializedName("evt_sold_cows_lact_1_61_120")
    @Expose
    var evtSoldCowsLact161120: String? = null

    @SerializedName("evt_sold_cows_lact_1_o120")
    @Expose
    var evtSoldCowsLact1O120: String? = null

    @SerializedName("evt_sold_cows_lact_1_total")
    @Expose
    var evtSoldCowsLact1Total: String? = null

    @SerializedName("evt_sold_cows_lact_2_0_10")
    @Expose
    var evtSoldCowsLact2010: String? = null

    @SerializedName("evt_sold_cows_lact_2_11_30")
    @Expose
    var evtSoldCowsLact21130: String? = null

    @SerializedName("evt_sold_cows_lact_2_31_60")
    @Expose
    var evtSoldCowsLact23160: String? = null

    @SerializedName("evt_sold_cows_lact_2_61_120")
    @Expose
    var evtSoldCowsLact261120: String? = null

    @SerializedName("evt_sold_cows_lact_2_o120")
    @Expose
    var evtSoldCowsLact2O120: String? = null

    @SerializedName("evt_sold_cows_lact_2_total")
    @Expose
    var evtSoldCowsLact2Total: String? = null

    @SerializedName("evt_sold_cows_lact_o2_0_10")
    @Expose
    var evtSoldCowsLactO2010: String? = null

    @SerializedName("evt_sold_cows_lact_o2_11_30")
    @Expose
    var evtSoldCowsLactO21130: String? = null

    @SerializedName("evt_sold_cows_lact_o2_31_60")
    @Expose
    var evtSoldCowsLactO23160: String? = null

    @SerializedName("evt_sold_cows_lact_o2_61_120")
    @Expose
    var evtSoldCowsLactO261120: String? = null

    @SerializedName("evt_sold_cows_lact_o2_o120")
    @Expose
    var evtSoldCowsLactO2O120: String? = null

    @SerializedName("evt_sold_cows_lact_o2_total")
    @Expose
    var evtSoldCowsLactO2Total: String? = null

    @SerializedName("evt_sold_cows_total")
    @Expose
    var evtSoldCowsTotal: String? = null

    @SerializedName("evt_sold_heifers_0_2")
    @Expose
    var evtSoldHeifers02: String? = null

    @SerializedName("evt_sold_heifers_2_6")
    @Expose
    var evtSoldHeifers26: String? = null

    @SerializedName("evt_sold_heifers_6_12")
    @Expose
    var evtSoldHeifers612: String? = null

    @SerializedName("evt_sold_heifers_o12")
    @Expose
    var evtSoldHeifersO12: String? = null

    @SerializedName("evt_sold_heifers_total")
    @Expose
    var evtSoldHeifersTotal: String? = null

    @SerializedName("evt_sold_pheifers")
    @Expose
    var evtSoldPheifers: String? = null

    @SerializedName("evt_sold_bulls")
    @Expose
    var evtSoldBulls: String? = null

    @SerializedName("evt_dead_cows_lact_1_0_10")
    @Expose
    var evtDeadCowsLact1010: String? = null

    @SerializedName("evt_dead_cows_lact_1_11_30")
    @Expose
    var evtDeadCowsLact11130: String? = null

    @SerializedName("evt_dead_cows_lact_1_31_60")
    @Expose
    var evtDeadCowsLact13160: String? = null

    @SerializedName("evt_dead_cows_lact_1_61_120")
    @Expose
    var evtDeadCowsLact161120: String? = null

    @SerializedName("evt_dead_cows_lact_1_o120")
    @Expose
    var evtDeadCowsLact1O120: String? = null

    @SerializedName("evt_dead_cows_lact_1_total")
    @Expose
    var evtDeadCowsLact1Total: String? = null

    @SerializedName("evt_dead_cows_lact_2_0_10")
    @Expose
    var evtDeadCowsLact2010: String? = null

    @SerializedName("evt_dead_cows_lact_2_11_30")
    @Expose
    var evtDeadCowsLact21130: String? = null

    @SerializedName("evt_dead_cows_lact_2_31_60")
    @Expose
    var evtDeadCowsLact23160: String? = null

    @SerializedName("evt_dead_cows_lact_2_61_120")
    @Expose
    var evtDeadCowsLact261120: String? = null

    @SerializedName("evt_dead_cows_lact_2_o120")
    @Expose
    var evtDeadCowsLact2O120: String? = null

    @SerializedName("evt_dead_cows_lact_2_total")
    @Expose
    var evtDeadCowsLact2Total: String? = null

    @SerializedName("evt_dead_cows_lact_o2_0_10")
    @Expose
    var evtDeadCowsLactO2010: String? = null

    @SerializedName("evt_dead_cows_lact_o2_11_30")
    @Expose
    var evtDeadCowsLactO21130: String? = null

    @SerializedName("evt_dead_cows_lact_o2_31_60")
    @Expose
    var evtDeadCowsLactO23160: String? = null

    @SerializedName("evt_dead_cows_lact_o2_61_120")
    @Expose
    var evtDeadCowsLactO261120: String? = null

    @SerializedName("evt_dead_cows_lact_o2_o120")
    @Expose
    var evtDeadCowsLactO2O120: String? = null

    @SerializedName("evt_dead_cows_lact_o2_total")
    @Expose
    var evtDeadCowsLactO2Total: String? = null

    @SerializedName("evt_dead_cows_total")
    @Expose
    var evtDeadCowsTotal: String? = null

    @SerializedName("evt_dead_heifers_0_2")
    @Expose
    var evtDeadHeifers02: String? = null

    @SerializedName("evt_dead_heifers_2_6")
    @Expose
    var evtDeadHeifers26: String? = null

    @SerializedName("evt_dead_heifers_6_12")
    @Expose
    var evtDeadHeifers612: String? = null

    @SerializedName("evt_dead_heifers_o12")
    @Expose
    var evtDeadHeifersO12: String? = null

    @SerializedName("evt_dead_heifers_total")
    @Expose
    var evtDeadHeifersTotal: String? = null

    @SerializedName("evt_dead_pheifers")
    @Expose
    var evtDeadPheifers: String? = null

    @SerializedName("evt_dead_bulls")
    @Expose
    var evtDeadBulls: String? = null

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

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    var mlkMilkSumYield: String? = null

    @SerializedName("mlk_milk_per_cow")
    @Expose
    var mlkMilkPerCow: String? = null

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    var mlkMilkPerLactCow: String? = null

    @SerializedName("feed_kpi")
    @Expose
    var feedKpi: Any? = null
}