package ru.agrointellect.remote.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ru.agrointellect.screen.report.Column
import ru.agrointellect.screen.report.Row
import ru.agrointellect.screen.report.Table

@Suppress("SpellCheckingInspection")
class TableHerdForecast : Table {

    override val columns: List<Column>
        get() = listOf(
            Column("Фуражных коров", mapByField("")),
            Column("Дойных коров всего", mapByField("")),
            Column("% дойных в стаде", mapByField("")),
            Column("Дойных коров 1 лактации", mapByField("")),
            Column("% 1 лактации в дойных", mapByField("")),
            Column("Дойных коров 1 лактации 0-30 ДД", mapByField("")),
            Column("Дойных коров 1 лактации 31-60 ДД", mapByField("")),
            Column("Дойных коров 1 лактации 61-120 ДД", mapByField("")),
            Column("Дойных коров 1 лактации > 120 ДД", mapByField("")),
            Column("Дойных коров 2 лактации", mapByField("")),
            Column("% 2 лактации в дойных", mapByField("")),
            Column("Дойных коров 2 лактации 0-30 ДД", mapByField("")),
            Column("Дойных коров 2 лактации 31-60 ДД", mapByField("")),
            Column("Дойных коров 2 лактации 61-120 ДД", mapByField("")),
            Column("Дойных коров 2 лактации > 120 ДД", mapByField("")),
            Column("Дойных коров лактации > 2", mapByField("")),
            Column("% лактации > 2 в дойных", mapByField("")),
            Column("Дойных коров лактации > 2 0-30 ДД", mapByField("")),
            Column("Дойных коров лактации > 2 31-60 ДД", mapByField("")),
            Column("Дойных коров лактации > 2 61-120 ДД", mapByField("")),
            Column("Дойных коров лактации > 2 > 120 ДД", mapByField("")),
            Column("Стельных коров", mapByField("")),
            Column("% стельных в стаде", mapByField("")),
            Column("Сухостойных коров всего", mapByField("")),
            Column("% сухостойных в стаде", mapByField("")),
            Column("Сухостойных коров 1 фазы", mapByField("")),
            Column("Сухостойных коров 2 фазы", mapByField("")),
            Column("Телок всего", mapByField("")),
            Column("Телок 0-2 мес", mapByField("")),
            Column("Телок 2-6 мес", mapByField("")),
            Column("Телок 6-12 мес", mapByField("")),
            Column("Телок > 12 мес", mapByField("")),
            Column("Нетелей всего", mapByField("")),
            Column("Нетелей 2 фазы", mapByField("")),
            Column("Быков", mapByField("")),
            Column("Осеменений коров", mapByField("")),
            Column("Осеменений телок", mapByField("")),
            Column("Выявлено стельных коров", mapByField("")),
            Column("Выявлено стельных телок", mapByField("")),
            Column("Запущено коров", mapByField("")),
            Column("Отелов всего", mapByField("")),
            Column("Отелов от нетелей", mapByField("")),
            Column("Отелов от коров", mapByField("")),
            Column("Родилось живых телок", mapByField("")),
            Column("Родилось живых быков", mapByField("")),
            Column("Выбытие коров всего", mapByField("")),
            Column("Выбытие коров лактация 1 всего", mapByField("")),
            Column("Выбытие коров лактация 1 0-30 ДД", mapByField("")),
            Column("Выбытие коров лактация 1 31-60 ДД", mapByField("")),
            Column("Выбытие коров лактация 1 61-120 ДД", mapByField("")),
            Column("Выбытие коров лактация 1 > 120 ДД", mapByField("")),
            Column("Выбытие коров лактация 2 всего", mapByField("")),
            Column("Выбытие коров лактация 2 0-30 ДД", mapByField("")),
            Column("Выбытие коров лактация 2 31-60 ДД", mapByField("")),
            Column("Выбытие коров лактация 2 61-120 ДД", mapByField("")),
            Column("Выбытие коров лактация 2 > 120 ДД", mapByField("")),
            Column("Выбытие коров лактация > 2 всего", mapByField("")),
            Column("Выбытие коров лактация > 2 0-30 ДД", mapByField("")),
            Column("Выбытие коров лактация > 2 31-60 ДД", mapByField("")),
            Column("Выбытие коров лактация > 2 61-120 ДД", mapByField("")),
            Column("Выбытие коров лактация > 2 > 120 ДД", mapByField("")),
            Column("Выбытие телок всего", mapByField("")),
            Column("Выбытие телок 0-2 мес", mapByField("")),
            Column("Выбытие телок 2-6 мес", mapByField("")),
            Column("Выбытие телок 6-12 мес", mapByField("")),
            Column("Выбытие телок > 12 мес", mapByField("")),
            Column("Выбытие нетелей", mapByField("")),
            Column("Выбытие быков", mapByField("")),
            Column("Валовой надой", mapByField("")),
            Column("Надой 1 ф/к", mapByField("")),
            Column("Надой 1 д/к", mapByField(""))
        )

    private fun mapByField(name: String): List<Row> {
        val field = RptHerdForecast::class.java.getField(name)
        "get" + propertyName.capitalize()
        return items.map { Row(it.yyyyMm, field.get(it)!!.toString()) }
    }

    @SerializedName("rpt_herd_forecast")
    @Expose
    lateinit var items: List<RptHerdForecast>
}