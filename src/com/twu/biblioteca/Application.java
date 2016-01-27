package com.twu.biblioteca;

import java.util.List;

public class Application {

    private ConsolePrinter console;
    private BookRepository bookRepository;

    public Application(ConsolePrinter console, BookRepository bookRepository) {
        this.console = console;
        this.bookRepository = bookRepository;
    }

    public void start() {
        displayWelcomeMessage();
        displayBookListInfo();
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
}
