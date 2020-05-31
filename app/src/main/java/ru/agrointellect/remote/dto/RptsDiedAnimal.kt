package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Падеж
 */
class RptsDiedAnimal : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Падеж коров всего", items.map { Row(it.date, it.evtDeadCowsTotal ?: "0") }),
            Column("Падеж нетелей", items.map { Row(it.date, it.evtDeadPheifers ?: "0") }),
            Column("Падеж телок всего", items.map { Row(it.date, it.evtDeadHeifersTotal ?: "0") }),
            Column("Падеж быков", items.map { Row(it.date, it.evtDeadBulls ?: "0") })
        )

    @SerializedName("rpt_died_animals")
    @Expose
    lateinit var items: List<RptDiedAnimal>
}