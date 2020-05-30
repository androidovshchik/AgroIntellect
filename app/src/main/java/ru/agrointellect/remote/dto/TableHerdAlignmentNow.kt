package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TableHerdAlignmentNow : Table {

    override val datesCount = 0

    override val columns: List<Column>
        get() = items.map {
            Column(
                "${it.groupNumber}. ${it.groupDescription}", listOf(
                    Row("К-во животных", it.countOfAnimalsInGroup),
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