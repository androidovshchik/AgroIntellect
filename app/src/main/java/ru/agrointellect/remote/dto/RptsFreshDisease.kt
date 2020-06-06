package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsFreshDisease : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Отелов всего", items.map { Row(it.date, it.evtCalvTotal) }),
            Column("Задержаний последа всего", items.map { Row(it.date, it.evtRetPlacTotal) }),
            Column("Парезов всего", items.map { Row(it.date, it.evtParesTotal) }),
            Column("Кетозов всего", items.map { Row(it.date, it.evtKetosTotal) }),
            Column("Метритов", items.map { Row(it.date, it.evtMetrit) })
        )

    @SerializedName("rpt_fresh_disease")
    @Expose
    lateinit var items: List<RptFreshDisease>
}