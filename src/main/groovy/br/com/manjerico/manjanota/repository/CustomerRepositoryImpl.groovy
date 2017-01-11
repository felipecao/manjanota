package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerRepositoryImpl implements CustomerRepository {

    static final String CUSTOMERS_WORKSHEET = "Clientes"

    static final Map SPREADSHEET_HEADERS = [
            identificador: "Identificador",
            razaoSocial: "Razão Social",
            cnpj: "CNPJ",
            endereco: "Endereço",
            complemento: "Complemento",
            bairro: "Bairro",
            numero: "Número",
            cidade: "Cidade",
            estado: "Estado",
            cep: "CEP",
            telefone: "Telefone"
    ]

    private Customers customers

    @Autowired
    CustomerRepositoryImpl(SpreadsheetReader spreadsheetReader) {
        customers = new Customers(spreadsheetReader.readWorksheet(CUSTOMERS_WORKSHEET).collect {
            new Customer(
                    identificador: Double.valueOf(it[SPREADSHEET_HEADERS.identificador]).intValue(),
                    razaoSocial: it[SPREADSHEET_HEADERS.razaoSocial],
                    cnpj: it[SPREADSHEET_HEADERS.cnpj],
                    endereco: it[SPREADSHEET_HEADERS.endereco],
                    numero: Integer.valueOf(it[SPREADSHEET_HEADERS.numero]),
                    complemento: it[SPREADSHEET_HEADERS.complemento] == "null" ? "" : it[SPREADSHEET_HEADERS.complemento],
                    bairro: it[SPREADSHEET_HEADERS.bairro],
                    cidade: it[SPREADSHEET_HEADERS.cidade],
                    estado: it[SPREADSHEET_HEADERS.estado],
                    cep: it[SPREADSHEET_HEADERS.cep],
                    telefone: it[SPREADSHEET_HEADERS.telefone],
            )
        })
    }

    @Override
    List<Customer> findAll() {
        return customers.findAll()
    }

    @Override
    Customer findByIdentifier(Integer identifier) {
        return customers.findByIdentifier(identifier)
    }
}
