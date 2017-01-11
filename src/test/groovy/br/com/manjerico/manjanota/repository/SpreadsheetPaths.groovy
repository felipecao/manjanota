package br.com.manjerico.manjanota.repository

import java.nio.file.Path
import java.nio.file.Paths

class SpreadsheetPaths {

    static Path getEmptySpreadsheet() {
        Paths.get("src", "test", "resources", "manjanotas-empty.xlsx")
    }

    static Path getSpreadsheetWithOneCustomer() {
        Paths.get("src", "test", "resources", "manjanotas-one-customer.xlsx")
    }

    static Path getSpreadsheetWithTwoCustomers() {
        Paths.get("src", "test", "resources", "manjanotas-two-customers.xlsx")
    }

}
