package br.com.manjerico.manjanota.repository

import spock.lang.Specification

class CustomerRepositoryIntegrationSpec extends Specification {

    private CustomerRepository customerRepository

    private SpreadsheetProvider provider

    private SpreadsheetReader reader

    def setup() {
        provider = Mock()
        reader = new SpreadsheetReaderImpl(provider)
        customerRepository = new CustomerRepositoryImpl(reader)
    }

    def "findAll returns empty collection for empty spreadsheet"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.emptySpreadsheet

        when:
        def customers = customerRepository.findAll()

        then:
        !customers
    }

    def "findAll returns collection of one customer for spreadsheet with one customer"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithOneCustomer

        when:
        def customers = customerRepository.findAll()

        then:
        [CustomerMother.eventosCia()] == customers
    }

    def "findAll returns collection of two customers for spreadsheet with two customers"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers

        when:
        def customers = customerRepository.findAll()

        then:
        [CustomerMother.eventosCia(), CustomerMother.petrobras()] == customers
    }

}
