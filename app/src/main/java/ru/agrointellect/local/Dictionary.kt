package ru.agrointellect.local

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader

object D {

    lateinit var map: HashMap<String, String>

    fun initialize(context: Context) {
        val json = context.assets.open("words.json").bufferedReader()
            .use(BufferedReader::readText)
        map = Gson().fromJson(
            json, TypeToken.getParameterized(
                HashMap::class.java,
                String::class.java,
                String::class.java
            ).type
        )
    }

    operator fun get(key: String) = map[key].orEmpty()
}