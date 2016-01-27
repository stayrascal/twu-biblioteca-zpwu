package com.twu.biblioteca;


public class Menu {

    private final int id;
    private final String name;

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%d %s", getId(), getName());
    }
}
