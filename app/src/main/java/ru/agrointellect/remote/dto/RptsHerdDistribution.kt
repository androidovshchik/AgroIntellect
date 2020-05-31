package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Поголовье: фуражное, дойное, стельное
 */
class RptsHerdDistribution : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", items.map { Row(it.date, it.hrdCowsAll ?: "0") }),
            Column("Дойных коров всего", items.map { Row(it.date, it.hrdCowsLactAll ?: "0") }),
            Column("Стельных коров", items.map { Row(it.date, it.hrdCowsPregAll ?: "0") })
        )

    @SerializedName("rpt_herd_distribution")
    @Expose
    lateinit var items: List<RptHerdDistribution>
}