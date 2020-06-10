package ru.agrointellect.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONObject
import ru.agrointellect.exception.NoDataException
import ru.agrointellect.exception.UnknownException
import ru.agrointellect.exception.WrongUidException
import ru.agrointellect.remote.dto.*

@Suppress("SpellCheckingInspection")
suspend inline fun <reified T> HttpResponse.readObject(
    gson: Gson,
    uid: String,
    vararg keys: String
): T {
    return readJson(*keys) {
        val cls = when (uid) {
            "rpt_herd_distribution" -> RptsHerdDistribution::class.java
            "rpt_herd_alignment_now" -> RptsHerdAlignmentNow::class.java
            "rpt_herd_alignment_history" -> RptsHerdAlignmentHistory::class.java
            "rpt_herd_lactation_graph" -> RptsHerdLactationGraph::class.java
            "rpt_milk_events_kpi" -> RptsMilkEventsKpi::class.java
            "rpt_breed_effectivity" -> RptsBreedEffectivity::class.java
            "rpt_fresh_disease" -> RptsFreshDisease::class.java
            "rpt_farm_summary_history" -> RptsFarmSummaryHistory::class.java
            "chrt_farm_summary_history2" -> ChrtsFarmSummaryHistory2::class.java
            "chrt_farm_summary_history3" -> ChrtsFarmSummaryHistory3::class.java
            "chrt_farm_summary_history4" -> ChrtsFarmSummaryHistory4::class.java
            "chrt_farm_summary_history5" -> ChrtsFarmSummaryHistory5::class.java
            "chrt_farm_summary_history6" -> ChrtsFarmSummaryHistory6::class.java
            "rpt_herd_forecast" -> RptsHerdForecast::class.java
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

suspend inline fun <T> HttpResponse.readJson(vararg keys: String, block: (String) -> T): T {
    var text = readText()
    try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            keys.forEach {
                json = (json as JSONObject).get(it)
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