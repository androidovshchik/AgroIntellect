@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.reflect.KProperty0

class RptCloneModelling : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров всего", rowsByProperty(data::hrdCowsAll)),
            Column("% дойных в стаде", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 1 лактации", rowsByProperty(data::hrdCowsAll)),
            Column("% 1 лактации в дойных", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 1 лактации 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 1 лактации 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 1 лактации 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 1 лактации &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 2 лактации", rowsByProperty(data::hrdCowsAll)),
            Column("% 2 лактации в дойных", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 2 лактации 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 2 лактации 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 2 лактации 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров 2 лактации &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров лактации &gt; 2", rowsByProperty(data::hrdCowsAll)),
            Column("% лактации &gt; 2 в дойных", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров лактации &gt; 2 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров лактации &gt; 2 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров лактации &gt; 2 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров лактации &gt; 2 &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Стельных коров", rowsByProperty(data::hrdCowsAll)),
            Column("% стельных в стаде", rowsByProperty(data::hrdCowsAll)),
            Column("Сухостойных коров всего", rowsByProperty(data::hrdCowsAll)),
            Column("% сухостойных в стаде", rowsByProperty(data::hrdCowsAll)),
            Column("Сухостойных коров 1 фазы", rowsByProperty(data::hrdCowsAll)),
            Column("Сухостойных коров 2 фазы", rowsByProperty(data::hrdCowsAll)),
            Column("Телок всего", rowsByProperty(data::hrdCowsAll)),
            Column("Телок 0-2 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Телок 2-6 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Телок 6-12 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Телок &gt; 12 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Нетелей всего", rowsByProperty(data::hrdCowsAll)),
            Column("Нетелей 2 фазы", rowsByProperty(data::hrdCowsAll)),
            Column("Быков", rowsByProperty(data::hrdCowsAll)),
            Column("Осеменений коров", rowsByProperty(data::hrdCowsAll)),
            Column("Осеменений телок", rowsByProperty(data::hrdCowsAll)),
            Column("Выявлено стельных коров", rowsByProperty(data::hrdCowsAll)),
            Column("Выявлено стельных телок", rowsByProperty(data::hrdCowsAll)),
            Column("Запущено коров", rowsByProperty(data::hrdCowsAll)),
            Column("Отелов всего", rowsByProperty(data::hrdCowsAll)),
            Column("Отелов от нетелей", rowsByProperty(data::hrdCowsAll)),
            Column("Отелов от коров", rowsByProperty(data::hrdCowsAll)),
            Column("Родилось живых телок", rowsByProperty(data::hrdCowsAll)),
            Column("Родилось живых быков", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров всего", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 1 всего", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 1 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 1 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 1 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 1 &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 2 всего", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 2 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 2 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 2 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация 2 &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация &gt; 2 всего", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация &gt; 2 0-30 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация &gt; 2 31-60 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация &gt; 2 61-120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие коров лактация &gt; 2 &gt; 120 ДД", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие телок всего", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие телок 0-2 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие телок 2-6 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие телок 6-12 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие телок &gt; 12 мес", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие нетелей", rowsByProperty(data::hrdCowsAll)),
            Column("Выбытие быков", rowsByProperty(data::hrdCowsAll)),
            Column("Валовой надой", rowsByProperty(data::hrdCowsAll)),
            Column("Надой 1 ф/к", rowsByProperty(data::hrdCowsAll)),
            Column("Надой 1 д/к", rowsByProperty(data::hrdCowsAll))
        )

    @SerializedName("model_parameters")
    @Expose
    lateinit var modelParameters: ModelParameters

    @SerializedName("data_table")
    @Expose
    lateinit var data: DataTable

    @SuppressLint("DefaultLocale")
    private fun rowsByProperty(property: KProperty0<List<String>>): List<Row> {
        val list = property.get()
        return with(data) {
            (0..yyyyMm.size step 2).map {
                Row(yyyyMm[it], list.getOrNull(it).orEmpty())
            }
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

class DataTable {

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