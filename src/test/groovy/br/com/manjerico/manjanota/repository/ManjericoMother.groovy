package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Manjerico

class ManjericoMother {

    static Manjerico instance() {
        new Manjerico(
                cnpj: "06.828.467/0001-00",
                razaoSocial: "Manjerico Corp SA",
                endereco: "Rua Itacuruçá",
                numero: 26,
                complemento: "Apto 212",
                bairro: "Tijuca",
                cidade: "Rio de Janeiro",
                estado: "RJ",
                cep: "20510150",
                telefone: "(21) 2135-1448",
                email: "manjerico@manjerico.com.br"
        )
    }
}
