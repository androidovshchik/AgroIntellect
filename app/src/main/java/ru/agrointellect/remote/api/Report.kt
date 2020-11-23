@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.os.Parcelable
import androidx.annotation.Keep
import com.github.mikephil.charting.data.LineDataSet
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Suppress("MemberVisibilityCanBePrivate")
object Period {

    fun hasDay(period: Int) = period and DAY

    fun hasWeek(period: Int) = period and WEEK

    fun hasMonth(period: Int) = period and MONTH

    fun hasYear(period: Int) = period and YEAR

    const val DAY = 0x1000
    const val WEEK = 0x0100
    const val MONTH = 0x0010
    const val YEAR = 0x0001
}

class Report {

    @SerializedName("report_id")
    @Expose
    lateinit var id: String

    /**
     * типы отчетов (report_type):
     *   0 - только таблица
     *   1 - только график
     *   2 - таблица + график
     */
    @SerializedName("report_type")
    @Expose
    lateinit var type: String

    @SerializedName("report_name")
    @Expose
    lateinit var name: String

    /**
     * флаг необходимости передачи диапазона дат для отчета (report_date_need)
     *   0 - диапазон дат не требуется
     *   1 - диапазон дат требуется
     */
    @SerializedName("report_date_need")
    @Expose
    lateinit var dateNeed: String
}

@Keep
@Parcelize
open class RptDesc(
    open val id: String,
    open val name: String,
    open val datesCount: Int,
    open val hasPeriod: Boolean = false,
    open val uid: String = id,
    open var isSelected: Boolean = false
) : Parcelable

@Keep
@Parcelize
class ChtDesc(
    override val id: String,
    override val name: String,
    override val datesCount: Int,
    override val uid: String = id,
    override val hasPeriod: Boolean = false,
    override var isSelected: Boolean = false
) : RptDesc(id, name, datesCount, false, uid) {

    val isLineChart
        get() = uid == "rpt_herd_lactation_graph" || uid == "rpt_milk_events_kpi" || uid == "rpt_farm_summary_history"

    val isStackedBarChart
        get() = uid == "rpt_herd_distribution" || uid == "cht_farm_summary_history2"

    val isGroupedBarChart
        get() = !isLineChart && !isStackedBarChart && !isPieChart

    val isPieChart
        get() = uid == "rpt_out_cows_main_reasons" || uid == "rpt_out_heif_main_reasons"

    val lineMode: LineDataSet.Mode
        get() = when (uid) {
            "rpt_herd_lactation_graph" -> LineDataSet.Mode.CUBIC_BEZIER
            else -> LineDataSet.Mode.HORIZONTAL_BEZIER
        }

    val useDateFormatter: Boolean
        get() = uid != "rpt_herd_lactation_graph" && uid != "rpt_out_cows_main_reasons" && uid != "rpt_out_heif_main_reasons"

    val rightAxisLines: List<Int>
        get() = when (uid) {
            "rpt_farm_summary_history" -> listOf(1)
            "rpt_milk_events_kpi" -> listOf(0)
            else -> emptyList()
        }
}