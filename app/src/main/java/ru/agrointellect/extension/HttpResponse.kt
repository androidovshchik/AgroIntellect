package ru.agrointellect.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONObject

suspend inline fun <reified T> HttpResponse.readObject(gson: Gson, vararg keys: String): T {
    var text = readText()
    return try {
        if (keys.isNotEmpty()) {
            var json: Any = JSONObject(text)
            keys.forEach {
                json = (json as JSONObject).get(it)
            }
            text = json.toString()
        }
        gson.fromJson(text, T::class.java)
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
        gson.fromJson(text, object : TypeToken<List<T>>() {}.type)
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}