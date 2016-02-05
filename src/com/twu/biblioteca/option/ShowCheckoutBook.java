package com.twu.biblioteca.option;

import com.twu.biblioteca.Application;

public class ShowCheckoutBook extends Option {

    public ShowCheckoutBook(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.displayCheckoutBookForLibrarian();
    }
}
