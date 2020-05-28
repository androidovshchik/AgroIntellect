package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Farms : Serializable {

    @SerializedName("farms")
    @Expose
    lateinit var farms: Array<Farm>
}