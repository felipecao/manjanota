package br.com.manjerico.manjanota.service

import br.com.manjerico.manjanota.domain.Customer
import br.com.manjerico.manjanota.domain.Manjerico
import br.com.manjerico.manjanota.repository.ManjericoRepository
import br.com.manjerico.manjanota.ui.Messages
import geb.Browser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class InvoiceServiceImpl implements InvoiceService {

    private static final String MEI = "1"
    private static final String OPERACAO_INTERNA = "1"

    public static final int DEFAULT_SLEEP_TIME_IN_MS = 1000

    private ManjericoRepository manjericoRepository

    @Autowired
    InvoiceServiceImpl(ManjericoRepository manjericoRepository) {
        this.manjericoRepository = manjericoRepository
    }

    @Override
    void generateInvoiceForCustomer(Customer customer) {

        Manjerico manjerico = manjericoRepository.read()

        if (!manjerico) {
            throw new IllegalStateException(Messages.NO_MANJERICO.toString())
        }

        Browser.drive {
            go "http://www4.fazenda.rj.gov.br/sefaz-dfe-nfae/paginas/identificacao.faces"

            $("#tipoRemetenteSelecionado").value(MEI)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteCNPJ").value(manjerico.cnpj)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteNomePessoa").value(manjerico.razaoSocial)

            $("#remetenteCEP").value(manjerico.cep)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $("#remetenteEmail").value(manjerico.email)
            $("#remetenteNumero").value(manjerico.numero)
            $("#remetenteConfirmarEmail").value(manjerico.email)
            $("#remetenteComplemento").value(manjerico.complemento)
            $("#remetenteTelefone").value(manjerico.telefone)
            $("#remetenteTipoOperacao").value(OPERACAO_INTERNA)
            sleep(DEFAULT_SLEEP_TIME_IN_MS)

            $('input[type=radio]').find {
                it.parent().parent().text().contains('Saída')
            }.click()

            sleep(DEFAULT_SLEEP_TIME_IN_MS)

//            $("#incluirProdutos").click()
        }
    }
}
