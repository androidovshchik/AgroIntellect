package ru.agrointellect.screen.report

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ShareCompat
import androidx.core.content.FileProvider
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import io.ktor.client.HttpClient
import org.jetbrains.anko.dip
import org.kodein.di.generic.instance
import ru.agrointellect.local.FileManager
import ru.agrointellect.local.Preferences
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
    }

    protected fun shareFile(file: File) = activity?.run {
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
        Snackbar.make(view ?: return, message, Snackbar.LENGTH_SHORT).apply {
            view.translationY = -context.dip(76f).toFloat()
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

        val apiFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

        private val userFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH)
    }
}