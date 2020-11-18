package ru.agrointellect.remote.api

import android.os.Parcelable
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import kotlinx.android.parcel.Parcelize
import ru.agrointellect.extension.orZero

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

fun newRow(key: String, value: String?): Row {
    var isBold = false
    val newKey = when (key) {
        "average" -> {
            isBold = true
            "Средние показатели"
        }
        "summary" -> {
            isBold = true
            "Суммарные показатели"
        }
        else -> {
            if (key.equals("Итого", true)) {
                isBold = true
            }
            key
        }
    }
    return Row(newKey, value.orZero(), isBold)
}

interface Table {

    val columns: List<Column>
}

class Column(title: String, items: List<Row>) : ExpandableGroup<Row>(title, items)

@Parcelize
class Row(
    var key: String,
    val value: String,
    var isBold: Boolean
) : Parcelable