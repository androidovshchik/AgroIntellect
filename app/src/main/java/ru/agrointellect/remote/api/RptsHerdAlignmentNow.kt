package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentNow : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                "${it.groupNumber}. ${it.groupDescription}", listOf(
                    Row("Кол-во животных", it.countOfAnimalsInGroup),
                    Row("Надой сегодня", it.averageMilkToday),
                    Row("Надой вчера", it.averageMilkYesterday),
                    Row("День доения", it.averageDaysInMilk),
                    Row("Ожидаемый надой", it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_now")
    @Expose
    lateinit var items: List<RptHerdAlignmentNow>
}