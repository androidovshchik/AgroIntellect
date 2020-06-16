@file:Suppress("unused")

package ru.agrointellect.extension

import android.graphics.Bitmap
import timber.log.Timber

inline fun <T> Bitmap.use(block: Bitmap.() -> T): T {
    try {
        return block()
    } finally {
        try {
            recycle()
        } catch (e: Throwable) {
            Timber.e(e)
        }
    }
}