package com.twu.biblioteca.option;


import com.twu.biblioteca.Application;

public abstract class Option {

    protected final String id;
    protected final String name;

    public Option(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%s %s", getId(), getName());
    }

    public abstract void execute(Application app);
}
