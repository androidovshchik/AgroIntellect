package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D

@Suppress("SpellCheckingInspection")
class RptsBreedEffectivity : Table {

    override val columns: List<Column>
        get() = listOf(
            Column(D["avg_lact_num"], rowsBy("avgLactNum")),
            Column(D["average_days_in_milk"], rowsBy("avgDaysInMilk")),
            Column(D["avg_open_days"], rowsBy("avgOpenDays")),
            Column(D["avg_dry_days"], rowsBy("avgDryDays")),
            Column(D["avg_pregnant_days_cows"], rowsBy("avgPregnantDaysCows")),
            Column(D["avg_pregnant_days_heifers"], rowsBy("avgPregnantDaysHeifers")),
            Column(D["avg_calv_int_days"], rowsBy("avgCalvIntDays")),
            Column(D["avg_insem_int_days_cows"], rowsBy("avgInsemIntDaysCows")),
            Column(D["avg_insem_int_days_heifers"], rowsBy("avgInsemIntDaysHeifers")),
            Column(D["avg_first_insem_dim_cows"], rowsBy("avgFirstInsemDimCows")),
            Column(D["avg_first_insem_age_heifers"], rowsBy("avgFirstInsemAgeHeifers")),
            Column(D["avg_first_calv_age_1_lact"], rowsBy("avgFirstCalvAge1Lact")),
            Column(D["hrd_cows_lact_all_pcnt"], rowsBy("hrdCowsLactAllPcnt")),
            Column(D["hrd_cows_preg_pcnt"], rowsBy("hrdCowsPregPcnt")),
            Column(D["hrd_cows_dry_pcnt"], rowsBy("hrdCowsDryPcnt")),
            Column(D["evt_calv_alive_heifers_all_pcnt"], rowsBy("evtCalvAliveHeifersAllPcnt")),
            Column(
                D["evt_calv_alive_heifers_pheifers_pcnt"],
                rowsBy("evtCalvAliveHeifersPheifersPcnt")
            ),
            Column(D["evt_calv_alive_heifers_cows_pcnt"], rowsBy("evtCalvAliveHeifersCowsPcnt")),
            Column(D["evt_calv_dead_all_pcnt"], rowsBy("evtCalvDeadAllPcnt")),
            Column(D["evt_calv_dead_pheifers_pcnt"], rowsBy("evtCalvDeadPheifersPcnt")),
            Column(D["evt_calv_dead_cows_pcnt"], rowsBy("evtCalvDeadCowsPcnt")),
            Column(D["brd_heat_det_rate_cow"], rowsBy("brdHeatDetRateCow")),
            Column(D["brd_heat_det_rate_heif"], rowsBy("brdHeatDetRateHeif")),
            Column(D["brd_conc_rate_cow"], rowsBy("brdConcRateCow")),
            Column(D["brd_conc_rate_heif"], rowsBy("brdConcRateHeif")),
            Column(D["brd_preg_rate_cow"], rowsBy("brdPregRateCow")),
            Column(D["brd_preg_rate_heif"], rowsBy("brdPregRateHeif")),
            Column(D["brd_straws_per_preg_cow"], rowsBy("brdStrawsPerPregCow")),
            Column(D["brd_straws_per_preg_heif"], rowsBy("brdStrawsPerPregHeif"))
        )

    @SuppressLint("DefaultLocale")
    private fun rowsBy(name: String): List<Row> {
        val method = RptBreedEffectivity::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.date, method.invoke(it)?.toString()) }
    }

    @SerializedName("rpt_breed_effectivity")
    @Expose
    lateinit var items: List<RptBreedEffectivity>
}