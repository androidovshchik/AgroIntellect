package ru.agrointellect.remote.bean

import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Keep
class Farm : Serializable {

    @SerializedName("farm_id")
    @Expose
    lateinit var id: String

    @SerializedName("farm_name")
    @Expose
    lateinit var name: String

    var isSelected = false
}