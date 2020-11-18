package ru.agrointellect.extension

import com.google.gson.JsonArray
import com.google.gson.JsonElement

fun JsonArray.getOrNull(i: Int): JsonElement? {
    return if (size() > i) get(i) else null
}