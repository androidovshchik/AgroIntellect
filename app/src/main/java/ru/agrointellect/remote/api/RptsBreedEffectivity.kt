package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsBreedEffectivity : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", rowsBy("avgLactNum")),
            Column("День доения", rowsBy("avgDaysInMilk")),
            Column("Сервис-период", rowsBy("avgOpenDays")),
            Column("Кол-во дней в сухостое", rowsBy("avgDryDays")),
            Column("День стельности коров", rowsBy("avgPregnantDaysCows")),
            Column("День стельности нетелей", rowsBy("avgPregnantDaysHeifers")),
            Column("Межотельный интервал", rowsBy("avgCalvIntDays")),
            Column("Интервал между осеменениями коров", rowsBy("avgInsemIntDaysCows")),
            Column("Интервал между осеменениями телок", rowsBy("avgInsemIntDaysHeifers")),
            Column("День доения 1-го осеменения коров", rowsBy("avgFirstInsemDimCows")),
            Column("Возраст 1-го осеменения телок", rowsBy("avgFirstInsemAgeHeifers")),
            Column("Возраст 1-го отела", rowsBy("avgFirstCalvAge1Lact")),
            Column("% дойных в стаде", rowsBy("hrdCowsLactAllPcnt")),
            Column("% стельных в стаде", rowsBy("hrdCowsPregPcnt")),
            Column("% сухостойных в стаде", rowsBy("hrdCowsDryPcnt")),
            Column("% рождаемости телок", rowsBy("evtCalvAliveHeifersAllPcnt")),
            Column("% рождаемости телок от нетелей", rowsBy("evtCalvAliveHeifersPheifersPcnt")),
            Column("% рождаемости телок от коров", rowsBy("evtCalvAliveHeifersCowsPcnt")),
            Column("% мертворожденности", rowsBy("evtCalvDeadAllPcnt")),
            Column("% мертворожденности от нетелей", rowsBy("evtCalvDeadPheifersPcnt")),
            Column("% мертворожденности от коров", rowsBy("evtCalvDeadCowsPcnt")),
            Column("Индекс выявления охоты коров", rowsBy("brdHeatDetRateCow")),
            Column("Индекс выявления охоты телок", rowsBy("brdHeatDetRateHeif")),
            Column("Индекс оплодотворяемости коров", rowsBy("brdConcRateCow")),
            Column("Индекс оплодотворяемости телок", rowsBy("brdConcRateHeif")),
            Column("Индекс стельности коров", rowsBy("brdPregRateCow")),
            Column("Индекс стельности телок", rowsBy("brdPregRateHeif")),
            Column("Доз семени на стельную корову", rowsBy("brdStrawsPerPregCow")),
            Column("Доз семени на стельную телку", rowsBy("brdStrawsPerPregHeif"))
        )

    @SuppressLint("DefaultLocale")
    private fun rowsBy(name: String): List<Row> {
        val method = RptBreedEffectivity::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.date, method.invoke(it)?.toString()) }
    }

    @SerializedName("rpt_breed_effectivity")
    @Expose
    lateinit var items: List<RptBreedEffectivity>
}