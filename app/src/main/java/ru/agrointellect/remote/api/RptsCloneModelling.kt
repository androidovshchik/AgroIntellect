@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.dto.CloneDataTable
import ru.agrointellect.remote.dto.ModelParameters

class RptsCloneModelling : Table {

    override val columns: List<Column>
        get() = listOf(
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
            Column(D["evt_calv_total_pheifers"], rowsBy("evtCalvTotalPheifers")),
            Column(D["evt_calv_total_cows"], rowsBy("evtCalvTotalCows")),
            Column(D["evt_calv_alive_heifers"], rowsBy("evtCalvAliveHeifers")),
            Column(D["evt_calv_alive_bulls"], rowsBy("evtCalvAliveBulls")),
            Column(D["evt_out_cows_total"], rowsBy("evtOutCowsTotal")),
            Column(D["evt_out_cows_lact_1_total"], rowsBy("evtOutCowsLact1Total")),
            Column(D["evt_out_cows_lact_1_0_30"], rowsBy("evtOutCowsLact1030")),
            Column(D["evt_out_cows_lact_1_31_60"], rowsBy("evtOutCowsLact13160")),
            Column(D["evt_out_cows_lact_1_61_120"], rowsBy("evtOutCowsLact161120")),
            Column(D["evt_out_cows_lact_1_o120"], rowsBy("evtOutCowsLact1O120")),
            Column(D["evt_out_cows_lact_2_total"], rowsBy("evtOutCowsLact2Total")),
            Column(D["evt_out_cows_lact_2_0_30"], rowsBy("evtOutCowsLact2030")),
            Column(D["evt_out_cows_lact_2_31_60"], rowsBy("evtOutCowsLact23160")),
            Column(D["evt_out_cows_lact_2_61_120"], rowsBy("evtOutCowsLact261120")),
            Column(D["evt_out_cows_lact_2_o120"], rowsBy("evtOutCowsLact2O120")),
            Column(D["evt_out_cows_lact_o2_total"], rowsBy("evtOutCowsLactO2Total")),
            Column(D["evt_out_cows_lact_o2_0_30"], rowsBy("evtOutCowsLactO2030")),
            Column(D["evt_out_cows_lact_o2_31_60"], rowsBy("evtOutCowsLactO23160")),
            Column(D["evt_out_cows_lact_o2_61_120"], rowsBy("evtOutCowsLactO261120")),
            Column(D["evt_out_cows_lact_o2_o120"], rowsBy("evtOutCowsLactO2O120")),
            Column(D["evt_out_heifers_total"], rowsBy("evtOutHeifersTotal")),
            Column(D["evt_out_heifers_0_2"], rowsBy("evtOutHeifers02")),
            Column(D["evt_out_heifers_2_6"], rowsBy("evtOutHeifers26")),
            Column(D["evt_out_heifers_6_12"], rowsBy("evtOutHeifers612")),
            Column(D["evt_out_heifers_o12"], rowsBy("evtOutHeifersO12")),
            Column(D["evt_out_pheifers"], rowsBy("evtOutPheifers")),
            Column(D["evt_out_bulls"], rowsBy("evtOutBulls")),
            Column(D["mlk_milk_sum_yield"], rowsBy("mlkMilkSumYield")),
            Column(D["mlk_milk_per_cow"], rowsBy("mlkMilkPerCow")),
            Column(D["mlk_milk_per_lact_cow"], rowsBy("mlkMilkPerLactCow"))
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
        val list = method.invoke(data) as List<String>
        return (data.yyyyMm.indices step 2).map {
            val value = "${list.getOrNull(it).orEmpty()} | ${list.getOrNull(it + 1).orEmpty()}"
            newRow(data.yyyyMm[it], value)
        }
    }
}