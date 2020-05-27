package ru.agrointellect.screen.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate", "DEPRECATION")
abstract class BaseFragment : Fragment(), KodeinAware, CoroutineScope {

    override val kodein by closestKodein()

    protected val job = SupervisorJob()

    private val waitDialogDelegate = lazy {
        requireContext().indeterminateProgressDialog(title = "Пожалуйста, подождите...")
    }
    protected val waitDialog by waitDialogDelegate

    protected val args: Bundle
        get() = arguments ?: Bundle()

    override fun onDestroyView() {
        if (waitDialogDelegate.isInitialized()) {
            waitDialog.dismiss()
        }
        job.cancelChildren()
        super.onDestroyView()
    }

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        Timber.e(e)
    }
}