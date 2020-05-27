package ru.agrointellect

import android.app.Application
import android.content.Context
import coil.Coil
import coil.ImageLoader
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import io.ktor.client.HttpClient
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import ru.agrointellect.local.localModule
import timber.log.Timber

class NetworkLogger : Logger {

    override fun log(message: String) {
        Timber.tag("API").d(message)
    }
}

@Suppress("unused")
class MainApp : Application(), KodeinAware {

    override val kodein by Kodein.lazy {

        bind<Context>() with provider {
            applicationContext
        }

        import(localModule)

        bind<HttpClient>() with singleton {
            HttpClient {
                if (BuildConfig.DEBUG) {
                    install(Logging) {
                        logger = NetworkLogger()
                        level = LogLevel.ALL
                    }
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("font/Ubuntu-Light.ttf")
                            .build()
                    )
                )
                .build()
        )
        Coil.setImageLoader(
            ImageLoader.Builder(applicationContext)
                .availableMemoryPercentage(0.5)
                .bitmapPoolPercentage(0.5)
                .build()
        )
    }
}