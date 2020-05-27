package ru.agrointellect.screen

import android.os.Bundle
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
