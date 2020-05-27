package ru.agrointellect.screen.main

import android.content.res.Configuration
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import androidx.core.view.isVisible
import coil.api.load
import coil.transform.CircleCropTransformation
import io.github.inflationx.calligraphy3.CalligraphyUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_header.view.*
import ru.agrointellect.R
import ru.agrointellect.screen.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar()
        setupNavigation()
        tv_exit.setOnClickListener {

        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        tv_exit.isVisible = !landscape
        val exitItem = nv_main.menu.findItem(R.id.action_exit)
        exitItem.isVisible = landscape
        if (landscape) {
            val spannable = SpannableString(exitItem.title).apply {
                val foreground = ForegroundColorSpan(Color.parseColor("#2EC0D1"))
                setSpan(foreground, 0, exitItem.title.length, SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            exitItem.title = spannable
        }
    }

    override fun setTitle(title: CharSequence?) {
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Medium.ttf")
        super.setTitle(CalligraphyUtils.applyTypefaceSpan(title, font))
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, dl_main, toolbar, 0, 0)
        dl_main.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = false
        toggle.setHomeAsUpIndicator(R.drawable.ic_hamburger)
        toggle.setToolbarNavigationClickListener {
            dl_main.openDrawer(GravityCompat.START)
        }
    }

    private fun setupNavigation() {
        dl_main.setScrimColor(Color.parseColor("#33000000"))
        val header = nv_main.getHeaderView(0)
        header.ib_close.setOnClickListener {
            dl_main.closeDrawers()
        }
        header.fab_avatar.load(R.mipmap.ic_launcher_round) {
            transformations(CircleCropTransformation())
        }
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Light.ttf")
        nv_main.menu.forEach {
            it.title = CalligraphyUtils.applyTypefaceSpan(it.title, font)
        }
        nv_main.itemIconTintList = null
    }

    override fun onBackPressed() {
        if (dl_main.isDrawerOpen(GravityCompat.START)) {
            dl_main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed();
        }
    }
}
