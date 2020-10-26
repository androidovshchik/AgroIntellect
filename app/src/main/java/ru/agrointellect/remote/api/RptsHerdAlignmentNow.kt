package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D
import ru.agrointellect.remote.dto.RptHerdAlignmentNow

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentNow : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                "${it.groupNumber}. ${it.groupDescription}", listOf(
                    newRow(D["count_of_animals_in_group"], it.countOfAnimalsInGroup),
                    newRow(D["average_milk_today"], it.averageMilkToday),
                    newRow(D["average_milk_yesterday"], it.averageMilkYesterday),
                    newRow(D["average_days_in_milk"], it.averageDaysInMilk),
                    newRow(D["expected_average_milk"], it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_now")
    @Expose
    lateinit var items: List<RptHerdAlignmentNow>
}