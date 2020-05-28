package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Report {

    @SerializedName("report_id")
    @Expose
    lateinit var id: String

    @SerializedName("report_type")
    @Expose
    lateinit var type: String

    @SerializedName("report_name")
    @Expose
    lateinit var name: String

    @SerializedName("report_date_need")
    @Expose
    lateinit var dateNeed: String
}