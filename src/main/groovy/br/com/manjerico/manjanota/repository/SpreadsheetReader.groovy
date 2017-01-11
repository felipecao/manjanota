package br.com.manjerico.manjanota.repository

import java.nio.file.Path

interface SpreadsheetReader {
    List readWorksheet(String worksheetName)
}
