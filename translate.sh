#!/bin/bash

ARRAY=( 
  "average_days_in_milk:День доения"
  "average_lactation_daily_milk:Средняя лактация"
  "average_milk:Надой"
  "average_milk_today:Надой сегодня"
  "average_milk_yesterday:Надой вчера"
  "avg_calv_int_days:Межотельный интервал"
  "avg_days_in_milk:День доения"
  "avg_days_in_milk_1_lact:День доения 1 лактации"
  "avg_days_in_milk_2_lact:День доения 2 лактации"
  "avg_days_in_milk_over_2_lact:День доения лактации >2"
  "avg_dry_days:Кол-во дней в сухостое"
  "avg_first_calv_age_1_lact:Возраст 1-го отела"
  "avg_first_insem_age_heifers:Возраст 1-го осеменения телок"
  "avg_first_insem_dim_cows:День доения 1-го осеменения коров"
  "avg_in_hosp_days:Дней в госпитале"
  "avg_insem_int_days_cows:Интервал между осеменениями коров"
  "avg_insem_int_days_heifers:Интервал между осеменениями телок"
  "avg_lact_num:№ лактации стада"
  "avg_milk_peak_days:День доения при пике"
  "avg_milk_peak_days_1_lact:День доения при пике 1 лактации"
  "avg_milk_peak_days_2_lact:День доения при пике 2 лактации"
  "avg_milk_peak_days_over_2_lact:День доения при пике лактации >2"
  "avg_open_days:Сервис-период"
  "avg_open_days_1_lact:Сервис-период 1 лактации"
  "avg_open_days_2_lact:Сервис-период 2 лактации"
  "avg_open_days_over_2_lact:Сервис-период лактации >2"
  "avg_pregnant_days_cows:День стельности коров"
  "avg_pregnant_days_heifers:День стельности нетелей"
  "brd_conc_rate_cow:Индекс оплодотворяемости коров"
  "brd_conc_rate_heif:Индекс оплодотворяемости телок"
  "brd_heat_det_rate_cow:Индекс выявления охоты коров"
  "brd_heat_det_rate_heif:Индекс выявления охоты телок"
  "brd_preg_rate_cow:Индекс стельности коров"
  "brd_preg_rate_heif:Индекс стельности телок"
  "brd_straws_per_preg_cow:Доз семени на стельную корову"
  "brd_straws_per_preg_heif:Доз семени на стельную телку"
  "count_of_animals_in_group:Кол-во животных"
  "date:Дата"
  "evt_abort_cows:Абортировало коров"
  "evt_abort_heifers:Абортировало нетелей"
  "evt_calv_alive_bulls:Родилось живых быков"
  "evt_calv_alive_bulls_cows:От коров родилось живых быков"
  "evt_calv_alive_bulls_pheifers:От нетелей родилось живых быков"
  "evt_calv_alive_heifers:Родилось живых телок"
  "evt_calv_alive_heifers_all_pcnt:% рождаемости телок"
  "evt_calv_alive_heifers_cows:От коров родилось живых телок"
  "evt_calv_alive_heifers_cows_pcnt:% рождаемости телок от коров"
  "evt_calv_alive_heifers_pheifers:От нетелей родилось живых телок"
  "evt_calv_alive_heifers_pheifers_pcnt:% рождаемости телок от нетелей"
  "evt_calv_dead_all_pcnt:% мертворожденности"
  "evt_calv_dead_bulls:Родилось мертвых быков"
  "evt_calv_dead_bulls_cows:От коров родилось мертвых быков"
  "evt_calv_dead_bulls_pheifers:От нетелей родилось мертвых быков"
  "evt_calv_dead_cows_pcnt:% мертворожденности от коров"
  "evt_calv_dead_heifers:Родилось мертвых телок"
  "evt_calv_dead_heifers_cows:От коров родилось мертвых телок"
  "evt_calv_dead_heifers_pheifers:От нетелей родилось мертвых телок"
  "evt_calv_dead_pheifers_pcnt:% мертворожденности от нетелей"
  "evt_calv_total:Отелов всего"
  "evt_calv_total_cows:Отелов от коров"
  "evt_calv_total_pheifers:Отелов от нетелей"
  "evt_dead_bulls:Падеж быков"
  "evt_dead_cows_lact_1_0_10:Падеж коров лактация 1 0-10 ДД"
  "evt_dead_cows_lact_1_11_30:Падеж коров лактация 1 11-30 ДД"
  "evt_dead_cows_lact_1_31_60:Падеж коров лактация 1 31-60 ДД"
  "evt_dead_cows_lact_1_61_120:Падеж коров лактация 1 61-120 ДД"
  "evt_dead_cows_lact_1_o120:Падеж коров лактация 1 >120 ДД"
  "evt_dead_cows_lact_1_total:Падеж коров лактация 1 всего"
  "evt_dead_cows_lact_2_0_10:Падеж коров лактация 2 0-10 ДД"
  "evt_dead_cows_lact_2_11_30:Падеж коров лактация 2 11-30 ДД"
  "evt_dead_cows_lact_2_31_60:Падеж коров лактация 2 31-60 ДД"
  "evt_dead_cows_lact_2_61_120:Падеж коров лактация 2 61-120 ДД"
  "evt_dead_cows_lact_2_o120:Падеж коров лактация 2 >120 ДД"
  "evt_dead_cows_lact_2_total:Падеж коров лактация 2 всего"
  "evt_dead_cows_lact_o2_0_10:Падеж коров лактация >2 0-10 ДД"
  "evt_dead_cows_lact_o2_11_30:Падеж коров лактация >2 11-30 ДД"
  "evt_dead_cows_lact_o2_31_60:Падеж коров лактация >2 31-60 ДД"
  "evt_dead_cows_lact_o2_61_120:Падеж коров лактация >2 61-120 ДД"
  "evt_dead_cows_lact_o2_o120:Падеж коров лактация >2 >120 ДД"
  "evt_dead_cows_lact_o2_total:Падеж коров лактация >2 всего"
  "evt_dead_cows_total:Падеж коров всего"
  "evt_dead_heifers_0_2:Падеж телок 0-2 мес"
  "evt_dead_heifers_2_6:Падеж телок 2-6 мес"
  "evt_dead_heifers_6_12:Падеж телок 6-12 мес"
  "evt_dead_heifers_o12:Падеж телок >12 мес"
  "evt_dead_heifers_total:Падеж телок всего"
  "evt_dead_pheifers:Падеж нетелей"
  "evt_dry_cows:Запущено коров"
  "evt_footrim_cows:Расчистка копыт коров"
  "evt_footrim_heifers:Расчистка копыт телок"
  "evt_got_preg_cows:Выявлено стельных коров"
  "evt_got_preg_heifers:Выявлено стельных телок"
  "evt_insem_cows:Осеменений коров"
  "evt_insem_heifers:Осеменений телок"
  "evt_ketos_lact_1:Кетозов лактация 1"
  "evt_ketos_lact_1_pcnt:% кетозов у нетелей"
  "evt_ketos_lact_o1:Кетозов лактация >1"
  "evt_ketos_lact_o1_pcnt:% кетозов у коров"
  "evt_ketos_total:Кетозов всего"
  "evt_ketos_total_pcnt:% кетозов"
  "evt_lame_for_month_cows:Хромота голов за месяц коров"
  "evt_lame_for_month_heifers:Хромота голов за месяц телок"
  "evt_mast_for_month_cows:Мастит голов за месяц коров"
  "evt_metrit:Метритов"
  "evt_metrit_pcnt:% метритов"
  "evt_move_cows:Переводов коров"
  "evt_move_heifers:Переводов телок"
  "evt_out_bulls:Выбытие быков"
  "evt_out_cows_lact_1_0_30:Выбытие коров лактация 1 0-30 ДД"
  "evt_out_cows_lact_1_31_60:Выбытие коров лактация 1 31-60 ДД"
  "evt_out_cows_lact_1_61_120:Выбытие коров лактация 1 61-120 ДД"
  "evt_out_cows_lact_1_o120:Выбытие коров лактация 1 >120 ДД"
  "evt_out_cows_lact_1_total:Выбытие коров лактация 1 всего"
  "evt_out_cows_lact_2_0_30:Выбытие коров лактация 2 0-30 ДД"
  "evt_out_cows_lact_2_31_60:Выбытие коров лактация 2 31-60 ДД"
  "evt_out_cows_lact_2_61_120:Выбытие коров лактация 2 61-120 ДД"
  "evt_out_cows_lact_2_o120:Выбытие коров лактация 2 >120 ДД"
  "evt_out_cows_lact_2_total:Выбытие коров лактация 2 всего"
  "evt_out_cows_lact_o2_0_30:Выбытие коров лактация >2 0-30 ДД"
  "evt_out_cows_lact_o2_31_60:Выбытие коров лактация >2 31-60 ДД"
  "evt_out_cows_lact_o2_61_120:Выбытие коров лактация >2 61-120 ДД"
  "evt_out_cows_lact_o2_o120:Выбытие коров лактация >2 >120 ДД"
  "evt_out_cows_lact_o2_total:Выбытие коров лактация >2 всего"
  "evt_out_cows_total:Выбытие коров всего"
  "evt_out_heifers_0_2:Выбытие телок 0-2 мес"
  "evt_out_heifers_2_6:Выбытие телок 2-6 мес"
  "evt_out_heifers_6_12:Выбытие телок 6-12 мес"
  "evt_out_heifers_o12:Выбытие телок >12 мес"
  "evt_out_heifers_total:Выбытие телок всего"
  "evt_out_pheifers:Выбытие нетелей"
  "evt_pares_lact_1:Парезов лактация 1"
  "evt_pares_lact_1_pcnt:% парезов у нетелей"
  "evt_pares_lact_o1:Парезов лактация >1"
  "evt_pares_lact_o1_pcnt:% парезов у коров"
  "evt_pares_total:Парезов всего"
  "evt_pares_total_pcnt:% парезов"
  "evt_preg_check_cows:Проверено на стельность коров"
  "evt_preg_check_heifers:Проверено на стельность телок"
  "evt_ret_plac_lact_1:Задержаний последа лактация 1"
  "evt_ret_plac_lact_1_pcnt:% задержаний последа у нетелей"
  "evt_ret_plac_lact_o1:Задержаний последа лактация >1"
  "evt_ret_plac_lact_o1_pcnt:% задержаний последа у коров"
  "evt_ret_plac_total:Задержаний последа всего"
  "evt_ret_plac_total_pcnt:% задержаний последа"
  "evt_sold_bulls:Продажа быков"
  "evt_sold_cows_lact_1_0_10:Продажа коров лактация 1 0-10 ДД"
  "evt_sold_cows_lact_1_11_30:Продажа коров лактация 1 11-30 ДД"
  "evt_sold_cows_lact_1_31_60:Продажа коров лактация 1 31-60 ДД"
  "evt_sold_cows_lact_1_61_120:Продажа коров лактация 1 61-120 ДД"
  "evt_sold_cows_lact_1_o120:Продажа коров лактация 1 >120 ДД"
  "evt_sold_cows_lact_1_total:Продажа коров лактация 1 всего"
  "evt_sold_cows_lact_2_0_10:Продажа коров лактация 2 0-10 ДД"
  "evt_sold_cows_lact_2_11_30:Продажа коров лактация 2 11-30 ДД"
  "evt_sold_cows_lact_2_31_60:Продажа коров лактация 2 31-60 ДД"
  "evt_sold_cows_lact_2_61_120:Продажа коров лактация 2 61-120 ДД"
  "evt_sold_cows_lact_2_o120:Продажа коров лактация 2 >120 ДД"
  "evt_sold_cows_lact_2_total:Продажа коров лактация 2 всего"
  "evt_sold_cows_lact_o2_0_10:Продажа коров лактация >2 0-10 ДД"
  "evt_sold_cows_lact_o2_11_30:Продажа коров лактация >2 11-30 ДД"
  "evt_sold_cows_lact_o2_31_60:Продажа коров лактация >2 31-60 ДД"
  "evt_sold_cows_lact_o2_61_120:Продажа коров лактация >2 61-120 ДД"
  "evt_sold_cows_lact_o2_o120:Продажа коров лактация >2 >120 ДД"
  "evt_sold_cows_lact_o2_total:Продажа коров лактация >2 всего"
  "evt_sold_cows_total:Продажа коров всего"
  "evt_sold_heifers_0_2:Продажа телок 0-2 мес"
  "evt_sold_heifers_2_6:Продажа телок 2-6 мес"
  "evt_sold_heifers_6_12:Продажа телок 6-12 мес"
  "evt_sold_heifers_o12:Продажа телок >12 мес"
  "evt_sold_heifers_total:Продажа телок всего"
  "evt_sold_pheifers:Продажа нетелей"
  "evt_vacc_cows:Вакцинация коров"
  "evt_vacc_heifers:Вакцинация телок"
  "expected_average_milk:Ожидаемый надой"
  "farm_name:Название фермы"
  "feed_cost_1kg_milk_cows_all:Кормовая с/с 1 кг молока ф/к"
  "feed_cost_1kg_milk_cows_lact:Кормовая с/с 1 кг молока д/к"
  "feed_cost_1kg_milk_total:Кормовая с/с 1 кг молока общая"
  "feed_kpi:KPI кормления"
  "group_description:Описание группы"
  "group_number:Группа"
  "hrd_bulls:Быков"
  "hrd_cows_all:Фуражных коров"
  "hrd_cows_dry_all:Сухостойных коров всего"
  "hrd_cows_dry_f1:Сухостойных коров 1 фазы"
  "hrd_cows_dry_f2:Сухостойных коров 2 фазы"
  "hrd_cows_dry_pcnt:% сухостойных в стаде"
  "hrd_cows_lact_1_0_30:Дойных коров 1 лактации 0-30 ДД"
  "hrd_cows_lact_1_31_60:Дойных коров 1 лактации 31-60 ДД"
  "hrd_cows_lact_1_61_120:Дойных коров 1 лактации 61-120 ДД"
  "hrd_cows_lact_1_all:Дойных коров 1 лактации"
  "hrd_cows_lact_1_o120:Дойных коров 1 лактации >120 ДД"
  "hrd_cows_lact_1_pcnt:% 1 лактации в дойных"
  "hrd_cows_lact_2_0_30:Дойных коров 2 лактации 0-30 ДД"
  "hrd_cows_lact_2_31_60:Дойных коров 2 лактации 31-60 ДД"
  "hrd_cows_lact_2_61_120:Дойных коров 2 лактации 61-120 ДД"
  "hrd_cows_lact_2_all:Дойных коров 2 лактации"
  "hrd_cows_lact_2_o120:Дойных коров 2 лактации >120 ДД"
  "hrd_cows_lact_2_pcnt:% 2 лактации в дойных"
  "hrd_cows_lact_all:Дойных коров всего"
  "hrd_cows_lact_all_pcnt:% дойных в стаде"
  "hrd_cows_lact_o2_0_30:Дойных коров лактации >2 0-30 ДД"
  "hrd_cows_lact_o2_31_60:Дойных коров лактации >2 31-60 ДД"
  "hrd_cows_lact_o2_61_120:Дойных коров лактации >2 61-120 ДД"
  "hrd_cows_lact_o2_all:Дойных коров лактации >2"
  "hrd_cows_lact_o2_o120:Дойных коров лактации >2 >120 ДД"
  "hrd_cows_lact_o2_pcnt:% лактации >2 в дойных"
  "hrd_cows_preg_all:Стельных коров"
  "hrd_cows_preg_pcnt:% стельных в стаде"
  "hrd_heifers_0_2:Телок 0-2 мес"
  "hrd_heifers_2_6:Телок 2-6 мес"
  "hrd_heifers_6_12:Телок 6-12 мес"
  "hrd_heifers_all:Телок всего"
  "hrd_heifers_o12:Телок >12 мес"
  "hrd_pheifers_all:Нетелей всего"
  "hrd_pheifers_f2:Нетелей 2 фазы"
  "lactation_1_daily_milk:Лактация 1"
  "lactation_2_daily_milk:Лактация 2"
  "lactation_days:День доения"
  "lactation_over_2_daily_milk:Лактация >2"
  "last_cows_cr_file_date:Conception Rate коров"
  "last_cows_pr_file_date:Pregnancy Rate коров"
  "last_evts_file_date:Событий"
  "last_feed_kpi_file_date:KPI кормления"
  "last_heif_cr_file_date:Conception Rate телок"
  "last_heif_pr_file_date:Pregnancy Rate телок"
  "last_herd_file_date:Поголовья"
  "last_milk_sum_file_date:Суммарного надоя"
  "mlk_avg_milk_per_cow:Среднесуточный надой 1 ф/к"
  "mlk_avg_milk_per_lact_cow:Среднесуточный надой 1 д/к"
  "mlk_avg_milk_sum_yield:Среднесуточный валовой надой"
  "mlk_milk_per_cow:Надой 1 ф/к"
  "mlk_milk_per_lact_cow:Надой 1 д/к"
  "mlk_milk_sum_yield:Валовой надой"
  "mlk_sum_milk_per_cow:Суммарный надой 1 ф/к"
  "mlk_sum_milk_per_lact_cow:Суммарный надой 1 д/к"
  "mlk_sum_milk_sum_yield:Суммарный валовой надой"
  "sample_lactation_*_per_305_milking_days_daily_milk:Образец %s за 305 дней"
  "yyyy_mm:Год Месяц"
)

for file in $(find app/src/main/java/ru/agrointellect/remote -name '*.kt'); do
  for item in "${ARRAY[@]}" ; do
    KEY="${item%%:*}"
    VALUE="${item##*:}"
    node replace.js "$file" "\"$VALUE\"" "D[\"$KEY\"]"
  done
done