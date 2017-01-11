package br.com.manjerico.manjanota.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Customer {
    String cnpj
    String razaoSocial
    String endereco
    String cidade
    String estado
}
