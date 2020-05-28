package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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