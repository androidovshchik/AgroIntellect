package ru.agrointellect.remote.dto

import android.os.Parcel
import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

interface Table {

    val columns: List<Column>
}

class Column(title: String, items: List<Row>) : ExpandableGroup<Row>(title, items)

class Row(key: String, val value: String) : Parcelable {

    val key = when (key) {
        "average" -> "Средние показатели"
        "summary" -> "Суммарные показатели"
        else -> key
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {}

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Row> {

        override fun createFromParcel(parcel: Parcel): Row? {
            return null
        }

        override fun newArray(size: Int): Array<Row>? {
            return null
        }
    }
}