package ru.agrointellect.extension

import com.google.gson.Gson
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONArray
import org.json.JSONObject

suspend inline fun <reified T : Any> HttpResponse.readJson(gson: Gson?): T {
    val text = readText()
    return try {
        when (T::class.java) {
            JSONObject::class.java -> JSONObject(text) as T
            JSONArray::class.java -> JSONArray(text) as T
            else -> gson!!.fromJson(text, T::class.java)
        }
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}