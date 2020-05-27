package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Farms {

    @Expose
    @SerializedName("farms")
    lateinit var farms: List<Farm>
}