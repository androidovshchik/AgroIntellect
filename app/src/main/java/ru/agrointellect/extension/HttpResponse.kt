package ru.agrointellect.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONObject
import ru.agrointellect.remote.dto.*
import timber.log.Timber
import kotlin.math.min

suspend inline fun <reified T> HttpResponse.readObject(
    gson: Gson,
    depth: Int,
    vararg keys: String
): T {
    return readJson(depth, *keys) {
        val cls = when (keys.lastOrNull()) {
            "rpt_herd_distribution" -> RptsHerdDistribution::class.java
            "rpt_herd_alignment_now" -> RptsHerdAlignmentNow::class.java
            "rpt_herd_alignment_history" -> RptsHerdAlignmentHistory::class.java
            "rpt_herd_lactation_graph" -> RptsHerdLactationGraph::class.java
            "rpt_milk_events_kpi" -> RptsMilkEventsKpi::class.java
            "rpt_fresh_disease" -> RptsFreshDisease::class.java
            "rpt_farm_summary_history" -> RptsFarmSummaryHistory::class.java
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
    return readJson(keys.size, *keys) {
        gson.fromJson(it, TypeToken.getParameterized(List::class.java, T::class.java).type)
    }
}

suspend inline fun <T> HttpResponse.readJson(
    depth: Int,
    vararg keys: String,
    block: (String) -> T
): T {
    var text = readText()
    try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            (0 until min(depth, keys.size)).forEach {
                json = (json as JSONObject).get(keys[it])
            }
            text = json.toString()
        }
        return block(text)
    } catch (e: Throwable) {
        Timber.e(e)
        throw Throwable("Ошибка: $text")
    }
}