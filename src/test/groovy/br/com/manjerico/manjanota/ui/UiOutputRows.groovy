package br.com.manjerico.manjanota.ui

class UiOutputRows {

    static String header() {
        return  "╔═════════════╤══════════════════╤══════════════════════════════════╗\n" +
                "║Identificador│CNPJ              │Razão Social                      ║\n" +
                "╟─────────────┼──────────────────┼──────────────────────────────────╢\n"
    }

    static String eventosCia() {
        "║1            │62.100.755/0001-15│Eventos & Cia                     ║\n"
    }

    static String divider() {
        "╟─────────────┼──────────────────┼──────────────────────────────────╢\n"
    }

    static String petrobras() {
        "║2            │78.865.726/0001-84│Petrobras - Petróleo Brasileiro SA║\n"
    }

    static String finalRow() {
        "╚═════════════╧══════════════════╧══════════════════════════════════╝\n"
    }

    static String tableWithEventosCiaAndPetrobras() {
        header() + eventosCia() + divider() + petrobras() + finalRow()
    }
}
