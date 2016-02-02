package com.twu.biblioteca.option;

import com.twu.biblioteca.Application;

public class ShouCheckoutBook extends Option {

    public ShouCheckoutBook(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.showCheckoutBookForLibrian();
    }
}
