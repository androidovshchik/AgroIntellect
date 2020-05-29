package ru.agrointellect.screen

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_wait.*
import ru.agrointellect.R

class WaitDialog(activity: Activity) : Dialog(activity, R.style.AppDialog) {

    init {
        setCancelable(false)
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setDimAmount(0.2f)
        setContentView(R.layout.dialog_wait)
        pb_wait.indeterminateDrawable
            .setColorFilter(Color.parseColor("#2EC0D1"), PorterDuff.Mode.SRC_IN)
    }
}