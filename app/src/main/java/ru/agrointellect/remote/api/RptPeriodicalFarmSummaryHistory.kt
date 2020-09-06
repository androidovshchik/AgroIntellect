@file:Suppress("SpellCheckingInspection")

package ru.agrointellect.remote.api

import android.annotation.SuppressLint
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlin.reflect.KProperty0

class RptPeriodicalFarmSummaryHistory : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("№ лактации стада", rowsByProperty(data::avgLactNum)),
            Column("День доения", rowsByProperty(data::avgDaysInMilk)),
            Column("День доения 1 лактации", rowsByProperty(data::avgDaysInMilk1Lact)),
            Column("День доения 2 лактации", rowsByProperty(data::avgDaysInMilk2Lact)),
            Column("День доения лактации > 2", rowsByProperty(data::avgDaysInMilkOver2Lact)),
            Column("Сервис-период", rowsByProperty(data::avgOpenDays)),
            Column("Сервис-период 1 лактации", rowsByProperty(data::avgOpenDays1Lact)),
            Column("Сервис-период 2 лактации", rowsByProperty(data::avgOpenDays2Lact)),
            Column("Сервис-период лактации > 2", rowsByProperty(data::avgOpenDaysOver2Lact)),
            Column("Кол-во дней в сухостое", rowsByProperty(data::avgDryDays)),
            Column("День стельности коров", rowsByProperty(data::avgPregnantDaysCows)),
            Column("День стельности нетелей", rowsByProperty(data::avgPregnantDaysHeifers)),
            Column("Межотельный интервал", rowsByProperty(data::avgCalvIntDays)),
            Column("Интервал между осеменениями коров", rowsByProperty(data::avgInsemIntDaysCows)),
            Column(
                "Интервал между осеменениями телок",
                rowsByProperty(data::avgInsemIntDaysHeifers)
            ),
            Column("День доения 1-го осеменения коров", rowsByProperty(data::avgFirstInsemDimCows)),
            Column("Возраст 1-го осеменения телок", rowsByProperty(data::avgFirstInsemAgeHeifers)),
            Column("Возраст 1-го отела", rowsByProperty(data::avgFirstCalvAge1Lact)),
            Column("День доения при пике", rowsByProperty(data::avgMilkPeakDays)),
            Column("День доения при пике 1 лактации", rowsByProperty(data::avgMilkPeakDays1Lact)),
            Column("День доения при пике 2 лактации", rowsByProperty(data::avgMilkPeakDays2Lact)),
            Column(
                "День доения при пике лактации > 2",
                rowsByProperty(data::avgMilkPeakDaysOver2Lact)
            ),
            Column("Фуражных коров", rowsByProperty(data::hrdCowsAll)),
            Column("Дойных коров всего", rowsByProperty(data::hrdCowsLactAll)),
            Column("% дойных в стаде", rowsByProperty(data::hrdCowsLactAllPcnt)),
            Column("Дойных коров 1 лактации", rowsByProperty(data::hrdCowsLact1All)),
            Column("% 1 лактации в дойных", rowsByProperty(data::hrdCowsLact1Pcnt)),
            Column("Дойных коров 1 лактации 0-30 ДД", rowsByProperty(data::hrdCowsLact1030)),
            Column("Дойных коров 1 лактации 31-60 ДД", rowsByProperty(data::hrdCowsLact13160)),
            Column("Дойных коров 1 лактации 61-120 ДД", rowsByProperty(data::hrdCowsLact161120)),
            Column("Дойных коров 1 лактации > 120 ДД", rowsByProperty(data::hrdCowsLact1O120)),
            Column("Дойных коров 2 лактации", rowsByProperty(data::hrdCowsLact2All)),
            Column("% 2 лактации в дойных", rowsByProperty(data::hrdCowsLact2Pcnt)),
            Column("Дойных коров 2 лактации 0-30 ДД", rowsByProperty(data::hrdCowsLact2030)),
            Column("Дойных коров 2 лактации 31-60 ДД", rowsByProperty(data::hrdCowsLact23160)),
            Column("Дойных коров 2 лактации 61-120 ДД", rowsByProperty(data::hrdCowsLact261120)),
            Column("Дойных коров 2 лактации > 120 ДД", rowsByProperty(data::hrdCowsLact2O120)),
            Column("Дойных коров лактации > 2", rowsByProperty(data::hrdCowsLactO2All)),
            Column("% лактации > 2 в дойных", rowsByProperty(data::hrdCowsLactO2Pcnt)),
            Column("Дойных коров лактации > 2 0-30 ДД", rowsByProperty(data::hrdCowsLactO2030)),
            Column("Дойных коров лактации > 2 31-60 ДД", rowsByProperty(data::hrdCowsLactO23160)),
            Column("Дойных коров лактации > 2 61-120 ДД", rowsByProperty(data::hrdCowsLactO261120)),
            Column("Дойных коров лактации > 2 > 120 ДД", rowsByProperty(data::hrdCowsLactO2O120)),
            Column("Стельных коров", rowsByProperty(data::hrdCowsPregAll)),
            Column("% стельных в стаде", rowsByProperty(data::hrdCowsPregPcnt)),
            Column("Сухостойных коров всего", rowsByProperty(data::hrdCowsDryAll)),
            Column("% сухостойных в стаде", rowsByProperty(data::hrdCowsDryPcnt)),
            Column("Сухостойных коров 1 фазы", rowsByProperty(data::hrdCowsDryF1)),
            Column("Сухостойных коров 2 фазы", rowsByProperty(data::hrdCowsDryF2)),
            Column("Телок всего", rowsByProperty(data::hrdHeifersAll)),
            Column("Телок 0-2 мес", rowsByProperty(data::hrdHeifers02)),
            Column("Телок 2-6 мес", rowsByProperty(data::hrdHeifers26)),
            Column("Телок 6-12 мес", rowsByProperty(data::hrdHeifers612)),
            Column("Телок > 12 мес", rowsByProperty(data::hrdHeifersO12)),
            Column("Нетелей всего", rowsByProperty(data::hrdPheifersAll)),
            Column("Нетелей 2 фазы", rowsByProperty(data::hrdPheifersF2)),
            Column("Быков", rowsByProperty(data::hrdBulls)),
            Column("Осеменений коров", rowsByProperty(data::evtInsemCows)),
            Column("Осеменений телок", rowsByProperty(data::evtInsemHeifers)),
            Column("Проверено на стельность коров", rowsByProperty(data::evtPregCheckCows)),
            Column("Выявлено стельных коров", rowsByProperty(data::evtGotPregCows)),
            Column("Проверено на стельность телок", rowsByProperty(data::evtPregCheckHeifers)),
            Column("Выявлено стельных телок", rowsByProperty(data::evtGotPregHeifers)),
            Column("Запущено коров", rowsByProperty(data::evtDryCows)),
            Column("Отелов всего", rowsByProperty(data::evtCalvTotal)),
            Column("Родилось живых телок", rowsByProperty(data::evtCalvAliveHeifers)),
            Column("Родилось живых быков", rowsByProperty(data::evtCalvAliveBulls)),
            Column("Родилось мертвых телок", rowsByProperty(data::evtCalvDeadHeifers)),
            Column("Родилось мертвых быков", rowsByProperty(data::evtCalvDeadBulls)),
            Column("% мертворожденности", rowsByProperty(data::evtCalvDeadAllPcnt)),
            Column("% рождаемости телок", rowsByProperty(data::evtCalvAliveHeifersAllPcnt)),
            Column("Отелов от нетелей", rowsByProperty(data::evtCalvTotalPheifers)),
            Column(
                "От нетелей родилось живых телок",
                rowsByProperty(data::evtCalvAliveHeifersPheifers)
            ),
            Column(
                "От нетелей родилось живых быков",
                rowsByProperty(data::evtCalvAliveBullsPheifers)
            ),
            Column(
                "От нетелей родилось мертвых телок",
                rowsByProperty(data::evtCalvDeadHeifersPheifers)
            ),
            Column(
                "От нетелей родилось мертвых быков",
                rowsByProperty(data::evtCalvDeadBullsPheifers)
            ),
            Column("% мертворожденности от нетелей", rowsByProperty(data::evtCalvDeadPheifersPcnt)),
            Column(
                "% рождаемости телок от нетелей",
                rowsByProperty(data::evtCalvAliveHeifersPheifersPcnt)
            ),
            Column("Отелов от коров", rowsByProperty(data::evtCalvTotalCows)),
            Column("От коров родилось живых телок", rowsByProperty(data::evtCalvAliveHeifersCows)),
            Column("От коров родилось живых быков", rowsByProperty(data::evtCalvAliveBullsCows)),
            Column("От коров родилось мертвых телок", rowsByProperty(data::evtCalvDeadHeifersCows)),
            Column("От коров родилось мертвых быков", rowsByProperty(data::evtCalvDeadBullsCows)),
            Column("% мертворожденности от коров", rowsByProperty(data::evtCalvDeadCowsPcnt)),
            Column(
                "% рождаемости телок от коров",
                rowsByProperty(data::evtCalvAliveHeifersCowsPcnt)
            ),
            Column("Абортировало коров", rowsByProperty(data::evtAbortCows)),
            Column("Абортировало нетелей", rowsByProperty(data::evtAbortHeifers)),
            Column("Мастит голов за месяц коров", rowsByProperty(data::evtMastForMonthCows)),
            Column("Хромота голов за месяц коров", rowsByProperty(data::evtLameForMonthCows)),
            Column("Хромота голов за месяц телок", rowsByProperty(data::evtLameForMonthHeifers)),
            Column("Задержаний последа лактация 1", rowsByProperty(data::evtRetPlacLact1)),
            Column("% задержаний последа у нетелей", rowsByProperty(data::evtRetPlacLact1Pcnt)),
            Column("Задержаний последа лактация > 1", rowsByProperty(data::evtRetPlacLactO1)),
            Column("% задержаний последа у коров", rowsByProperty(data::evtRetPlacLactO1Pcnt)),
            Column("Задержаний последа всего", rowsByProperty(data::evtRetPlacTotal)),
            Column("% задержаний последа", rowsByProperty(data::evtRetPlacTotalPcnt)),
            Column("Парезов лактация 1", rowsByProperty(data::evtParesLact1)),
            Column("% парезов у нетелей", rowsByProperty(data::evtParesLact1Pcnt)),
            Column("Парезов лактация > 1", rowsByProperty(data::evtParesLactO1)),
            Column("% парезов у коров", rowsByProperty(data::evtParesLactO1Pcnt)),
            Column("Парезов всего", rowsByProperty(data::evtParesTotal)),
            Column("% парезов", rowsByProperty(data::evtParesTotalPcnt)),
            Column("Кетозов лактация 1", rowsByProperty(data::evtKetosLact1)),
            Column("% кетозов у нетелей", rowsByProperty(data::evtKetosLact1Pcnt)),
            Column("Кетозов лактация > 1", rowsByProperty(data::evtKetosLactO1)),
            Column("% кетозов у коров", rowsByProperty(data::evtKetosLactO1Pcnt)),
            Column("Кетозов всего", rowsByProperty(data::evtKetosTotal)),
            Column("% кетозов", rowsByProperty(data::evtKetosTotalPcnt)),
            Column("Метритов", rowsByProperty(data::evtMetrit)),
            Column("% метритов", rowsByProperty(data::evtMetritPcnt)),
            Column("Переводов коров", rowsByProperty(data::evtMoveCows)),
            Column("Переводов телок", rowsByProperty(data::evtMoveHeifers)),
            Column("Вакцинация коров", rowsByProperty(data::evtVaccCows)),
            Column("Вакцинация телок", rowsByProperty(data::evtVaccHeifers)),
            Column("Расчистка копыт коров", rowsByProperty(data::evtFootrimCows)),
            Column("Расчистка копыт телок", rowsByProperty(data::evtFootrimHeifers)),
            Column("Продажа коров лактация 1 0-10 ДД", rowsByProperty(data::evtSoldCowsLact1010)),
            Column("Продажа коров лактация 1 11-30 ДД", rowsByProperty(data::evtSoldCowsLact11130)),
            Column("Продажа коров лактация 1 31-60 ДД", rowsByProperty(data::evtSoldCowsLact13160)),
            Column(
                "Продажа коров лактация 1 61-120 ДД",
                rowsByProperty(data::evtSoldCowsLact161120)
            ),
            Column("Продажа коров лактация 1 > 120 ДД", rowsByProperty(data::evtSoldCowsLact1O120)),
            Column("Продажа коров лактация 1 всего", rowsByProperty(data::evtSoldCowsLact1Total)),
            Column("Продажа коров лактация 2 0-10 ДД", rowsByProperty(data::evtSoldCowsLact2010)),
            Column("Продажа коров лактация 2 11-30 ДД", rowsByProperty(data::evtSoldCowsLact21130)),
            Column("Продажа коров лактация 2 31-60 ДД", rowsByProperty(data::evtSoldCowsLact23160)),
            Column(
                "Продажа коров лактация 2 61-120 ДД",
                rowsByProperty(data::evtSoldCowsLact261120)
            ),
            Column("Продажа коров лактация 2 > 120 ДД", rowsByProperty(data::evtSoldCowsLact2O120)),
            Column("Продажа коров лактация 2 всего", rowsByProperty(data::evtSoldCowsLact2Total)),
            Column(
                "Продажа коров лактация > 2 0-10 ДД",
                rowsByProperty(data::evtSoldCowsLactO2010)
            ),
            Column(
                "Продажа коров лактация > 2 11-30 ДД",
                rowsByProperty(data::evtSoldCowsLactO21130)
            ),
            Column(
                "Продажа коров лактация > 2 31-60 ДД",
                rowsByProperty(data::evtSoldCowsLactO23160)
            ),
            Column(
                "Продажа коров лактация > 2 61-120 ДД",
                rowsByProperty(data::evtSoldCowsLactO261120)
            ),
            Column(
                "Продажа коров лактация > 2 > 120 ДД",
                rowsByProperty(data::evtSoldCowsLactO2O120)
            ),
            Column(
                "Продажа коров лактация > 2 всего",
                rowsByProperty(data::evtSoldCowsLactO2Total)
            ),
            Column("Продажа коров всего", rowsByProperty(data::evtSoldCowsTotal)),
            Column("Продажа телок 0-2 мес", rowsByProperty(data::evtSoldHeifers02)),
            Column("Продажа телок 2-6 мес", rowsByProperty(data::evtSoldHeifers26)),
            Column("Продажа телок 6-12 мес", rowsByProperty(data::evtSoldHeifers612)),
            Column("Продажа телок > 12 мес", rowsByProperty(data::evtSoldHeifersO12)),
            Column("Продажа телок всего", rowsByProperty(data::evtSoldHeifersTotal)),
            Column("Продажа нетелей", rowsByProperty(data::evtSoldPheifers)),
            Column("Продажа быков", rowsByProperty(data::evtSoldBulls)),
            Column("Падеж коров лактация 1 0-10 ДД", rowsByProperty(data::evtDeadCowsLact1010)),
            Column("Падеж коров лактация 1 11-30 ДД", rowsByProperty(data::evtDeadCowsLact11130)),
            Column("Падеж коров лактация 1 31-60 ДД", rowsByProperty(data::evtDeadCowsLact13160)),
            Column("Падеж коров лактация 1 61-120 ДД", rowsByProperty(data::evtDeadCowsLact161120)),
            Column("Падеж коров лактация 1 > 120 ДД", rowsByProperty(data::evtDeadCowsLact1O120)),
            Column("Падеж коров лактация 1 всего", rowsByProperty(data::evtDeadCowsLact1Total)),
            Column("Падеж коров лактация 2 0-10 ДД", rowsByProperty(data::evtDeadCowsLact2010)),
            Column("Падеж коров лактация 2 11-30 ДД", rowsByProperty(data::evtDeadCowsLact21130)),
            Column("Падеж коров лактация 2 31-60 ДД", rowsByProperty(data::evtDeadCowsLact23160)),
            Column("Падеж коров лактация 2 61-120 ДД", rowsByProperty(data::evtDeadCowsLact261120)),
            Column("Падеж коров лактация 2 > 120 ДД", rowsByProperty(data::evtDeadCowsLact2O120)),
            Column("Падеж коров лактация 2 всего", rowsByProperty(data::evtDeadCowsLact2Total)),
            Column("Падеж коров лактация > 2 0-10 ДД", rowsByProperty(data::evtDeadCowsLactO2010)),
            Column(
                "Падеж коров лактация > 2 11-30 ДД",
                rowsByProperty(data::evtDeadCowsLactO21130)
            ),
            Column(
                "Падеж коров лактация > 2 31-60 ДД",
                rowsByProperty(data::evtDeadCowsLactO23160)
            ),
            Column(
                "Падеж коров лактация > 2 61-120 ДД",
                rowsByProperty(data::evtDeadCowsLactO261120)
            ),
            Column(
                "Падеж коров лактация > 2 > 120 ДД",
                rowsByProperty(data::evtDeadCowsLactO2O120)
            ),
            Column("Падеж коров лактация > 2 всего", rowsByProperty(data::evtDeadCowsLactO2Total)),
            Column("Падеж коров всего", rowsByProperty(data::evtDeadCowsTotal)),
            Column("Падеж телок 0-2 мес", rowsByProperty(data::evtDeadHeifers02)),
            Column("Падеж телок 2-6 мес", rowsByProperty(data::evtDeadHeifers26)),
            Column("Падеж телок 6-12 мес", rowsByProperty(data::evtDeadHeifers612)),
            Column("Падеж телок > 12 мес", rowsByProperty(data::evtDeadHeifersO12)),
            Column("Падеж телок всего", rowsByProperty(data::evtDeadHeifersTotal)),
            Column("Падеж нетелей", rowsByProperty(data::evtDeadPheifers)),
            Column("Падеж быков", rowsByProperty(data::evtDeadBulls)),
            Column("Индекс выявления охоты коров", rowsByProperty(data::brdHeatDetRateCow)),
            Column("Индекс выявления охоты телок", rowsByProperty(data::brdHeatDetRateHeif)),
            Column("Индекс оплодотворяемости коров", rowsByProperty(data::brdConcRateCow)),
            Column("Индекс оплодотворяемости телок", rowsByProperty(data::brdConcRateHeif)),
            Column("Индекс стельности коров", rowsByProperty(data::brdPregRateCow)),
            Column("Индекс стельности телок", rowsByProperty(data::brdPregRateHeif)),
            Column("Доз семени на стельную корову", rowsByProperty(data::brdStrawsPerPregCow)),
            Column("Доз семени на стельную телку", rowsByProperty(data::brdStrawsPerPregHeif)),
            Column("Среднесуточный валовой надой", rowsByProperty(data::mlkAvgMilkSumYield)),
            Column("Суммарный валовой надой", rowsByProperty(data::mlkSumMilkSumYield)),
            Column("Среднесуточный надой 1 ф/к", rowsByProperty(data::mlkAvgMilkPerCow)),
            Column("Суммарный надой 1 ф/к", rowsByProperty(data::mlkSumMilkPerCow)),
            Column("Среднесуточный надой 1 д/к", rowsByProperty(data::mlkAvgMilkPerLactCow)),
            Column("Суммарный надой 1 д/к", rowsByProperty(data::mlkSumMilkPerLactCow)),
            Column("KPI кормления", rowsByProperty(data::feedKpi)),
        )

    @SerializedName("data_table")
    @Expose
    lateinit var data: PeriodicalDataTable

    @SuppressLint("DefaultLocale")
    private fun rowsByProperty(property: KProperty0<List<String>>): List<Row> {
        val list = property.get()
        return (data.yyyyMm.indices step 2).map {
            Row(data.yyyyMm[it], list.getOrNull(it).orEmpty())
        }
    }
}

class PeriodicalDataTable {

    @SerializedName("date")
    @Expose
    lateinit var date: List<String>

    @SerializedName("avg_lact_num")
    @Expose
    lateinit var avgLactNum: List<String>

    @SerializedName("avg_days_in_milk")
    @Expose
    lateinit var avgDaysInMilk: List<String>

    @SerializedName("avg_days_in_milk_1_lact")
    @Expose
    lateinit var avgDaysInMilk1Lact: List<String>

    @SerializedName("avg_days_in_milk_2_lact")
    @Expose
    lateinit var avgDaysInMilk2Lact: List<String>

    @SerializedName("avg_days_in_milk_over_2_lact")
    @Expose
    lateinit var avgDaysInMilkOver2Lact: List<String>

    @SerializedName("avg_open_days")
    @Expose
    lateinit var avgOpenDays: List<String>

    @SerializedName("avg_open_days_1_lact")
    @Expose
    lateinit var avgOpenDays1Lact: List<String>

    @SerializedName("avg_open_days_2_lact")
    @Expose
    lateinit var avgOpenDays2Lact: List<String>

    @SerializedName("avg_open_days_over_2_lact")
    @Expose
    lateinit var avgOpenDaysOver2Lact: List<String>

    @SerializedName("avg_dry_days")
    @Expose
    lateinit var avgDryDays: List<String>

    @SerializedName("avg_pregnant_days_cows")
    @Expose
    lateinit var avgPregnantDaysCows: List<String>

    @SerializedName("avg_pregnant_days_heifers")
    @Expose
    lateinit var avgPregnantDaysHeifers: List<String>

    @SerializedName("avg_calv_int_days")
    @Expose
    lateinit var avgCalvIntDays: List<String>

    @SerializedName("avg_insem_int_days_cows")
    @Expose
    lateinit var avgInsemIntDaysCows: List<String>

    @SerializedName("avg_insem_int_days_heifers")
    @Expose
    lateinit var avgInsemIntDaysHeifers: List<String>

    @SerializedName("avg_first_insem_dim_cows")
    @Expose
    lateinit var avgFirstInsemDimCows: List<String>

    @SerializedName("avg_first_insem_age_heifers")
    @Expose
    lateinit var avgFirstInsemAgeHeifers: List<String>

    @SerializedName("avg_first_calv_age_1_lact")
    @Expose
    lateinit var avgFirstCalvAge1Lact: List<String>

    @SerializedName("avg_milk_peak_days")
    @Expose
    lateinit var avgMilkPeakDays: List<String>

    @SerializedName("avg_milk_peak_days_1_lact")
    @Expose
    lateinit var avgMilkPeakDays1Lact: List<String>

    @SerializedName("avg_milk_peak_days_2_lact")
    @Expose
    lateinit var avgMilkPeakDays2Lact: List<String>

    @SerializedName("avg_milk_peak_days_over_2_lact")
    @Expose
    lateinit var avgMilkPeakDaysOver2Lact: List<String>

    @SerializedName("hrd_cows_all")
    @Expose
    lateinit var hrdCowsAll: List<String>

    @SerializedName("hrd_cows_lact_all")
    @Expose
    lateinit var hrdCowsLactAll: List<String>

    @SerializedName("hrd_cows_lact_all_pcnt")
    @Expose
    lateinit var hrdCowsLactAllPcnt: List<String>

    @SerializedName("hrd_cows_lact_1_all")
    @Expose
    lateinit var hrdCowsLact1All: List<String>

    @SerializedName("hrd_cows_lact_1_pcnt")
    @Expose
    lateinit var hrdCowsLact1Pcnt: List<String>

    @SerializedName("hrd_cows_lact_1_0_30")
    @Expose
    lateinit var hrdCowsLact1030: List<String>

    @SerializedName("hrd_cows_lact_1_31_60")
    @Expose
    lateinit var hrdCowsLact13160: List<String>

    @SerializedName("hrd_cows_lact_1_61_120")
    @Expose
    lateinit var hrdCowsLact161120: List<String>

    @SerializedName("hrd_cows_lact_1_o120")
    @Expose
    lateinit var hrdCowsLact1O120: List<String>

    @SerializedName("hrd_cows_lact_2_all")
    @Expose
    lateinit var hrdCowsLact2All: List<String>

    @SerializedName("hrd_cows_lact_2_pcnt")
    @Expose
    lateinit var hrdCowsLact2Pcnt: List<String>

    @SerializedName("hrd_cows_lact_2_0_30")
    @Expose
    lateinit var hrdCowsLact2030: List<String>

    @SerializedName("hrd_cows_lact_2_31_60")
    @Expose
    lateinit var hrdCowsLact23160: List<String>

    @SerializedName("hrd_cows_lact_2_61_120")
    @Expose
    lateinit var hrdCowsLact261120: List<String>

    @SerializedName("hrd_cows_lact_2_o120")
    @Expose
    lateinit var hrdCowsLact2O120: List<String>

    @SerializedName("hrd_cows_lact_o2_all")
    @Expose
    lateinit var hrdCowsLactO2All: List<String>

    @SerializedName("hrd_cows_lact_o2_pcnt")
    @Expose
    lateinit var hrdCowsLactO2Pcnt: List<String>

    @SerializedName("hrd_cows_lact_o2_0_30")
    @Expose
    lateinit var hrdCowsLactO2030: List<String>

    @SerializedName("hrd_cows_lact_o2_31_60")
    @Expose
    lateinit var hrdCowsLactO23160: List<String>

    @SerializedName("hrd_cows_lact_o2_61_120")
    @Expose
    lateinit var hrdCowsLactO261120: List<String>

    @SerializedName("hrd_cows_lact_o2_o120")
    @Expose
    lateinit var hrdCowsLactO2O120: List<String>

    @SerializedName("hrd_cows_preg_all")
    @Expose
    lateinit var hrdCowsPregAll: List<String>

    @SerializedName("hrd_cows_preg_pcnt")
    @Expose
    lateinit var hrdCowsPregPcnt: List<String>

    @SerializedName("hrd_cows_dry_all")
    @Expose
    lateinit var hrdCowsDryAll: List<String>

    @SerializedName("hrd_cows_dry_pcnt")
    @Expose
    lateinit var hrdCowsDryPcnt: List<String>

    @SerializedName("hrd_cows_dry_f1")
    @Expose
    lateinit var hrdCowsDryF1: List<String>

    @SerializedName("hrd_cows_dry_f2")
    @Expose
    lateinit var hrdCowsDryF2: List<String>

    @SerializedName("hrd_heifers_all")
    @Expose
    lateinit var hrdHeifersAll: List<String>

    @SerializedName("hrd_heifers_0_2")
    @Expose
    lateinit var hrdHeifers02: List<String>

    @SerializedName("hrd_heifers_2_6")
    @Expose
    lateinit var hrdHeifers26: List<String>

    @SerializedName("hrd_heifers_6_12")
    @Expose
    lateinit var hrdHeifers612: List<String>

    @SerializedName("hrd_heifers_o12")
    @Expose
    lateinit var hrdHeifersO12: List<String>

    @SerializedName("hrd_pheifers_all")
    @Expose
    lateinit var hrdPheifersAll: List<String>

    @SerializedName("hrd_pheifers_f2")
    @Expose
    lateinit var hrdPheifersF2: List<String>

    @SerializedName("hrd_bulls")
    @Expose
    lateinit var hrdBulls: List<String>

    @SerializedName("evt_insem_cows")
    @Expose
    lateinit var evtInsemCows: List<String>

    @SerializedName("evt_insem_heifers")
    @Expose
    lateinit var evtInsemHeifers: List<String>

    @SerializedName("evt_preg_check_cows")
    @Expose
    lateinit var evtPregCheckCows: List<String>

    @SerializedName("evt_got_preg_cows")
    @Expose
    lateinit var evtGotPregCows: List<String>

    @SerializedName("evt_preg_check_heifers")
    @Expose
    lateinit var evtPregCheckHeifers: List<String>

    @SerializedName("evt_got_preg_heifers")
    @Expose
    lateinit var evtGotPregHeifers: List<String>

    @SerializedName("evt_dry_cows")
    @Expose
    lateinit var evtDryCows: List<String>

    @SerializedName("evt_calv_total")
    @Expose
    lateinit var evtCalvTotal: List<String>

    @SerializedName("evt_calv_alive_heifers")
    @Expose
    lateinit var evtCalvAliveHeifers: List<String>

    @SerializedName("evt_calv_alive_bulls")
    @Expose
    lateinit var evtCalvAliveBulls: List<String>

    @SerializedName("evt_calv_dead_heifers")
    @Expose
    lateinit var evtCalvDeadHeifers: List<String>

    @SerializedName("evt_calv_dead_bulls")
    @Expose
    lateinit var evtCalvDeadBulls: List<String>

    @SerializedName("evt_calv_dead_all_pcnt")
    @Expose
    lateinit var evtCalvDeadAllPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_all_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersAllPcnt: List<String>

    @SerializedName("evt_calv_total_pheifers")
    @Expose
    lateinit var evtCalvTotalPheifers: List<String>

    @SerializedName("evt_calv_alive_heifers_pheifers")
    @Expose
    lateinit var evtCalvAliveHeifersPheifers: List<String>

    @SerializedName("evt_calv_alive_bulls_pheifers")
    @Expose
    lateinit var evtCalvAliveBullsPheifers: List<String>

    @SerializedName("evt_calv_dead_heifers_pheifers")
    @Expose
    lateinit var evtCalvDeadHeifersPheifers: List<String>

    @SerializedName("evt_calv_dead_bulls_pheifers")
    @Expose
    lateinit var evtCalvDeadBullsPheifers: List<String>

    @SerializedName("evt_calv_dead_pheifers_pcnt")
    @Expose
    lateinit var evtCalvDeadPheifersPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_pheifers_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersPheifersPcnt: List<String>

    @SerializedName("evt_calv_total_cows")
    @Expose
    lateinit var evtCalvTotalCows: List<String>

    @SerializedName("evt_calv_alive_heifers_cows")
    @Expose
    lateinit var evtCalvAliveHeifersCows: List<String>

    @SerializedName("evt_calv_alive_bulls_cows")
    @Expose
    lateinit var evtCalvAliveBullsCows: List<String>

    @SerializedName("evt_calv_dead_heifers_cows")
    @Expose
    lateinit var evtCalvDeadHeifersCows: List<String>

    @SerializedName("evt_calv_dead_bulls_cows")
    @Expose
    lateinit var evtCalvDeadBullsCows: List<String>

    @SerializedName("evt_calv_dead_cows_pcnt")
    @Expose
    lateinit var evtCalvDeadCowsPcnt: List<String>

    @SerializedName("evt_calv_alive_heifers_cows_pcnt")
    @Expose
    lateinit var evtCalvAliveHeifersCowsPcnt: List<String>

    @SerializedName("evt_abort_cows")
    @Expose
    lateinit var evtAbortCows: List<String>

    @SerializedName("evt_abort_heifers")
    @Expose
    lateinit var evtAbortHeifers: List<String>

    @SerializedName("evt_mast_for_month_cows")
    @Expose
    lateinit var evtMastForMonthCows: List<String>

    @SerializedName("evt_lame_for_month_cows")
    @Expose
    lateinit var evtLameForMonthCows: List<String>

    @SerializedName("evt_lame_for_month_heifers")
    @Expose
    lateinit var evtLameForMonthHeifers: List<String>

    @SerializedName("evt_ret_plac_lact_1")
    @Expose
    lateinit var evtRetPlacLact1: List<String>

    @SerializedName("evt_ret_plac_lact_1_pcnt")
    @Expose
    lateinit var evtRetPlacLact1Pcnt: List<String>

    @SerializedName("evt_ret_plac_lact_o1")
    @Expose
    lateinit var evtRetPlacLactO1: List<String>

    @SerializedName("evt_ret_plac_lact_o1_pcnt")
    @Expose
    lateinit var evtRetPlacLactO1Pcnt: List<String>

    @SerializedName("evt_ret_plac_total")
    @Expose
    lateinit var evtRetPlacTotal: List<String>

    @SerializedName("evt_ret_plac_total_pcnt")
    @Expose
    lateinit var evtRetPlacTotalPcnt: List<String>

    @SerializedName("evt_pares_lact_1")
    @Expose
    lateinit var evtParesLact1: List<String>

    @SerializedName("evt_pares_lact_1_pcnt")
    @Expose
    lateinit var evtParesLact1Pcnt: List<String>

    @SerializedName("evt_pares_lact_o1")
    @Expose
    lateinit var evtParesLactO1: List<String>

    @SerializedName("evt_pares_lact_o1_pcnt")
    @Expose
    lateinit var evtParesLactO1Pcnt: List<String>

    @SerializedName("evt_pares_total")
    @Expose
    lateinit var evtParesTotal: List<String>

    @SerializedName("evt_pares_total_pcnt")
    @Expose
    lateinit var evtParesTotalPcnt: List<String>

    @SerializedName("evt_ketos_lact_1")
    @Expose
    lateinit var evtKetosLact1: List<String>

    @SerializedName("evt_ketos_lact_1_pcnt")
    @Expose
    lateinit var evtKetosLact1Pcnt: List<String>

    @SerializedName("evt_ketos_lact_o1")
    @Expose
    lateinit var evtKetosLactO1: List<String>

    @SerializedName("evt_ketos_lact_o1_pcnt")
    @Expose
    lateinit var evtKetosLactO1Pcnt: List<String>

    @SerializedName("evt_ketos_total")
    @Expose
    lateinit var evtKetosTotal: List<String>

    @SerializedName("evt_ketos_total_pcnt")
    @Expose
    lateinit var evtKetosTotalPcnt: List<String>

    @SerializedName("evt_metrit")
    @Expose
    lateinit var evtMetrit: List<String>

    @SerializedName("evt_metrit_pcnt")
    @Expose
    lateinit var evtMetritPcnt: List<String>

    @SerializedName("evt_move_cows")
    @Expose
    lateinit var evtMoveCows: List<String>

    @SerializedName("evt_move_heifers")
    @Expose
    lateinit var evtMoveHeifers: List<String>

    @SerializedName("evt_vacc_cows")
    @Expose
    lateinit var evtVaccCows: List<String>

    @SerializedName("evt_vacc_heifers")
    @Expose
    lateinit var evtVaccHeifers: List<String>

    @SerializedName("evt_footrim_cows")
    @Expose
    lateinit var evtFootrimCows: List<String>

    @SerializedName("evt_footrim_heifers")
    @Expose
    lateinit var evtFootrimHeifers: List<String>

    @SerializedName("evt_sold_cows_lact_1_0_10")
    @Expose
    lateinit var evtSoldCowsLact1010: List<String>

    @SerializedName("evt_sold_cows_lact_1_11_30")
    @Expose
    lateinit var evtSoldCowsLact11130: List<String>

    @SerializedName("evt_sold_cows_lact_1_31_60")
    @Expose
    lateinit var evtSoldCowsLact13160: List<String>

    @SerializedName("evt_sold_cows_lact_1_61_120")
    @Expose
    lateinit var evtSoldCowsLact161120: List<String>

    @SerializedName("evt_sold_cows_lact_1_o120")
    @Expose
    lateinit var evtSoldCowsLact1O120: List<String>

    @SerializedName("evt_sold_cows_lact_1_total")
    @Expose
    lateinit var evtSoldCowsLact1Total: List<String>

    @SerializedName("evt_sold_cows_lact_2_0_10")
    @Expose
    lateinit var evtSoldCowsLact2010: List<String>

    @SerializedName("evt_sold_cows_lact_2_11_30")
    @Expose
    lateinit var evtSoldCowsLact21130: List<String>

    @SerializedName("evt_sold_cows_lact_2_31_60")
    @Expose
    lateinit var evtSoldCowsLact23160: List<String>

    @SerializedName("evt_sold_cows_lact_2_61_120")
    @Expose
    lateinit var evtSoldCowsLact261120: List<String>

    @SerializedName("evt_sold_cows_lact_2_o120")
    @Expose
    lateinit var evtSoldCowsLact2O120: List<String>

    @SerializedName("evt_sold_cows_lact_2_total")
    @Expose
    lateinit var evtSoldCowsLact2Total: List<String>

    @SerializedName("evt_sold_cows_lact_o2_0_10")
    @Expose
    lateinit var evtSoldCowsLactO2010: List<String>

    @SerializedName("evt_sold_cows_lact_o2_11_30")
    @Expose
    lateinit var evtSoldCowsLactO21130: List<String>

    @SerializedName("evt_sold_cows_lact_o2_31_60")
    @Expose
    lateinit var evtSoldCowsLactO23160: List<String>

    @SerializedName("evt_sold_cows_lact_o2_61_120")
    @Expose
    lateinit var evtSoldCowsLactO261120: List<String>

    @SerializedName("evt_sold_cows_lact_o2_o120")
    @Expose
    lateinit var evtSoldCowsLactO2O120: List<String>

    @SerializedName("evt_sold_cows_lact_o2_total")
    @Expose
    lateinit var evtSoldCowsLactO2Total: List<String>

    @SerializedName("evt_sold_cows_total")
    @Expose
    lateinit var evtSoldCowsTotal: List<String>

    @SerializedName("evt_sold_heifers_0_2")
    @Expose
    lateinit var evtSoldHeifers02: List<String>

    @SerializedName("evt_sold_heifers_2_6")
    @Expose
    lateinit var evtSoldHeifers26: List<String>

    @SerializedName("evt_sold_heifers_6_12")
    @Expose
    lateinit var evtSoldHeifers612: List<String>

    @SerializedName("evt_sold_heifers_o12")
    @Expose
    lateinit var evtSoldHeifersO12: List<String>

    @SerializedName("evt_sold_heifers_total")
    @Expose
    lateinit var evtSoldHeifersTotal: List<String>

    @SerializedName("evt_sold_pheifers")
    @Expose
    lateinit var evtSoldPheifers: List<String>

    @SerializedName("evt_sold_bulls")
    @Expose
    lateinit var evtSoldBulls: List<String>

    @SerializedName("evt_dead_cows_lact_1_0_10")
    @Expose
    lateinit var evtDeadCowsLact1010: List<String>

    @SerializedName("evt_dead_cows_lact_1_11_30")
    @Expose
    lateinit var evtDeadCowsLact11130: List<String>

    @SerializedName("evt_dead_cows_lact_1_31_60")
    @Expose
    lateinit var evtDeadCowsLact13160: List<String>

    @SerializedName("evt_dead_cows_lact_1_61_120")
    @Expose
    lateinit var evtDeadCowsLact161120: List<String>

    @SerializedName("evt_dead_cows_lact_1_o120")
    @Expose
    lateinit var evtDeadCowsLact1O120: List<String>

    @SerializedName("evt_dead_cows_lact_1_total")
    @Expose
    lateinit var evtDeadCowsLact1Total: List<String>

    @SerializedName("evt_dead_cows_lact_2_0_10")
    @Expose
    lateinit var evtDeadCowsLact2010: List<String>

    @SerializedName("evt_dead_cows_lact_2_11_30")
    @Expose
    lateinit var evtDeadCowsLact21130: List<String>

    @SerializedName("evt_dead_cows_lact_2_31_60")
    @Expose
    lateinit var evtDeadCowsLact23160: List<String>

    @SerializedName("evt_dead_cows_lact_2_61_120")
    @Expose
    lateinit var evtDeadCowsLact261120: List<String>

    @SerializedName("evt_dead_cows_lact_2_o120")
    @Expose
    lateinit var evtDeadCowsLact2O120: List<String>

    @SerializedName("evt_dead_cows_lact_2_total")
    @Expose
    lateinit var evtDeadCowsLact2Total: List<String>

    @SerializedName("evt_dead_cows_lact_o2_0_10")
    @Expose
    lateinit var evtDeadCowsLactO2010: List<String>

    @SerializedName("evt_dead_cows_lact_o2_11_30")
    @Expose
    lateinit var evtDeadCowsLactO21130: List<String>

    @SerializedName("evt_dead_cows_lact_o2_31_60")
    @Expose
    lateinit var evtDeadCowsLactO23160: List<String>

    @SerializedName("evt_dead_cows_lact_o2_61_120")
    @Expose
    lateinit var evtDeadCowsLactO261120: List<String>

    @SerializedName("evt_dead_cows_lact_o2_o120")
    @Expose
    lateinit var evtDeadCowsLactO2O120: List<String>

    @SerializedName("evt_dead_cows_lact_o2_total")
    @Expose
    lateinit var evtDeadCowsLactO2Total: List<String>

    @SerializedName("evt_dead_cows_total")
    @Expose
    lateinit var evtDeadCowsTotal: List<String>

    @SerializedName("evt_dead_heifers_0_2")
    @Expose
    lateinit var evtDeadHeifers02: List<String>

    @SerializedName("evt_dead_heifers_2_6")
    @Expose
    lateinit var evtDeadHeifers26: List<String>

    @SerializedName("evt_dead_heifers_6_12")
    @Expose
    lateinit var evtDeadHeifers612: List<String>

    @SerializedName("evt_dead_heifers_o12")
    @Expose
    lateinit var evtDeadHeifersO12: List<String>

    @SerializedName("evt_dead_heifers_total")
    @Expose
    lateinit var evtDeadHeifersTotal: List<String>

    @SerializedName("evt_dead_pheifers")
    @Expose
    lateinit var evtDeadPheifers: List<String>

    @SerializedName("evt_dead_bulls")
    @Expose
    lateinit var evtDeadBulls: List<String>

    @SerializedName("brd_heat_det_rate_cow")
    @Expose
    lateinit var brdHeatDetRateCow: List<String>

    @SerializedName("brd_heat_det_rate_heif")
    @Expose
    lateinit var brdHeatDetRateHeif: List<String>

    @SerializedName("brd_conc_rate_cow")
    @Expose
    lateinit var brdConcRateCow: List<String>

    @SerializedName("brd_conc_rate_heif")
    @Expose
    lateinit var brdConcRateHeif: List<String>

    @SerializedName("brd_preg_rate_cow")
    @Expose
    lateinit var brdPregRateCow: List<String>

    @SerializedName("brd_preg_rate_heif")
    @Expose
    lateinit var brdPregRateHeif: List<String>

    @SerializedName("brd_straws_per_preg_cow")
    @Expose
    lateinit var brdStrawsPerPregCow: List<String>

    @SerializedName("brd_straws_per_preg_heif")
    @Expose
    lateinit var brdStrawsPerPregHeif: List<String>

    @SerializedName("mlk_avg_milk_sum_yield")
    @Expose
    lateinit var mlkAvgMilkSumYield: List<String>

    @SerializedName("mlk_sum_milk_sum_yield")
    @Expose
    lateinit var mlkSumMilkSumYield: List<String>

    @SerializedName("mlk_avg_milk_per_cow")
    @Expose
    lateinit var mlkAvgMilkPerCow: List<String>

    @SerializedName("mlk_sum_milk_per_cow")
    @Expose
    lateinit var mlkSumMilkPerCow: List<String>

    @SerializedName("mlk_avg_milk_per_lact_cow")
    @Expose
    lateinit var mlkAvgMilkPerLactCow: List<String>

    @SerializedName("mlk_sum_milk_per_lact_cow")
    @Expose
    lateinit var mlkSumMilkPerLactCow: List<String>

    @SerializedName("feed_kpi")
    @Expose
    lateinit var feedKpi: List<String>
}