package com.twu.biblioteca.option;


import com.twu.biblioteca.Application;

public class ReturnBookOption extends Option {

    public ReturnBookOption(String id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.displayCanReturnBooks();
    }
}
