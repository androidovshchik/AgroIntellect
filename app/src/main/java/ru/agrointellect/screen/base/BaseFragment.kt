package ru.agrointellect.screen.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.*
import org.jetbrains.anko.design.longSnackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.closestKodein
import ru.agrointellect.screen.WaitDialog
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseFragment : Fragment(), KodeinAware, CoroutineScope {

    override val kodein by closestKodein()

    protected val job = SupervisorJob()

    private val waitDelegate = lazy {
        WaitDialog(requireActivity())
    }
    protected val waitDialog by waitDelegate

    protected val args: Bundle
        get() = arguments ?: Bundle()

    protected open fun showError(e: Throwable) {
        waitDialog.dismiss()
        view?.longSnackbar(e.message ?: e.toString())
    }

    override fun onDestroyView() {
        if (waitDelegate.isInitialized()) {
            waitDialog.dismiss()
        }
        job.cancelChildren()
        super.onDestroyView()
    }

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        Timber.e(e)
        if (e !is CancellationException && view != null) {
            activity?.runOnUiThread {
                showError(e)
            }
        }
    }
}