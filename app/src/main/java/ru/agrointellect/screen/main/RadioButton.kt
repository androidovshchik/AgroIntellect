package ru.agrointellect.screen.main

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.radiobutton.MaterialRadioButton
import ru.agrointellect.R

class RadioButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.radioButtonStyle
) : MaterialRadioButton(context, attrs, defStyleAttr) {

    override fun toggle() {}

    fun setCheckedManually(checked: Boolean) {
        super.setChecked(checked)
        jumpDrawablesToCurrentState()
    }

    override fun hasOverlappingRendering() = false
}