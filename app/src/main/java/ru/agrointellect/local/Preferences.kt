package ru.agrointellect.local

import android.content.Context
import com.chibatching.kotpref.KotprefModel
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

class Preferences(context: Context) : KotprefModel(context) {

    override val kotprefName = "${context.packageName}_preferences"

    var login by nullableStringPref(null, "login")

    var password by nullableStringPref(null, "password")

    val hash: String?
        get() {
            val login = login ?: return null
            val password = password ?: return null
            return String(Hex.encodeHex(DigestUtils.sha512("$login+@p+$password")))
        }
}