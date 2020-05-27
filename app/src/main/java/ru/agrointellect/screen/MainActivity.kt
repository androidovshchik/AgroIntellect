package ru.agrointellect.screen

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import coil.api.load
import coil.transform.CircleCropTransformation
import io.github.inflationx.calligraphy3.CalligraphyTypefaceSpan
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header.view.*
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
        val header = nv_main.getHeaderView(0)
        header.fab_avatar.load(R.mipmap.ic_launcher_round) {
            transformations(CircleCropTransformation())
        }
        header.ib_close.setOnClickListener {
            dl_main.closeDrawers()
        }
        tv_exit.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        if (dl_main.isDrawerOpen(GravityCompat.START)) {
            dl_main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed();
        }
    }
}
