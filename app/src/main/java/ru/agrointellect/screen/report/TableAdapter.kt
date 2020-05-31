package ru.agrointellect.screen.report

import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import org.jetbrains.anko.layoutInflater
import ru.agrointellect.R
import ru.agrointellect.remote.dto.Column

class ColumnHeader(itemView: View) : GroupViewHolder(itemView) {
}

class RowHolder(itemView: View) : ChildViewHolder(itemView) {
}

class TableAdapter(columns: List<Column>) :
    ExpandableRecyclerViewAdapter<ColumnHeader, RowHolder>(columns) {

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

    }

    override fun onBindChildViewHolder(
        holder: RowHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {

    }

    private fun ViewGroup.inflate(@LayoutRes layout: Int): View {
        return context.layoutInflater.inflate(layout, this, false)
    }
}