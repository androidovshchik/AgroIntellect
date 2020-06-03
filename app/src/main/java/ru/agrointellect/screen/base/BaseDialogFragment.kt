@file:Suppress("DEPRECATION")

package ru.agrointellect.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import org.jetbrains.anko.inputMethodManager
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

abstract class BaseDialogFragment : DialogFragment(), KodeinAware {

    override val kodein by closestKodein()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View? {
        dialog?.window?.apply {
            setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
            setDimAmount(0.2f)
        }
        return null
    }

    override fun dismiss() {
        context?.inputMethodManager?.hideSoftInputFromWindow(view?.windowToken, 0)
        super.dismiss()
    }
}