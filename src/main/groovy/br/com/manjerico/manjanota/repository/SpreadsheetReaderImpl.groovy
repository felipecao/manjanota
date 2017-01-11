package br.com.manjerico.manjanota.repository

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
                        (headers[4]): row.getCell(4).toString(),
                        (headers[5]): row.getCell(5).toString()
                ]
            }
        }

        return maps
    }
}
