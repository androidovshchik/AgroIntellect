package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RptHerdAlignmentHistory {

    @SerializedName("date")
    @Expose
    lateinit var date: String

    @SerializedName("group_number")
    @Expose
    lateinit var groupNumber: String

    @SerializedName("count_of_animals_in_group")
    @Expose
    lateinit var countOfAnimalsInGroup: String

    @SerializedName("average_days_in_milk")
    @Expose
    lateinit var averageDaysInMilk: String

    @SerializedName("average_milk")
    @Expose
    lateinit var averageMilk: String

    @SerializedName("expected_average_milk")
    @Expose
    lateinit var expectedAverageMilk: String
}