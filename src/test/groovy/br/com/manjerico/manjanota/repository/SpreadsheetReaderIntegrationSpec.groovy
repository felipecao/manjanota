package br.com.manjerico.manjanota.repository

import spock.lang.Specification

class SpreadsheetReaderIntegrationSpec extends Specification {

    private SpreadsheetProvider provider

    private SpreadsheetReader reader

    def setup() {
        provider = Mock()
        reader = new SpreadsheetReaderImpl(provider)
    }

    def "readWorksheet returns empty array for empty spreadsheet"() {
        when:
        def spreadsheetContents = reader.readCustomersWorksheet()

        then:
        !spreadsheetContents
        1 * provider.spreadsheetPath >> SpreadsheetPaths.emptySpreadsheet
    }

    def "readWorksheet returns array with one entry for spreadsheet with one line"() {
        when:
        def spreadsheetContents = reader.readCustomersWorksheet()

        then:
        [CustomerMother.EVENTOS_CIA] == spreadsheetContents
        1 * provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithOneCustomer
    }

    def "readWorksheet returns array with two entries for spreadsheet with two lines"() {
        when:
        def spreadsheetContents = reader.readCustomersWorksheet()

        then:
        [CustomerMother.EVENTOS_CIA, CustomerMother.PETROBRAS] == spreadsheetContents
        1 * provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers
    }

}
