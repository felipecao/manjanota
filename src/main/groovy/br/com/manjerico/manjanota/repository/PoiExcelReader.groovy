package br.com.manjerico.manjanota.repository

import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.hssf.usermodel.HSSFSheet
import org.apache.poi.hssf.usermodel.HSSFRow
import org.apache.poi.hssf.usermodel.HSSFCell
import org.apache.poi.hssf.usermodel.HSSFDateUtil
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import java.nio.file.Path

/**
 * Groovy Builder that extracts data from
 * Microsoft Excel spreadsheets.
 * @author Goran Ehrsson
 * @see http://www.technipelago.se/blog/show/groovy-poi-excel
 */
class PoiExcelReader {

    Workbook workbook
    def labels
    def row

    PoiExcelReader(Path pathToFile) {
        HSSFRow.metaClass.getAt = {int idx ->
            def cell = delegate.getCell(idx)
            if(! cell) {
                return null
            }
            def value
            switch(cell.cellType) {
                case HSSFCell.CELL_TYPE_NUMERIC:
                    if(HSSFDateUtil.isCellDateFormatted(cell)) {
                        value = cell.dateCellValue
                    } else {
                        value = cell.numericCellValue
                    }
                    break
                case HSSFCell.CELL_TYPE_BOOLEAN:
                    value = cell.booleanCellValue
                    break
                default:
                    value = cell.stringCellValue
                    break
            }
            return value
        }

        pathToFile.withInputStream{is->
            workbook = new XSSFWorkbook(is)
        }
    }

    def eachLine(Map params = [:], Closure closure) {
        def offset = params.offset ?: 0
        def max = params.max ?: 9999999
        def sheet = workbook.getSheet(params.sheet)

        if (!sheet) {
            closure.call([], null)
            return ;
        }

        def rowIterator = sheet.rowIterator()
        def linesRead = 0

        if(params.labels) {
            labels = rowIterator.next().collect{it.toString()}
        }

        offset.times{ rowIterator.next() }

        closure.setDelegate(this)

        while(rowIterator.hasNext() && linesRead++ < max) {
            row = rowIterator.next()
            closure.call(labels, row)
        }
    }
}