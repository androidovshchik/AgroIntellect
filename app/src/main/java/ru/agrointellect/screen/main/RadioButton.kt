package ru.agrointellect.screen.main

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.radiobutton.MaterialRadioButton

class RadioButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = android.R.attr.radioButtonStyle
) : MaterialRadioButton(context, attrs, defStyleAttr) {

    override fun toggle() {}

    fun setChecked(checked: Boolean, animate: Boolean) {
        super.setChecked(checked)
        if (!animate) {
            jumpDrawablesToCurrentState()
        }
    }

    override fun hasOverlappingRendering() = false
}