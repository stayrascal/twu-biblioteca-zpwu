package com.twu.biblioteca.option;

import com.twu.biblioteca.Application;

public class QuitOption extends Option {

    public QuitOption(String id, String name) {
        super(id, name);
    }

    @Override
    public void execute(Application app) {
        app.exit();
    }
}
