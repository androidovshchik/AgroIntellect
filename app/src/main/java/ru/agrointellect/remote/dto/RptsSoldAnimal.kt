package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Продажа
 */
@Suppress("SpellCheckingInspection")
class RptsSoldAnimal : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Продажа коров всего", items.map { Row(it.date, it.evtSoldCowsTotal) }),
            Column("Продажа нетелей", items.map { Row(it.date, it.evtSoldPheifers) }),
            Column("Продажа телок всего", items.map { Row(it.date, it.evtSoldHeifersTotal) }),
            Column("Продажа быков", items.map { Row(it.date, it.evtSoldBulls) })
        )

    @SerializedName("rpt_sold_animals")
    @Expose
    lateinit var items: List<RptSoldAnimal>
}