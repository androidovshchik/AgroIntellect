package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.ChartData
import com.github.mikephil.charting.data.Entry
import ru.agrointellect.extension.asFloat
import java.text.SimpleDateFormat
import java.util.*

private val chartFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)

fun newEntry(date: String, value: String?): Entry? {
    return Entry(parseDate(date) ?: return null, value.asFloat)
}

fun newBarEntry(date: String, value: String?): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, value.asFloat)
}

fun newGroupBarEntry(date: String, array: FloatArray): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, array)
}

/**
 * From YYYY-MM-DD
 * To Unix seconds
 */
private fun parseDate(date: String): Float? {
    return try {
        chartFormatter.parse(date)!!.time / 1000f
    } catch (ignored: Throwable) {
        null
    }
}

interface ChartBase {

    val legends: Collection<String>

    val data: ChartData<*>
}