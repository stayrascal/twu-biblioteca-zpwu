package com.twu.biblioteca;

import java.util.Map;

public class Application {

    private ConsolePrinter console;
    private BookRepository bookRepository;
    private Map<String, Menu> menuMap;

    public Application(ConsolePrinter console, BookRepository bookRepository, Map<String, Menu> menuMap) {
        this.console = console;
        this.bookRepository = bookRepository;
        this.menuMap = menuMap;
    }

    public void start() {
        displayWelcomeMessage();
        displayBookListInfo();
    }

    public void startByMenu() {
        displayWelcomeMessage();
        displayMenusInfo();
    }

    private void displayMenusInfo() {
        console.print("Please choose options as follow:");
        for (Menu menu : menuMap.values()) {
            console.print(menu.toString());
        }
    }

    private void displayBookListInfo() {
        console.print("The Books in library as follow:");
        for (Book book : bookRepository.getBooks()) {
            console.print(book.toString());
        }
    }

    private void displayWelcomeMessage() {
        console.print("Welcome to Bangalore Public Library");
    }

    public void validateInput(String command) {
        for (String key : menuMap.keySet()) {
            if (key.equals(command)) {
                excute(command);
            }
        }
        console.print("Please select a valid option!");
    }

    private void excute(String command) {
    }
}
