package ru.agrointellect.remote.bean

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
class Farm(
    @SerializedName("farm_id")
    @Expose
    var id: String,
    @SerializedName("farm_name")
    @Expose
    var name: String,
    var isSelected: Boolean = false
) : Parcelable