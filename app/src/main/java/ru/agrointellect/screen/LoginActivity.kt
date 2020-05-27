package ru.agrointellect.screen

import android.os.Bundle
import io.ktor.client.HttpClient
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.startActivity
import org.kodein.di.generic.instance
import ru.agrointellect.BASE_URL
import ru.agrointellect.R
import ru.agrointellect.local.Preferences
import ru.agrointellect.screen.base.BaseActivity
import ru.agrointellect.screen.main.MainActivity

class LoginActivity : BaseActivity() {

    private val preferences by instance<Preferences>()

    private val client by instance<HttpClient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (preferences.hash != null) {
            startActivity<MainActivity>()
            finish()
            return
        }
        setContentView(R.layout.activity_login)
        mb_login.setOnClickListener {
            startActivity<MainActivity>()
        }
        launch {
            withContext(Dispatchers.IO) {
                val data = client.post<String>(BASE_URL) {
                    parameter("name", "Andrei")
                }
            }
        }
    }
}
