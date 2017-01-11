package br.com.manjerico.manjanota.ui

import br.com.manjerico.manjanota.repository.CustomerMother
import br.com.manjerico.manjanota.repository.CustomerRepository
import spock.lang.Specification

class InputReaderSpec extends Specification {

    private InputReader inputReader

    private CustomerRepository customerRepository

    String commandOutput

    def setup() {
        customerRepository = Mock()
        inputReader = new InputReader(customerRepository)
    }

    void "if there are no customers, nothing is presented"() {
        given:
        customerRepository.findAll() >> []

        when:
        commandOutput = inputReader.listCustomers()

        then:
        Messages.NO_CUSTOMERS.toString() == commandOutput
    }

    void "if there are customers, they're all presented"() {
        given:
        customerRepository.findAll() >> [CustomerMother.eventosCia(), CustomerMother.petrobras()]

        when:
        commandOutput = inputReader.listCustomers()

        then:
        UiOutputRows.tableWithEventosCiaAndPetrobras() == commandOutput
    }

}
