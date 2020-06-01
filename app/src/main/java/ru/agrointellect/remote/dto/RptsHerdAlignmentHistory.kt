package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * История распределения поголовья по группам
 */
@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentHistory : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Кол-во животных", items.map { Row(it.group, it.countOfAnimalsInGroup) }),
            Column("День доения", items.map { Row(it.group, it.averageDaysInMilk) }),
            Column("Надой", items.map { Row(it.group, it.averageMilk) }),
            Column("Ожидаемый надой", items.map { Row(it.group, it.expectedAverageMilk) })
        )

    private val RptHerdAlignmentHistory.group
        get() = "Группа $groupNumber"

    @SerializedName("rpt_herd_alignment_history")
    @Expose
    lateinit var items: List<RptHerdAlignmentHistory>
}