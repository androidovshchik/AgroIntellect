package ru.agrointellect.extension

val Any?.f: Float
    get() = this?.toString()?.toFloatOrNull() ?: 0f