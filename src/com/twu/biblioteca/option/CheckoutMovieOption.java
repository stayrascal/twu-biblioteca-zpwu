package com.twu.biblioteca.option;

import com.twu.biblioteca.Application;

public class CheckoutMovieOption extends Option {

    public CheckoutMovieOption(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.displayAvailableMovieList();
    }
}
