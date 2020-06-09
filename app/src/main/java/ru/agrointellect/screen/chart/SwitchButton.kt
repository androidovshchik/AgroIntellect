package ru.agrointellect.screen.chart

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.switchmaterial.SwitchMaterial
import ru.agrointellect.R

class SwitchButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.switchStyle
) : SwitchMaterial(context, attrs, defStyleAttr) {

    var programmatically = false

    override fun setChecked(checked: Boolean) {
        programmatically = false
        super.setChecked(checked)
    }

    fun setCheckedProgrammatically(checked: Boolean) {
        programmatically = true
        super.setChecked(checked)
    }

    override fun hasOverlappingRendering() = false
}