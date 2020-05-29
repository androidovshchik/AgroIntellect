package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptFreshDisease {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("evt_calv_total")
    @Expose
    var evtCalvTotal: String? = null

    @SerializedName("evt_ret_plac_total")
    @Expose
    var evtRetPlacTotal: String? = null

    @SerializedName("evt_pares_total")
    @Expose
    var evtParesTotal: String? = null

    @SerializedName("evt_ketos_total")
    @Expose
    var evtKetosTotal: String? = null

    @SerializedName("evt_metrit")
    @Expose
    var evtMetrit: String? = null
}