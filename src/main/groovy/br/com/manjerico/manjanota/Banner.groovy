package br.com.manjerico.manjanota

import org.springframework.core.annotation.Order
import org.springframework.shell.plugin.BannerProvider
import org.springframework.stereotype.Component

@Component
@Order(Integer.MIN_VALUE)
class Banner implements BannerProvider {

    @Override
    String getBanner() {
        // criado com http://patorjk.com/software/taag/#p=display&f=Big%20Money-ne&t=Manjanota
        return " /\$\$      /\$\$                                                         /\$\$              \n" +
                "| \$\$\$    /\$\$\$                                                        | \$\$              \n" +
                "| \$\$\$\$  /\$\$\$\$  /\$\$\$\$\$\$  /\$\$\$\$\$\$\$  /\$\$  /\$\$\$\$\$\$  /\$\$\$\$\$\$\$   /\$\$\$\$\$\$  /\$\$\$\$\$\$    /\$\$\$\$\$\$ \n" +
                "| \$\$ \$\$/\$\$ \$\$ |____  \$\$| \$\$__  \$\$|__/ |____  \$\$| \$\$__  \$\$ /\$\$__  \$\$|_  \$\$_/   |____  \$\$\n" +
                "| \$\$  \$\$\$| \$\$  /\$\$\$\$\$\$\$| \$\$  \\ \$\$ /\$\$  /\$\$\$\$\$\$\$| \$\$  \\ \$\$| \$\$  \\ \$\$  | \$\$      /\$\$\$\$\$\$\$\n" +
                "| \$\$\\  \$ | \$\$ /\$\$__  \$\$| \$\$  | \$\$| \$\$ /\$\$__  \$\$| \$\$  | \$\$| \$\$  | \$\$  | \$\$ /\$\$ /\$\$__  \$\$\n" +
                "| \$\$ \\/  | \$\$|  \$\$\$\$\$\$\$| \$\$  | \$\$| \$\$|  \$\$\$\$\$\$\$| \$\$  | \$\$|  \$\$\$\$\$\$/  |  \$\$\$\$/|  \$\$\$\$\$\$\$\n" +
                "|__/     |__/ \\_______/|__/  |__/| \$\$ \\_______/|__/  |__/ \\______/    \\___/   \\_______/\n" +
                "                            /\$\$  | \$\$                                                  \n" +
                "                           |  \$\$\$\$\$\$/                                                  \n" +
                "                            \\______/                                                   "
    }

    @Override
    String getVersion() {
        return "1.0"
    }

    @Override
    String getWelcomeMessage() {
        return "Vamos gerar umas notas?"
    }

    @Override
    String getProviderName() {
        return "Manjerico Corp"
    }
}
