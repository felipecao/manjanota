package br.com.manjerico.manjanota

import org.springframework.shell.core.CommandMarker
import org.springframework.shell.core.annotation.CliCommand
import org.springframework.stereotype.Component

@Component
class InputReader implements CommandMarker {

    @CliCommand(value = "listar")
    String listCustomers() {
        println("imprimindo")
        return "retornando"
    }
}
