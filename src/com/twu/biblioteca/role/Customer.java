package com.twu.biblioteca.role;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.option.*;

import java.util.List;

import static java.util.Arrays.asList;

public class Customer implements Role {

    private List<Option> menu;

    public Customer() {
        this.menu = initializeMenu();
    }

    private List<Option> initializeMenu() {
        ListBooksOption listBooks = new ListBooksOption(1, "List Books");
        CheckoutBookOption checkoutBook = new CheckoutBookOption(2, "Checkout Book");
        ReturnBookOption returnBook = new ReturnBookOption(3, "Return Book");
        CheckoutMovieOption checkoutMovie = new CheckoutMovieOption(4, "Checkout Movie");
        QuitOption quit = new QuitOption(5, "Quit");
        return asList(listBooks, checkoutBook, returnBook, checkoutMovie, quit);
    }

    @Override
    public boolean addOption(Option option) {
        return menu.add(option);
    }

    @Override
    public String getName() {
        return "customer";
    }

    @Override
    public List<Option> getMenu() {
        return menu;
    }

    @Override
    public void displayMenu(Console console) {
        console.print("Please choose options as follow:");
        for (Option option : menu) {
            console.print(option.toString());
        }
    }
}
