package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsBreedEffectivity : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", items.map { Row(it.date, it.avgLactNum) }),
            Column("День доения", items.map { Row(it.date, it.avgDaysInMilk) }),
            Column("Сервис-период", items.map { Row(it.date, it.avgOpenDays) }),
            Column("Кол-во дней в сухостое", items.map { Row(it.date, it.avgDryDays) }),
            Column("День стельности коров", items.map { Row(it.date, it.avgPregnantDaysCows) }),
            Column(
                "День стельности нетелей",
                items.map { Row(it.date, it.avgPregnantDaysHeifers) }),
            Column("Межотельный интервал", items.map { Row(it.date, it.avgCalvIntDays) }),
            Column(
                "Интервал между осеменениями коров",
                items.map { Row(it.date, it.avgInsemIntDaysCows) }),
            Column(
                "Интервал между осеменениями телок",
                items.map { Row(it.date, it.avgInsemIntDaysHeifers) }),
            Column(
                "День доения 1-го осеменения коров",
                items.map { Row(it.date, it.avgFirstInsemDimCows) }),
            Column(
                "Возраст 1-го осеменения телок",
                items.map { Row(it.date, it.avgFirstInsemAgeHeifers) }),
            Column("Возраст 1-го отела", items.map { Row(it.date, it.avgFirstCalvAge1Lact) }),
            Column("% дойных в стаде", items.map { Row(it.date, it.hrdCowsLactAllPcnt) }),
            Column("% стельных в стаде", items.map { Row(it.date, it.hrdCowsPregPcnt) }),
            Column("% сухостойных в стаде", items.map { Row(it.date, it.hrdCowsDryPcnt) }),
            Column(
                "% рождаемости телок",
                items.map { Row(it.date, it.evtCalvAliveHeifersAllPcnt) }),
            Column(
                "% рождаемости телок от нетелей",
                items.map { Row(it.date, it.evtCalvAliveHeifersPheifersPcnt) }),
            Column(
                "% рождаемости телок от коров",
                items.map { Row(it.date, it.evtCalvAliveHeifersCowsPcnt) }),
            Column("% мертворожденности", items.map { Row(it.date, it.evtCalvDeadAllPcnt) }),
            Column(
                "% мертворожденности от нетелей",
                items.map { Row(it.date, it.evtCalvDeadPheifersPcnt) }),
            Column(
                "% мертворожденности от коров",
                items.map { Row(it.date, it.evtCalvDeadCowsPcnt) }),
            Column(
                "Индекс выявления охоты коров",
                items.map { Row(it.date, it.brdHeatDetRateCow) }),
            Column(
                "Индекс выявления охоты телок",
                items.map { Row(it.date, it.brdHeatDetRateHeif) }),
            Column("Индекс оплодотворяемости коров", items.map { Row(it.date, it.brdConcRateCow) }),
            Column(
                "Индекс оплодотворяемости телок",
                items.map { Row(it.date, it.brdConcRateHeif) }),
            Column("Индекс стельности коров", items.map { Row(it.date, it.brdPregRateCow) }),
            Column("Индекс стельности телок", items.map { Row(it.date, it.brdPregRateHeif) }),
            Column(
                "Доз семени на стельную корову",
                items.map { Row(it.date, it.brdStrawsPerPregCow) }),
            Column(
                "Доз семени на стельную телку",
                items.map { Row(it.date, it.brdStrawsPerPregHeif) })
        )

    @SerializedName("rpt_breed_effectivity")
    @Expose
    lateinit var items: List<RptBreedEffectivity>
}