package br.com.manjerico.manjanota.ui

import br.com.manjerico.manjanota.domain.Customer
import br.com.manjerico.manjanota.repository.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.shell.core.CommandMarker
import org.springframework.shell.core.annotation.CliCommand
import org.springframework.stereotype.Component

@Component
class InputReader implements CommandMarker {

    private CustomerRepository customerRepository

    @Autowired
    InputReader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository
    }

    @CliCommand(value = "listar-clientes")
    String listCustomers() {

        List<Customer> allCustomers = customerRepository.findAll()

        if (!allCustomers) {
            return Messages.NO_CUSTOMERS.toString()
        }

        return UiTable.ofCustomers(allCustomers).toString()
    }
}
