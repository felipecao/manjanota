package br.com.manjerico.manjanota.ui

enum Messages {

    NO_CUSTOMERS("Não há clientes na base de dados"),
    NO_CUSTOMER_WITH_IDENTIFIER("Não existe cliente com identificador informado"),
    INVOICE_GENERATED("A nota fiscal foi preenchida, por favor confira os dados e confirme-a!"),

    private String text

    private Messages(String text) {
        this.text = text
    }


    @Override
    public String toString() {
        text
    }
}
