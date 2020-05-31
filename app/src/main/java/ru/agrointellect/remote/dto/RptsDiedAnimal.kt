package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Падеж
 */
@Suppress("SpellCheckingInspection")
class RptsDiedAnimal : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Падеж коров всего", items.map { Row(it.date, it.evtDeadCowsTotal) }),
            Column("Падеж нетелей", items.map { Row(it.date, it.evtDeadPheifers) }),
            Column("Падеж телок всего", items.map { Row(it.date, it.evtDeadHeifersTotal) }),
            Column("Падеж быков", items.map { Row(it.date, it.evtDeadBulls) })
        )

    @SerializedName("rpt_died_animals")
    @Expose
    lateinit var items: List<RptDiedAnimal>
}