package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Послеотельные заболевания
 */
@Suppress("SpellCheckingInspection")
class RptsFreshDisease : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Отелов всего", items.map { Row(it.date, it.evtCalvTotal ?: "0") }),
            Column(
                "Задержаний последа всего",
                items.map { Row(it.date, it.evtRetPlacTotal ?: "0") }
            ),
            Column("Парезов всего", items.map { Row(it.date, it.evtParesTotal ?: "0") }),
            Column("Кетозов всего", items.map { Row(it.date, it.evtKetosTotal ?: "0") }),
            Column("Метритов", items.map { Row(it.date, it.evtMetrit ?: "0") })
        )

    @SerializedName("rpt_fresh_disease")
    @Expose
    lateinit var items: List<RptFreshDisease>
}