package ru.agrointellect.remote.dto

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdForecast : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", rowsByMethod("hrdCowsAll")),
            Column("Дойных коров всего", rowsByMethod("hrdCowsLactAll")),
            Column("% дойных в стаде", rowsByMethod("hrdCowsLactAllPcnt")),
            Column("Дойных коров 1 лактации", rowsByMethod("hrdCowsLact1All")),
            Column("% 1 лактации в дойных", rowsByMethod("hrdCowsLact1Pcnt")),
            Column("Дойных коров 1 лактации 0-30 ДД", rowsByMethod("hrdCowsLact1030")),
            Column("Дойных коров 1 лактации 31-60 ДД", rowsByMethod("hrdCowsLact13160")),
            Column("Дойных коров 1 лактации 61-120 ДД", rowsByMethod("hrdCowsLact161120")),
            Column("Дойных коров 1 лактации > 120 ДД", rowsByMethod("hrdCowsLact1O120")),
            Column("Дойных коров 2 лактации", rowsByMethod("hrdCowsLact2All")),
            Column("% 2 лактации в дойных", rowsByMethod("hrdCowsLact2Pcnt")),
            Column("Дойных коров 2 лактации 0-30 ДД", rowsByMethod("hrdCowsLact2030")),
            Column("Дойных коров 2 лактации 31-60 ДД", rowsByMethod("hrdCowsLact23160")),
            Column("Дойных коров 2 лактации 61-120 ДД", rowsByMethod("hrdCowsLact261120")),
            Column("Дойных коров 2 лактации > 120 ДД", rowsByMethod("hrdCowsLact2O120")),
            Column("Дойных коров лактации > 2", rowsByMethod("hrdCowsLactO2All")),
            Column("% лактации > 2 в дойных", rowsByMethod("hrdCowsLactO2Pcnt")),
            Column("Дойных коров лактации > 2 0-30 ДД", rowsByMethod("hrdCowsLactO2030")),
            Column("Дойных коров лактации > 2 31-60 ДД", rowsByMethod("hrdCowsLactO23160")),
            Column("Дойных коров лактации > 2 61-120 ДД", rowsByMethod("hrdCowsLactO261120")),
            Column("Дойных коров лактации > 2 > 120 ДД", rowsByMethod("hrdCowsLactO2O120")),
            Column("Стельных коров", rowsByMethod("hrdCowsPregAll")),
            Column("% стельных в стаде", rowsByMethod("hrdCowsPregPcnt")),
            Column("Сухостойных коров всего", rowsByMethod("hrdCowsDryAll")),
            Column("% сухостойных в стаде", rowsByMethod("hrdCowsDryPcnt")),
            Column("Сухостойных коров 1 фазы", rowsByMethod("hrdCowsDryF1")),
            Column("Сухостойных коров 2 фазы", rowsByMethod("hrdCowsDryF2")),
            Column("Телок всего", rowsByMethod("hrdHeifersAll")),
            Column("Телок 0-2 мес", rowsByMethod("hrdHeifers02")),
            Column("Телок 2-6 мес", rowsByMethod("hrdHeifers26")),
            Column("Телок 6-12 мес", rowsByMethod("hrdHeifers612")),
            Column("Телок > 12 мес", rowsByMethod("hrdHeifersO12")),
            Column("Нетелей всего", rowsByMethod("hrdPheifersAll")),
            Column("Нетелей 2 фазы", rowsByMethod("hrdPheifersF2")),
            Column("Быков", rowsByMethod("hrdBulls")),
            Column("Осеменений коров", rowsByMethod("evtInsemCows")),
            Column("Осеменений телок", rowsByMethod("evtInsemHeifers")),
            Column("Выявлено стельных коров", rowsByMethod("evtGotPregCows")),
            Column("Выявлено стельных телок", rowsByMethod("evtGotPregHeifers")),
            Column("Запущено коров", rowsByMethod("evtDryCows")),
            Column("Отелов всего", rowsByMethod("evtCalvTotal")),
            Column("Отелов от нетелей", rowsByMethod("evtCalvTotalPheifers")),
            Column("Отелов от коров", rowsByMethod("evtCalvTotalCows")),
            Column("Родилось живых телок", rowsByMethod("evtCalvAliveHeifers")),
            Column("Родилось живых быков", rowsByMethod("evtCalvAliveBulls")),
            Column("Выбытие коров всего", rowsByMethod("evtOutCowsTotal")),
            Column("Выбытие коров лактация 1 всего", rowsByMethod("evtOutCowsLact1Total")),
            Column("Выбытие коров лактация 1 0-30 ДД", rowsByMethod("evtOutCowsLact1030")),
            Column("Выбытие коров лактация 1 31-60 ДД", rowsByMethod("evtOutCowsLact13160")),
            Column("Выбытие коров лактация 1 61-120 ДД", rowsByMethod("evtOutCowsLact161120")),
            Column("Выбытие коров лактация 1 > 120 ДД", rowsByMethod("evtOutCowsLact1O120")),
            Column("Выбытие коров лактация 2 всего", rowsByMethod("evtOutCowsLact2Total")),
            Column("Выбытие коров лактация 2 0-30 ДД", rowsByMethod("evtOutCowsLact2030")),
            Column("Выбытие коров лактация 2 31-60 ДД", rowsByMethod("evtOutCowsLact23160")),
            Column("Выбытие коров лактация 2 61-120 ДД", rowsByMethod("evtOutCowsLact261120")),
            Column("Выбытие коров лактация 2 > 120 ДД", rowsByMethod("evtOutCowsLact2O120")),
            Column("Выбытие коров лактация > 2 всего", rowsByMethod("evtOutCowsLactO2Total")),
            Column("Выбытие коров лактация > 2 0-30 ДД", rowsByMethod("evtOutCowsLactO2030")),
            Column("Выбытие коров лактация > 2 31-60 ДД", rowsByMethod("evtOutCowsLactO23160")),
            Column("Выбытие коров лактация > 2 61-120 ДД", rowsByMethod("evtOutCowsLactO261120")),
            Column("Выбытие коров лактация > 2 > 120 ДД", rowsByMethod("evtOutCowsLactO2O120")),
            Column("Выбытие телок всего", rowsByMethod("evtOutHeifersTotal")),
            Column("Выбытие телок 0-2 мес", rowsByMethod("evtOutHeifers02")),
            Column("Выбытие телок 2-6 мес", rowsByMethod("evtOutHeifers26")),
            Column("Выбытие телок 6-12 мес", rowsByMethod("evtOutHeifers612")),
            Column("Выбытие телок > 12 мес", rowsByMethod("evtOutHeifersO12")),
            Column("Выбытие нетелей", rowsByMethod("evtOutPheifers")),
            Column("Выбытие быков", rowsByMethod("evtOutBulls")),
            Column("Валовой надой", rowsByMethod("mlkMilkSumYield")),
            Column("Надой 1 ф/к", rowsByMethod("mlkMilkPerCow")),
            Column("Надой 1 д/к", rowsByMethod("mlkMilkPerLactCow"))
        )

    @SuppressLint("DefaultLocale")
    private fun rowsByMethod(name: String): List<Row> {
        val method = RptHerdForecast::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.yyyyMm.substringAfter("."), method.invoke(it)!!.toString()) }
    }

    @SerializedName("rpt_herd_forecast")
    @Expose
    lateinit var items: List<RptHerdForecast>
}