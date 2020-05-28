package ru.agrointellect.extension

import com.google.gson.Gson
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import org.json.JSONArray
import org.json.JSONObject

suspend inline fun <reified T : Any> HttpResponse.readAny(gson: Gson?): Any {
    val text = readText()
    return try {
        when (T::class.java) {
            JSONObject::class.java -> JSONObject(text)
            JSONArray::class.java -> JSONArray(text)
            else -> gson!!.fromJson(text, T::class.java)!!
        }
    } catch (ignored: Throwable) {
        text
    }
}