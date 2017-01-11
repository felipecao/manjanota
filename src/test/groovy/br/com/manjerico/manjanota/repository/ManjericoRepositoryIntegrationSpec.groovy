package br.com.manjerico.manjanota.repository

import br.com.manjerico.manjanota.domain.Manjerico
import spock.lang.Specification

class ManjericoRepositoryIntegrationSpec extends Specification {

    private ManjericoRepository repository

    private SpreadsheetReader reader

    private SpreadsheetProvider provider

    def setup() {
        provider = Mock()
        reader = new SpreadsheetReaderImpl(provider)
        repository = null
    }

    def "empty spreadsheet has no Manjerico"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.emptySpreadsheet
        repository = new ManjericoRepositoryImpl(reader)

        when:
        Manjerico manjerico = repository.read()

        then:
        !manjerico
    }

    def "complete spreadsheet has Manjerico"() {
        given:
        provider.spreadsheetPath >> SpreadsheetPaths.spreadsheetWithTwoCustomers
        repository = new ManjericoRepositoryImpl(reader)

        when:
        Manjerico manjerico = repository.read()

        then:
        ManjericoMother.instance() == manjerico
    }

}
