package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Farm {

    @Expose
    @SerializedName("farm_id")
    lateinit var id: String

    @Expose
    @SerializedName("farm_name")
    lateinit var name: String

    var checked = false
}