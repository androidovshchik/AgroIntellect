package ru.agrointellect.screen.base

import android.content.Context
import android.graphics.Typeface
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import io.github.inflationx.calligraphy3.CalligraphyUtils
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.coroutines.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.longSnackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import ru.agrointellect.screen.WaitDialog
import timber.log.Timber

@Suppress("MemberVisibilityCanBePrivate")
abstract class BaseActivity : AppCompatActivity(), KodeinAware, CoroutineScope {

    override val kodein by closestKodein()

    protected val job = SupervisorJob()

    private val waitDelegate = lazy {
        WaitDialog(this)
    }
    protected val waitDialog by waitDelegate

    override fun setTitle(title: CharSequence?) {
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Medium.ttf")
        super.setTitle(CalligraphyUtils.applyTypefaceSpan(title, font))
    }

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

    protected open fun showError(e: Throwable) {
        waitDialog.dismiss()
        contentView?.longSnackbar(e.message ?: e.toString())
    }

    override fun onDestroy() {
        if (waitDelegate.isInitialized()) {
            waitDialog.dismiss()
        }
        job.cancelChildren()
        super.onDestroy()
    }

    override val coroutineContext = Dispatchers.Main + job + CoroutineExceptionHandler { _, e ->
        Timber.e(e)
        if (e !is CancellationException && !isFinishing) {
            runOnUiThread {
                showError(e)
            }
        }
    }
}