@file:Suppress("unused")

package ru.agrointellect.extension

import android.widget.EditText

fun EditText.setTextSelection(text: CharSequence?) {
    (text ?: "").let {
        setText(it)
        setSelection(it.length)
    }
}