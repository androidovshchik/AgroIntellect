package ru.agrointellect.remote.api

import com.github.mikephil.charting.data.*
import ru.agrointellect.extension.asFloat
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

typealias GraphData = ChartData<*>

private val dateFormatter = SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).apply {
    timeZone = TimeZone.getTimeZone("UTC")
}

fun newEntry(date: String, value: String?): Entry? {
    return Entry(parseDate(date) ?: return null, value.asFloat)
}

fun newBarEntry(date: String, value: String?): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, value.asFloat)
}

fun newBarEntry(date: String, array: FloatArray): BarEntry? {
    return BarEntry(parseDate(date) ?: return null, array)
}

fun newPieEntry(value: String?): PieEntry {
    return PieEntry(value.asFloat, value)
}

/**
 * From YYYY-MM-DD
 * To Unix seconds
 */
private fun parseDate(date: String): Float? {
    return try {
        dateFormatter.parse(date)!!.time / 1000f
    } catch (ignored: Throwable) {
        null
    }
}

interface Graph {

    val legends: Collection<String>

    val data: GraphData
}

class PieBackupDataSet(yVals: List<PieEntry>, label: String?) : PieDataSet(yVals, label) {

    private val backup = mutableListOf<PieEntry>().apply { addAll(yVals) }

    private val pins = BooleanArray(yVals.size) { true }

    fun setEntryVisible(i: Int, visible: Boolean) {
        Timber.e("i $i visible $visible")
        pins[i] = visible
        mValues.clear()
        mValues.addAll(backup.filterIndexed { j, _ -> pins[j] })
        notifyDataSetChanged()
    }

    // todo does this is really needed?
    override fun getEntryIndex(e: PieEntry?) = mValues.indexOf(e)
}