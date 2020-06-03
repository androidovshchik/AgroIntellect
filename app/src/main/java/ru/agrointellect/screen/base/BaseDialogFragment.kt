@file:Suppress("DEPRECATION")

package ru.agrointellect.screen.base

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein

abstract class BaseDialogFragment : DialogFragment(), KodeinAware {

    override val kodein by closestKodein()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BaseDialog(requireActivity())
    }
}