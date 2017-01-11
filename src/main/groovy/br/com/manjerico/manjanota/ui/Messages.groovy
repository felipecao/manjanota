package br.com.manjerico.manjanota.ui

enum Messages {

    NO_CUSTOMERS("Não há clientes na base de dados")

    private String text

    private Messages(String text) {
        this.text = text
    }


    @Override
    public String toString() {
        text
    }
}
