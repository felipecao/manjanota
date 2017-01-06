package br.com.manjerico.manjanota;

import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

/**
 * Created by felipe on 06/01/17.
 */
//@Component
public class JavaInputReader implements CommandMarker {

    @CliCommand(value = "felipe")
    public String doNothing() {
        System.out.println("oioioi");
        return "oi";
    }
}
