package br.com.manjerico.manjanota.acceptance

import org.springframework.shell.Bootstrap
import org.springframework.shell.core.JLineShellComponent
import spock.lang.Specification

abstract class BaseAcceptanceTest extends Specification {

    private static JLineShellComponent shell

    def setupSpec() {
        Bootstrap bootstrap = new Bootstrap();
        shell = bootstrap.getJLineShellComponent();
    }

    def cleanupSpec() {
        shell.stop()
    }

    public static JLineShellComponent getShell() {
        return shell;
    }

}
