package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Customer

interface CustomerRepository {
    List<Customer> findAll()

    Customer findByIdentifier(Integer identifier)
}
