@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.statement.*
import org.json.JSONObject
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.exception.UnknownException
import ru.agrointellect.exception.WrongUidException
import ru.agrointellect.remote.api.*

val objectList = listOf(
    "rpt_periodical_farm_summary_history",
    "rpt_all_farms_summary_history",
    "rpt_clone_modelling",
    "rpt_out_cows_main_reasons",
    "rpt_out_heif_main_reasons"
)

suspend inline fun <reified T> HttpResponse.readObject(
    gson: Gson,
    uid: String,
    vararg keys: String
): T {
    // go deeper when data is object (not list)
    val reportId = if (uid in objectList) uid else null
    return readJson(*keys, reportId) {
        val cls = when (uid) {
            "rpt_herd_distribution" -> RptsHerdDistribution::class.java
            "rpt_herd_alignment_now" -> RptsHerdAlignmentNow::class.java
            "rpt_herd_alignment_history" -> RptsHerdAlignmentHistory::class.java
            "rpt_herd_lactation_graph" -> RptsHerdLactationGraph::class.java
            "rpt_milk_events_kpi" -> RptsMilkEventsKpi::class.java
            "rpt_breed_effectivity" -> RptsBreedEffectivity::class.java
            "rpt_fresh_disease" -> RptsFreshDisease::class.java
            "rpt_farm_summary_history" -> RptsFarmSummaryHistory::class.java
            "cht_farm_summary_history2" -> ChtsFarmSummaryHistory2::class.java
            "cht_farm_summary_history3" -> ChtsFarmSummaryHistory3::class.java
            "cht_farm_summary_history4" -> ChtsFarmSummaryHistory4::class.java
            "cht_farm_summary_history5" -> ChtsFarmSummaryHistory5::class.java
            "cht_farm_summary_history6" -> ChtsFarmSummaryHistory6::class.java
            "rpt_periodical_farm_summary_history" -> RptsPeriodicalFarmSummaryHistory::class.java
            "rpt_all_farms_summary_history" -> RptsAllFarmsSummaryHistory::class.java
            "rpt_herd_forecast" -> RptsHerdForecast::class.java
            "rpt_clone_modelling" -> RptsCloneModelling::class.java
            "rpt_out_cows_main_reasons", "rpt_out_heif_main_reasons" -> RptsOutMainReasons::class.java
            "rpt_sold_animals" -> RptsSoldAnimal::class.java
            "rpt_died_animals" -> RptsDiedAnimal::class.java
            "rpt_last_updates" -> RptsLastUpdate::class.java
            else -> T::class.java
        }
        gson.fromJson(it, cls) as T
    }
}

suspend inline fun <reified T> HttpResponse.readArray(gson: Gson, vararg keys: String): List<T> {
    return readJson(*keys) {
        gson.fromJson(it, TypeToken.getParameterized(List::class.java, T::class.java).type)
    }
}

suspend inline fun <T> HttpResponse.readJson(vararg keys: String?, block: (String) -> T): T {
    var text = readText()
    try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            keys.forEach {
                if (it != null) {
                    json = (json as JSONObject).get(it)
                }
            }
            text = json.toString()
        }
        return block(text)
    } catch (e: Throwable) {
        throw when {
            text.contains("wrong_uid") -> WrongUidException(e)
            text.contains("no_data") -> NoDataException(e)
            else -> UnknownException(text, e)
        }
    }
}