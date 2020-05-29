package ru.agrointellect.extension

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

fun <T> typeOfList(): Type {
    return object : TypeToken<List<T>>() {}.type
}