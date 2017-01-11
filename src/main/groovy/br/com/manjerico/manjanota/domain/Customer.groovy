package br.com.manjerico.manjanota.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
@Immutable
class Customer {
    Integer identificador
    String cnpj
    String razaoSocial
    String endereco
    String cidade
    String estado
}
