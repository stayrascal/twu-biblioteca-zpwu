package com.twu.biblioteca;


import com.twu.biblioteca.option.*;
import com.twu.biblioteca.role.Librarian;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = BookRepository.getBookRepository(asList(new BookStock(algebra, 2), new BookStock(computer, 1)), bookList);

        Console console = new Console(new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));

        User customer = new User("xxx-xxxx", "customer", "password", "email", "phone");
        User librarian = new User("xxx-xxx1", "librarian", "password", "email", "phone", new Librarian());
        UserCenter userCenter = new UserCenter(asList(customer, librarian));

        CheckoutBookLog checkoutBookLog = CheckoutBookLog.getCheckoutBookLog(new HashMap<>(), new HashMap<>());

        Application app = new Application(userCenter, console, bookRepository, null, checkoutBookLog);

        app.startByMenu();
    }

}
