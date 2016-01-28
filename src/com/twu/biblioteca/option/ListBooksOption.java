package com.twu.biblioteca.option;


import com.twu.biblioteca.Application;

public class ListBooksOption extends Option {

    public ListBooksOption(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.displayBookListInfo();
    }
}
