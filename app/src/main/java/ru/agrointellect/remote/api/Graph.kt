package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData
import com.github.mikephil.charting.data.Entry
import ru.agrointellect.extension.asFloat
import java.text.SimpleDateFormat
import java.util.*

typealias GraphData = BarLineScatterCandleBubbleData<*>

private val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).apply {
    timeZone = TimeZone.getTimeZone("UTC")
}

fun newEntry(date: String, value: String?): Entry? {
    return Entry(parseDate(date) ?: return null, value.asFloat)
}

fun newBarEntry(date: String, value: String?): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, value.asFloat)
}

fun newBarEntry(date: String, array: FloatArray): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, array)
}

/**
 * From YYYY-MM-DD
 * To Unix seconds
 */
private fun parseDate(date: String): Float? {
    return try {
        dateFormatter.parse(date)!!.time / 1000f
    } catch (ignored: Throwable) {
        null
    }
}

interface Graph {

    val legends: Collection<String>

    val data: GraphData
}