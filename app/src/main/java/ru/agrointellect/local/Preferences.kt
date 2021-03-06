package ru.agrointellect.local

import android.content.Context
import com.chibatching.kotpref.KotprefModel
import org.apache.commons.codec.binary.Base32
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils

class Preferences(context: Context) : KotprefModel(context) {

    override val kotprefName = "${context.packageName}_preferences"

    var login by nullableStringPref(null, "login")

    var password by nullableStringPref(null, "password")

    fun getHash(email: String? = null, pwd: String? = null): String? {
        val login = email ?: login ?: return null
        val password = pwd ?: password ?: return null
        return String(Hex.encodeHex(DigestUtils.sha512("$login$p$password")))
    }

    @Suppress("SpellCheckingInspection")
    companion object {

        /**
         * Encoded: +@p+
         */
        private val p = Base32().decode("FNAHAKY=").toString(Charsets.UTF_8)
    }
}