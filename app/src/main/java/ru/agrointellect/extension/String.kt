@file:Suppress("NOTHING_TO_INLINE")

package ru.agrointellect.extension

inline fun String?.orDash() = this ?: "-"

inline fun String?.orZero() = this ?: "0"