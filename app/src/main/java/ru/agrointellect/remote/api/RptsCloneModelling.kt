@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptCloneModelling : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", rowsBy("hrdCowsAll")),
            Column("Дойных коров всего", rowsBy("hrdCowsLactAll")),
            Column("% дойных в стаде", rowsBy("hrdCowsLactAllPcnt")),
            Column("Дойных коров 1 лактации", rowsBy("hrdCowsLact1All")),
            Column("% 1 лактации в дойных", rowsBy("hrdCowsLact1Pcnt")),
            Column("Дойных коров 1 лактации 0-30 ДД", rowsBy("hrdCowsLact1030")),
            Column("Дойных коров 1 лактации 31-60 ДД", rowsBy("hrdCowsLact13160")),
            Column("Дойных коров 1 лактации 61-120 ДД", rowsBy("hrdCowsLact161120")),
            Column("Дойных коров 1 лактации > 120 ДД", rowsBy("hrdCowsLact1O120")),
            Column("Дойных коров 2 лактации", rowsBy("hrdCowsLact2All")),
            Column("% 2 лактации в дойных", rowsBy("hrdCowsLact2Pcnt")),
            Column("Дойных коров 2 лактации 0-30 ДД", rowsBy("hrdCowsLact2030")),
            Column("Дойных коров 2 лактации 31-60 ДД", rowsBy("hrdCowsLact23160")),
            Column("Дойных коров 2 лактации 61-120 ДД", rowsBy("hrdCowsLact261120")),
            Column("Дойных коров 2 лактации > 120 ДД", rowsBy("hrdCowsLact2O120")),
            Column("Дойных коров лактации > 2", rowsBy("hrdCowsLactO2All")),
            Column("% лактации > 2 в дойных", rowsBy("hrdCowsLactO2Pcnt")),
            Column("Дойных коров лактации > 2 0-30 ДД", rowsBy("hrdCowsLactO2030")),
            Column("Дойных коров лактации > 2 31-60 ДД", rowsBy("hrdCowsLactO23160")),
            Column("Дойных коров лактации > 2 61-120 ДД", rowsBy("hrdCowsLactO261120")),
            Column("Дойных коров лактации > 2 > 120 ДД", rowsBy("hrdCowsLactO2O120")),
            Column("Стельных коров", rowsBy("hrdCowsPregAll")),
            Column("% стельных в стаде", rowsBy("hrdCowsPregPcnt")),
            Column("Сухостойных коров всего", rowsBy("hrdCowsDryAll")),
            Column("% сухостойных в стаде", rowsBy("hrdCowsDryPcnt")),
            Column("Сухостойных коров 1 фазы", rowsBy("hrdCowsDryF1")),
            Column("Сухостойных коров 2 фазы", rowsBy("hrdCowsDryF2")),
            Column("Телок всего", rowsBy("hrdHeifersAll")),
            Column("Телок 0-2 мес", rowsBy("hrdHeifers02")),
            Column("Телок 2-6 мес", rowsBy("hrdHeifers26")),
            Column("Телок 6-12 мес", rowsBy("hrdHeifers612")),
            Column("Телок > 12 мес", rowsBy("hrdHeifersO12")),
            Column("Нетелей всего", rowsBy("hrdPheifersAll")),
            Column("Нетелей 2 фазы", rowsBy("hrdPheifersF2")),
            Column("Быков", rowsBy("hrdBulls")),
            Column("Осеменений коров", rowsBy("evtInsemCows")),
            Column("Осеменений телок", rowsBy("evtInsemHeifers")),
            Column("Выявлено стельных коров", rowsBy("evtGotPregCows")),
            Column("Выявлено стельных телок", rowsBy("evtGotPregHeifers")),
            Column("Запущено коров", rowsBy("evtDryCows")),
            Column("Отелов всего", rowsBy("evtCalvTotal")),
            Column("Отелов от нетелей", rowsBy("evtCalvTotalPheifers")),
            Column("Отелов от коров", rowsBy("evtCalvTotalCows")),
            Column("Родилось живых телок", rowsBy("evtCalvAliveHeifers")),
            Column("Родилось живых быков", rowsBy("evtCalvAliveBulls")),
            Column("Выбытие коров всего", rowsBy("evtOutCowsTotal")),
            Column("Выбытие коров лактация 1 всего", rowsBy("evtOutCowsLact1Total")),
            Column("Выбытие коров лактация 1 0-30 ДД", rowsBy("evtOutCowsLact1030")),
            Column("Выбытие коров лактация 1 31-60 ДД", rowsBy("evtOutCowsLact13160")),
            Column("Выбытие коров лактация 1 61-120 ДД", rowsBy("evtOutCowsLact161120")),
            Column("Выбытие коров лактация 1 > 120 ДД", rowsBy("evtOutCowsLact1O120")),
            Column("Выбытие коров лактация 2 всего", rowsBy("evtOutCowsLact2Total")),
            Column("Выбытие коров лактация 2 0-30 ДД", rowsBy("evtOutCowsLact2030")),
            Column("Выбытие коров лактация 2 31-60 ДД", rowsBy("evtOutCowsLact23160")),
            Column("Выбытие коров лактация 2 61-120 ДД", rowsBy("evtOutCowsLact261120")),
            Column("Выбытие коров лактация 2 > 120 ДД", rowsBy("evtOutCowsLact2O120")),
            Column("Выбытие коров лактация > 2 всего", rowsBy("evtOutCowsLactO2Total")),
            Column("Выбытие коров лактация > 2 0-30 ДД", rowsBy("evtOutCowsLactO2030")),
            Column("Выбытие коров лактация > 2 31-60 ДД", rowsBy("evtOutCowsLactO23160")),
            Column("Выбытие коров лактация > 2 61-120 ДД", rowsBy("evtOutCowsLactO261120")),
            Column("Выбытие коров лактация > 2 > 120 ДД", rowsBy("evtOutCowsLactO2O120")),
            Column("Выбытие телок всего", rowsBy("evtOutHeifersTotal")),
            Column("Выбытие телок 0-2 мес", rowsBy("evtOutHeifers02")),
            Column("Выбытие телок 2-6 мес", rowsBy("evtOutHeifers26")),
            Column("Выбытие телок 6-12 мес", rowsBy("evtOutHeifers612")),
            Column("Выбытие телок > 12 мес", rowsBy("evtOutHeifersO12")),
            Column("Выбытие нетелей", rowsBy("evtOutPheifers")),
            Column("Выбытие быков", rowsBy("evtOutBulls")),
            Column("Валовой надой", rowsBy("mlkMilkSumYield")),
            Column("Надой 1 ф/к", rowsBy("mlkMilkPerCow")),
            Column("Надой 1 д/к", rowsBy("mlkMilkPerLactCow"))
        )

    @SerializedName("model_parameters")
    @Expose
    lateinit var modelParameters: ModelParameters

    @SerializedName("data_table")
    @Expose
    lateinit var data: CloneDataTable

    @Suppress("UNCHECKED_CAST")
    @SuppressLint("DefaultLocale")
    private fun rowsBy(name: String): List<Row> {
        val method = CloneDataTable::class.java.getMethod("get${name.capitalize()}")
        return (data.yyyyMm.indices step 2).map {
            Row(data.yyyyMm[it], list.getOrNull(it).orEmpty())
        }
    }
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

class CloneDataTable {

    @SerializedName("yyyy_mm")
    @Expose
    lateinit var yyyyMm: List<String>

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

    @SerializedName("evt_got_preg_cows")
    @Expose
    lateinit var evtGotPregCows: List<String>

    @SerializedName("evt_got_preg_heifers")
    @Expose
    lateinit var evtGotPregHeifers: List<String>

    @SerializedName("evt_dry_cows")
    @Expose
    lateinit var evtDryCows: List<String>

    @SerializedName("evt_calv_total")
    @Expose
    lateinit var evtCalvTotal: List<String>

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    lateinit var evtCalvTotalPheifers: List<String>

    @SerializedName("evt_calv_total_cows")
    @Expose
    lateinit var evtCalvTotalCows: List<String>

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    lateinit var evtCalvAliveHeifers: List<String>

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    lateinit var evtCalvAliveBulls: List<String>

    @SerializedName("evt_out_cows_total")
    @Expose
    lateinit var evtOutCowsTotal: List<String>

    @SerializedName("evt_out_cows_lact_1_total")
    @Expose
    lateinit var evtOutCowsLact1Total: List<String>

    @SerializedName("evt_out_cows_lact_1_0_30")
    @Expose
    lateinit var evtOutCowsLact1030: List<String>

    @SerializedName("evt_out_cows_lact_1_31_60")
    @Expose
    lateinit var evtOutCowsLact13160: List<String>

    @SerializedName("evt_out_cows_lact_1_61_120")
    @Expose
    lateinit var evtOutCowsLact161120: List<String>

    @SerializedName("evt_out_cows_lact_1_o120")
    @Expose
    lateinit var evtOutCowsLact1O120: List<String>

    @SerializedName("evt_out_cows_lact_2_total")
    @Expose
    lateinit var evtOutCowsLact2Total: List<String>

    @SerializedName("evt_out_cows_lact_2_0_30")
    @Expose
    lateinit var evtOutCowsLact2030: List<String>

    @SerializedName("evt_out_cows_lact_2_31_60")
    @Expose
    lateinit var evtOutCowsLact23160: List<String>

    @SerializedName("evt_out_cows_lact_2_61_120")
    @Expose
    lateinit var evtOutCowsLact261120: List<String>

    @SerializedName("evt_out_cows_lact_2_o120")
    @Expose
    lateinit var evtOutCowsLact2O120: List<String>

    @SerializedName("evt_out_cows_lact_o2_total")
    @Expose
    lateinit var evtOutCowsLactO2Total: List<String>

    @SerializedName("evt_out_cows_lact_o2_0_30")
    @Expose
    lateinit var evtOutCowsLactO2030: List<String>

    @SerializedName("evt_out_cows_lact_o2_31_60")
    @Expose
    lateinit var evtOutCowsLactO23160: List<String>

    @SerializedName("evt_out_cows_lact_o2_61_120")
    @Expose
    lateinit var evtOutCowsLactO261120: List<String>

    @SerializedName("evt_out_cows_lact_o2_o120")
    @Expose
    lateinit var evtOutCowsLactO2O120: List<String>

    @SerializedName("evt_out_heifers_total")
    @Expose
    lateinit var evtOutHeifersTotal: List<String>

    @SerializedName("evt_out_heifers_0_2")
    @Expose
    lateinit var evtOutHeifers02: List<String>

    @SerializedName("evt_out_heifers_2_6")
    @Expose
    lateinit var evtOutHeifers26: List<String>

    @SerializedName("evt_out_heifers_6_12")
    @Expose
    lateinit var evtOutHeifers612: List<String>

    @SerializedName("evt_out_heifers_o12")
    @Expose
    lateinit var evtOutHeifersO12: List<String>

    @SerializedName("evt_out_pheifers")
    @Expose
    lateinit var evtOutPheifers: List<String>

    @SerializedName("evt_out_bulls")
    @Expose
    lateinit var evtOutBulls: List<String>

    @SerializedName("mlk_milk_sum_yield")
    @Expose
    lateinit var mlkMilkSumYield: List<String>

    @SerializedName("mlk_milk_per_cow")
    @Expose
    lateinit var mlkMilkPerCow: List<String>

    @SerializedName("mlk_milk_per_lact_cow")
    @Expose
    lateinit var mlkMilkPerLactCow: List<String>
}