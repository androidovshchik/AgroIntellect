package ru.agrointellect.remote.dto

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsBreedEffectivity : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", rowsByMethod("avgLactNum")),
            Column("День доения", rowsByMethod("avgDaysInMilk")),
            Column("Сервис-период", rowsByMethod("avgOpenDays")),
            Column("Кол-во дней в сухостое", rowsByMethod("avgDryDays")),
            Column("День стельности коров", rowsByMethod("avgPregnantDaysCows")),
            Column("День стельности нетелей", rowsByMethod("avgPregnantDaysHeifers")),
            Column("Межотельный интервал", rowsByMethod("avgCalvIntDays")),
            Column("Интервал между осеменениями коров", rowsByMethod("avgInsemIntDaysCows")),
            Column("Интервал между осеменениями телок", rowsByMethod("avgInsemIntDaysHeifers")),
            Column("День доения 1-го осеменения коров", rowsByMethod("avgFirstInsemDimCows")),
            Column("Возраст 1-го осеменения телок", rowsByMethod("avgFirstInsemAgeHeifers")),
            Column("Возраст 1-го отела", rowsByMethod("avgFirstCalvAge1Lact")),
            Column("% дойных в стаде", rowsByMethod("hrdCowsLactAllPcnt")),
            Column("% стельных в стаде", rowsByMethod("hrdCowsPregPcnt")),
            Column("% сухостойных в стаде", rowsByMethod("hrdCowsDryPcnt")),
            Column("% рождаемости телок", rowsByMethod("evtCalvAliveHeifersAllPcnt")),
            Column(
                "% рождаемости телок от нетелей",
                rowsByMethod("evtCalvAliveHeifersPheifersPcnt")
            ),
            Column("% рождаемости телок от коров", rowsByMethod("evtCalvAliveHeifersCowsPcnt")),
            Column("% мертворожденности", rowsByMethod("evtCalvDeadAllPcnt")),
            Column("% мертворожденности от нетелей", rowsByMethod("evtCalvDeadPheifersPcnt")),
            Column("% мертворожденности от коров", rowsByMethod("evtCalvDeadCowsPcnt")),
            Column("Индекс выявления охоты коров", rowsByMethod("brdHeatDetRateCow")),
            Column("Индекс выявления охоты телок", rowsByMethod("brdHeatDetRateHeif")),
            Column("Индекс оплодотворяемости коров", rowsByMethod("brdConcRateCow")),
            Column("Индекс оплодотворяемости телок", rowsByMethod("brdConcRateHeif")),
            Column("Индекс стельности коров", rowsByMethod("brdPregRateCow")),
            Column("Индекс стельности телок", rowsByMethod("brdPregRateHeif")),
            Column("Доз семени на стельную корову", rowsByMethod("brdStrawsPerPregCow")),
            Column("Доз семени на стельную телку", rowsByMethod("brdStrawsPerPregHeif"))
        )

    @SuppressLint("DefaultLocale")
    private fun rowsByMethod(name: String): List<Row> {
        val method = RptBreedEffectivity::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.date, method.invoke(it)?.toString()) }
    }

    @SerializedName("rpt_breed_effectivity")
    @Expose
    lateinit var items: List<RptBreedEffectivity>
}