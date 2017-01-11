package br.com.manjerico.manjanota.service

import br.com.manjerico.manjanota.domain.Customer

interface InvoiceService {

    void generateInvoiceForCustomer(Customer customer)

}