package com.twu.biblioteca;


import com.twu.biblioteca.option.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = new BookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 1)), bookList);

        Console console = new Console(new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));

        User user = new User("xxx-xxxx", "name", "password", "email", "phone");
        UserCenter userCenter = new UserCenter(Collections.singletonList(user));

        CheckoutBookLog checkoutBookLog = new CheckoutBookLog(new HashMap<>(), new HashMap<>());

        Application app = new Application(userCenter, console, bookRepository, checkoutBookLog, user);

        app.startByMenu();
    }

}
