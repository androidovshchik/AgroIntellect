package ru.agrointellect.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

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

    val hasChart: Boolean
        get() = type == "1" || type == "2"

    val hasTable: Boolean
        get() = type == "0" || type == "2"

    val isDateNeeded: Boolean
        get() = dateNeed == "1"

    @Keep
    @Suppress("SpellCheckingInspection")
    class Default(val id: String, val name: String, val dates: Int, val uid: String = id) :
        Serializable {

        val singleDate: Boolean
            get() = dates == 1

        val isLine
            get() = uid == "rpt_farm_summary_history" || uid == "rpt_milk_events_kpi" || uid == "rpt_herd_lactation_graph"

        val isBar
            get() = uid == "chrt_farm_summary_history2" || uid == "rpt_herd_distribution"

        val isGroupedBar
            get() = !isLine && !isBar

        var selected = false
    }
}