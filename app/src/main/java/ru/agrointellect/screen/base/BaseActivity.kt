package ru.agrointellect.screen.base

import android.content.Context
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.coroutines.*
import org.jetbrains.anko.indeterminateProgressDialog
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate", "DEPRECATION")
abstract class BaseActivity : AppCompatActivity(), KodeinAware, CoroutineScope {

    override val kodein by closestKodein()

    protected val job = SupervisorJob()

    private val waitDialogDelegate = lazy {
        indeterminateProgressDialog(title = "Пожалуйста, подождите...")
    }
    protected val waitDialog by waitDialogDelegate

    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(context))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onDestroy() {
        if (waitDialogDelegate.isInitialized()) {
            waitDialog.dismiss()
        }
        job.cancelChildren()
        super.onDestroy()
    }

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        Timber.e(e)
    }
}