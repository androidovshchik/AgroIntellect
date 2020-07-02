package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.R

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
    lateinit var compare1Interval: String

    @SerializedName("parameter_compare_1_value")
    @Expose
    lateinit var compare1Value: String

    @SerializedName("parameter_compare_1_diff")
    @Expose
    lateinit var compare1Diff: String

    @SerializedName("parameter_compare_1_diff_pcnt")
    @Expose
    lateinit var compare1DiffPcnt: String

    @SerializedName("parameter_compare_1_diff_sign")
    @Expose
    lateinit var compare1DiffSign: String

    @SerializedName("parameter_compare_2_interval")
    @Expose
    lateinit var compare2Interval: String

    @SerializedName("parameter_compare_2_value")
    @Expose
    lateinit var compare2Value: String

    @SerializedName("parameter_compare_2_diff")
    @Expose
    lateinit var compare2Diff: String

    @SerializedName("parameter_compare_2_diff_pcnt")
    @Expose
    lateinit var compare2DiffPcnt: String

    @SerializedName("parameter_compare_2_diff_sign")
    @Expose
    lateinit var compare2DiffSign: String

    val signIcon: Int
        get() {
            val avgRating = getRating(compare1DiffSign) - 3 + getRating(compare2DiffSign) - 3
            return when {
                avgRating > 0 -> R.drawable.ic_arrow_green
                avgRating < 0 -> R.drawable.ic_arrow_red
                else -> R.drawable.ic_minus
            }
        }

    val valueUp: String
        get() = "${formatDate(compare1Interval)}: $compare1Value ($compare1Diff : $compare1DiffPcnt%)"

    val valueDown: String
        get() = "${formatDate(compare2Interval)}: $compare2Value ($compare2Diff : $compare2DiffPcnt%)"

    companion object {

        fun getRating(symbols: String): Int {
            return when (symbols) {
                "--" -> 1
                "-" -> 2
                "+" -> 4
                "++" -> 5
                else -> 3
            }
        }
    }
}