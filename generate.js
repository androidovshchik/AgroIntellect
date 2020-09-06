const titles =
`Фуражных коров
Дойных коров всего
% дойных в стаде
Дойных коров 1 лактации
% 1 лактации в дойных
Дойных коров 1 лактации 0-30 ДД
Дойных коров 1 лактации 31-60 ДД
Дойных коров 1 лактации 61-120 ДД
Дойных коров 1 лактации > 120 ДД
Дойных коров 2 лактации
% 2 лактации в дойных
Дойных коров 2 лактации 0-30 ДД
Дойных коров 2 лактации 31-60 ДД
Дойных коров 2 лактации 61-120 ДД
Дойных коров 2 лактации > 120 ДД
Дойных коров лактации > 2
% лактации > 2 в дойных
Дойных коров лактации > 2 0-30 ДД
Дойных коров лактации > 2 31-60 ДД
Дойных коров лактации > 2 61-120 ДД
Дойных коров лактации > 2 > 120 ДД
Стельных коров
% стельных в стаде
Сухостойных коров всего
% сухостойных в стаде
Сухостойных коров 1 фазы
Сухостойных коров 2 фазы
Телок всего
Телок 0-2 мес
Телок 2-6 мес
Телок 6-12 мес
Телок > 12 мес
Нетелей всего
Нетелей 2 фазы
Быков
Осеменений коров
Осеменений телок
Выявлено стельных коров
Выявлено стельных телок
Запущено коров
Отелов всего
Отелов от нетелей
Отелов от коров
Родилось живых телок
Родилось живых быков
Выбытие коров всего
Выбытие коров лактация 1 всего
Выбытие коров лактация 1 0-30 ДД
Выбытие коров лактация 1 31-60 ДД
Выбытие коров лактация 1 61-120 ДД
Выбытие коров лактация 1 > 120 ДД
Выбытие коров лактация 2 всего
Выбытие коров лактация 2 0-30 ДД
Выбытие коров лактация 2 31-60 ДД
Выбытие коров лактация 2 61-120 ДД
Выбытие коров лактация 2 > 120 ДД
Выбытие коров лактация > 2 всего
Выбытие коров лактация > 2 0-30 ДД
Выбытие коров лактация > 2 31-60 ДД
Выбытие коров лактация > 2 61-120 ДД
Выбытие коров лактация > 2 > 120 ДД
Выбытие телок всего
Выбытие телок 0-2 мес
Выбытие телок 2-6 мес
Выбытие телок 6-12 мес
Выбытие телок > 12 мес
Выбытие нетелей
Выбытие быков
Валовой надой
Надой 1 ф/к
Надой 1 д/к`.split('\n');
const vars =
`hrdCowsAll
hrdCowsLactAll
hrdCowsLactAllPcnt
hrdCowsLact1All
hrdCowsLact1Pcnt
hrdCowsLact1030
hrdCowsLact13160
hrdCowsLact161120
hrdCowsLact1O120
hrdCowsLact2All
hrdCowsLact2Pcnt
hrdCowsLact2030
hrdCowsLact23160
hrdCowsLact261120
hrdCowsLact2O120
hrdCowsLactO2All
hrdCowsLactO2Pcnt
hrdCowsLactO2030
hrdCowsLactO23160
hrdCowsLactO261120
hrdCowsLactO2O120
hrdCowsPregAll
hrdCowsPregPcnt
hrdCowsDryAll
hrdCowsDryPcnt
hrdCowsDryF1
hrdCowsDryF2
hrdHeifersAll
hrdHeifers02
hrdHeifers26
hrdHeifers612
hrdHeifersO12
hrdPheifersAll
hrdPheifersF2
hrdBulls
evtInsemCows
evtInsemHeifers
evtGotPregCows
evtGotPregHeifers
evtDryCows
evtCalvTotal
evtCalvTotalPheifers
evtCalvTotalCows
evtCalvAliveHeifers
evtCalvAliveBulls
evtOutCowsTotal
evtOutCowsLact1Total
evtOutCowsLact1030
evtOutCowsLact13160
evtOutCowsLact161120
evtOutCowsLact1O120
evtOutCowsLact2Total
evtOutCowsLact2030
evtOutCowsLact23160
evtOutCowsLact261120
evtOutCowsLact2O120
evtOutCowsLactO2Total
evtOutCowsLactO2030
evtOutCowsLactO23160
evtOutCowsLactO261120
evtOutCowsLactO2O120
evtOutHeifersTotal
evtOutHeifers02
evtOutHeifers26
evtOutHeifers612
evtOutHeifersO12
evtOutPheifers
evtOutBulls
mlkMilkSumYield
mlkMilkPerCow
mlkMilkPerLactCow`.split('\n');

for (let i = 0; i < titles.length; i++) {
    const text = `Column("${titles[i]}", rowsBy("${vars[i]}")),`;
    console.log(text);
}
