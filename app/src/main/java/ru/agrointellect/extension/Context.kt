@file:Suppress("unused")

package ru.agrointellect.extension

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaScannerConnection
import android.net.Uri

inline fun <reified T> Context.activityCallback(action: T.() -> Unit) {
    activity()?.let {
        if (it is T && !it.isFinishing) {
            action(it)
        }
    }
}

tailrec fun Context?.activity(): Activity? = when (this) {
    is Activity -> this
    else -> (this as? ContextWrapper)?.baseContext?.activity()
}

fun Context.areGranted(vararg permissions: String): Boolean {
    for (permission in permissions) {
        if (checkCallingOrSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
            return false
        }
    }
    return true
}

@Suppress("DEPRECATION")
fun Context.scanFile(path: String) {
    sendBroadcast(Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).apply {
        data = Uri.parse("file://$path")
    })
    MediaScannerConnection.scanFile(applicationContext, arrayOf(path), null, null)
}