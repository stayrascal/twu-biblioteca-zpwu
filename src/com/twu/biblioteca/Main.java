package com.twu.biblioteca;


import com.twu.biblioteca.option.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = new BookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 1)));

        Console console = new Console(new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));

        Set<Book> customerBooks = new TreeSet<>();
        List<Option> menu = main.initializeMenu();

        User user = new User("xxx-xxxx", "name", "password", "email", "phone");
        UserCenter userCenter = new UserCenter(Collections.singletonList(user));

        Application app = new Application(userCenter, console, bookList, bookRepository, customerBooks, menu);

        app.startByMenu();
    }

    private List<Option> initializeMenu() {
        ListBooksOption listBooks = new ListBooksOption(1, "List Books");
        CheckoutBookOption checkoutBook = new CheckoutBookOption(2, "Checkout Book");
        ReturnBookOption returnBook = new ReturnBookOption(3, "Return Book");
        QuitOption quit = new QuitOption(4, "Quit");
        return asList(listBooks, checkoutBook, returnBook, quit);
    }
}
