package ru.agrointellect.screen.report

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.item_column.view.*
import kotlinx.android.synthetic.main.item_row.view.*
import org.jetbrains.anko.layoutInflater
import ru.agrointellect.R
import ru.agrointellect.remote.dto.Column
import ru.agrointellect.remote.dto.Row

class ColumnHeader(itemView: View) : GroupViewHolder(itemView) {
    val name: TextView = itemView.tv_name
}

class RowHolder(itemView: View) : ChildViewHolder(itemView) {
    val key: TextView = itemView.tv_key
    val value: TextView = itemView.tv_value
}

class TableAdapter : ExpandableRecyclerViewAdapter<ColumnHeader, RowHolder>(emptyList()) {

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
        holder.key.text = row.key
        holder.value.text = row.value
    }

    fun setAll(groups: List<Column>) {
        expandableList.groups = groups
        expandableList.expandedGroupIndexes = BooleanArray(groups.size)
    }

    private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
        return context.layoutInflater.inflate(layout, this, false)
    }
}