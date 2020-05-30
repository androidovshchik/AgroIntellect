package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.screen.report.Column
import ru.agrointellect.screen.report.Row
import ru.agrointellect.screen.report.Table

/**
 * Даты актуальности данных
 */
class TableLastUpdate : Table {

    override val columns: List<Column>
        get() = listOf(
            Column(
                "", listOf(
                    Row("Поголовья", items[0].lastHerdFileDate),
                    Row("Событий", items[0].lastEvtsFileDate),
                    Row("Conception Rate коров", items[0].lastCowsCrFileDate),
                    Row("Pregnancy Rate коров", items[0].lastCowsPrFileDate),
                    Row("Conception Rate телок", items[0].lastHeifCrFileDate),
                    Row("Pregnancy Rate телок", items[0].lastHeifPrFileDate),
                    Row("Суммарного надоя", items[0].lastMilkSumFileDate),
                    Row("KPI кормления", items[0].lastFeedKpiFileDate)
                )
            )
        )

    @SerializedName("rpt_last_updates")
    @Expose
    lateinit var items: List<RptLastUpdate>
}