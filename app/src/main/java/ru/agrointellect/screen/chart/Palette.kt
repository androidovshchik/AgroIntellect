package ru.agrointellect.screen.chart

import android.graphics.Color

val highlightColor = Color.parseColor("#2EC0D1")

private val palette = listOf(
    Color.rgb(46, 192, 209),
    Color.rgb(255, 47, 84),
    Color.rgb(220, 224, 230),
    Color.rgb(65, 162, 252),
    Color.rgb(153, 223, 64),
    Color.rgb(255, 123, 1),
    Color.rgb(249, 57, 161),
    Color.rgb(188, 170, 164)
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