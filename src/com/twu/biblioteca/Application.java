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
        console.print("Welcome to Bangalore Public Library");
        console.print("The Books in library as follow:");
        List<Book> books = bookRepository.getBooks();
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            console.print(String.format("%d. %s", i + 1, book.toString()));
        }
    }
}
