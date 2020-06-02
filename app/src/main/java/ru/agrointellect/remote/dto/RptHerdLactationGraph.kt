package ru.agrointellect.remote.dto

import androidx.collection.SimpleArrayMap

@Suppress("SpellCheckingInspection")
class RptHerdLactationGraph {

    lateinit var lactationDays: String

    var averageLactationDailyMilk: String? = null

    var lactation1DailyMilk: String? = null

    var lactation2DailyMilk: String? = null

    var lactationOver2DailyMilk: String? = null

    val sampleLactations = SimpleArrayMap<String, String?>()
}