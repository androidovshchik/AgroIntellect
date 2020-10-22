package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.bean.RptHerdAlignmentHistory

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentHistory : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                D["group_number", it.groupNumber], listOf(
                    Row(D["count_of_animals_in_group"], it.countOfAnimalsInGroup),
                    Row(D["average_days_in_milk"], it.averageDaysInMilk),
                    Row(D["average_milk"], it.averageMilk),
                    Row(D["expected_average_milk"], it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_history")
    @Expose
    lateinit var items: List<RptHerdAlignmentHistory>
}