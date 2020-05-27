package ru.agrointellect

import android.app.Application
import coil.Coil
import coil.ImageLoader
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

@Suppress("unused")
class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("font/Ubuntu-Light.ttf")
                            .setFontAttrId(R.attr.fontPath)
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