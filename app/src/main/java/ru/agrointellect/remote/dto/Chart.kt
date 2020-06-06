package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import java.text.SimpleDateFormat
import java.util.*

private val chartFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)

/**
 * From YYYY-MM-DD
 * To Unix seconds
 */
fun parseDate(date: String): Float {
    return chartFormatter.parse(date)!!.time / 1000f
}

interface ChartLine {

}

interface ChartBar {

    val data: BarData
}