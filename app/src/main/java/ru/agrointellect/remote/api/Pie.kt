package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class PieBackEntry(value: Float, label: String?) : PieEntry(value, label) {

    var isVisible = true

    var backY = value
}

class PieBackDataSet(yVals: List<PieBackEntry>, label: String?) : PieDataSet(yVals, label) {

    fun setEntryVisible(i: Int, visible: Boolean) {
        (getEntryForIndex(i) as PieBackEntry).isVisible = visible
        mValues.forEach {
            it.y = if ((it as PieBackEntry).isVisible) it.backY else 0f
        }
        notifyDataSetChanged()
    }

    override fun getEntryIndex(e: PieEntry?) = mValues.indexOf(e)
}