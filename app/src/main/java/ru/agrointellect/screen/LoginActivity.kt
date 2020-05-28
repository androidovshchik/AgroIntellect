package ru.agrointellect.screen

import android.os.Bundle
import android.util.Patterns
import com.chibatching.kotpref.bulk
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.startActivity
import org.kodein.di.generic.instance
import ru.agrointellect.R
import ru.agrointellect.local.Preferences
import ru.agrointellect.screen.base.BaseActivity
import ru.agrointellect.screen.main.MainActivity

class LoginActivity : BaseActivity() {

    private val preferences by instance<Preferences>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (preferences.hash != null) {
            startActivity<MainActivity>()
            finish()
            return
        }
        setContentView(R.layout.activity_login)
        mb_login.setOnClickListener {
            val email = et_login.text.toString().trim().ifEmpty {
                contentView?.longSnackbar("Заполните логин (e-mail)")
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                contentView?.longSnackbar("Невалидный логин (e-mail)")
                return@setOnClickListener
            }
            val pwd = et_password.text.toString().trim().ifEmpty {
                contentView?.longSnackbar("Заполните пароль")
                return@setOnClickListener
            }
            preferences.bulk {
                login = email
                password = pwd
            }
            startActivity<MainActivity>()
            finish()
        }
    }
}
