package ru.agrointellect.remote.dto

import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.LineData
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

interface ChartBase {

    val legends: List<String>
}

interface ChartLine : ChartBase {

    val lineData: LineData
}

interface ChartBar : ChartBase {

    val barData: BarData
}