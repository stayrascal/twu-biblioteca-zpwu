package com.twu.biblioteca;

import java.util.List;

import com.twu.biblioteca.option.Option;

public class Application {

    private ConsolePrinter console;
    private BookList bookList;
    private BookRepository bookRepository;
    private List<Option> menu;

    public Application(ConsolePrinter console, BookList bookList, BookRepository bookRepository, List<Option> menu) {
        this.console = console;
        this.bookList = bookList;
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
        for (Book book : bookList.getBooks()) {
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
        console.print("which book do you want check out:");
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            console.print(bookStock.getBook().toString());
        }
    }

    public void displayCanReturnBooks() {
    }
}
