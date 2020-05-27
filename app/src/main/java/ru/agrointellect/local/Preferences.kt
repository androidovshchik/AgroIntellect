package ru.agrointellect.local

import android.content.Context
import android.util.Base64
import com.chibatching.kotpref.KotprefModel
import java.security.MessageDigest

class Preferences(context: Context) : KotprefModel(context) {

    override val kotprefName = "${context.packageName}_preferences"

    var login by nullableStringPref(null, "login")

    var password by nullableStringPref(null, "password")

    fun getHash(): String {
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update("$login@p$password".toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(messageDigest.digest(), Base64.NO_WRAP)
    }
}