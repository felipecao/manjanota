package br.com.manjerico.manjanota.domain

import groovy.transform.EqualsAndHashCode
import groovy.transform.Immutable
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
@Immutable
class Manjerico {
    String cnpj
    String razaoSocial
    String endereco
    Integer numero
    String complemento
    String bairro
    String cidade
    String estado
    String cep
}
