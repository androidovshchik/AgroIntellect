package ru.agrointellect.screen

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity
import ru.agrointellect.screen.main.MainActivity

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mb_login.setOnClickListener {
            startActivity<MainActivity>()
        }
    }
}
