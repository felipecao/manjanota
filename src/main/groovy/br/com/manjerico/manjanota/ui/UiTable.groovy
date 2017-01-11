package br.com.manjerico.manjanota.ui

import br.com.manjerico.manjanota.domain.Customer
import org.springframework.shell.table.BeanListTableModel
import org.springframework.shell.table.BorderStyle
import org.springframework.shell.table.TableBuilder

class UiTable {

    private static final int TABLE_WIDTH = 200

    private List<Customer> customers

    private UiTable(List<Customer> customers) {
        this.customers = customers
    }

    static UiTable ofCustomers(List<Customer> customers) {
        return new UiTable(customers)
    }

    @Override
    public String toString() {
        return new TableBuilder(
                new BeanListTableModel(customers, ["identificador": "Identificador", "cnpj": "CNPJ", "razaoSocial": "Razão Social"]))
                .addHeaderAndVerticalsBorders(BorderStyle.fancy_heavy)
                .addFullBorder(BorderStyle.fancy_double)
                .addInnerBorder(BorderStyle.fancy_light)
                .build()
                .render(TABLE_WIDTH);
    }
}
