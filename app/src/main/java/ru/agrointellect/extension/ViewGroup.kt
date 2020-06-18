package ru.agrointellect.extension

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.view.ViewGroup

fun ViewGroup.getBitmap(height: Int = getChildAt(0).height): Bitmap {
    val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    with(Canvas(bitmap)) {
        val background = background
        if (background != null) {
            background.draw(this)
        } else {
            drawColor(Color.WHITE)
        }
        draw(this)
    }
    return bitmap
}