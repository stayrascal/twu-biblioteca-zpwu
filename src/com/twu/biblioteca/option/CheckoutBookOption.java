package com.twu.biblioteca.option;

import com.twu.biblioteca.Application;

public class CheckoutBookOption extends Option {

    public CheckoutBookOption(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.disPlayAvailableBooks();
    }
}
