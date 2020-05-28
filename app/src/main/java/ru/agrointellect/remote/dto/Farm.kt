package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Farm : Serializable {

    @SerializedName("farm_id")
    @Expose
    lateinit var id: String

    @SerializedName("farm_name")
    @Expose
    lateinit var name: String

    var selected = false
}