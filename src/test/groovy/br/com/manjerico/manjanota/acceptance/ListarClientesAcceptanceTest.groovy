package br.com.manjerico.manjanota.acceptance

import br.com.manjerico.manjanota.ui.UiOutputRows
import org.springframework.shell.core.CommandResult

class ListarClientesAcceptanceTest extends BaseAcceptanceTest {

    CommandResult commandResult

    void "all customers are presented"() {
        when:
        commandResult = shell.executeCommand("listar-clientes")

        then:
        commandResult.success
        UiOutputRows.tableWithEventosCiaAndPetrobras() == commandResult.result
    }
}
