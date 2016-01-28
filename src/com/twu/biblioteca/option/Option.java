package com.twu.biblioteca.option;


import com.twu.biblioteca.Application;

public abstract class Option {

    protected final Integer id;
    protected final String name;

    public Option(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return String.format("%d %s", getId(), getName());
    }

    public abstract void execute(Application app);
}
