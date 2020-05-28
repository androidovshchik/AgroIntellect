package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Reports {

    @SerializedName("reports")
    @Expose
    lateinit var reports: List<Report>
}