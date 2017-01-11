package br.com.manjerico.manjanota.ui

import br.com.manjerico.manjanota.domain.Customer
import br.com.manjerico.manjanota.domain.Manjerico
import br.com.manjerico.manjanota.repository.CustomerRepository
import br.com.manjerico.manjanota.repository.ManjericoRepository
import br.com.manjerico.manjanota.service.InvoiceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.core.CommandMarker
import org.springframework.shell.core.annotation.CliCommand
import org.springframework.shell.core.annotation.CliOption
import org.springframework.stereotype.Component

@Component
class UserInputHandler implements CommandMarker {

    private CustomerRepository customerRepository

    private InvoiceService invoiceService

    @Autowired
    UserInputHandler(CustomerRepository customerRepository, InvoiceService invoiceService) {
        this.customerRepository = customerRepository
        this.invoiceService = invoiceService
    }

    @CliCommand(value = "listar-clientes", help = "Listar todos os clientes disponíveis na base de dados Manjerico")
    String listCustomers() {

        List<Customer> allCustomers = customerRepository.findAll()

        if (!allCustomers) {
            return Messages.NO_CUSTOMERS.toString()
        }

        return UiTable.ofCustomers(allCustomers).toString()
    }

    @CliCommand(value = "gerar-nota-fiscal", help = "Gerar nota fiscal para um cliente a partir de seu identificador")
    String generateInvoiceForCustomer(@CliOption(key = "identificador", mandatory = true) Integer identifier) {

        Customer customer = customerRepository.findByIdentifier(identifier)

        if (!customer) {
            return Messages.NO_CUSTOMER_WITH_IDENTIFIER.toString()
        }

        invoiceService.generateInvoiceForCustomer(customer)

        return Messages.INVOICE_GENERATED.toString()
    }
}
