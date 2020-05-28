@file:Suppress("NOTHING_TO_INLINE")

package ru.agrointellect.extension

import com.afollestad.recyclical.datasource.DataSource

inline fun <T> MutableCollection<T>.setAll(items: Collection<T>) {
    clear()
    addAll(items)
}

inline fun <T : Any> DataSource<T>.setAll(items: Collection<T>) {
    clear()
    addAll(items)
}