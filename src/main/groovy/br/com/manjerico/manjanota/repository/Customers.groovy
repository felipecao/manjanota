package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Customer

class Customers {
    private List<Customers> allCustomers

    Customers(List<Customers> allCustomers) {
        this.allCustomers = allCustomers
    }

    List<Customer> findAll() {
        return new ArrayList<Customer>(allCustomers)
    }

    Customer findByIdentifier(Integer identifier) {
        return allCustomers.find { it.identificador == identifier }
    }
}
