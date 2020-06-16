package ru.agrointellect.extension

import org.apache.poi.xssf.usermodel.XSSFSheet

fun XSSFSheet.setCellValue(x: Int, y: Int, value: String?) {
    val row = getRow(y) ?: createRow(y)
    val cell = row.getCell(x) ?: row.createCell(x)
    cell.setCellValue(value.orEmpty())
}