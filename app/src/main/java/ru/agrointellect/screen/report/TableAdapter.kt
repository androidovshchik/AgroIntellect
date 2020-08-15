package ru.agrointellect.screen.report

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import io.github.inflationx.calligraphy3.CalligraphyUtils
import kotlinx.android.synthetic.main.item_column.view.*
import kotlinx.android.synthetic.main.item_row.view.*
import org.jetbrains.anko.layoutInflater
import ru.agrointellect.R
import ru.agrointellect.extension.setAll
import ru.agrointellect.remote.api.Column
import ru.agrointellect.remote.api.Row

class ColumnHolder(itemView: View) : GroupViewHolder(itemView) {

    val top: View? = itemView.v_top
    val name: TextView? = itemView.tv_name
    val arrow: ImageView? = itemView.iv_arrow

    override fun expand() {
        arrow?.setImageResource(R.drawable.ic_arrow_up)
    }

    override fun collapse() {
        arrow?.setImageResource(R.drawable.ic_arrow_down)
    }
}

class RowHolder(itemView: View) : ChildViewHolder(itemView) {
    val key: TextView = itemView.tv_key
    val value: TextView = itemView.tv_value
}

class TableAdapter(context: Context) :
    ExpandableRecyclerViewAdapter<ColumnHolder, RowHolder>(mutableListOf<Column>()) {

    private val grayColor = ContextCompat.getColor(context, R.color.colorRowGray)

    private val regularFont = Typeface.createFromAsset(context.assets, "font/Ubuntu-Regular.ttf")

    private var singleHeader = false

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ColumnHolder {
        return ColumnHolder(
            parent.inflate(
                if (singleHeader) {
                    R.layout.item_dummy
                } else {
                    R.layout.item_column
                }
            )
        )
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(parent.inflate(R.layout.item_row))
    }

    override fun onBindGroupViewHolder(
        holder: ColumnHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        holder.apply {
            top?.isVisible = flatPosition > 0
            name?.text = group.title
            arrow?.setImageResource(
                if (isGroupExpanded(group)) {
                    R.drawable.ic_arrow_up
                } else {
                    R.drawable.ic_arrow_down
                }
            )
        }
    }

    override fun onBindChildViewHolder(
        holder: RowHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val row = group.items[childIndex] as Row
        holder.apply {
            if (row.isBold) {
                itemView.setBackgroundColor(Color.TRANSPARENT)
                key.text = CalligraphyUtils.applyTypefaceSpan(row.key, regularFont)
                value.text = CalligraphyUtils.applyTypefaceSpan(row.value, regularFont)
            } else {
                itemView.setBackgroundColor(if (childIndex % 2 != 0) grayColor else Color.TRANSPARENT)
                key.text = row.key
                value.text = row.value
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun setAll(columns: List<Column>) {
        (expandableList.groups as MutableList<Column>).setAll(columns)
        expandableList.expandedGroupIndexes = BooleanArray(columns.size)
        singleHeader = columns.size == 1
    }

    fun clear() {
        expandableList.groups.clear()
    }

    private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
        return context.layoutInflater.inflate(layout, this, false)
    }
}