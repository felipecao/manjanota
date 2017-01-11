package br.com.manjerico.manjanota.repository

import spock.lang.Specification

class CustomerRepositoryIntegrationSpec extends Specification {

    private CustomerRepository customerRepository

    private SpreadsheetProvider provider

    private SpreadsheetReader reader

    def setup() {
        provider = Mock()
        reader = new SpreadsheetReaderImpl(provider)
        customerRepository = null
    }

    def "findAll returns empty collection for empty spreadsheet"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.emptySpreadsheet
        customerRepository = new CustomerRepositoryImpl(reader)

        when:
        def customers = customerRepository.findAll()

        then:
        !customers
    }

    def "findAll returns collection of one customer for spreadsheet with one customer"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithOneCustomer
        customerRepository = new CustomerRepositoryImpl(reader)

        when:
        def customers = customerRepository.findAll()

        then:
        [CustomerMother.eventosCia()] == customers
    }

    def "findAll returns collection of two customers for spreadsheet with two customers"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers
        customerRepository = new CustomerRepositoryImpl(reader)

        when:
        def customers = customerRepository.findAll()

        then:
        [CustomerMother.eventosCia(), CustomerMother.petrobras()] == customers
    }

    def "findByIdentifier returns Eventos & Cia"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers
        customerRepository = new CustomerRepositoryImpl(reader)

        when:
        def customer = customerRepository.findByIdentifier(CustomerMother.eventosCia().identificador)

        then:
        CustomerMother.eventosCia() == customer
    }

    def "findByIdentifier returns nothing"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers
        customerRepository = new CustomerRepositoryImpl(reader)

        when:
        def customer = customerRepository.findByIdentifier(1001)

        then:
        !customer
    }

}
