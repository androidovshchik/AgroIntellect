package ru.agrointellect.screen

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.forEach
import io.github.inflationx.calligraphy3.CalligraphyTypefaceSpan
import kotlinx.android.synthetic.main.activity_main.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, dl_main, toolbar, 0, 0)
        dl_main.addDrawerListener(toggle)
        toggle.syncState()
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Light.ttf")
        nv_main.menu.forEach {
            it.title = SpannableString(it.title).apply {
                setSpan(CalligraphyTypefaceSpan(font), 0, it.title.length, SPAN_INCLUSIVE_INCLUSIVE)
            }
        }
    }
}
