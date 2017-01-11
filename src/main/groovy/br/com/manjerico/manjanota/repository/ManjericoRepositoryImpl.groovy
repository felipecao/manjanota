package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Manjerico
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ManjericoRepositoryImpl implements ManjericoRepository {

    private SpreadsheetReader spreadsheetReader

    @Autowired
    ManjericoRepositoryImpl(SpreadsheetReader spreadsheetReader) {
        this.spreadsheetReader = spreadsheetReader
    }

    @Override
    Manjerico read() {
        def entries = spreadsheetReader.readManjericoWorksheet().collect {
            new Manjerico(
                    razaoSocial: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.razaoSocial],
                    cnpj: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cnpj],
                    endereco: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.endereco],
                    numero: Integer.valueOf(it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.numero]),
                    complemento: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.complemento] == "null" ? "" : it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.complemento],
                    bairro: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.bairro],
                    cidade: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cidade],
                    estado: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.estado],
                    cep: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cep],
                    telefone: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.telefone],
                    email: it[CustomerRepositoryImpl.SPREADSHEET_HEADERS.email],
            )
        }

        return entries.isEmpty() ? null : entries.first()
    }
}
