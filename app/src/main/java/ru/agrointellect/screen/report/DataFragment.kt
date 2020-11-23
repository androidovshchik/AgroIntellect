package ru.agrointellect.screen.report

import android.Manifest
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.core.content.FileProvider
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import io.ktor.client.*
import org.jetbrains.anko.dip
import org.kodein.di.generic.instance
import ru.agrointellect.extension.areGranted
import ru.agrointellect.local.FileManager
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.api.Period
import ru.agrointellect.screen.base.BaseFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

abstract class DataFragment : BaseFragment() {

    protected val client by instance<HttpClient>()

    protected val preferences by instance<Preferences>()

    protected val gson by instance<Gson>()

    protected val fileManager by instance<FileManager>()

    protected abstract val reportModel: ReportModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (reportModel.getDesc().datesCount == 1) {
            reportModel.dateTo = Calendar.getInstance().apply {
                add(Calendar.DAY_OF_MONTH, -1)
            }.time
        }
        reportModel.period = when (reportModel.getDesc().period) {
            Period.NONE -> null
            Period.TOTAL -> "total"
            Period.NO_DAY -> "week"
            else -> "day"
        }
    }

    protected fun checkPermissions(): Boolean {
        if (context?.areGranted(Manifest.permission.WRITE_EXTERNAL_STORAGE) == false) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_WRITE
            )
            return false
        }
        return true
    }

    protected fun shareFile(file: File) = activity?.run {
        if (!file.exists()) {
            showMessage("Файл не найден")
            return@run
        }
        ShareCompat.IntentBuilder
            .from(this)
            .setType(
                when (file.extension) {
                    "png", "jpg" -> "image/*"
                    else -> "application/vnd.ms-excel"
                }
            )
            .addStream(
                FileProvider.getUriForFile(
                    applicationContext,
                    "$packageName.file_provider",
                    file
                )
            )
            .apply {
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            .setChooserTitle("Поделиться файлом")
            .startChooser()
    }

    protected fun showMessage(message: String) {
        Snackbar.make(view ?: return, message, Snackbar.LENGTH_LONG).apply {
            view.translationY = -context.dip(70f).toFloat()
            show()
        }
    }

    protected fun TextView.updateDates() {
        val dateTo = userFormatter.format(reportModel.dateTo ?: return)
        text = if (reportModel.getDesc().datesCount > 1) {
            val dateFrom = userFormatter.format(reportModel.dateFrom ?: return)
            "Даты: $dateFrom – $dateTo"
        } else {
            "Дата: $dateTo"
        }
    }

    companion object {

        const val REQUEST_WRITE = 120

        val apiFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        private val userFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
    }
}