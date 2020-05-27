package ru.agrointellect.screen

import android.app.Activity
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
import kotlinx.android.synthetic.main.fragment_farms.*
import kotlinx.android.synthetic.main.item_farm.view.*
import org.jetbrains.anko.dip
import ru.agrointellect.R
import ru.agrointellect.extension.activityCallback
import ru.agrointellect.model.Farm
import ru.agrointellect.screen.base.BaseFragment

class FarmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val circle: ImageView = itemView.iv_circle
    val name: TextView = itemView.tv_name
}

class FarmsFragment : BaseFragment() {

    private val dataSource = dataSourceTypedOf<Farm>(
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5"),
        Farm("Авангард\nКомплекс-5")
    )

    override fun onCreateView(inflater: LayoutInflater, root: ViewGroup?, bundle: Bundle?): View {
        context?.activityCallback<Activity> {
            title = "Выберите ферму"
        }
        return inflater.inflate(R.layout.fragment_farms, root, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val space = requireContext().dip(20)
        rv_farms.addItemDecoration(LayoutMarginDecoration(2, space).also {
            it.setPadding(rv_farms, space)
        })
        rv_farms.setup {
            withDataSource(dataSource)
            withItem<Farm, FarmHolder>(R.layout.item_farm) {
                onBind(::FarmHolder) { _, item ->
                    val circleSize = if (item.checked) {
                        circle.setBackgroundResource(R.drawable.ring_farm)
                        circle.setImageResource(R.drawable.ic_daw)
                        resources.getDimensionPixelSize(R.dimen.farm_max)
                    } else {
                        circle.setBackgroundResource(R.drawable.circle_farm)
                        circle.setImageResource(0)
                        resources.getDimensionPixelSize(R.dimen.farm_min)
                    }
                    circle.updateLayoutParams<ViewGroup.LayoutParams> {
                        height = circleSize
                        width = circleSize
                    }
                    name.text = item.name
                }
                onClick {
                    item.checked = true
                }
            }
        }
    }
}