package ru.agrointellect.remote.api

import android.graphics.Color
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.R

@Suppress("SpellCheckingInspection")
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

    val title: String
        get() {
            val date = formatDateZero(parameterInterval)
            return when (parameterName) {
                "mlk_milk_sum_yield" -> "Валовой надой за $date"
                "mlk_milk_per_cow" -> "Надой 1 ф/к за $date"
                "mlk_milk_per_lact_cow" -> "Надой 1 д/к за $date"
                "hrd_cows_all" -> "Фуражных коров за $date"
                "hrd_cows_lact_all" -> "Дойных коров всего за $date"
                "hrd_pheifers_all" -> "Нетелей всего за $date"
                "avg_days_in_milk" -> "День доения за $date"
                "avg_open_days" -> "Сервис-период за $date"
                "hrd_cows_preg_pcnt" -> "% стельных в стаде за $date"
                "brd_preg_rate_cow" -> "Индекс стельности коров за $date"
                "brd_preg_rate_heif" -> "Индекс стельности телок за $date"
                "evt_calv_total" -> "Отелов всего за $date"
                "evt_calv_alive_heifers_all_pcnt" -> "% рождаемости телок за $date"
                "evt_calv_dead_all_pcnt" -> "% мертворожденности за $date"
                "evt_ret_plac_total_pcnt" -> "% задержаний последа за $date"
                "evt_mast_for_month_cows" -> "Мастит голов за месяц коров за $date"
                "evt_lame_for_month_cows" -> "Хромота голов за месяц коров за $date"
                "evt_out_cows_total" -> "Выбытие коров всего за $date"
                "evt_out_pheifers" -> "Выбытие нетелей за $date"
                else -> date
            }
        }

    val signColor: Int
        get() = when {
            compare1DiffSign.contains("+") -> Color.parseColor("#2ED1AA")
            compare1DiffSign.contains("-") -> Color.parseColor("#FD5D5D")
            else -> Color.parseColor("#506482")
        }

    val signIcon: Int
        get() = when {
            compare1DiffSign.contains("+") -> R.drawable.ic_arrow_green
            compare1DiffSign.contains("-") -> R.drawable.ic_arrow_red
            else -> R.drawable.ic_minus
        }

    val valueUp: String
        get() = "${formatDateZero(compare1Interval)}: $compare1Value ($compare1Diff : $compare1DiffPcnt%)"
            .replace("-", "")

    val valueDown: String
        get() = "${formatDateZero(compare2Interval)}: $compare2Value ($compare2Diff : $compare2DiffPcnt%)"
            .replace("-", "")
}