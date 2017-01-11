package br.com.manjerico.manjanota.repository

import java.nio.file.Path

interface SpreadsheetProvider {
    Path getSpreadsheetPath()
}
