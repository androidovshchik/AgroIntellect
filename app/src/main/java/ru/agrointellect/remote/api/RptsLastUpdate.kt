package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.orDash
import ru.agrointellect.local.D

@Suppress("SpellCheckingInspection")
class RptsLastUpdate : Table {

    override val columns: List<Column>
        get() = listOf(
            Column(
                "", listOf(
                    Row(D["last_herd_file_date"], items[0].lastHerdFileDate.orDash()),
                    Row(D["last_evts_file_date"], items[0].lastEvtsFileDate.orDash()),
                    Row(D["last_cows_cr_file_date"], items[0].lastCowsCrFileDate.orDash()),
                    Row(D["last_cows_pr_file_date"], items[0].lastCowsPrFileDate.orDash()),
                    Row(D["last_heif_cr_file_date"], items[0].lastHeifCrFileDate.orDash()),
                    Row(D["last_heif_pr_file_date"], items[0].lastHeifPrFileDate.orDash()),
                    Row(D["last_milk_sum_file_date"], items[0].lastMilkSumFileDate.orDash()),
                    Row(D["last_feed_kpi_file_date"], items[0].lastFeedKpiFileDate.orDash())
                )
            )
        )

    @SerializedName("rpt_last_updates")
    @Expose
    lateinit var items: List<RptLastUpdate>
}