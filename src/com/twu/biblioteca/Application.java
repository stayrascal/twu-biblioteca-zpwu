package com.twu.biblioteca;

import java.util.List;
import java.util.Set;

import com.twu.biblioteca.option.Option;

public class Application {

    private ConsolePrinter console;
    private BookList bookList;
    private BookRepository bookRepository;
    private Set<Book> customerBooks;
    private List<Option> menu;

    public Application(ConsolePrinter console, BookList bookList, BookRepository bookRepository, Set<Book> customerBooks, List<Option> menu) {
        this.console = console;
        this.bookList = bookList;
        this.bookRepository = bookRepository;
        this.customerBooks = customerBooks;
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
        menu.stream().filter(option -> option.getId().equals(command)).forEach(option -> option.execute(this));
        console.print("Please select a valid option!");
    }

    public void exit() {
        console.print("Thank you come to Bangalore Public Library, goodbye!");
    }

    public void disPlayAvailableBooks() {
        console.print("which book do you want check out:");
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            console.print(bookStock.getBook().toString());
        }
    }

    public void displayCanReturnBooks() {
        console.print("which book do you want return:");
        customerBooks.forEach(book -> console.print(book.toString()));
    }

    public void checkoutBook(int isbn) {
        bookRepository.getAvailableBooks().stream().filter(bookStock -> bookStock.getBook().getIsbn().equals(isbn)).forEach(bookStock -> {
            bookStock.checkoutOne();
            customerBooks.add(bookStock.getBook());
            console.print("Thank you! Enjoy the book!");
        });
        console.print("That book is not available.");
    }

    public void returnBook(int isbn) {
        bookRepository.getAvailableBooks().stream().filter(bookStock -> bookStock.getBook().getIsbn().equals(isbn)).forEach(bookStock -> {
            bookStock.returnOneBook();
            customerBooks.remove(bookStock.getBook());
            console.print("Thank you for returning the book.");
        });
        console.print("That is not a valid book to return.");
    }
}
