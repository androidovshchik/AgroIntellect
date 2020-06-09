package ru.agrointellect.screen.chart

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.util.AttributeSet
import com.google.android.material.switchmaterial.SwitchMaterial
import ru.agrointellect.R

class SwitchButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.switchStyle
) : SwitchMaterial(context, attrs, defStyleAttr) {

    private var programmatically = false

    var color = Color.WHITE

    var isCheckedProgrammatically: Boolean
        get() = programmatically
        set(value) {
            programmatically = true
            changeColor(value)
            super.setChecked(value)
        }

    override fun setChecked(checked: Boolean) {
        programmatically = false
        changeColor(checked)
        super.setChecked(checked)
    }

    @Suppress("DEPRECATION")
    private fun changeColor(checked: Boolean) {
        thumbDrawable?.setColorFilter(if (checked) color else Color.WHITE, PorterDuff.Mode.MULTIPLY)
    }

    override fun hasOverlappingRendering() = false
}