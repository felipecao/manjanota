package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Customer

class CustomerMother {

    static Map EVENTOS_CIA = [
            "Identificador": "1.0",
            "Razão Social": "Eventos & Cia",
            "CNPJ": "62.100.755/0001-15",
            "Endereço": "Rua Presidente Kennedy",
            "Número": "57",
            "Complemento": "Casa 05",
            "Bairro": "Cônego",
            "Cidade": "Nova Friburgo",
            "Estado": "RJ",
            "CEP": "28621000",
            "Telefone": "(22) 2522-5120"
    ]

    static Map PETROBRAS = [
            "Identificador": "2.0",
            "Razão Social": "Petrobras - Petróleo Brasileiro SA",
            "CNPJ": "78.865.726/0001-84",
            "Endereço": "Avenida República do Chile",
            "Número": "65",
            "Complemento": null,
            "Bairro": "Centro",
            "Cidade": "Rio de Janeiro",
            "Estado": "RJ",
            "CEP": "20031912",
            "Telefone": "(22) 2513-0056"
    ]

    static Customer eventosCia() {
        new Customer(
                identificador: Double.valueOf(EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.identificador]).intValue(),
                cnpj: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cnpj],
                razaoSocial: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.razaoSocial],
                endereco: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.endereco],
                numero: Integer.valueOf(EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.numero]),
                complemento: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.complemento],
                bairro: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.bairro],
                cidade: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cidade],
                estado: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.estado],
                cep: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cep],
                telefone: EVENTOS_CIA[CustomerRepositoryImpl.SPREADSHEET_HEADERS.telefone],
        )
    }

    static Customer petrobras() {
        new Customer(
                identificador: Double.valueOf(PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.identificador]).intValue(),
                cnpj: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cnpj],
                razaoSocial: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.razaoSocial],
                endereco: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.endereco],
                numero: Integer.valueOf(PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.numero]),
                complemento: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.complemento],
                bairro: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.bairro],
                cidade: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cidade],
                estado: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.estado],
                cep: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.cep],
                telefone: PETROBRAS[CustomerRepositoryImpl.SPREADSHEET_HEADERS.telefone],
        )
    }
}
