package br.com.manjerico.manjanota.ui

import br.com.manjerico.manjanota.domain.Customer
import br.com.manjerico.manjanota.repository.CustomerMother
import br.com.manjerico.manjanota.repository.CustomerRepository
import br.com.manjerico.manjanota.repository.ManjericoRepository
import br.com.manjerico.manjanota.service.InvoiceService
import spock.lang.Specification

class UserInputHandlerSpec extends Specification {

    private UserInputHandler inputReader

    private CustomerRepository customerRepository

    private InvoiceService invoiceService

    String commandOutput

    def setup() {
        customerRepository = Mock()
        invoiceService = Mock()
        inputReader = new UserInputHandler(customerRepository, invoiceService)
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

    void "if customer does not exist, invoice is not generated"() {
        given:
        Integer identifier = 1

        and:
        customerRepository.findByIdentifier(identifier) >> null

        when:
        commandOutput = inputReader.generateInvoiceForCustomer(identifier)

        then:
        Messages.NO_CUSTOMER_WITH_IDENTIFIER.toString() == commandOutput
        0 * invoiceService.generateInvoiceForCustomer(_ as Customer)
    }

    void "if customer exists, invoice is generated"() {
        given:
        Integer identifier = 1

        and:
        customerRepository.findByIdentifier(identifier) >> CustomerMother.eventosCia()

        when:
        commandOutput = inputReader.generateInvoiceForCustomer(identifier)

        then:
        Messages.INVOICE_GENERATED.toString() == commandOutput
        1 * invoiceService.generateInvoiceForCustomer(CustomerMother.eventosCia())
    }

}
