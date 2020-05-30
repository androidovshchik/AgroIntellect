package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TableFarmSummaryHistory : Table {

    override val datesCount = 2

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", items.map { Row(it.date, it.avgLactNum ?: "0") }),
            Column("День доения", items.map { Row(it.date, it.avgDaysInMilk ?: "0") }),
            Column(
                "День доения 1 лактации",
                items.map { Row(it.date, it.avgDaysInMilk1Lact ?: "0") }),
            Column(
                "День доения 2 лактации",
                items.map { Row(it.date, it.avgDaysInMilk2Lact ?: "0") }),
            Column(
                "День доения лактации > 2",
                items.map { Row(it.date, it.avgDaysInMilkOver2Lact ?: "0") }),
            Column("Сервис-период", items.map { Row(it.date, it.avgOpenDays ?: "0") }),
            Column(
                "Сервис-период 1 лактации",
                items.map { Row(it.date, it.avgOpenDays1Lact ?: "0") }),
            Column(
                "Сервис-период 2 лактации",
                items.map { Row(it.date, it.avgOpenDays2Lact ?: "0") }),
            Column(
                "Сервис-период лактации > 2",
                items.map { Row(it.date, it.avgOpenDaysOver2Lact ?: "0") }),
            Column("Кол-во дней в сухостое", items.map { Row(it.date, it.avgDryDays ?: "0") }),
            Column(
                "День стельности коров",
                items.map { Row(it.date, it.avgPregnantDaysCows ?: "0") })
        )

    @SerializedName("rpt_farm_summary_history")
    @Expose
    lateinit var items: List<RptFarmSummaryHistory>
}