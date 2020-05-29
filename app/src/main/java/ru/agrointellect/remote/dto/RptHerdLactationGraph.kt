package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptHerdLactationGraph {

    @SerializedName("lactation_days")
    @Expose
    lateinit var lactationDays: String

    @SerializedName("average_lactation_daily_milk")
    @Expose
    lateinit var averageLactationDailyMilk: String

    @SerializedName("lactation_1_daily_milk")
    @Expose
    lateinit var lactation1DailyMilk: String

    @SerializedName("lactation_2_daily_milk")
    @Expose
    lateinit var lactation2DailyMilk: String

    @SerializedName("lactation_over_2_daily_milk")
    @Expose
    lateinit var lactationOver2DailyMilk: String

    @SerializedName("sample_lactation_7000_per_305_milking_days_daily_milk")
    @Expose
    lateinit var sampleLactation7000Per305MilkingDaysDailyMilk: String

    @SerializedName("sample_lactation_7500_per_305_milking_days_daily_milk")
    @Expose
    lateinit var sampleLactation7500Per305MilkingDaysDailyMilk: String
}