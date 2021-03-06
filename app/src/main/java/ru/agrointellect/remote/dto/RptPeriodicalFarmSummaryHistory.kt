@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
open class RptPeriodicalDataTable {

    @SerializedName("date")
    @Expose
    var date = emptyList<String>()

    @SerializedName("avg_lact_num")
    @Expose
    lateinit var avgLactNum: List<String>

    @SerializedName("avg_days_in_milk")
    @Expose
    lateinit var avgDaysInMilk: List<String>

    @SerializedName("avg_days_in_milk_1_lact")
    @Expose
    lateinit var avgDaysInMilk1Lact: List<String>

    @SerializedName("avg_days_in_milk_2_lact")
    @Expose
    lateinit var avgDaysInMilk2Lact: List<String>

    @SerializedName("avg_days_in_milk_over_2_lact")
    @Expose
    lateinit var avgDaysInMilkOver2Lact: List<String>

    @SerializedName("avg_open_days")
    @Expose
    lateinit var avgOpenDays: List<String>

    @SerializedName("avg_open_days_1_lact")
    @Expose
    lateinit var avgOpenDays1Lact: List<String>

    @SerializedName("avg_open_days_2_lact")
    @Expose
    lateinit var avgOpenDays2Lact: List<String>

    @SerializedName("avg_open_days_over_2_lact")
    @Expose
    lateinit var avgOpenDaysOver2Lact: List<String>

    @SerializedName("avg_dry_days")
    @Expose
    lateinit var avgDryDays: List<String>

    @SerializedName("avg_pregnant_days_cows")
    @Expose
    lateinit var avgPregnantDaysCows: List<String>

    @SerializedName("avg_pregnant_days_heifers")
    @Expose
    lateinit var avgPregnantDaysHeifers: List<String>

    @SerializedName("avg_calv_int_days")
    @Expose
    lateinit var avgCalvIntDays: List<String>

    @SerializedName("avg_insem_int_days_cows")
    @Expose
    lateinit var avgInsemIntDaysCows: List<String>

    @SerializedName("avg_insem_int_days_heifers")
    @Expose
    lateinit var avgInsemIntDaysHeifers: List<String>

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    lateinit var avgFirstInsemDimCows: List<String>

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    lateinit var avgFirstInsemAgeHeifers: List<String>

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    lateinit var avgFirstCalvAge1Lact: List<String>

    @SerializedName("avg_milk_peak_days")
    @Expose
    lateinit var avgMilkPeakDays: List<String>

    @SerializedName("avg_milk_peak_days_1_lact")
    @Expose
    lateinit var avgMilkPeakDays1Lact: List<String>

    @SerializedName("avg_milk_peak_days_2_lact")
    @Expose
    lateinit var avgMilkPeakDays2Lact: List<String>

    @SerializedName("avg_milk_peak_days_over_2_lact")
    @Expose
    lateinit var avgMilkPeakDaysOver2Lact: List<String>

    @SerializedName("hrd_cows_all")
    @Expose
    lateinit var hrdCowsAll: List<String>

    @SerializedName("hrd_cows_lact_all")
    @Expose
    lateinit var hrdCowsLactAll: List<String>

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    lateinit var hrdCowsLactAllPcnt: List<String>

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    lateinit var hrdCowsLact1All: List<String>

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    lateinit var hrdCowsLact1Pcnt: List<String>

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    lateinit var hrdCowsLact1030: List<String>

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    lateinit var hrdCowsLact13160: List<String>

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    lateinit var hrdCowsLact161120: List<String>

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    lateinit var hrdCowsLact1O120: List<String>

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    lateinit var hrdCowsLact2All: List<String>

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    lateinit var hrdCowsLact2Pcnt: List<String>

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    lateinit var hrdCowsLact2030: List<String>

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    lateinit var hrdCowsLact23160: List<String>

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    lateinit var hrdCowsLact261120: List<String>

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    lateinit var hrdCowsLact2O120: List<String>

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    lateinit var hrdCowsLactO2All: List<String>

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    lateinit var hrdCowsLactO2Pcnt: List<String>

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    lateinit var hrdCowsLactO2030: List<String>

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    lateinit var hrdCowsLactO23160: List<String>

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    lateinit var hrdCowsLactO261120: List<String>

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    lateinit var hrdCowsLactO2O120: List<String>

    @SerializedName("hrd_cows_preg_all")
    @Expose
    lateinit var hrdCowsPregAll: List<String>

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    lateinit var hrdCowsPregPcnt: List<String>

    @SerializedName("hrd_cows_dry_all")
    @Expose
    lateinit var hrdCowsDryAll: List<String>

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    lateinit var hrdCowsDryPcnt: List<String>

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    lateinit var hrdCowsDryF1: List<String>

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    lateinit var hrdCowsDryF2: List<String>

    @SerializedName("hrd_heifers_all")
    @Expose
    lateinit var hrdHeifersAll: List<String>

    @SerializedName("hrd_heifers_0_2")
    @Expose
    lateinit var hrdHeifers02: List<String>

    @SerializedName("hrd_heifers_2_6")
    @Expose
    lateinit var hrdHeifers26: List<String>

    @SerializedName("hrd_heifers_6_12")
    @Expose
    lateinit var hrdHeifers612: List<String>

    @SerializedName("hrd_heifers_o12")
    @Expose
    lateinit var hrdHeifersO12: List<String>

    @SerializedName("hrd_pheifers_all")
    @Expose
    lateinit var hrdPheifersAll: List<String>

    @SerializedName("hrd_pheifers_f2")
    @Expose
    lateinit var hrdPheifersF2: List<String>

    @SerializedName("hrd_bulls")
    @Expose
    lateinit var hrdBulls: List<String>

    @SerializedName("evt_insem_cows")
    @Expose
    lateinit var evtInsemCows: List<String>

    @SerializedName("evt_insem_heifers")
    @Expose
    lateinit var evtInsemHeifers: List<String>

    @SerializedName("evt_preg_check_cows")
    @Expose
    lateinit var evtPregCheckCows: List<String>

    @SerializedName("evt_got_preg_cows")
    @Expose
    lateinit var evtGotPregCows: List<String>

    @SerializedName("evt_preg_check_heifers")
    @Expose
    lateinit var evtPregCheckHeifers: List<String>

    @SerializedName("evt_got_preg_heifers")
    @Expose
    lateinit var evtGotPregHeifers: List<String>

    @SerializedName("evt_dry_cows")
    @Expose
    lateinit var evtDryCows: List<String>

    @SerializedName("evt_calv_total")
    @Expose
    lateinit var evtCalvTotal: List<String>

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    lateinit var evtCalvAliveHeifers: List<String>

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    lateinit var evtCalvAliveBulls: List<String>

    @SerializedName("evt_calv_dead_heifers")
    @Expose
    lateinit var evtCalvDeadHeifers: List<String>

    @SerializedName("evt_calv_dead_bulls")
    @Expose
    lateinit var evtCalvDeadBulls: List<String>

    @SerializedName("evt_calv_dead_all_pcnt")
    @Expose
    lateinit var evtCalvDeadAllPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_all_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersAllPcnt: List<String>

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    lateinit var evtCalvTotalPheifers: List<String>

    @SerializedName("evt_calv_alive_heifers_pheifers")
    @Expose
    lateinit var evtCalvAliveHeifersPheifers: List<String>

    @SerializedName("evt_calv_alive_bulls_pheifers")
    @Expose
    lateinit var evtCalvAliveBullsPheifers: List<String>

    @SerializedName("evt_calv_dead_heifers_pheifers")
    @Expose
    lateinit var evtCalvDeadHeifersPheifers: List<String>

    @SerializedName("evt_calv_dead_bulls_pheifers")
    @Expose
    lateinit var evtCalvDeadBullsPheifers: List<String>

    @SerializedName("evt_calv_dead_pheifers_pcnt")
    @Expose
    lateinit var evtCalvDeadPheifersPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_pheifers_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersPheifersPcnt: List<String>

    @SerializedName("evt_calv_total_cows")
    @Expose
    lateinit var evtCalvTotalCows: List<String>

    @SerializedName("evt_calv_alive_heifers_cows")
    @Expose
    lateinit var evtCalvAliveHeifersCows: List<String>

    @SerializedName("evt_calv_alive_bulls_cows")
    @Expose
    lateinit var evtCalvAliveBullsCows: List<String>

    @SerializedName("evt_calv_dead_heifers_cows")
    @Expose
    lateinit var evtCalvDeadHeifersCows: List<String>

    @SerializedName("evt_calv_dead_bulls_cows")
    @Expose
    lateinit var evtCalvDeadBullsCows: List<String>

    @SerializedName("evt_calv_dead_cows_pcnt")
    @Expose
    lateinit var evtCalvDeadCowsPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_cows_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersCowsPcnt: List<String>

    @SerializedName("evt_abort_cows")
    @Expose
    lateinit var evtAbortCows: List<String>

    @SerializedName("evt_abort_heifers")
    @Expose
    lateinit var evtAbortHeifers: List<String>

    @SerializedName("evt_mast_for_month_cows")
    @Expose
    lateinit var evtMastForMonthCows: List<String>

    @SerializedName("evt_lame_for_month_cows")
    @Expose
    lateinit var evtLameForMonthCows: List<String>

    @SerializedName("evt_lame_for_month_heifers")
    @Expose
    lateinit var evtLameForMonthHeifers: List<String>

    @SerializedName("evt_ret_plac_lact_1")
    @Expose
    lateinit var evtRetPlacLact1: List<String>

    @SerializedName("evt_ret_plac_lact_1_pcnt")
    @Expose
    lateinit var evtRetPlacLact1Pcnt: List<String>

    @SerializedName("evt_ret_plac_lact_o1")
    @Expose
    lateinit var evtRetPlacLactO1: List<String>

    @SerializedName("evt_ret_plac_lact_o1_pcnt")
    @Expose
    lateinit var evtRetPlacLactO1Pcnt: List<String>

    @SerializedName("evt_ret_plac_total")
    @Expose
    lateinit var evtRetPlacTotal: List<String>

    @SerializedName("evt_ret_plac_total_pcnt")
    @Expose
    lateinit var evtRetPlacTotalPcnt: List<String>

    @SerializedName("evt_pares_lact_1")
    @Expose
    lateinit var evtParesLact1: List<String>

    @SerializedName("evt_pares_lact_1_pcnt")
    @Expose
    lateinit var evtParesLact1Pcnt: List<String>

    @SerializedName("evt_pares_lact_o1")
    @Expose
    lateinit var evtParesLactO1: List<String>

    @SerializedName("evt_pares_lact_o1_pcnt")
    @Expose
    lateinit var evtParesLactO1Pcnt: List<String>

    @SerializedName("evt_pares_total")
    @Expose
    lateinit var evtParesTotal: List<String>

    @SerializedName("evt_pares_total_pcnt")
    @Expose
    lateinit var evtParesTotalPcnt: List<String>

    @SerializedName("evt_ketos_lact_1")
    @Expose
    lateinit var evtKetosLact1: List<String>

    @SerializedName("evt_ketos_lact_1_pcnt")
    @Expose
    lateinit var evtKetosLact1Pcnt: List<String>

    @SerializedName("evt_ketos_lact_o1")
    @Expose
    lateinit var evtKetosLactO1: List<String>

    @SerializedName("evt_ketos_lact_o1_pcnt")
    @Expose
    lateinit var evtKetosLactO1Pcnt: List<String>

    @SerializedName("evt_ketos_total")
    @Expose
    lateinit var evtKetosTotal: List<String>

    @SerializedName("evt_ketos_total_pcnt")
    @Expose
    lateinit var evtKetosTotalPcnt: List<String>

    @SerializedName("evt_metrit")
    @Expose
    lateinit var evtMetrit: List<String>

    @SerializedName("evt_metrit_pcnt")
    @Expose
    lateinit var evtMetritPcnt: List<String>

    @SerializedName("evt_move_cows")
    @Expose
    lateinit var evtMoveCows: List<String>

    @SerializedName("evt_move_heifers")
    @Expose
    lateinit var evtMoveHeifers: List<String>

    @SerializedName("evt_vacc_cows")
    @Expose
    lateinit var evtVaccCows: List<String>

    @SerializedName("evt_vacc_heifers")
    @Expose
    lateinit var evtVaccHeifers: List<String>

    @SerializedName("evt_footrim_cows")
    @Expose
    lateinit var evtFootrimCows: List<String>

    @SerializedName("evt_footrim_heifers")
    @Expose
    lateinit var evtFootrimHeifers: List<String>

    @SerializedName("evt_sold_cows_lact_1_0_10")
    @Expose
    lateinit var evtSoldCowsLact1010: List<String>

    @SerializedName("evt_sold_cows_lact_1_11_30")
    @Expose
    lateinit var evtSoldCowsLact11130: List<String>

    @SerializedName("evt_sold_cows_lact_1_31_60")
    @Expose
    lateinit var evtSoldCowsLact13160: List<String>

    @SerializedName("evt_sold_cows_lact_1_61_120")
    @Expose
    lateinit var evtSoldCowsLact161120: List<String>

    @SerializedName("evt_sold_cows_lact_1_o120")
    @Expose
    lateinit var evtSoldCowsLact1O120: List<String>

    @SerializedName("evt_sold_cows_lact_1_total")
    @Expose
    lateinit var evtSoldCowsLact1Total: List<String>

    @SerializedName("evt_sold_cows_lact_2_0_10")
    @Expose
    lateinit var evtSoldCowsLact2010: List<String>

    @SerializedName("evt_sold_cows_lact_2_11_30")
    @Expose
    lateinit var evtSoldCowsLact21130: List<String>

    @SerializedName("evt_sold_cows_lact_2_31_60")
    @Expose
    lateinit var evtSoldCowsLact23160: List<String>

    @SerializedName("evt_sold_cows_lact_2_61_120")
    @Expose
    lateinit var evtSoldCowsLact261120: List<String>

    @SerializedName("evt_sold_cows_lact_2_o120")
    @Expose
    lateinit var evtSoldCowsLact2O120: List<String>

    @SerializedName("evt_sold_cows_lact_2_total")
    @Expose
    lateinit var evtSoldCowsLact2Total: List<String>

    @SerializedName("evt_sold_cows_lact_o2_0_10")
    @Expose
    lateinit var evtSoldCowsLactO2010: List<String>

    @SerializedName("evt_sold_cows_lact_o2_11_30")
    @Expose
    lateinit var evtSoldCowsLactO21130: List<String>

    @SerializedName("evt_sold_cows_lact_o2_31_60")
    @Expose
    lateinit var evtSoldCowsLactO23160: List<String>

    @SerializedName("evt_sold_cows_lact_o2_61_120")
    @Expose
    lateinit var evtSoldCowsLactO261120: List<String>

    @SerializedName("evt_sold_cows_lact_o2_o120")
    @Expose
    lateinit var evtSoldCowsLactO2O120: List<String>

    @SerializedName("evt_sold_cows_lact_o2_total")
    @Expose
    lateinit var evtSoldCowsLactO2Total: List<String>

    @SerializedName("evt_sold_cows_total")
    @Expose
    lateinit var evtSoldCowsTotal: List<String>

    @SerializedName("evt_sold_heifers_0_2")
    @Expose
    lateinit var evtSoldHeifers02: List<String>

    @SerializedName("evt_sold_heifers_2_6")
    @Expose
    lateinit var evtSoldHeifers26: List<String>

    @SerializedName("evt_sold_heifers_6_12")
    @Expose
    lateinit var evtSoldHeifers612: List<String>

    @SerializedName("evt_sold_heifers_o12")
    @Expose
    lateinit var evtSoldHeifersO12: List<String>

    @SerializedName("evt_sold_heifers_total")
    @Expose
    lateinit var evtSoldHeifersTotal: List<String>

    @SerializedName("evt_sold_pheifers")
    @Expose
    lateinit var evtSoldPheifers: List<String>

    @SerializedName("evt_sold_bulls")
    @Expose
    lateinit var evtSoldBulls: List<String>

    @SerializedName("evt_dead_cows_lact_1_0_10")
    @Expose
    lateinit var evtDeadCowsLact1010: List<String>

    @SerializedName("evt_dead_cows_lact_1_11_30")
    @Expose
    lateinit var evtDeadCowsLact11130: List<String>

    @SerializedName("evt_dead_cows_lact_1_31_60")
    @Expose
    lateinit var evtDeadCowsLact13160: List<String>

    @SerializedName("evt_dead_cows_lact_1_61_120")
    @Expose
    lateinit var evtDeadCowsLact161120: List<String>

    @SerializedName("evt_dead_cows_lact_1_o120")
    @Expose
    lateinit var evtDeadCowsLact1O120: List<String>

    @SerializedName("evt_dead_cows_lact_1_total")
    @Expose
    lateinit var evtDeadCowsLact1Total: List<String>

    @SerializedName("evt_dead_cows_lact_2_0_10")
    @Expose
    lateinit var evtDeadCowsLact2010: List<String>

    @SerializedName("evt_dead_cows_lact_2_11_30")
    @Expose
    lateinit var evtDeadCowsLact21130: List<String>

    @SerializedName("evt_dead_cows_lact_2_31_60")
    @Expose
    lateinit var evtDeadCowsLact23160: List<String>

    @SerializedName("evt_dead_cows_lact_2_61_120")
    @Expose
    lateinit var evtDeadCowsLact261120: List<String>

    @SerializedName("evt_dead_cows_lact_2_o120")
    @Expose
    lateinit var evtDeadCowsLact2O120: List<String>

    @SerializedName("evt_dead_cows_lact_2_total")
    @Expose
    lateinit var evtDeadCowsLact2Total: List<String>

    @SerializedName("evt_dead_cows_lact_o2_0_10")
    @Expose
    lateinit var evtDeadCowsLactO2010: List<String>

    @SerializedName("evt_dead_cows_lact_o2_11_30")
    @Expose
    lateinit var evtDeadCowsLactO21130: List<String>

    @SerializedName("evt_dead_cows_lact_o2_31_60")
    @Expose
    lateinit var evtDeadCowsLactO23160: List<String>

    @SerializedName("evt_dead_cows_lact_o2_61_120")
    @Expose
    lateinit var evtDeadCowsLactO261120: List<String>

    @SerializedName("evt_dead_cows_lact_o2_o120")
    @Expose
    lateinit var evtDeadCowsLactO2O120: List<String>

    @SerializedName("evt_dead_cows_lact_o2_total")
    @Expose
    lateinit var evtDeadCowsLactO2Total: List<String>

    @SerializedName("evt_dead_cows_total")
    @Expose
    lateinit var evtDeadCowsTotal: List<String>

    @SerializedName("evt_dead_heifers_0_2")
    @Expose
    lateinit var evtDeadHeifers02: List<String>

    @SerializedName("evt_dead_heifers_2_6")
    @Expose
    lateinit var evtDeadHeifers26: List<String>

    @SerializedName("evt_dead_heifers_6_12")
    @Expose
    lateinit var evtDeadHeifers612: List<String>

    @SerializedName("evt_dead_heifers_o12")
    @Expose
    lateinit var evtDeadHeifersO12: List<String>

    @SerializedName("evt_dead_heifers_total")
    @Expose
    lateinit var evtDeadHeifersTotal: List<String>

    @SerializedName("evt_dead_pheifers")
    @Expose
    lateinit var evtDeadPheifers: List<String>

    @SerializedName("evt_dead_bulls")
    @Expose
    lateinit var evtDeadBulls: List<String>

    @SerializedName("brd_heat_det_rate_cow")
    @Expose
    lateinit var brdHeatDetRateCow: List<String>

    @SerializedName("brd_heat_det_rate_heif")
    @Expose
    lateinit var brdHeatDetRateHeif: List<String>

    @SerializedName("brd_conc_rate_cow")
    @Expose
    lateinit var brdConcRateCow: List<String>

    @SerializedName("brd_conc_rate_heif")
    @Expose
    lateinit var brdConcRateHeif: List<String>

    @SerializedName("brd_preg_rate_cow")
    @Expose
    lateinit var brdPregRateCow: List<String>

    @SerializedName("brd_preg_rate_heif")
    @Expose
    lateinit var brdPregRateHeif: List<String>

    @SerializedName("brd_straws_per_preg_cow")
    @Expose
    lateinit var brdStrawsPerPregCow: List<String>

    @SerializedName("brd_straws_per_preg_heif")
    @Expose
    lateinit var brdStrawsPerPregHeif: List<String>

    @SerializedName("mlk_avg_milk_sum_yield")
    @Expose
    lateinit var mlkAvgMilkSumYield: List<String>

    @SerializedName("mlk_sum_milk_sum_yield")
    @Expose
    lateinit var mlkSumMilkSumYield: List<String>

    @SerializedName("mlk_avg_milk_per_cow")
    @Expose
    lateinit var mlkAvgMilkPerCow: List<String>

    @SerializedName("mlk_sum_milk_per_cow")
    @Expose
    lateinit var mlkSumMilkPerCow: List<String>

    @SerializedName("mlk_avg_milk_per_lact_cow")
    @Expose
    lateinit var mlkAvgMilkPerLactCow: List<String>

    @SerializedName("mlk_sum_milk_per_lact_cow")
    @Expose
    lateinit var mlkSumMilkPerLactCow: List<String>

    @SerializedName("feed_kpi")
    @Expose
    lateinit var feedKpi: List<String>

    @SerializedName("feed_cost_1kg_milk_total")
    @Expose
    lateinit var feedCost1kgMilkTotal: List<String>

    @SerializedName("feed_cost_1kg_milk_cows_all")
    @Expose
    lateinit var feedCost1kgMilkCowsAll: List<String>

    @SerializedName("feed_cost_1kg_milk_cows_lact")
    @Expose
    lateinit var feedCost1kgMilkCowsLact: List<String>
}