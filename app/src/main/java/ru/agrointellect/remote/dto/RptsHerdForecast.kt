package ru.agrointellect.remote.dto

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdForecast : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", mapByMethod("hrdCowsAll")),
            Column("Дойных коров всего", mapByMethod("hrdCowsLactAll")),
            Column("% дойных в стаде", mapByMethod("hrdCowsLactAllPcnt")),
            Column("Дойных коров 1 лактации", mapByMethod("hrdCowsLact1All")),
            Column("% 1 лактации в дойных", mapByMethod("hrdCowsLact1Pcnt")),
            Column("Дойных коров 1 лактации 0-30 ДД", mapByMethod("hrdCowsLact1030")),
            Column("Дойных коров 1 лактации 31-60 ДД", mapByMethod("hrdCowsLact13160")),
            Column("Дойных коров 1 лактации 61-120 ДД", mapByMethod("hrdCowsLact161120")),
            Column("Дойных коров 1 лактации > 120 ДД", mapByMethod("hrdCowsLact1O120")),
            Column("Дойных коров 2 лактации", mapByMethod("hrdCowsLact2All")),
            Column("% 2 лактации в дойных", mapByMethod("hrdCowsLact2Pcnt")),
            Column("Дойных коров 2 лактации 0-30 ДД", mapByMethod("hrdCowsLact2030")),
            Column("Дойных коров 2 лактации 31-60 ДД", mapByMethod("hrdCowsLact23160")),
            Column("Дойных коров 2 лактации 61-120 ДД", mapByMethod("hrdCowsLact261120")),
            Column("Дойных коров 2 лактации > 120 ДД", mapByMethod("hrdCowsLact2O120")),
            Column("Дойных коров лактации > 2", mapByMethod("hrdCowsLactO2All")),
            Column("% лактации > 2 в дойных", mapByMethod("hrdCowsLactO2Pcnt")),
            Column("Дойных коров лактации > 2 0-30 ДД", mapByMethod("hrdCowsLactO2030")),
            Column("Дойных коров лактации > 2 31-60 ДД", mapByMethod("hrdCowsLactO23160")),
            Column("Дойных коров лактации > 2 61-120 ДД", mapByMethod("hrdCowsLactO261120")),
            Column("Дойных коров лактации > 2 > 120 ДД", mapByMethod("hrdCowsLactO2O120")),
            Column("Стельных коров", mapByMethod("hrdCowsPregAll")),
            Column("% стельных в стаде", mapByMethod("hrdCowsPregPcnt")),
            Column("Сухостойных коров всего", mapByMethod("hrdCowsDryAll")),
            Column("% сухостойных в стаде", mapByMethod("hrdCowsDryPcnt")),
            Column("Сухостойных коров 1 фазы", mapByMethod("hrdCowsDryF1")),
            Column("Сухостойных коров 2 фазы", mapByMethod("hrdCowsDryF2")),
            Column("Телок всего", mapByMethod("hrdHeifersAll")),
            Column("Телок 0-2 мес", mapByMethod("hrdHeifers02")),
            Column("Телок 2-6 мес", mapByMethod("hrdHeifers26")),
            Column("Телок 6-12 мес", mapByMethod("hrdHeifers612")),
            Column("Телок > 12 мес", mapByMethod("hrdHeifersO12")),
            Column("Нетелей всего", mapByMethod("hrdPheifersAll")),
            Column("Нетелей 2 фазы", mapByMethod("hrdPheifersF2")),
            Column("Быков", mapByMethod("hrdBulls")),
            Column("Осеменений коров", mapByMethod("evtInsemCows")),
            Column("Осеменений телок", mapByMethod("evtInsemHeifers")),
            Column("Выявлено стельных коров", mapByMethod("evtGotPregCows")),
            Column("Выявлено стельных телок", mapByMethod("evtGotPregHeifers")),
            Column("Запущено коров", mapByMethod("evtDryCows")),
            Column("Отелов всего", mapByMethod("evtCalvTotal")),
            Column("Отелов от нетелей", mapByMethod("evtCalvTotalPheifers")),
            Column("Отелов от коров", mapByMethod("evtCalvTotalCows")),
            Column("Родилось живых телок", mapByMethod("evtCalvAliveHeifers")),
            Column("Родилось живых быков", mapByMethod("evtCalvAliveBulls")),
            Column("Выбытие коров всего", mapByMethod("evtOutCowsTotal")),
            Column("Выбытие коров лактация 1 всего", mapByMethod("evtOutCowsLact1Total")),
            Column("Выбытие коров лактация 1 0-30 ДД", mapByMethod("evtOutCowsLact1030")),
            Column("Выбытие коров лактация 1 31-60 ДД", mapByMethod("evtOutCowsLact13160")),
            Column("Выбытие коров лактация 1 61-120 ДД", mapByMethod("evtOutCowsLact161120")),
            Column("Выбытие коров лактация 1 > 120 ДД", mapByMethod("evtOutCowsLact1O120")),
            Column("Выбытие коров лактация 2 всего", mapByMethod("evtOutCowsLact2Total")),
            Column("Выбытие коров лактация 2 0-30 ДД", mapByMethod("evtOutCowsLact2030")),
            Column("Выбытие коров лактация 2 31-60 ДД", mapByMethod("evtOutCowsLact23160")),
            Column("Выбытие коров лактация 2 61-120 ДД", mapByMethod("evtOutCowsLact261120")),
            Column("Выбытие коров лактация 2 > 120 ДД", mapByMethod("evtOutCowsLact2O120")),
            Column("Выбытие коров лактация > 2 всего", mapByMethod("evtOutCowsLactO2Total")),
            Column("Выбытие коров лактация > 2 0-30 ДД", mapByMethod("evtOutCowsLactO2030")),
            Column("Выбытие коров лактация > 2 31-60 ДД", mapByMethod("evtOutCowsLactO23160")),
            Column("Выбытие коров лактация > 2 61-120 ДД", mapByMethod("evtOutCowsLactO261120")),
            Column("Выбытие коров лактация > 2 > 120 ДД", mapByMethod("evtOutCowsLactO2O120")),
            Column("Выбытие телок всего", mapByMethod("evtOutHeifersTotal")),
            Column("Выбытие телок 0-2 мес", mapByMethod("evtOutHeifers02")),
            Column("Выбытие телок 2-6 мес", mapByMethod("evtOutHeifers26")),
            Column("Выбытие телок 6-12 мес", mapByMethod("evtOutHeifers612")),
            Column("Выбытие телок > 12 мес", mapByMethod("evtOutHeifersO12")),
            Column("Выбытие нетелей", mapByMethod("evtOutPheifers")),
            Column("Выбытие быков", mapByMethod("evtOutBulls")),
            Column("Валовой надой", mapByMethod("mlkMilkSumYield")),
            Column("Надой 1 ф/к", mapByMethod("mlkMilkPerCow")),
            Column("Надой 1 д/к", mapByMethod("mlkMilkPerLactCow"))
        )

    @SuppressLint("DefaultLocale")
    private fun mapByMethod(name: String): List<Row> {
        val method = RptHerdForecast::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.yyyyMm.substringAfter("."), method.invoke(it)!!.toString()) }
    }

    @SerializedName("rpt_herd_forecast")
    @Expose
    lateinit var items: List<RptHerdForecast>
}