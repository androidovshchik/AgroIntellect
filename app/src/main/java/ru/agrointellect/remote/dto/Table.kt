package ru.agrointellect.remote.dto

import android.os.Parcel
import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

/**
 * From YYYY-MM-DD
 * To DD.MM.YYYY
 */
fun formatDate(date: String): String {
    val first = date.indexOf("-")
    val second = date.indexOf("-", first + 1)
    if (first > 0 && second > 0) {
        return "${date.substring(second + 1)}.${date.substring(first + 1, second)}.${date.substring(
            0,
            first
        )}"
    }
    return date
}

interface Table {

    val columns: List<Column>
}

class Column(title: String, items: List<Row>) : ExpandableGroup<Row>(title, items)

class Row(key: String, value: String?) : Parcelable {

    var bold = false

    val key = when (key) {
        "average" -> {
            bold = true
            "Средние показатели"
        }
        "summary" -> {
            bold = true
            "Суммарные показатели"
        }
        else -> key
    }

    val value = value ?: "0"

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
