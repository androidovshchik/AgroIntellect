package ru.agrointellect.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONObject
import ru.agrointellect.remote.dto.*
import kotlin.math.min

suspend inline fun <reified T> HttpResponse.readObject(
    gson: Gson,
    depth: Int,
    vararg keys: String
): T {
    var text = readText()
    return try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            (0 until min(depth, keys.size)).forEach {
                json = (json as JSONObject).get(keys[it])
            }
            text = json.toString()
        }
        gson.fromJson(
            text, when (keys.lastOrNull()) {
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
        ) as T
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}

suspend inline fun <reified T> HttpResponse.readArray(gson: Gson, vararg keys: String): List<T> {
    var text = readText()
    return try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            keys.forEach {
                json = (json as JSONObject).get(it)
            }
            text = json.toString()
        }
        gson.fromJson(text, TypeToken.getParameterized(List::class.java, T::class.java).type)
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}