@file:Suppress("unused")

package ru.agrointellect.local

import android.content.Context
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream

@Suppress("MemberVisibilityCanBePrivate")
class FileManager(context: Context) {

    val externalDir: File? = context.getExternalFilesDir(null)?.apply { mkdirs() }

    val internalDir: File = context.filesDir

    fun getImageFile(name: String) = File(externalDir, "$name.jpg")

    fun getExcelFile(name: String) = File(externalDir, "$name.xlsx")
}

fun deleteFile(file: File?) {
    try {
        if (file?.isFile == true) {
            file.delete()
        }
    } catch (ignored: Throwable) {
    }
}

inline fun writeFile(dist: File, block: (FileOutputStream) -> Unit): Boolean {
    return try {
        FileOutputStream(dist).use { output ->
            block(output)
            output.flush()
        }
        true
    } catch (e: Throwable) {
        Timber.e(e)
        deleteFile(dist)
        false
    }
}