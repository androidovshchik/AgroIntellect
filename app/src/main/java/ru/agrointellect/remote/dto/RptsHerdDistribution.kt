package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Поголовье: фуражное, дойное, стельное
 */
@Suppress("SpellCheckingInspection")
class RptsHerdDistribution : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", items.map { Row(it.date, it.hrdCowsAll) }),
            Column("Дойных коров всего", items.map { Row(it.date, it.hrdCowsLactAll) }),
            Column("Стельных коров", items.map { Row(it.date, it.hrdCowsPregAll) })
        )

    @SerializedName("rpt_herd_distribution")
    @Expose
    lateinit var items: List<RptHerdDistribution>
}