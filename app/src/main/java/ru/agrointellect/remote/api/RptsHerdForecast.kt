package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Suppress("SpellCheckingInspection")
class RptsHerdForecast : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", rowsBy("hrdCowsAll")),
            Column("Дойных коров всего", rowsBy("hrdCowsLactAll")),
            Column("% дойных в стаде", rowsBy("hrdCowsLactAllPcnt")),
            Column("Дойных коров 1 лактации", rowsBy("hrdCowsLact1All")),
            Column("% 1 лактации в дойных", rowsBy("hrdCowsLact1Pcnt")),
            Column("Дойных коров 1 лактации 0-30 ДД", rowsBy("hrdCowsLact1030")),
            Column("Дойных коров 1 лактации 31-60 ДД", rowsBy("hrdCowsLact13160")),
            Column("Дойных коров 1 лактации 61-120 ДД", rowsBy("hrdCowsLact161120")),
            Column("Дойных коров 1 лактации > 120 ДД", rowsBy("hrdCowsLact1O120")),
            Column("Дойных коров 2 лактации", rowsBy("hrdCowsLact2All")),
            Column("% 2 лактации в дойных", rowsBy("hrdCowsLact2Pcnt")),
            Column("Дойных коров 2 лактации 0-30 ДД", rowsBy("hrdCowsLact2030")),
            Column("Дойных коров 2 лактации 31-60 ДД", rowsBy("hrdCowsLact23160")),
            Column("Дойных коров 2 лактации 61-120 ДД", rowsBy("hrdCowsLact261120")),
            Column("Дойных коров 2 лактации > 120 ДД", rowsBy("hrdCowsLact2O120")),
            Column("Дойных коров лактации > 2", rowsBy("hrdCowsLactO2All")),
            Column("% лактации > 2 в дойных", rowsBy("hrdCowsLactO2Pcnt")),
            Column("Дойных коров лактации > 2 0-30 ДД", rowsBy("hrdCowsLactO2030")),
            Column("Дойных коров лактации > 2 31-60 ДД", rowsBy("hrdCowsLactO23160")),
            Column("Дойных коров лактации > 2 61-120 ДД", rowsBy("hrdCowsLactO261120")),
            Column("Дойных коров лактации > 2 > 120 ДД", rowsBy("hrdCowsLactO2O120")),
            Column("Стельных коров", rowsBy("hrdCowsPregAll")),
            Column("% стельных в стаде", rowsBy("hrdCowsPregPcnt")),
            Column("Сухостойных коров всего", rowsBy("hrdCowsDryAll")),
            Column("% сухостойных в стаде", rowsBy("hrdCowsDryPcnt")),
            Column("Сухостойных коров 1 фазы", rowsBy("hrdCowsDryF1")),
            Column("Сухостойных коров 2 фазы", rowsBy("hrdCowsDryF2")),
            Column("Телок всего", rowsBy("hrdHeifersAll")),
            Column("Телок 0-2 мес", rowsBy("hrdHeifers02")),
            Column("Телок 2-6 мес", rowsBy("hrdHeifers26")),
            Column("Телок 6-12 мес", rowsBy("hrdHeifers612")),
            Column("Телок > 12 мес", rowsBy("hrdHeifersO12")),
            Column("Нетелей всего", rowsBy("hrdPheifersAll")),
            Column("Нетелей 2 фазы", rowsBy("hrdPheifersF2")),
            Column("Быков", rowsBy("hrdBulls")),
            Column("Осеменений коров", rowsBy("evtInsemCows")),
            Column("Осеменений телок", rowsBy("evtInsemHeifers")),
            Column("Выявлено стельных коров", rowsBy("evtGotPregCows")),
            Column("Выявлено стельных телок", rowsBy("evtGotPregHeifers")),
            Column("Запущено коров", rowsBy("evtDryCows")),
            Column("Отелов всего", rowsBy("evtCalvTotal")),
            Column("Отелов от нетелей", rowsBy("evtCalvTotalPheifers")),
            Column("Отелов от коров", rowsBy("evtCalvTotalCows")),
            Column("Родилось живых телок", rowsBy("evtCalvAliveHeifers")),
            Column("Родилось живых быков", rowsBy("evtCalvAliveBulls")),
            Column("Выбытие коров всего", rowsBy("evtOutCowsTotal")),
            Column("Выбытие коров лактация 1 всего", rowsBy("evtOutCowsLact1Total")),
            Column("Выбытие коров лактация 1 0-30 ДД", rowsBy("evtOutCowsLact1030")),
            Column("Выбытие коров лактация 1 31-60 ДД", rowsBy("evtOutCowsLact13160")),
            Column("Выбытие коров лактация 1 61-120 ДД", rowsBy("evtOutCowsLact161120")),
            Column("Выбытие коров лактация 1 > 120 ДД", rowsBy("evtOutCowsLact1O120")),
            Column("Выбытие коров лактация 2 всего", rowsBy("evtOutCowsLact2Total")),
            Column("Выбытие коров лактация 2 0-30 ДД", rowsBy("evtOutCowsLact2030")),
            Column("Выбытие коров лактация 2 31-60 ДД", rowsBy("evtOutCowsLact23160")),
            Column("Выбытие коров лактация 2 61-120 ДД", rowsBy("evtOutCowsLact261120")),
            Column("Выбытие коров лактация 2 > 120 ДД", rowsBy("evtOutCowsLact2O120")),
            Column("Выбытие коров лактация > 2 всего", rowsBy("evtOutCowsLactO2Total")),
            Column("Выбытие коров лактация > 2 0-30 ДД", rowsBy("evtOutCowsLactO2030")),
            Column("Выбытие коров лактация > 2 31-60 ДД", rowsBy("evtOutCowsLactO23160")),
            Column("Выбытие коров лактация > 2 61-120 ДД", rowsBy("evtOutCowsLactO261120")),
            Column("Выбытие коров лактация > 2 > 120 ДД", rowsBy("evtOutCowsLactO2O120")),
            Column("Выбытие телок всего", rowsBy("evtOutHeifersTotal")),
            Column("Выбытие телок 0-2 мес", rowsBy("evtOutHeifers02")),
            Column("Выбытие телок 2-6 мес", rowsBy("evtOutHeifers26")),
            Column("Выбытие телок 6-12 мес", rowsBy("evtOutHeifers612")),
            Column("Выбытие телок > 12 мес", rowsBy("evtOutHeifersO12")),
            Column("Выбытие нетелей", rowsBy("evtOutPheifers")),
            Column("Выбытие быков", rowsBy("evtOutBulls")),
            Column("Валовой надой", rowsBy("mlkMilkSumYield")),
            Column("Надой 1 ф/к", rowsBy("mlkMilkPerCow")),
            Column("Надой 1 д/к", rowsBy("mlkMilkPerLactCow"))
        )

    @SuppressLint("DefaultLocale")
    private fun rowsBy(name: String): List<Row> {
        val method = RptHerdForecast::class.java.getMethod("get${name.capitalize()}")
        return items.map { Row(it.yyyyMm.substringAfter("."), method.invoke(it)!!.toString()) }
    }

    @SerializedName("rpt_herd_forecast")
    @Expose
    lateinit var items: List<RptHerdForecast>
}