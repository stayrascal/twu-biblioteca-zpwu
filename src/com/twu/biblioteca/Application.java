package com.twu.biblioteca;

import java.util.List;

import com.twu.biblioteca.option.Option;

public class Application {

    private ConsolePrinter console;
    private BookRepository bookRepository;
    private List<Option> menu;

    public Application(ConsolePrinter console, BookRepository bookRepository, List<com.twu.biblioteca.option.Option> menu) {
        this.console = console;
        this.bookRepository = bookRepository;
        this.menu = menu;
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
        for (com.twu.biblioteca.option.Option option : menu) {
            console.print(option.toString());
        }
    }

    public void displayBookListInfo() {
        console.print("The Books in library as follow:");
        for (Book book : bookRepository.getBooks()) {
            console.print(book.toString());
        }
    }

    private void displayWelcomeMessage() {
        console.print("Welcome to Bangalore Public Library");
    }

    public void validateInput(String command) {
        for (Option option : menu) {
            if (option.getId().equals(command)) {
                option.execute(this);
            }
        }
        console.print("Please select a valid option!");
    }

    public void exit() {

    }

    public void disPlayAvailableBooks() {
    }

    public void displayCanReturnBooks() {
    }
}
