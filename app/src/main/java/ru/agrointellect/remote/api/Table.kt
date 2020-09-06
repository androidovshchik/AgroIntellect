package ru.agrointellect.remote.api

import android.os.Parcel
import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

/**
 * From YYYY-MM-DD
 * To DD.MM.YYYY
 */
fun formatDate(date: String?): String {
    val first = date?.indexOf("-") ?: return "-"
    val second = date.indexOf("-", first + 1)
    if (first > 0 && second > 0) {
        val dd = date.substring(second + 1)
        val mm = date.substring(first + 1, second)
        val yyyy = date.substring(0, first)
        return "$dd.$mm.$yyyy"
    }
    return date
}

fun formatDateZero(date: String): String {
    return formatDate(date).substringAfterLast("00.")
}

interface Table {

    val columns: List<Column>
}

class Column(title: String, items: List<Row>) : ExpandableGroup<Row>(title, items)

class Row(key: String, value: String?) : Parcelable {

    var isBold = false

    val key = when (key) {
        "average" -> {
            isBold = true
            "Средние показатели"
        }
        "summary" -> {
            isBold = true
            "Суммарные показатели"
        }
        else -> key
    }

    val value = value ?: "0"

    override fun writeToParcel(dest: Parcel, flags: Int) {}

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Row> {

        override fun createFromParcel(parcel: Parcel) = null

        override fun newArray(size: Int) = null
    }
}
