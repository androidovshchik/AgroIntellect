package ru.agrointellect.extension

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.interfaces.datasets.IDataSet

inline fun <T : Entry, R> IDataSet<T>.map(transform: (T) -> R): List<R> {
    return mapTo(ArrayList(entryCount), transform)
}

inline fun <T : Entry, R, C : MutableCollection<in R>> IDataSet<T>.mapTo(
    destination: C,
    transform: (T) -> R
): C {
    (0 until entryCount).forEach {
        destination.add(transform(getEntryForIndex(it)))
    }
    return destination
}