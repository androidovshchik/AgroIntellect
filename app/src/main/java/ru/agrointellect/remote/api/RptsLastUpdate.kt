package ru.agrointellect.remote.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.extension.orDash
import ru.agrointellect.local.D
import ru.agrointellect.remote.dto.RptLastUpdate

@Suppress("SpellCheckingInspection")
class RptsLastUpdate : Table {

    override val columns: List<Column>
        get() = listOf(
            Column(
                "", listOf(
                    newRow(D["last_herd_file_date"], items[0].lastHerdFileDate.orDash()),
                    newRow(D["last_evts_file_date"], items[0].lastEvtsFileDate.orDash()),
                    newRow(D["last_cows_cr_file_date"], items[0].lastCowsCrFileDate.orDash()),
                    newRow(D["last_cows_pr_file_date"], items[0].lastCowsPrFileDate.orDash()),
                    newRow(D["last_heif_cr_file_date"], items[0].lastHeifCrFileDate.orDash()),
                    newRow(D["last_heif_pr_file_date"], items[0].lastHeifPrFileDate.orDash()),
                    newRow(D["last_milk_sum_file_date"], items[0].lastMilkSumFileDate.orDash()),
                    newRow(D["last_feed_kpi_file_date"], items[0].lastFeedKpiFileDate.orDash())
                )
            )
        )

    @SerializedName("rpt_last_updates")
    @Expose
    lateinit var items: List<RptLastUpdate>
}