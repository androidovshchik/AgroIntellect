package ru.agrointellect.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import io.ktor.client.HttpClient
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.agrointellect.BuildConfig
import timber.log.Timber

class NetworkLogger : Logger {

    override fun log(message: String) {
        Timber.tag("API").d(message)
    }
}

val remoteModule = Kodein.Module("remote") {

    bind<Gson>() with provider {
        GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .setLenient()
            .create()
    }

    bind<HttpClient>() with singleton {
        HttpClient {
            if (BuildConfig.DEBUG) {
                install(Logging) {
                    logger = NetworkLogger()
                    level = LogLevel.ALL
                }
            }
            install(JsonFeature) {
                serializer = GsonSerializer {
                    excludeFieldsWithoutExposeAnnotation()
                    setLenient()
                }
            }
        }
    }
}