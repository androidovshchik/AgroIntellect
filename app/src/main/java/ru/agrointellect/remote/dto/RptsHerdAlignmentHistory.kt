package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentHistory : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                "Группа ${it.groupNumber}", listOf(
                    Row("Кол-во животных", it.countOfAnimalsInGroup),
                    Row("День доения", it.averageDaysInMilk),
                    Row("Надой", it.averageMilk),
                    Row("Ожидаемый надой", it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_history")
    @Expose
    lateinit var items: List<RptHerdAlignmentHistory>
}