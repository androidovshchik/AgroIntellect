package ru.agrointellect.extension

import com.google.gson.Gson
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONObject

suspend inline fun <reified T> HttpResponse.readObject(gson: Gson): T {
    val text = readText()
    return try {
        gson.fromJson(text, T::class.java)
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}

suspend inline fun <reified T> HttpResponse.readArray(gson: Gson, vararg keys: String): List<T> {
    val text = readText()
    return try {
        var jsonObject: Any? = JSONObject(keys[0])
        (1 until keys.size).forEach {
            jsonObject = (jsonObject as? JSONObject)?.get(keys[it])
        }
        gson.fromJson(jsonObject.toString(), typeOfList<T>())
    } catch (ignored: Throwable) {
        throw Throwable("Ошибка: $text")
    }
}