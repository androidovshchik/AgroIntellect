package ru.agrointellect.remote.bean

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.remote.api.formatDate

@Suppress("SpellCheckingInspection")
class RptSoldAnimal {

    @SerializedName("date")
    @Expose
    var date = ""
        get() = formatDate(field)

    @SerializedName("evt_sold_cows_total")
    @Expose
    var evtSoldCowsTotal: String? = null

    @SerializedName("evt_sold_pheifers")
    @Expose
    var evtSoldPheifers: String? = null

    @SerializedName("evt_sold_heifers_total")
    @Expose
    var evtSoldHeifersTotal: String? = null

    @SerializedName("evt_sold_bulls")
    @Expose
    var evtSoldBulls: String? = null
}