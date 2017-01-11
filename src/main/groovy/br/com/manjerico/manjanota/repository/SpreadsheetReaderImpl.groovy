package br.com.manjerico.manjanota.repository

import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SpreadsheetReaderImpl implements SpreadsheetReader {

    private SpreadsheetProvider provider

    @Autowired
    SpreadsheetReaderImpl(SpreadsheetProvider provider) {
        this.provider = provider
    }

    @Override
    List readWorksheet(String worksheetName) {

        List maps = []

        new PoiExcelReader(provider.spreadsheetPath).eachLine([labels: true, sheet: worksheetName]) { List<String> headers, Row row ->
            if (headers && row) {
                maps << [
                        (headers[0]): row.getCell(0).toString(),
                        (headers[1]): row.getCell(1).toString(),
                        (headers[2]): row.getCell(2).toString(),
                        (headers[3]): row.getCell(3).toString(),
                        (headers[4]): new DataFormatter().formatCellValue(row.getCell(4)),
                        (headers[5]): row.getCell(5)?.toString(),
                        (headers[6]): row.getCell(6).toString(),
                        (headers[7]): row.getCell(7).toString(),
                        (headers[8]): row.getCell(8).toString(),
                        (headers[9]): new DataFormatter().formatCellValue(row.getCell(9)),
                        (headers[10]): row.getCell(10).toString(),
                ]
            }
        }

        return maps
    }
}
