package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.bean.RptFarmSummaryHistory

/**
 * График: Валовой надой + KPI
 */
@Suppress("SpellCheckingInspection")
open class RptsFarmSummaryHistory : Table, Graph {

    override val legends: List<String>
        get() = listOf(D["mlk_milk_sum_yield"], D["feed_kpi"])

    override val columns: List<Column>
        get() = listOf(
            Column(D["avg_lact_num"], rowsBy("avgLactNum")),
            Column(D["average_days_in_milk"], rowsBy("avgDaysInMilk")),
            Column(D["avg_days_in_milk_1_lact"], rowsBy("avgDaysInMilk1Lact")),
            Column(D["avg_days_in_milk_2_lact"], rowsBy("avgDaysInMilk2Lact")),
            Column(D["avg_days_in_milk_over_2_lact"], rowsBy("avgDaysInMilkOver2Lact")),
            Column(D["avg_open_days"], rowsBy("avgOpenDays")),
            Column(D["avg_open_days_1_lact"], rowsBy("avgOpenDays1Lact")),
            Column(D["avg_open_days_2_lact"], rowsBy("avgOpenDays2Lact")),
            Column(D["avg_open_days_over_2_lact"], rowsBy("avgOpenDaysOver2Lact")),
            Column(D["avg_dry_days"], rowsBy("avgDryDays")),
            Column(D["avg_pregnant_days_cows"], rowsBy("avgPregnantDaysCows")),
            Column(D["avg_pregnant_days_heifers"], rowsBy("avgPregnantDaysHeifers")),
            Column(D["avg_calv_int_days"], rowsBy("avgCalvIntDays")),
            Column(D["avg_insem_int_days_cows"], rowsBy("avgInsemIntDaysCows")),
            Column(D["avg_insem_int_days_heifers"], rowsBy("avgInsemIntDaysHeifers")),
            Column(D["avg_in_hosp_days"], rowsBy("avgInHospDays")),
            Column(D["avg_first_insem_dim_cows"], rowsBy("avgFirstInsemDimCows")),
            Column(D["avg_first_insem_age_heifers"], rowsBy("avgFirstInsemAgeHeifers")),
            Column(D["avg_first_calv_age_1_lact"], rowsBy("avgFirstCalvAge1Lact")),
            Column(D["avg_milk_peak_days"], rowsBy("avgMilkPeakDays")),
            Column(D["avg_milk_peak_days_1_lact"], rowsBy("avgMilkPeakDays1Lact")),
            Column(D["avg_milk_peak_days_2_lact"], rowsBy("avgMilkPeakDays2Lact")),
            Column(D["avg_milk_peak_days_over_2_lact"], rowsBy("avgMilkPeakDaysOver2Lact")),
            Column(D["hrd_cows_all"], rowsBy("hrdCowsAll")),
            Column(D["hrd_cows_lact_all"], rowsBy("hrdCowsLactAll")),
            Column(D["hrd_cows_lact_all_pcnt"], rowsBy("hrdCowsLactAllPcnt")),
            Column(D["hrd_cows_lact_1_all"], rowsBy("hrdCowsLact1All")),
            Column(D["hrd_cows_lact_1_pcnt"], rowsBy("hrdCowsLact1Pcnt")),
            Column(D["hrd_cows_lact_1_0_30"], rowsBy("hrdCowsLact1030")),
            Column(D["hrd_cows_lact_1_31_60"], rowsBy("hrdCowsLact13160")),
            Column(D["hrd_cows_lact_1_61_120"], rowsBy("hrdCowsLact161120")),
            Column(D["hrd_cows_lact_1_o120"], rowsBy("hrdCowsLact1O120")),
            Column(D["hrd_cows_lact_2_all"], rowsBy("hrdCowsLact2All")),
            Column(D["hrd_cows_lact_2_pcnt"], rowsBy("hrdCowsLact2Pcnt")),
            Column(D["hrd_cows_lact_2_0_30"], rowsBy("hrdCowsLact2030")),
            Column(D["hrd_cows_lact_2_31_60"], rowsBy("hrdCowsLact23160")),
            Column(D["hrd_cows_lact_2_61_120"], rowsBy("hrdCowsLact261120")),
            Column(D["hrd_cows_lact_2_o120"], rowsBy("hrdCowsLact2O120")),
            Column(D["hrd_cows_lact_o2_all"], rowsBy("hrdCowsLactO2All")),
            Column(D["hrd_cows_lact_o2_pcnt"], rowsBy("hrdCowsLactO2Pcnt")),
            Column(D["hrd_cows_lact_o2_0_30"], rowsBy("hrdCowsLactO2030")),
            Column(D["hrd_cows_lact_o2_31_60"], rowsBy("hrdCowsLactO23160")),
            Column(D["hrd_cows_lact_o2_61_120"], rowsBy("hrdCowsLactO261120")),
            Column(D["hrd_cows_lact_o2_o120"], rowsBy("hrdCowsLactO2O120")),
            Column(D["hrd_cows_preg_all"], rowsBy("hrdCowsPregAll")),
            Column(D["hrd_cows_preg_pcnt"], rowsBy("hrdCowsPregPcnt")),
            Column(D["hrd_cows_dry_all"], rowsBy("hrdCowsDryAll")),
            Column(D["hrd_cows_dry_pcnt"], rowsBy("hrdCowsDryPcnt")),
            Column(D["hrd_cows_dry_f1"], rowsBy("hrdCowsDryF1")),
            Column(D["hrd_cows_dry_f2"], rowsBy("hrdCowsDryF2")),
            Column(D["hrd_heifers_all"], rowsBy("hrdHeifersAll")),
            Column(D["hrd_heifers_0_2"], rowsBy("hrdHeifers02")),
            Column(D["hrd_heifers_2_6"], rowsBy("hrdHeifers26")),
            Column(D["hrd_heifers_6_12"], rowsBy("hrdHeifers612")),
            Column(D["hrd_heifers_o12"], rowsBy("hrdHeifersO12")),
            Column(D["hrd_pheifers_all"], rowsBy("hrdPheifersAll")),
            Column(D["hrd_pheifers_f2"], rowsBy("hrdPheifersF2")),
            Column(D["hrd_bulls"], rowsBy("hrdBulls")),
            Column(D["evt_insem_cows"], rowsBy("evtInsemCows")),
            Column(D["evt_insem_heifers"], rowsBy("evtInsemHeifers")),
            Column(D["evt_got_preg_cows"], rowsBy("evtGotPregCows")),
            Column(D["evt_got_preg_heifers"], rowsBy("evtGotPregHeifers")),
            Column(D["evt_dry_cows"], rowsBy("evtDryCows")),
            Column(D["evt_calv_total"], rowsBy("evtCalvTotal")),
            Column(D["evt_calv_alive_heifers"], rowsBy("evtCalvAliveHeifers")),
            Column(D["evt_calv_alive_bulls"], rowsBy("evtCalvAliveBulls")),
            Column(D["evt_calv_dead_heifers"], rowsBy("evtCalvDeadHeifers")),
            Column(D["evt_calv_dead_bulls"], rowsBy("evtCalvDeadBulls")),
            Column(D["evt_calv_dead_all_pcnt"], rowsBy("evtCalvDeadAllPcnt")),
            Column(D["evt_calv_alive_heifers_all_pcnt"], rowsBy("evtCalvAliveHeifersAllPcnt")),
            Column(D["evt_calv_total_pheifers"], rowsBy("evtCalvTotalPheifers")),
            Column(D["evt_calv_alive_heifers_pheifers"], rowsBy("evtCalvAliveHeifersPheifers")),
            Column(D["evt_calv_alive_bulls_pheifers"], rowsBy("evtCalvAliveBullsPheifers")),
            Column(D["evt_calv_dead_heifers_pheifers"], rowsBy("evtCalvDeadHeifersPheifers")),
            Column(D["evt_calv_dead_bulls_pheifers"], rowsBy("evtCalvDeadBullsPheifers")),
            Column(D["evt_calv_dead_pheifers_pcnt"], rowsBy("evtCalvDeadPheifersPcnt")),
            Column(
                D["evt_calv_alive_heifers_pheifers_pcnt"],
                rowsBy("evtCalvAliveHeifersPheifersPcnt")
            ),
            Column(D["evt_calv_total_cows"], rowsBy("evtCalvTotalCows")),
            Column(D["evt_calv_alive_heifers_cows"], rowsBy("evtCalvAliveHeifersCows")),
            Column(D["evt_calv_alive_bulls_cows"], rowsBy("evtCalvAliveBullsCows")),
            Column(D["evt_calv_dead_heifers_cows"], rowsBy("evtCalvDeadHeifersCows")),
            Column(D["evt_calv_dead_bulls_cows"], rowsBy("evtCalvDeadBullsCows")),
            Column(D["evt_calv_dead_cows_pcnt"], rowsBy("evtCalvDeadCowsPcnt")),
            Column(D["evt_calv_alive_heifers_cows_pcnt"], rowsBy("evtCalvAliveHeifersCowsPcnt")),
            Column(D["evt_abort_cows"], rowsBy("evtAbortCows")),
            Column(D["evt_abort_heifers"], rowsBy("evtAbortHeifers")),
            Column(D["evt_mast_for_month_cows"], rowsBy("evtMastForMonthCows")),
            Column(D["evt_lame_for_month_cows"], rowsBy("evtLameForMonthCows")),
            Column(D["evt_lame_for_month_heifers"], rowsBy("evtLameForMonthHeifers")),
            Column(D["evt_ret_plac_lact_1"], rowsBy("evtRetPlacLact1")),
            Column(D["evt_ret_plac_lact_1_pcnt"], rowsBy("evtRetPlacLact1Pcnt")),
            Column(D["evt_ret_plac_lact_o1"], rowsBy("evtRetPlacLactO1")),
            Column(D["evt_ret_plac_lact_o1_pcnt"], rowsBy("evtRetPlacLactO1Pcnt")),
            Column(D["evt_ret_plac_total"], rowsBy("evtRetPlacTotal")),
            Column(D["evt_ret_plac_total_pcnt"], rowsBy("evtRetPlacTotalPcnt")),
            Column(D["evt_pares_lact_1"], rowsBy("evtParesLact1")),
            Column(D["evt_pares_lact_1_pcnt"], rowsBy("evtParesLact1Pcnt")),
            Column(D["evt_pares_lact_o1"], rowsBy("evtParesLactO1")),
            Column(D["evt_pares_lact_o1_pcnt"], rowsBy("evtParesLactO1Pcnt")),
            Column(D["evt_pares_total"], rowsBy("evtParesTotal")),
            Column(D["evt_pares_total_pcnt"], rowsBy("evtParesTotalPcnt")),
            Column(D["evt_ketos_lact_1"], rowsBy("evtKetosLact1")),
            Column(D["evt_ketos_lact_1_pcnt"], rowsBy("evtKetosLact1Pcnt")),
            Column(D["evt_ketos_lact_o1"], rowsBy("evtKetosLactO1")),
            Column(D["evt_ketos_lact_o1_pcnt"], rowsBy("evtKetosLactO1Pcnt")),
            Column(D["evt_ketos_total"], rowsBy("evtKetosTotal")),
            Column(D["evt_ketos_total_pcnt"], rowsBy("evtKetosTotalPcnt")),
            Column(D["evt_metrit"], rowsBy("evtMetrit")),
            Column(D["evt_metrit_pcnt"], rowsBy("evtMetritPcnt")),
            Column(D["evt_move_cows"], rowsBy("evtMoveCows")),
            Column(D["evt_move_heifers"], rowsBy("evtMoveHeifers")),
            Column(D["evt_vacc_cows"], rowsBy("evtVaccCows")),
            Column(D["evt_vacc_heifers"], rowsBy("evtVaccHeifers")),
            Column(D["evt_footrim_cows"], rowsBy("evtFootrimCows")),
            Column(D["evt_footrim_heifers"], rowsBy("evtFootrimHeifers")),
            Column(D["evt_sold_cows_lact_1_0_10"], rowsBy("evtSoldCowsLact1010")),
            Column(D["evt_sold_cows_lact_1_11_30"], rowsBy("evtSoldCowsLact11130")),
            Column(D["evt_sold_cows_lact_1_31_60"], rowsBy("evtSoldCowsLact13160")),
            Column(D["evt_sold_cows_lact_1_61_120"], rowsBy("evtSoldCowsLact161120")),
            Column(D["evt_sold_cows_lact_1_o120"], rowsBy("evtSoldCowsLact1O120")),
            Column(D["evt_sold_cows_lact_1_total"], rowsBy("evtSoldCowsLact1Total")),
            Column(D["evt_sold_cows_lact_2_0_10"], rowsBy("evtSoldCowsLact2010")),
            Column(D["evt_sold_cows_lact_2_11_30"], rowsBy("evtSoldCowsLact21130")),
            Column(D["evt_sold_cows_lact_2_31_60"], rowsBy("evtSoldCowsLact23160")),
            Column(D["evt_sold_cows_lact_2_61_120"], rowsBy("evtSoldCowsLact261120")),
            Column(D["evt_sold_cows_lact_2_o120"], rowsBy("evtSoldCowsLact2O120")),
            Column(D["evt_sold_cows_lact_2_total"], rowsBy("evtSoldCowsLact2Total")),
            Column(D["evt_sold_cows_lact_o2_0_10"], rowsBy("evtSoldCowsLactO2010")),
            Column(D["evt_sold_cows_lact_o2_11_30"], rowsBy("evtSoldCowsLactO21130")),
            Column(D["evt_sold_cows_lact_o2_31_60"], rowsBy("evtSoldCowsLactO23160")),
            Column(D["evt_sold_cows_lact_o2_61_120"], rowsBy("evtSoldCowsLactO261120")),
            Column(D["evt_sold_cows_lact_o2_o120"], rowsBy("evtSoldCowsLactO2O120")),
            Column(D["evt_sold_cows_lact_o2_total"], rowsBy("evtSoldCowsLactO2Total")),
            Column(D["evt_sold_cows_total"], rowsBy("evtSoldCowsTotal")),
            Column(D["evt_sold_heifers_0_2"], rowsBy("evtSoldHeifers02")),
            Column(D["evt_sold_heifers_2_6"], rowsBy("evtSoldHeifers26")),
            Column(D["evt_sold_heifers_6_12"], rowsBy("evtSoldHeifers612")),
            Column(D["evt_sold_heifers_o12"], rowsBy("evtSoldHeifersO12")),
            Column(D["evt_sold_heifers_total"], rowsBy("evtSoldHeifersTotal")),
            Column(D["evt_sold_pheifers"], rowsBy("evtSoldPheifers")),
            Column(D["evt_sold_bulls"], rowsBy("evtSoldBulls")),
            Column(D["evt_dead_cows_lact_1_0_10"], rowsBy("evtDeadCowsLact1010")),
            Column(D["evt_dead_cows_lact_1_11_30"], rowsBy("evtDeadCowsLact11130")),
            Column(D["evt_dead_cows_lact_1_31_60"], rowsBy("evtDeadCowsLact13160")),
            Column(D["evt_dead_cows_lact_1_61_120"], rowsBy("evtDeadCowsLact161120")),
            Column(D["evt_dead_cows_lact_1_o120"], rowsBy("evtDeadCowsLact1O120")),
            Column(D["evt_dead_cows_lact_1_total"], rowsBy("evtDeadCowsLact1Total")),
            Column(D["evt_dead_cows_lact_2_0_10"], rowsBy("evtDeadCowsLact2010")),
            Column(D["evt_dead_cows_lact_2_11_30"], rowsBy("evtDeadCowsLact21130")),
            Column(D["evt_dead_cows_lact_2_31_60"], rowsBy("evtDeadCowsLact23160")),
            Column(D["evt_dead_cows_lact_2_61_120"], rowsBy("evtDeadCowsLact261120")),
            Column(D["evt_dead_cows_lact_2_o120"], rowsBy("evtDeadCowsLact2O120")),
            Column(D["evt_dead_cows_lact_2_total"], rowsBy("evtDeadCowsLact2Total")),
            Column(D["evt_dead_cows_lact_o2_0_10"], rowsBy("evtDeadCowsLactO2010")),
            Column(D["evt_dead_cows_lact_o2_11_30"], rowsBy("evtDeadCowsLactO21130")),
            Column(D["evt_dead_cows_lact_o2_31_60"], rowsBy("evtDeadCowsLactO23160")),
            Column(D["evt_dead_cows_lact_o2_61_120"], rowsBy("evtDeadCowsLactO261120")),
            Column(D["evt_dead_cows_lact_o2_o120"], rowsBy("evtDeadCowsLactO2O120")),
            Column(D["evt_dead_cows_lact_o2_total"], rowsBy("evtDeadCowsLactO2Total")),
            Column(D["evt_dead_cows_total"], rowsBy("evtDeadCowsTotal")),
            Column(D["evt_dead_heifers_0_2"], rowsBy("evtDeadHeifers02")),
            Column(D["evt_dead_heifers_2_6"], rowsBy("evtDeadHeifers26")),
            Column(D["evt_dead_heifers_6_12"], rowsBy("evtDeadHeifers612")),
            Column(D["evt_dead_heifers_o12"], rowsBy("evtDeadHeifersO12")),
            Column(D["evt_dead_heifers_total"], rowsBy("evtDeadHeifersTotal")),
            Column(D["evt_dead_pheifers"], rowsBy("evtDeadPheifers")),
            Column(D["evt_dead_bulls"], rowsBy("evtDeadBulls")),
            Column(D["brd_heat_det_rate_cow"], rowsBy("brdHeatDetRateCow")),
            Column(D["brd_heat_det_rate_heif"], rowsBy("brdHeatDetRateHeif")),
            Column(D["brd_conc_rate_cow"], rowsBy("brdConcRateCow")),
            Column(D["brd_conc_rate_heif"], rowsBy("brdConcRateHeif")),
            Column(D["brd_preg_rate_cow"], rowsBy("brdPregRateCow")),
            Column(D["brd_preg_rate_heif"], rowsBy("brdPregRateHeif")),
            Column(D["brd_straws_per_preg_cow"], rowsBy("brdStrawsPerPregCow")),
            Column(D["brd_straws_per_preg_heif"], rowsBy("brdStrawsPerPregHeif")),
            Column(D["mlk_milk_sum_yield"], rowsBy("mlkSumYield")),
            Column(D["mlk_milk_per_cow"], rowsBy("mlkMilkPerCow")),
            Column(D["mlk_milk_per_lact_cow"], rowsBy("mlkMilkPerLactCow")),
            Column(D["feed_kpi"], rowsBy("feedKpi")),
            Column(D["feed_cost_1kg_milk_total"], rowsBy("feedCost1kgMilkTotal")),
            Column(D["feed_cost_1kg_milk_cows_all"], rowsBy("feedCost1kgMilkCowsAll")),
            Column(D["feed_cost_1kg_milk_cows_lact"], rowsBy("feedCost1kgMilkCowsLact"))
        )

    override val data: GraphData
        get() = LineData(
            mutableListOf<ILineDataSet>(
                LineDataSet(items.mapNotNull { newEntry(it.date, it.mlkSumYield) }, null),
                LineDataSet(items.mapNotNull { newEntry(it.date, it.feedKpi) }, null)
            )
        )

    private fun rowsBy(name: String): List<Row> {
        val field = RptFarmSummaryHistory::class.java.getField(name)
        return items.map { newRow(it.date, field.get(it)?.toString()) }
    }

    @SerializedName("rpt_farm_summary_history")
    @Expose
    lateinit var items: List<RptFarmSummaryHistory>
}