package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptHerdLactationGraph {

    @SerializedName("lactation_days")
    @Expose
    lateinit var lactationDays: String

    @SerializedName("average_lactation_daily_milk")
    @Expose
    var averageLactationDailyMilk: String? = null

    @SerializedName("lactation_1_daily_milk")
    @Expose
    var lactation1DailyMilk: String? = null

    @SerializedName("lactation_2_daily_milk")
    @Expose
    var lactation2DailyMilk: String? = null

    @SerializedName("lactation_over_2_daily_milk")
    @Expose
    var lactationOver2DailyMilk: String? = null

    @SerializedName("sample_lactation_5000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation5000: String? = null

    @SerializedName("sample_lactation_5500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation5500: String? = null

    @SerializedName("sample_lactation_6000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation6000: String? = null

    @SerializedName("sample_lactation_6500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation6500: String? = null

    @SerializedName("sample_lactation_7000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation7000: String? = null

    @SerializedName("sample_lactation_7500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation7500: String? = null

    @SerializedName("sample_lactation_8000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation8000: String? = null

    @SerializedName("sample_lactation_8500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation8500: String? = null

    @SerializedName("sample_lactation_9000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation9000: String? = null

    @SerializedName("sample_lactation_9500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation9500: String? = null

    @SerializedName("sample_lactation_10000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation10000: String? = null

    @SerializedName("sample_lactation_10500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation10500: String? = null

    @SerializedName("sample_lactation_11000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation11000: String? = null

    @SerializedName("sample_lactation_11500_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation11500: String? = null

    @SerializedName("sample_lactation_12000_per_305_milking_days_daily_milk")
    @Expose
    var sampleLactation12000: String? = null
}