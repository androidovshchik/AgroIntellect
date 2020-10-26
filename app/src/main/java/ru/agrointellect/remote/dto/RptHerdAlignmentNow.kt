package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptHerdAlignmentNow {

    @SerializedName("group_number")
    @Expose
    lateinit var groupNumber: String

    @SerializedName("group_description")
    @Expose
    lateinit var groupDescription: String

    @SerializedName("count_of_animals_in_group")
    @Expose
    lateinit var countOfAnimalsInGroup: String

    @SerializedName("average_milk_today")
    @Expose
    lateinit var averageMilkToday: String

    @SerializedName("average_milk_yesterday")
    @Expose
    lateinit var averageMilkYesterday: String

    @SerializedName("average_days_in_milk")
    @Expose
    lateinit var averageDaysInMilk: String

    @SerializedName("expected_average_milk")
    @Expose
    lateinit var expectedAverageMilk: String
}