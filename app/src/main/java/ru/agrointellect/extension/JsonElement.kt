package ru.agrointellect.extension

import com.google.gson.JsonElement
import com.google.gson.JsonNull

val JsonElement.asNullableString: String?
    get() = if (this is JsonNull) null else asString