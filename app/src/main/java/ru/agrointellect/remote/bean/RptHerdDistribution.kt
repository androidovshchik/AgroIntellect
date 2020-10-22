package ru.agrointellect.remote.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.api.formatDate

@Suppress("SpellCheckingInspection")
class RptHerdDistribution {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("hrd_cows_all")
    @Expose
    var hrdCowsAll: String? = null

    @SerializedName("hrd_cows_lact_all")
    @Expose
    var hrdCowsLactAll: String? = null

    @SerializedName("hrd_cows_preg_all")
    @Expose
    var hrdCowsPregAll: String? = null
}