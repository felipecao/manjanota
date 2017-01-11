package br.com.manjerico.manjanota.service

import br.com.manjerico.manjanota.domain.Customer
import geb.Browser
import org.springframework.stereotype.Component

@Component
class InvoiceServiceImpl implements InvoiceService {

    private static final String MEI = "1"
    public static final int DEFAULT_SLEEP_TIME_IN_MS = 1000

    @Override
    void generateInvoiceForCustomer(Customer customer) {
        Browser.drive {
            go "http://www4.fazenda.rj.gov.br/sefaz-dfe-nfae/paginas/identificacao.faces"

            $("#tipoRemetenteSelecionado").value(MEI)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteCNPJ").value(customer.cnpj)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteNomePessoa").value(customer.razaoSocial)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteCEP").value(customer.cep)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)
        }
    }
}
