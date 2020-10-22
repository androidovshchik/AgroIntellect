package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.local.D

@Suppress("SpellCheckingInspection")
class RptsHerdAlignmentNow : Table {

    override val columns: List<Column>
        get() = items.map {
            Column(
                "${it.groupNumber}. ${it.groupDescription}", listOf(
                    Row(D["count_of_animals_in_group"], it.countOfAnimalsInGroup),
                    Row(D["average_milk_today"], it.averageMilkToday),
                    Row(D["average_milk_yesterday"], it.averageMilkYesterday),
                    Row(D["average_days_in_milk"], it.averageDaysInMilk),
                    Row(D["expected_average_milk"], it.expectedAverageMilk)
                )
            )
        }

    @SerializedName("rpt_herd_alignment_now")
    @Expose
    lateinit var items: List<RptHerdAlignmentNow>
}