package ru.agrointellect.screen.main

import android.app.Activity
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.recyclical.datasource.dataSourceTypedOf
import com.afollestad.recyclical.setup
import com.afollestad.recyclical.withItem
import com.thekhaeng.recyclerviewmargin.LayoutMarginDecoration
import io.github.inflationx.calligraphy3.CalligraphyUtils
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_farms.*
import kotlinx.android.synthetic.main.item_farm.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.dip
import org.kodein.di.generic.instance
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.local.Preferences
import ru.agrointellect.remote.dto.Farm
import ru.agrointellect.remote.dto.Farms
import ru.agrointellect.screen.base.BaseFragment

class FarmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val circle: ImageView = itemView.iv_circle
    val name: TextView = itemView.tv_name
}

class FarmsFragment : BaseFragment() {

    private val client by instance<HttpClient>()

    private val preferences by instance<Preferences>()

    private val dataSource = dataSourceTypedOf<Farm>()

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите ферму"
        }
        return inflater.inflate(R.layout.fragment_farms, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val context = requireContext()
        val space = context.dip(20)
        val assets = context.assets
        val lightFont = Typeface.createFromAsset(assets, "font/Ubuntu-Light.ttf")
        val regularFont = Typeface.createFromAsset(assets, "font/Ubuntu-Regular.ttf")
        sl_farms.setOnRefreshListener {
            loadFarms()
        }
        rv_farms.apply {
            setHasFixedSize(true)
            addItemDecoration(LayoutMarginDecoration(2, space).also {
                it.setPadding(this, space)
            })
            setup {
                withDataSource(dataSource)
                withItem<Farm, FarmHolder>(R.layout.item_farm) {
                    onBind(::FarmHolder) { _, item ->
                        val circleSize = if (item.checked) {
                            CalligraphyUtils.applyFontToTextView(name, regularFont)
                            circle.setBackgroundResource(R.drawable.ring_farm)
                            circle.setImageResource(R.drawable.ic_daw)
                            resources.getDimensionPixelSize(R.dimen.image_farm_max)
                        } else {
                            CalligraphyUtils.applyFontToTextView(name, lightFont)
                            circle.setBackgroundResource(R.drawable.circle_farm)
                            circle.setImageResource(0)
                            resources.getDimensionPixelSize(R.dimen.image_farm_min)
                        }
                        circle.updateLayoutParams<ViewGroup.LayoutParams> {
                            width = circleSize
                            height = circleSize
                        }
                        name.text = item.name
                    }
                    onClick {
                        dataSource.forEach {
                            it.checked = false
                        }
                        item.checked = true
                        dataSource.invalidateAll()
                    }
                }
            }
        }
        waitDialog.show()
        loadFarms()
    }

    override fun showError(e: Throwable) {
        super.showError(e)
        sl_farms.isRefreshing = false
    }

    private fun loadFarms() {
        job.cancelChildren()
        launch {
            val data = withContext(Dispatchers.IO) {
                client.post<Farms>(BuildConfig.API_URL) {
                    body = FormDataContent(Parameters.build {
                        append("uid", preferences.hash.toString())
                    })
                }
            }
            dataSource.clear()
            dataSource.addAll(data.farms)
            dataSource.invalidateAll()
            waitDialog.hide()
            sl_farms.isRefreshing = false
        }
    }
}