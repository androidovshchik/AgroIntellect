package ru.agrointellect.extension

val Any?.asFloat: Float
    get() = this?.toString()?.toFloatOrNull() ?: 0f