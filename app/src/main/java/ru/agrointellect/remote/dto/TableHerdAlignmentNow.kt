package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.screen.report.Column
import ru.agrointellect.screen.report.Row
import ru.agrointellect.screen.report.Table

/**
 * Распределение поголовья по группам на текущий момент
 */
class TableHerdAlignmentNow : Table {

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