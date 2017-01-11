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
            cidade: "Cidade",
            estado: "Estado"
    ]

    private SpreadsheetReader spreadsheetReader

    @Autowired
    CustomerRepositoryImpl(SpreadsheetReader spreadsheetReader) {
        this.spreadsheetReader = spreadsheetReader
    }

    @Override
    List<Customer> findAll() {
        return spreadsheetReader.readWorksheet(CUSTOMERS_WORKSHEET).collect {
            new Customer(
                    identificador: Double.valueOf(it[SPREADSHEET_HEADERS.identificador]).intValue(),
                    razaoSocial: it[SPREADSHEET_HEADERS.razaoSocial],
                    cnpj: it[SPREADSHEET_HEADERS.cnpj],
                    endereco: it[SPREADSHEET_HEADERS.endereco],
                    cidade: it[SPREADSHEET_HEADERS.cidade],
                    estado: it[SPREADSHEET_HEADERS.estado]
            )
        }
    }
}
