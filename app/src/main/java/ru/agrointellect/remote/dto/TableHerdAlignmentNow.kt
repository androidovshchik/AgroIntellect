package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TableHerdAlignmentNow : Table {

    override val columns: List<Column>
        get() {

        }

    @SerializedName("rpt_herd_alignment_now")
    @Expose
    lateinit var items: List<RptHerdAlignmentNow>
}