package ru.agrointellect.screen.base

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import ru.agrointellect.R

open class BaseDialog(activity: Activity) : Dialog(activity, R.style.AppDialog), KodeinAware {

    override val kodein by closestKodein()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.setDimAmount(0.2f)
    }
}