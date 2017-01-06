package br.com.manjerico.manjanota

import org.springframework.core.annotation.Order
import org.springframework.shell.plugin.PromptProvider
import org.springframework.stereotype.Component

@Component
@Order(Integer.MIN_VALUE)
class Prompt implements PromptProvider {

    @Override
    public String getPrompt() {
        return "manjanota>";
    }

    @Override
    public String getProviderName() {
        return "Manjerico";
    }
}
