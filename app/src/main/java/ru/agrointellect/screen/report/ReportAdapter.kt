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

class HeaderHolder(itemView: View) : GroupViewHolder(itemView) {
}

class RowHolder(itemView: View) : ChildViewHolder(itemView) {
}

class ReportAdapter(groups: List<ExpandableGroup<*>>) :
    ExpandableRecyclerViewAdapter<HeaderHolder, RowHolder>(groups) {

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): HeaderHolder {
        return HeaderHolder(parent.inflate(R.layout.item_header))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        return RowHolder(parent.inflate(R.layout.item_row))
    }

    override fun onBindGroupViewHolder(
        holder: HeaderHolder,
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