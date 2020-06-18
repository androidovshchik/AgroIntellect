package ru.agrointellect.extension

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import kotlin.math.max
import kotlin.math.min

fun XSSFSheet.setCellValue(x: Int, y: Int, value: String?) {
    val row = getRow(y) ?: createRow(y)
    val cell = row.getCell(x) ?: row.createCell(x)
    cell.setCellValue(value.orEmpty())
}

fun XSSFSheet.adjustWidth() {
    var x = 0
    while (true) {
        var y = 0
        var row: XSSFRow? = getRow(y) ?: break
        var count = 0
        do {
            val cell = row?.getCell(x)
            if (cell != null) {
                count = max(count, cell.toString().length)
            } else {
                count = -1
                break
            }
            y++
            row = getRow(y)
        } while (row != null)
        if (count > 0) {
            setColumnWidth(x, min(255, count) * 256)
        } else if (count < 0) {
            break
        }
        x++
    }
}