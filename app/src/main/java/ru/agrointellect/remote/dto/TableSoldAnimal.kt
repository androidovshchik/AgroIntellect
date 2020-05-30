package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Продажа
 */
class TableSoldAnimal : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Продажа коров всего", items.map { Row(it.date, it.evtSoldCowsTotal ?: "0") }),
            Column("Продажа нетелей", items.map { Row(it.date, it.evtSoldPheifers ?: "0") }),
            Column(
                "Продажа телок всего",
                items.map { Row(it.date, it.evtSoldHeifersTotal ?: "0") }
            ),
            Column("Продажа быков", items.map { Row(it.date, it.evtSoldBulls ?: "0") })
        )

    @SerializedName("rpt_sold_animals")
    @Expose
    lateinit var items: List<RptSoldAnimal>
}