package br.com.manjerico.manjanota

import org.springframework.shell.Bootstrap

import java.nio.file.Paths

class Main {
    static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", Paths.get(".").toAbsolutePath().normalize().toString() + "/chromedriver/2.27/chromedriver")
        Bootstrap.main(args)
    }
}
