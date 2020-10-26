package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.api.formatDate

@Keep
@Suppress("SpellCheckingInspection")
class RptFarmSummaryHistory {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("avg_lact_num")
    @Expose
    @JvmField
    var avgLactNum: String? = null

    @SerializedName("avg_days_in_milk")
    @Expose
    @JvmField
    var avgDaysInMilk: String? = null

    @SerializedName("avg_days_in_milk_1_lact")
    @Expose
    @JvmField
    var avgDaysInMilk1Lact: String? = null

    @SerializedName("avg_days_in_milk_2_lact")
    @Expose
    @JvmField
    var avgDaysInMilk2Lact: String? = null

    @SerializedName("avg_days_in_milk_over_2_lact")
    @Expose
    @JvmField
    var avgDaysInMilkOver2Lact: String? = null

    @SerializedName("avg_open_days")
    @Expose
    @JvmField
    var avgOpenDays: String? = null

    @SerializedName("avg_open_days_1_lact")
    @Expose
    @JvmField
    var avgOpenDays1Lact: String? = null

    @SerializedName("avg_open_days_2_lact")
    @Expose
    @JvmField
    var avgOpenDays2Lact: String? = null

    @SerializedName("avg_open_days_over_2_lact")
    @Expose
    @JvmField
    var avgOpenDaysOver2Lact: String? = null

    @SerializedName("avg_dry_days")
    @Expose
    @JvmField
    var avgDryDays: String? = null

    @SerializedName("avg_pregnant_days_cows")
    @Expose
    @JvmField
    var avgPregnantDaysCows: String? = null

    @SerializedName("avg_pregnant_days_heifers")
    @Expose
    @JvmField
    var avgPregnantDaysHeifers: String? = null

    @SerializedName("avg_calv_int_days")
    @Expose
    @JvmField
    var avgCalvIntDays: String? = null

    @SerializedName("avg_insem_int_days_cows")
    @Expose
    @JvmField
    var avgInsemIntDaysCows: String? = null

    @SerializedName("avg_insem_int_days_heifers")
    @Expose
    @JvmField
    var avgInsemIntDaysHeifers: String? = null

    @SerializedName("avg_in_hosp_days")
    @Expose
    @JvmField
    var avgInHospDays: String? = null

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    @JvmField
    var avgFirstInsemDimCows: String? = null

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    @JvmField
    var avgFirstInsemAgeHeifers: String? = null

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    @JvmField
    var avgFirstCalvAge1Lact: String? = null

    @SerializedName("avg_milk_peak_days")
    @Expose
    @JvmField
    var avgMilkPeakDays: String? = null

    @SerializedName("avg_milk_peak_days_1_lact")
    @Expose
    @JvmField
    var avgMilkPeakDays1Lact: String? = null

    @SerializedName("avg_milk_peak_days_2_lact")
    @Expose
    @JvmField
    var avgMilkPeakDays2Lact: String? = null

    @SerializedName("avg_milk_peak_days_over_2_lact")
    @Expose
    @JvmField
    var avgMilkPeakDaysOver2Lact: String? = null

    @SerializedName("hrd_cows_all")
    @Expose
    @JvmField
    var hrdCowsAll: String? = null

    @SerializedName("hrd_cows_lact_all")
    @Expose
    @JvmField
    var hrdCowsLactAll: String? = null

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    @JvmField
    var hrdCowsLactAllPcnt = ""

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    @JvmField
    var hrdCowsLact1All: String? = null

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    @JvmField
    var hrdCowsLact1Pcnt = ""

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    @JvmField
    var hrdCowsLact1030: String? = null

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    @JvmField
    var hrdCowsLact13160: String? = null

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    @JvmField
    var hrdCowsLact161120: String? = null

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    @JvmField
    var hrdCowsLact1O120: String? = null

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    @JvmField
    var hrdCowsLact2All: String? = null

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    @JvmField
    var hrdCowsLact2Pcnt = ""

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    @JvmField
    var hrdCowsLact2030: String? = null

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    @JvmField
    var hrdCowsLact23160: String? = null

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    @JvmField
    var hrdCowsLact261120: String? = null

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    @JvmField
    var hrdCowsLact2O120: String? = null

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    @JvmField
    var hrdCowsLactO2All: String? = null

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    @JvmField
    var hrdCowsLactO2Pcnt = ""

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    @JvmField
    var hrdCowsLactO2030: String? = null

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    @JvmField
    var hrdCowsLactO23160: String? = null

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    @JvmField
    var hrdCowsLactO261120: String? = null

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    @JvmField
    var hrdCowsLactO2O120: String? = null

    @SerializedName("hrd_cows_preg_all")
    @Expose
    @JvmField
    var hrdCowsPregAll: String? = null

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    @JvmField
    var hrdCowsPregPcnt = ""

    @SerializedName("hrd_cows_dry_all")
    @Expose
    @JvmField
    var hrdCowsDryAll: String? = null

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    @JvmField
    var hrdCowsDryPcnt = ""

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    @JvmField
    var hrdCowsDryF1: String? = null

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    @JvmField
    var hrdCowsDryF2: String? = null

    @SerializedName("hrd_heifers_all")
    @Expose
    @JvmField
    var hrdHeifersAll: String? = null

    @SerializedName("hrd_heifers_0_2")
    @Expose
    @JvmField
    var hrdHeifers02: String? = null

    @SerializedName("hrd_heifers_2_6")
    @Expose
    @JvmField
    var hrdHeifers26: String? = null

    @SerializedName("hrd_heifers_6_12")
    @Expose
    @JvmField
    var hrdHeifers612: String? = null

    @SerializedName("hrd_heifers_o12")
    @Expose
    @JvmField
    var hrdHeifersO12: String? = null

    @SerializedName("hrd_pheifers_all")
    @Expose
    @JvmField
    var hrdPheifersAll: String? = null

    @SerializedName("hrd_pheifers_f2")
    @Expose
    @JvmField
    var hrdPheifersF2: String? = null

    @SerializedName("hrd_bulls")
    @Expose
    @JvmField
    var hrdBulls: String? = null

    @SerializedName("evt_insem_cows")
    @Expose
    @JvmField
    var evtInsemCows: String? = null

    @SerializedName("evt_insem_heifers")
    @Expose
    @JvmField
    var evtInsemHeifers: String? = null

    @SerializedName("evt_got_preg_cows")
    @Expose
    @JvmField
    var evtGotPregCows: String? = null

    @SerializedName("evt_got_preg_heifers")
    @Expose
    @JvmField
    var evtGotPregHeifers: String? = null

    @SerializedName("evt_dry_cows")
    @Expose
    @JvmField
    var evtDryCows: String? = null

    @SerializedName("evt_calv_total")
    @Expose
    @JvmField
    var evtCalvTotal: String? = null

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    @JvmField
    var evtCalvAliveHeifers: String? = null

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    @JvmField
    var evtCalvAliveBulls: String? = null

    @SerializedName("evt_calv_dead_heifers")
    @Expose
    @JvmField
    var evtCalvDeadHeifers: String? = null

    @SerializedName("evt_calv_dead_bulls")
    @Expose
    @JvmField
    var evtCalvDeadBulls: String? = null

    @SerializedName("evt_calv_dead_all_pcnt")
    @Expose
    @JvmField
    var evtCalvDeadAllPcnt = ""

    @SerializedName("evt_calv_alive_heifers_all_pcnt")
    @Expose
    @JvmField
    var evtCalvAliveHeifersAllPcnt = ""

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    @JvmField
    var evtCalvTotalPheifers: String? = null

    @SerializedName("evt_calv_alive_heifers_pheifers")
    @Expose
    @JvmField
    var evtCalvAliveHeifersPheifers: String? = null

    @SerializedName("evt_calv_alive_bulls_pheifers")
    @Expose
    @JvmField
    var evtCalvAliveBullsPheifers: String? = null

    @SerializedName("evt_calv_dead_heifers_pheifers")
    @Expose
    @JvmField
    var evtCalvDeadHeifersPheifers: String? = null

    @SerializedName("evt_calv_dead_bulls_pheifers")
    @Expose
    @JvmField
    var evtCalvDeadBullsPheifers: String? = null

    @SerializedName("evt_calv_dead_pheifers_pcnt")
    @Expose
    @JvmField
    var evtCalvDeadPheifersPcnt = ""

    @SerializedName("evt_calv_alive_heifers_pheifers_pcnt")
    @Expose
    @JvmField
    var evtCalvAliveHeifersPheifersPcnt = ""

    @SerializedName("evt_calv_total_cows")
    @Expose
    @JvmField
    var evtCalvTotalCows: String? = null

    @SerializedName("evt_calv_alive_heifers_cows")
    @Expose
    @JvmField
    var evtCalvAliveHeifersCows: String? = null

    @SerializedName("evt_calv_alive_bulls_cows")
    @Expose
    @JvmField
    var evtCalvAliveBullsCows: String? = null

    @SerializedName("evt_calv_dead_heifers_cows")
    @Expose
    @JvmField
    var evtCalvDeadHeifersCows: String? = null

    @SerializedName("evt_calv_dead_bulls_cows")
    @Expose
    @JvmField
    var evtCalvDeadBullsCows: String? = null

    @SerializedName("evt_calv_dead_cows_pcnt")
    @Expose
    @JvmField
    var evtCalvDeadCowsPcnt = ""

    @SerializedName("evt_calv_alive_heifers_cows_pcnt")
    @Expose
    @JvmField
    var evtCalvAliveHeifersCowsPcnt = ""

    @SerializedName("evt_abort_cows")
    @Expose
    @JvmField
    var evtAbortCows: String? = null

    @SerializedName("evt_abort_heifers")
    @Expose
    @JvmField
    var evtAbortHeifers: String? = null

    @SerializedName("evt_mast_for_month_cows")
    @Expose
    @JvmField
    var evtMastForMonthCows: String? = null

    @SerializedName("evt_lame_for_month_cows")
    @Expose
    @JvmField
    var evtLameForMonthCows: String? = null

    @SerializedName("evt_lame_for_month_heifers")
    @Expose
    @JvmField
    var evtLameForMonthHeifers: String? = null

    @SerializedName("evt_ret_plac_lact_1")
    @Expose
    @JvmField
    var evtRetPlacLact1: String? = null

    @SerializedName("evt_ret_plac_lact_1_pcnt")
    @Expose
    @JvmField
    var evtRetPlacLact1Pcnt = ""

    @SerializedName("evt_ret_plac_lact_o1")
    @Expose
    @JvmField
    var evtRetPlacLactO1: String? = null

    @SerializedName("evt_ret_plac_lact_o1_pcnt")
    @Expose
    @JvmField
    var evtRetPlacLactO1Pcnt = ""

    @SerializedName("evt_ret_plac_total")
    @Expose
    @JvmField
    var evtRetPlacTotal: String? = null

    @SerializedName("evt_ret_plac_total_pcnt")
    @Expose
    @JvmField
    var evtRetPlacTotalPcnt = ""

    @SerializedName("evt_pares_lact_1")
    @Expose
    @JvmField
    var evtParesLact1: String? = null

    @SerializedName("evt_pares_lact_1_pcnt")
    @Expose
    @JvmField
    var evtParesLact1Pcnt = ""

    @SerializedName("evt_pares_lact_o1")
    @Expose
    @JvmField
    var evtParesLactO1: String? = null

    @SerializedName("evt_pares_lact_o1_pcnt")
    @Expose
    @JvmField
    var evtParesLactO1Pcnt = ""

    @SerializedName("evt_pares_total")
    @Expose
    @JvmField
    var evtParesTotal: String? = null

    @SerializedName("evt_pares_total_pcnt")
    @Expose
    @JvmField
    var evtParesTotalPcnt = ""

    @SerializedName("evt_ketos_lact_1")
    @Expose
    @JvmField
    var evtKetosLact1: String? = null

    @SerializedName("evt_ketos_lact_1_pcnt")
    @Expose
    @JvmField
    var evtKetosLact1Pcnt = ""

    @SerializedName("evt_ketos_lact_o1")
    @Expose
    @JvmField
    var evtKetosLactO1: String? = null

    @SerializedName("evt_ketos_lact_o1_pcnt")
    @Expose
    @JvmField
    var evtKetosLactO1Pcnt = ""

    @SerializedName("evt_ketos_total")
    @Expose
    @JvmField
    var evtKetosTotal: String? = null

    @SerializedName("evt_ketos_total_pcnt")
    @Expose
    @JvmField
    var evtKetosTotalPcnt = ""

    @SerializedName("evt_metrit")
    @Expose
    @JvmField
    var evtMetrit: String? = null

    @SerializedName("evt_metrit_pcnt")
    @Expose
    @JvmField
    var evtMetritPcnt = ""

    @SerializedName("evt_move_cows")
    @Expose
    @JvmField
    var evtMoveCows: String? = null

    @SerializedName("evt_move_heifers")
    @Expose
    @JvmField
    var evtMoveHeifers: String? = null

    @SerializedName("evt_vacc_cows")
    @Expose
    @JvmField
    var evtVaccCows: String? = null

    @SerializedName("evt_vacc_heifers")
    @Expose
    @JvmField
    var evtVaccHeifers: String? = null

    @SerializedName("evt_footrim_cows")
    @Expose
    @JvmField
    var evtFootrimCows: String? = null

    @SerializedName("evt_footrim_heifers")
    @Expose
    @JvmField
    var evtFootrimHeifers: String? = null

    @SerializedName("evt_sold_cows_lact_1_0_10")
    @Expose
    @JvmField
    var evtSoldCowsLact1010: String? = null

    @SerializedName("evt_sold_cows_lact_1_11_30")
    @Expose
    @JvmField
    var evtSoldCowsLact11130: String? = null

    @SerializedName("evt_sold_cows_lact_1_31_60")
    @Expose
    @JvmField
    var evtSoldCowsLact13160: String? = null

    @SerializedName("evt_sold_cows_lact_1_61_120")
    @Expose
    @JvmField
    var evtSoldCowsLact161120: String? = null

    @SerializedName("evt_sold_cows_lact_1_o120")
    @Expose
    @JvmField
    var evtSoldCowsLact1O120: String? = null

    @SerializedName("evt_sold_cows_lact_1_total")
    @Expose
    @JvmField
    var evtSoldCowsLact1Total: String? = null

    @SerializedName("evt_sold_cows_lact_2_0_10")
    @Expose
    @JvmField
    var evtSoldCowsLact2010: String? = null

    @SerializedName("evt_sold_cows_lact_2_11_30")
    @Expose
    @JvmField
    var evtSoldCowsLact21130: String? = null

    @SerializedName("evt_sold_cows_lact_2_31_60")
    @Expose
    @JvmField
    var evtSoldCowsLact23160: String? = null

    @SerializedName("evt_sold_cows_lact_2_61_120")
    @Expose
    @JvmField
    var evtSoldCowsLact261120: String? = null

    @SerializedName("evt_sold_cows_lact_2_o120")
    @Expose
    @JvmField
    var evtSoldCowsLact2O120: String? = null

    @SerializedName("evt_sold_cows_lact_2_total")
    @Expose
    @JvmField
    var evtSoldCowsLact2Total: String? = null

    @SerializedName("evt_sold_cows_lact_o2_0_10")
    @Expose
    @JvmField
    var evtSoldCowsLactO2010: String? = null

    @SerializedName("evt_sold_cows_lact_o2_11_30")
    @Expose
    @JvmField
    var evtSoldCowsLactO21130: String? = null

    @SerializedName("evt_sold_cows_lact_o2_31_60")
    @Expose
    @JvmField
    var evtSoldCowsLactO23160: String? = null

    @SerializedName("evt_sold_cows_lact_o2_61_120")
    @Expose
    @JvmField
    var evtSoldCowsLactO261120: String? = null

    @SerializedName("evt_sold_cows_lact_o2_o120")
    @Expose
    @JvmField
    var evtSoldCowsLactO2O120: String? = null

    @SerializedName("evt_sold_cows_lact_o2_total")
    @Expose
    @JvmField
    var evtSoldCowsLactO2Total: String? = null

    @SerializedName("evt_sold_cows_total")
    @Expose
    @JvmField
    var evtSoldCowsTotal: String? = null

    @SerializedName("evt_sold_heifers_0_2")
    @Expose
    @JvmField
    var evtSoldHeifers02: String? = null

    @SerializedName("evt_sold_heifers_2_6")
    @Expose
    @JvmField
    var evtSoldHeifers26: String? = null

    @SerializedName("evt_sold_heifers_6_12")
    @Expose
    @JvmField
    var evtSoldHeifers612: String? = null

    @SerializedName("evt_sold_heifers_o12")
    @Expose
    @JvmField
    var evtSoldHeifersO12: String? = null

    @SerializedName("evt_sold_heifers_total")
    @Expose
    @JvmField
    var evtSoldHeifersTotal: String? = null

    @SerializedName("evt_sold_pheifers")
    @Expose
    @JvmField
    var evtSoldPheifers: String? = null

    @SerializedName("evt_sold_bulls")
    @Expose
    @JvmField
    var evtSoldBulls: String? = null

    @SerializedName("evt_dead_cows_lact_1_0_10")
    @Expose
    @JvmField
    var evtDeadCowsLact1010: String? = null

    @SerializedName("evt_dead_cows_lact_1_11_30")
    @Expose
    @JvmField
    var evtDeadCowsLact11130: String? = null

    @SerializedName("evt_dead_cows_lact_1_31_60")
    @Expose
    @JvmField
    var evtDeadCowsLact13160: String? = null

    @SerializedName("evt_dead_cows_lact_1_61_120")
    @Expose
    @JvmField
    var evtDeadCowsLact161120: String? = null

    @SerializedName("evt_dead_cows_lact_1_o120")
    @Expose
    @JvmField
    var evtDeadCowsLact1O120: String? = null

    @SerializedName("evt_dead_cows_lact_1_total")
    @Expose
    @JvmField
    var evtDeadCowsLact1Total: String? = null

    @SerializedName("evt_dead_cows_lact_2_0_10")
    @Expose
    @JvmField
    var evtDeadCowsLact2010: String? = null

    @SerializedName("evt_dead_cows_lact_2_11_30")
    @Expose
    @JvmField
    var evtDeadCowsLact21130: String? = null

    @SerializedName("evt_dead_cows_lact_2_31_60")
    @Expose
    @JvmField
    var evtDeadCowsLact23160: String? = null

    @SerializedName("evt_dead_cows_lact_2_61_120")
    @Expose
    @JvmField
    var evtDeadCowsLact261120: String? = null

    @SerializedName("evt_dead_cows_lact_2_o120")
    @Expose
    @JvmField
    var evtDeadCowsLact2O120: String? = null

    @SerializedName("evt_dead_cows_lact_2_total")
    @Expose
    @JvmField
    var evtDeadCowsLact2Total: String? = null

    @SerializedName("evt_dead_cows_lact_o2_0_10")
    @Expose
    @JvmField
    var evtDeadCowsLactO2010: String? = null

    @SerializedName("evt_dead_cows_lact_o2_11_30")
    @Expose
    @JvmField
    var evtDeadCowsLactO21130: String? = null

    @SerializedName("evt_dead_cows_lact_o2_31_60")
    @Expose
    @JvmField
    var evtDeadCowsLactO23160: String? = null

    @SerializedName("evt_dead_cows_lact_o2_61_120")
    @Expose
    @JvmField
    var evtDeadCowsLactO261120: String? = null

    @SerializedName("evt_dead_cows_lact_o2_o120")
    @Expose
    @JvmField
    var evtDeadCowsLactO2O120: String? = null

    @SerializedName("evt_dead_cows_lact_o2_total")
    @Expose
    @JvmField
    var evtDeadCowsLactO2Total: String? = null

    @SerializedName("evt_dead_cows_total")
    @Expose
    @JvmField
    var evtDeadCowsTotal: String? = null

    @SerializedName("evt_dead_heifers_0_2")
    @Expose
    @JvmField
    var evtDeadHeifers02: String? = null

    @SerializedName("evt_dead_heifers_2_6")
    @Expose
    @JvmField
    var evtDeadHeifers26: String? = null

    @SerializedName("evt_dead_heifers_6_12")
    @Expose
    @JvmField
    var evtDeadHeifers612: String? = null

    @SerializedName("evt_dead_heifers_o12")
    @Expose
    @JvmField
    var evtDeadHeifersO12: String? = null

    @SerializedName("evt_dead_heifers_total")
    @Expose
    @JvmField
    var evtDeadHeifersTotal: String? = null

    @SerializedName("evt_dead_pheifers")
    @Expose
    @JvmField
    var evtDeadPheifers: String? = null

    @SerializedName("evt_dead_bulls")
    @Expose
    @JvmField
    var evtDeadBulls: String? = null

    @SerializedName("brd_heat_det_rate_cow")
    @Expose
    @JvmField
    var brdHeatDetRateCow: String? = null

    @SerializedName("brd_heat_det_rate_heif")
    @Expose
    @JvmField
    var brdHeatDetRateHeif: String? = null

    @SerializedName("brd_conc_rate_cow")
    @Expose
    @JvmField
    var brdConcRateCow: String? = null

    @SerializedName("brd_conc_rate_heif")
    @Expose
    @JvmField
    var brdConcRateHeif: String? = null

    @SerializedName("brd_preg_rate_cow")
    @Expose
    @JvmField
    var brdPregRateCow: String? = null

    @SerializedName("brd_preg_rate_heif")
    @Expose
    @JvmField
    var brdPregRateHeif: String? = null

    @SerializedName("brd_straws_per_preg_cow")
    @Expose
    @JvmField
    var brdStrawsPerPregCow: String? = null

    @SerializedName("brd_straws_per_preg_heif")
    @Expose
    @JvmField
    var brdStrawsPerPregHeif: String? = null

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    @JvmField
    var mlkSumYield: String? = null

    @SerializedName("mlk_milk_per_cow")
    @Expose
    @JvmField
    var mlkMilkPerCow = ""

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    @JvmField
    var mlkMilkPerLactCow = ""

    @SerializedName("feed_kpi")
    @Expose
    @JvmField
    var feedKpi: String? = null

    @SerializedName("feed_cost_1kg_milk_total")
    @Expose
    @JvmField
    var feedCost1kgMilkTotal: String? = null

    @SerializedName("feed_cost_1kg_milk_cows_all")
    @Expose
    @JvmField
    var feedCost1kgMilkCowsAll: String? = null

    @SerializedName("feed_cost_1kg_milk_cows_lact")
    @Expose
    @JvmField
    var feedCost1kgMilkCowsLact: String? = null
}