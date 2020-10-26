package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.dto.RptHerdAlignmentHistory

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentHistory : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                D["group_number", it.groupNumber], listOf(
                    newRow(D["count_of_animals_in_group"], it.countOfAnimalsInGroup),
                    newRow(D["average_days_in_milk"], it.averageDaysInMilk),
                    newRow(D["average_milk"], it.averageMilk),
                    newRow(D["expected_average_milk"], it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_history")
    @Expose
    lateinit var items: List<RptHerdAlignmentHistory>
}