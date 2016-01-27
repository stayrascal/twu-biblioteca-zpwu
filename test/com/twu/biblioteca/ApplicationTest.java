package com.twu.biblioteca;


import com.twu.biblioteca.option.*;
import com.twu.biblioteca.option.Option;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;


import java.util.*;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    private ConsolePrinter console;
    private Application app;
    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {

        console = mock(ConsolePrinter.class);
        inOrder = inOrder(console);

        Book algebra = new Book("book1", "algebra", "author1", "2012");
        Book computer = new Book("book2", "computer", "author2", "2013");
        BookRepository bookRepository = new BookRepository(asList(algebra, computer));

        ListBooksOption listBooks = new ListBooksOption("1", "List Books");
        CheckoutBookOption checkoutBook = new CheckoutBookOption("2", "Checkout Book");
        ReturnBookOption returnBook = new ReturnBookOption("3", "Return Book");
        QuitOption quit = new QuitOption("4", "Quit");
        List<Option> menu = asList(listBooks, checkoutBook, returnBook, quit);

        app = new Application(console, bookRepository, menu);
    }

    @Test
    public void console_should_display_welcome_message_when_start_application() throws Exception {
        app.start();

        inOrder.verify(console, times(1)).print("Welcome to Bangalore Public Library");
    }

    @Test
    public void console_should_display_book_list_after_welcome_message() throws Exception {
        app.start();

        inOrder.verify(console, times(1)).print("The Books in library as follow:");
        inOrder.verify(console, times(1)).print("book1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("book2 computer author2 2013");
    }

    @Test
    public void console_should_display_main_menu_information_when_start_application() throws Exception {

        app.startByMenu();

        inOrder.verify(console, times(1)).print("Please choose options as follow:");
        inOrder.verify(console, times(1)).print("1 List Books");
        inOrder.verify(console, times(1)).print("2 Checkout Book");
        inOrder.verify(console, times(1)).print("3 Return Book");
        inOrder.verify(console, times(1)).print("4 Quit");
    }

    @Test
    public void console_should_notified_select_a_valid_opetion_when_customer_choose_wrong() throws Exception {

        app.validateInput("5");
        inOrder.verify(console, times(1)).print("Please select a valid option!");
    }


}
