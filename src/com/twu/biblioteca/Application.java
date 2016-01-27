package com.twu.biblioteca;

public class Application {

    private ConsolePrinter console;

    public Application(ConsolePrinter console) {
        this.console = console;
    }

    public void start() {
        console.print("Welcome to Bangalore Public Library");
    }
}
