package ru.agrointellect.screen

import android.app.Activity
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_wait.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseDialog

class WaitDialog(activity: Activity) : BaseDialog(activity) {

    init {
        setCancelable(false)
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_wait)
        pb_wait.indeterminateDrawable
            .setColorFilter(Color.parseColor("#2EC0D1"), PorterDuff.Mode.SRC_IN)
    }
}