package ru.agrointellect.remote

import com.google.gson.*
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import okhttp3.logging.HttpLoggingInterceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.agrointellect.BuildConfig
import ru.agrointellect.extension.asNullableString
import ru.agrointellect.remote.api.RptHerdLactationGraph
import timber.log.Timber
import java.lang.reflect.Type

class LogInterceptor : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
        Timber.tag("API").d(message)
    }
}

class LactationGraphDeserializer : JsonDeserializer<RptHerdLactationGraph> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): RptHerdLactationGraph {
        val rptObject = RptHerdLactationGraph()
        json.asJsonObject.entrySet().forEach {
            when (it.key) {
                "lactation_days" -> rptObject.lactationDays = it.value.asString
                "average_lactation_daily_milk" -> rptObject.averageLactationDailyMilk =
                    it.value.asNullableString
                "lactation_1_daily_milk" -> rptObject.lactation1DailyMilk =
                    it.value.asNullableString
                "lactation_2_daily_milk" -> rptObject.lactation2DailyMilk =
                    it.value.asNullableString
                "lactation_over_2_daily_milk" -> rptObject.lactationOver2DailyMilk =
                    it.value.asNullableString
                else -> rptObject.sampleLactations[it.key] = it.value.asNullableString
            }
        }
        return rptObject
    }
}

val remoteModule = Kodein.Module("remote") {

    bind<Gson>() with provider {
        GsonBuilder()
            .registerTypeAdapter(RptHerdLactationGraph::class.java, LactationGraphDeserializer())
            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()
    }

    bind<HttpClient>() with singleton {
        HttpClient(OkHttp) {
            engine {
                if (BuildConfig.DEBUG) {
                    addInterceptor(
                        HttpLoggingInterceptor(LogInterceptor())
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                }
            }
            install(JsonFeature) {
                serializer = GsonSerializer {
                    registerTypeAdapter(
                        RptHerdLactationGraph::class.java,
                        LactationGraphDeserializer()
                    )
                    excludeFieldsWithoutExposeAnnotation()
                    setLenient()
                }
            }
        }
    }
}