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
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import coil.api.load
import coil.transform.CircleCropTransformation
import io.github.inflationx.calligraphy3.CalligraphyUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.include_toolbar.*
import kotlinx.android.synthetic.main.layout_header.view.*
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.contentView
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.newTask
import org.kodein.di.generic.instance
import ru.agrointellect.R
import ru.agrointellect.extension.navigateExclusive
import ru.agrointellect.extension.setAll
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.screen.LoginActivity
import ru.agrointellect.screen.base.BaseActivity

class MainActivity : BaseActivity() {

    private val preferences by instance<Preferences>()

    private lateinit var mainModel: MainModel

    private lateinit var navController: NavHostController

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainModel = ViewModelProvider(this).get(MainModel::class.java)
        if (intent.hasExtra("farms")) {
            mainModel.farms.setAll(intent.getSerializableExtra("farms") as List<Farm>)
        }
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this, R.id.f_host) as NavHostController
        setupToolbar()
        setupNavigation()
        tv_exit.setOnClickListener {
            logout()
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val landscape = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE
        tv_exit.isVisible = !landscape
        val exitItem = nv_main.menu.findItem(R.id.action_exit)
        exitItem.isVisible = landscape
        if (landscape) {
            exitItem.title = SpannableString(exitItem.title).apply {
                val foreground = ForegroundColorSpan(Color.parseColor("#2EC0D1"))
                setSpan(foreground, 0, exitItem.title.length, SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
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
        header.fab_avatar.load(R.drawable.avatar) {
            transformations(CircleCropTransformation())
        }
        header.tv_email.text = preferences.login
        nv_main.itemIconTintList = null
        val font = Typeface.createFromAsset(assets, "font/Ubuntu-Light.ttf")
        nv_main.menu.forEach {
            it.title = CalligraphyUtils.applyTypefaceSpan(it.title, font)
        }
        nv_main.setNavigationItemSelectedListener {
            dl_main.closeDrawers()
            when (it.itemId) {
                R.id.farmsFragment -> {
                    navController.navigateExclusive(it.itemId)
                }
                R.id.action_exit -> {
                    logout()
                }
                else -> {
                    if (mainModel.farm != null) {
                        navController.navigateExclusive(it.itemId)
                    } else {
                        contentView?.longSnackbar("Выберите ферму")
                        return@setNavigationItemSelectedListener false
                    }
                }
            }
            true
        }
    }

    private fun logout() {
        preferences.clear()
        startActivity(intentFor<LoginActivity>().newTask().clearTask())
    }

    override fun onBackPressed() {
        if (dl_main.isDrawerOpen(GravityCompat.START)) {
            dl_main.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            if (!isFinishing) {
                navController.currentDestination?.id?.let {
                    nv_main.setCheckedItem(it)
                }
            }
        }
    }
}
