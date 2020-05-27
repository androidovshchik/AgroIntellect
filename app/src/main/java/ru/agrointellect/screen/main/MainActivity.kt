package ru.agrointellect.screen.main

import android.content.res.Configuration
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.core.view.children
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
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(this, dl_main, toolbar, 0, 0)
        dl_main.addDrawerListener(toggle)
        toggle.syncState()
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Medium.ttf")
        toolbar.children.forEach {
            if (it is TextView) {
                CalligraphyUtils.applyFontToTextView(it, font)
            }
        }
    }

    private fun setupNavigation() {
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
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            nv_main.menu.findItem(R.id.action_exit).isVisible = true
            tv_exit.isVisible = false
        } else {
            tv_exit.setOnClickListener {

            }
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
