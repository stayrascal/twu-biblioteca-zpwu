package com.twu.biblioteca;


public class Menu {

    private final String id;
    private final String name;

    public Menu(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %s", getId(), getName());
    }
}
