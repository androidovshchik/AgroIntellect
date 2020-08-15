package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptDiedAnimal {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("evt_dead_cows_total")
    @Expose
    var evtDeadCowsTotal: String? = null

    @SerializedName("evt_dead_pheifers")
    @Expose
    var evtDeadPheifers: String? = null

    @SerializedName("evt_dead_heifers_total")
    @Expose
    var evtDeadHeifersTotal: String? = null

    @SerializedName("evt_dead_bulls")
    @Expose
    var evtDeadBulls: String? = null
}