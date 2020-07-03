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
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import kotlinx.android.synthetic.main.fragment_farms.*
import kotlinx.android.synthetic.main.item_farm.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.dip
import ru.agrointellect.BuildConfig
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.extension.navigateExclusive
import ru.agrointellect.extension.readArray
import ru.agrointellect.extension.setAll
import ru.agrointellect.remote.dto.Farm

class FarmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val circle: ImageView = itemView.iv_circle
    val name: TextView = itemView.tv_name
}

class FarmsFragment : MainFragment() {

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
                        val circleSize = if (item.isSelected) {
                            name.text = CalligraphyUtils.applyTypefaceSpan(item.name, regularFont)
                            circle.setBackgroundResource(R.drawable.ring_farm)
                            circle.setImageResource(R.drawable.ic_daw)
                            resources.getDimensionPixelSize(R.dimen.image_farm_max)
                        } else {
                            name.text = item.name
                            circle.setBackgroundResource(R.drawable.circle_farm)
                            circle.setImageResource(0)
                            resources.getDimensionPixelSize(R.dimen.image_farm_min)
                        }
                        circle.updateLayoutParams<ViewGroup.LayoutParams> {
                            width = circleSize
                            height = circleSize
                        }
                    }
                    onClick { i ->
                        mainModel.reports.clear()
                        dataSource.toList().forEachIndexed { j, farm ->
                            if (i == j) {
                                farm.isSelected = true
                                dataSource.invalidateAt(i)
                            } else if (farm.isSelected) {
                                farm.isSelected = false
                                dataSource.invalidateAt(j)
                            }
                        }
                        navController.navigateExclusive(R.id.monitorFragment)
                    }
                }
            }
        }
        if (mainModel.farms.isNotEmpty()) {
            dataSource.setAll(mainModel.farms)
            dataSource.invalidateAll()
        } else {
            waitDialog.show()
            loadFarms()
        }
    }

    override fun showError(e: Throwable) {
        super.showError(e)
        sl_farms.isRefreshing = false
    }

    private fun loadFarms() {
        job.cancelChildren()
        launch {
            val data = withContext(Dispatchers.IO) {
                val response = client.post<HttpResponse>(BuildConfig.API_URL) {
                    body = FormDataContent(Parameters.build {
                        append("uid", preferences.getHash().toString())
                    })
                }
                response.readArray<Farm>(gson, "farms")
            }
            mainModel.farms.setAll(data)
            dataSource.setAll(data)
            dataSource.invalidateAll()
            waitDialog.dismiss()
            sl_farms.isRefreshing = false
        }
    }
}