package ru.agrointellect.screen.chart

import android.graphics.Color

val highlightColor = Color.parseColor("#2EC0D1")

private val palette = listOf(
    Color.parseColor("#5899da"),
    Color.parseColor("#e8743b"),
    Color.parseColor("#19a979"),
    Color.parseColor("#ed4a7b"),
    Color.parseColor("#945ecf"),
    Color.parseColor("#13a4b4"),
    Color.parseColor("#525df4"),
    Color.parseColor("#bf399e"),
    Color.parseColor("#6c8893"),
    Color.parseColor("#ee6868"),
    Color.parseColor("#2f6497")
)

fun pickColor(index: Int): Int {
    var i = index
    while (i >= palette.size) {
        i -= palette.size
    }
    return palette[i]
}

fun pickColors(size: Int): List<Int> {
    return (0 until size).map { pickColor(it) }
}