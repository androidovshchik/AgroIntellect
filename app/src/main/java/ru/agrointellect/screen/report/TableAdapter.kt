package ru.agrointellect.screen.report

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import io.github.inflationx.calligraphy3.CalligraphyUtils
import kotlinx.android.synthetic.main.item_column.view.*
import kotlinx.android.synthetic.main.item_row.view.*
import org.jetbrains.anko.layoutInflater
import ru.agrointellect.R
import ru.agrointellect.remote.dto.Column
import ru.agrointellect.remote.dto.Row

class ColumnHeader(itemView: View) : GroupViewHolder(itemView) {

    val name: TextView = itemView.tv_name

    private val arrow: ImageView = itemView.iv_arrow

    override fun expand() {
        val rotate = RotateAnimation(360f, 180f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        arrow.animation = rotate
    }

    override fun collapse() {
        val rotate = RotateAnimation(180f, 360f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
        rotate.duration = 300
        rotate.fillAfter = true
        arrow.animation = rotate
    }
}

class RowHolder(itemView: View) : ChildViewHolder(itemView) {
    val key: TextView = itemView.tv_key
    val value: TextView = itemView.tv_value
}

/*class Decor : DividerItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        state.
    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        super.getItemOffsets(outRect, view, parent, state)
    }
}*/

class TableAdapter(context: Context) :
    ExpandableRecyclerViewAdapter<ColumnHeader, RowHolder>(emptyList()) {

    private val grayColor = ContextCompat.getColor(context, R.color.colorRowGray)

    private val regularFont = Typeface.createFromAsset(context.assets, "font/Ubuntu-Regular.ttf")

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ColumnHeader {
        return ColumnHeader(parent.inflate(R.layout.item_column))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(parent.inflate(R.layout.item_row))
    }

    override fun onBindGroupViewHolder(
        holder: ColumnHeader,
        flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        holder.name.text = group.title
    }

    override fun onBindChildViewHolder(
        holder: RowHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val row = group.items[childIndex] as Row
        holder.apply {
            if (row.bold) {
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

    fun setAll(groups: List<Column>) {
        expandableList.groups = groups
        expandableList.expandedGroupIndexes = BooleanArray(groups.size)
    }

    private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
        return context.layoutInflater.inflate(layout, this, false)
    }
}