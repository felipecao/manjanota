package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Customer

class CustomerMother {

    static Map EVENTOS_CIA = [
            "Razão Social": "Eventos & Cia",
            "CNPJ": "62.100.755/0001-15",
            "Endereço": "Rua Presidente Kennedy, 57",
            "Cidade": "Nova Friburgo",
            "Estado": "RJ"
    ]

    static Map PETROBRAS = [
            "Razão Social": "Petrobras - Petróleo Brasileiro SA",
            "CNPJ": "78.865.726/0001-84",
            "Endereço": "Avenida República do Chile, 51",
            "Cidade": "Rio de Janeiro",
            "Estado": "RJ"
    ]

    static Customer eventosCia() {
        new Customer(
                cnpj: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cnpj],
                razaoSocial: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.razaoSocial],
                endereco: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.endereco],
                cidade: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cidade],
                estado: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.estado]
        )
    }

    static Customer petrobras() {
        new Customer(
                cnpj: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cnpj],
                razaoSocial: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.razaoSocial],
                endereco: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.endereco],
                cidade: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cidade],
                estado: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.estado]
        )
    }
}
