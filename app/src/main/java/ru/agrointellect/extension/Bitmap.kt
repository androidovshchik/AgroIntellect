@file:Suppress("unused")

package ru.agrointellect.extension

import android.graphics.Bitmap

inline fun <T> Bitmap.use(block: Bitmap.() -> T): T {
    try {
        return block()
    } finally {
        try {
            recycle()
        } catch (ignored: Throwable) {
        }
    }
}