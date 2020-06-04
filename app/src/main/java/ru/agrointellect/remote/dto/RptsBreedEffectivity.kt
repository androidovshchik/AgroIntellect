package ru.agrointellect.remote.dto

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsBreedEffectivity : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", mapByMethod("avgLactNum")),
            Column("День доения", mapByMethod("avgDaysInMilk")),
            Column("Сервис-период", mapByMethod("avgOpenDays")),
            Column("Кол-во дней в сухостое", mapByMethod("avgDryDays")),
            Column("День стельности коров", mapByMethod("avgPregnantDaysCows")),
            Column("День стельности нетелей", mapByMethod("avgPregnantDaysHeifers")),
            Column("Межотельный интервал", mapByMethod("avgCalvIntDays")),
            Column("Интервал между осеменениями коров", mapByMethod("avgInsemIntDaysCows")),
            Column("Интервал между осеменениями телок", mapByMethod("avgInsemIntDaysHeifers")),
            Column("День доения 1-го осеменения коров", mapByMethod("avgFirstInsemDimCows")),
            Column("Возраст 1-го осеменения телок", mapByMethod("avgFirstInsemAgeHeifers")),
            Column("Возраст 1-го отела", mapByMethod("avgFirstCalvAge1Lact")),
            Column("% дойных в стаде", mapByMethod("hrdCowsLactAllPcnt")),
            Column("% стельных в стаде", mapByMethod("hrdCowsPregPcnt")),
            Column("% сухостойных в стаде", mapByMethod("hrdCowsDryPcnt")),
            Column("% рождаемости телок", mapByMethod("evtCalvAliveHeifersAllPcnt")),
            Column(
                "% рождаемости телок от нетелей",
                mapByMethod("evtCalvAliveHeifersPheifersPcnt")
            ),
            Column("% рождаемости телок от коров", mapByMethod("evtCalvAliveHeifersCowsPcnt")),
            Column("% мертворожденности", mapByMethod("evtCalvDeadAllPcnt")),
            Column("% мертворожденности от нетелей", mapByMethod("evtCalvDeadPheifersPcnt")),
            Column("% мертворожденности от коров", mapByMethod("evtCalvDeadCowsPcnt")),
            Column("Индекс выявления охоты коров", mapByMethod("brdHeatDetRateCow")),
            Column("Индекс выявления охоты телок", mapByMethod("brdHeatDetRateHeif")),
            Column("Индекс оплодотворяемости коров", mapByMethod("brdConcRateCow")),
            Column("Индекс оплодотворяемости телок", mapByMethod("brdConcRateHeif")),
            Column("Индекс стельности коров", mapByMethod("brdPregRateCow")),
            Column("Индекс стельности телок", mapByMethod("brdPregRateHeif")),
            Column("Доз семени на стельную корову", mapByMethod("brdStrawsPerPregCow")),
            Column("Доз семени на стельную телку", mapByMethod("brdStrawsPerPregHeif"))
        )

    @SuppressLint("DefaultLocale")
    private fun mapByMethod(name: String): List<Row> {
        val method = RptBreedEffectivity::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.date, method.invoke(it)?.toString()) }
    }

    @SerializedName("rpt_breed_effectivity")
    @Expose
    lateinit var items: List<RptBreedEffectivity>
}