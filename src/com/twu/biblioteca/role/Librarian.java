package com.twu.biblioteca.role;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.option.*;

import java.util.List;

import static java.util.Arrays.asList;

public class Librarian implements Role {

    private List<Option> menu;

    public Librarian() {
        this.menu = initializeMenu();
    }

    private List<Option> initializeMenu() {
        ListBooksOption listBooks = new ListBooksOption(1, "List Books");
        CheckoutBookOption checkoutBook = new CheckoutBookOption(2, "Checkout Book");
        ReturnBookOption returnBook = new ReturnBookOption(3, "Return Book");
        ShowCheckoutBook showCheckoutBook = new ShowCheckoutBook(4, "Show checkouted book");
        CheckoutMovieOption checkoutMovie = new CheckoutMovieOption(5, "Checkout Movie");
        QuitOption quit = new QuitOption(6, "Quit");
        return asList(listBooks, checkoutBook, returnBook, showCheckoutBook, checkoutMovie, quit);
    }

    @Override
    public String getName() {
        return "Librarian";
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

    @Override
    public boolean addOption(Option option) {
        return menu.add(option);
    }
}
