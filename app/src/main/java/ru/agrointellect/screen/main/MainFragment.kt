package ru.agrointellect.screen.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.extension.readArray
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.api.Report
import ru.agrointellect.remote.api.RptDesc
import ru.agrointellect.screen.base.BaseFragment

abstract class MainFragment : BaseFragment() {

    protected val client by instance<HttpClient>()

    protected val preferences by instance<Preferences>()

    protected val gson by instance<Gson>()

    protected lateinit var mainModel: MainModel

    protected val navController by lazy {
        findNavController()
    }

    @Suppress("SpellCheckingInspection")
    protected open val defaultList: List<RptDesc>
        get() = mutableListOf(
            RptDesc("rpt_herd_distribution", "Поголовье: фуражное, дойное, стельное", 2),
            RptDesc(
                "rpt_herd_alignment_now",
                "Распределение поголовья по группам на текущий момент",
                0
            ),
            RptDesc("rpt_herd_alignment_history", "История распределения поголовья по группам", 1),
            RptDesc("rpt_herd_lactation_graph", "График лактации поголовья", 0),
            RptDesc("rpt_milk_events_kpi", "Надой, события, кормление", 2),
            RptDesc("rpt_breed_effectivity", "Воспроизводство", 2),
            RptDesc("rpt_fresh_disease", "Послеотельные заболевания", 2),
            RptDesc("rpt_farm_summary_history", "Сводный отчет", 2),
            RptDesc("rpt_periodical_farm_summary_history", "Сводный отчет по периодам", 2, true),
            RptDesc("rpt_all_farms_summary_history", "Сводный отчет по всем фермам", 2),
            RptDesc("rpt_herd_forecast", "Прогноз", 0),
            RptDesc("rpt_sold_animals", "Продажа", 2),
            RptDesc("rpt_died_animals", "Падеж", 2),
            RptDesc("rpt_last_updates", "Даты актуальности данных", 0)
        ).apply {
            if (BuildConfig.DEBUG) {
                add(RptDesc("rpt_clone_modelling", "Моделирование в клоне", 0))
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(requireActivity()).get(MainModel::class.java)
    }

    protected suspend fun loadReports(farmId: String): List<Report> {
        return withContext(Dispatchers.IO) {
            val response = client.post<HttpResponse>(BuildConfig.API_URL) {
                body = FormDataContent(Parameters.build {
                    append("uid", preferences.getHash().toString())
                    append("farm_id", farmId)
                })
            }
            response.readArray<Report>(gson, farmId, "reports")
        }
    }
}