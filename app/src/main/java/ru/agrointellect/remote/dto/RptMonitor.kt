package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class RptMonitor {

    @SerializedName("parameter_name")
    @Expose
    lateinit var parameterName: String

    @SerializedName("parameter_interval")
    @Expose
    lateinit var parameterInterval: String

    @SerializedName("parameter_value")
    @Expose
    lateinit var parameterValue: String

    @SerializedName("parameter_report")
    @Expose
    lateinit var parameterReport: String

    @SerializedName("parameter_compare_1_interval")
    @Expose
    lateinit var parameterCompare1Interval: String

    @SerializedName("parameter_compare_1_value")
    @Expose
    lateinit var parameterCompare1Value: String

    @SerializedName("parameter_compare_1_diff")
    @Expose
    lateinit var parameterCompare1Diff: String

    @SerializedName("parameter_compare_1_diff_pcnt")
    @Expose
    lateinit var parameterCompare1DiffPcnt: String

    @SerializedName("parameter_compare_1_diff_sign")
    @Expose
    lateinit var parameterCompare1DiffSign: String

    @SerializedName("parameter_compare_2_interval")
    @Expose
    lateinit var parameterCompare2Interval: String

    @SerializedName("parameter_compare_2_value")
    @Expose
    lateinit var parameterCompare2Value: String

    @SerializedName("parameter_compare_2_diff")
    @Expose
    lateinit var parameterCompare2Diff: String

    @SerializedName("parameter_compare_2_diff_pcnt")
    @Expose
    lateinit var parameterCompare2DiffPcnt: String

    @SerializedName("parameter_compare_2_diff_sign")
    @Expose
    lateinit var parameterCompare2DiffSign: String
}