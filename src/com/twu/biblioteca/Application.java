package com.twu.biblioteca;

import com.twu.biblioteca.option.Option;

import java.util.List;
import java.util.Set;

public class Application {

    private Console console;
    private BookList bookList;
    private BookRepository bookRepository;
    private Set<Book> customerBooks;
    private List<Option> menu;
    private Boolean flag = Boolean.TRUE;

    public Application(Console console, BookList bookList, BookRepository bookRepository, Set<Book> customerBooks, List<Option> menu) {
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
        while (flag) {
            displayMenusInfo();
            validateInput(console.nextInt());
        }
    }

    public void validateInput(int input) {
        boolean isValid = false;
        for (Option option : menu) {
            if (option.getId().equals(input)) {
                isValid = true;
                option.execute(this);
            }
        }
        if (!isValid) {
            console.print("Please select a valid option!");
        }
    }

    public void displayMenusInfo() {
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

    public void disPlayAvailableBooks() {
        console.print("which book do you want check out:");
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            console.print(bookStock.getBook().toString());
        }
        checkoutBook(console.nextInt());
    }

    public void checkoutBook(int isbn) {
        boolean isValid = false;
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            if (bookStock.getBook().getIsbn().equals(isbn)) {
                isValid = true;
                bookStock.checkoutOne();
                customerBooks.add(bookStock.getBook());
                console.print("Thank you! Enjoy the book!");
            }
        }
        if (!isValid) {
            console.print("That book is not available.");
        }
    }

    public void displayCanReturnBooks() {
        console.print("which book do you want return:");
        customerBooks.forEach(book -> console.print(book.toString()));
        returnBook(console.nextInt());
    }

    public void returnBook(int isbn) {
        boolean isValid = false;
        for (BookStock bookStock : bookRepository.getBooks()) {
            if (bookStock.getBook().getIsbn().equals(isbn)) {
                isValid = true;
                if (!customerBooks.remove(bookStock.getBook())) {
                    console.print("That is not a valid book to return.");
                }
                bookStock.returnOneBook();
                console.print("Thank you for returning the book.");
            }
        }
        if (!isValid) {
            console.print("That is not a valid book to return.");
        }
    }

    private void displayWelcomeMessage() {
        console.print("Welcome to Bangalore Public Library!");
    }

    public void exit() {
        flag = Boolean.FALSE;
        console.print("Thank you come to Bangalore Public Library, goodbye!");
    }
}
