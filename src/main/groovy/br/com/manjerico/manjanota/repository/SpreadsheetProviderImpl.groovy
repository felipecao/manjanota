package br.com.manjerico.manjanota.repository

import org.springframework.stereotype.Component

import java.nio.file.Path
import java.nio.file.Paths

@Component
class SpreadsheetProviderImpl implements SpreadsheetProvider {

    @Override
    Path getSpreadsheetPath() {
        return Paths.get("manjanotas.xlsx")
    }
}
