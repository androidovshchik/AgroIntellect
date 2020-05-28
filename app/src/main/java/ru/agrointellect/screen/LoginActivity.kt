package ru.agrointellect.screen

import android.os.Bundle
import android.util.Patterns
import com.chibatching.kotpref.bulk
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.startActivity
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.readJson
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Farms
import ru.agrointellect.screen.base.BaseActivity
import ru.agrointellect.screen.main.MainActivity

class LoginActivity : BaseActivity() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val gson by instance<Gson>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (preferences.getHash() != null) {
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
            waitDialog.show()
            job.cancelChildren()
            launch {
                val data = withContext(Dispatchers.IO) {
                    val response = client.post<HttpResponse>(BuildConfig.API_URL) {
                        body = FormDataContent(Parameters.build {
                            append("uid", preferences.getHash(email, pwd).orEmpty())
                        })
                    }
                    response.readJson<Farms>(gson)
                }
                preferences.bulk {
                    login = email
                    password = pwd
                }
                startActivity<MainActivity>("farms" to data.farms)
                finish()
            }
        }
    }
}
