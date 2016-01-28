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

        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = new BookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 1)));

        Set<Book> customerBooks = new TreeSet<>();
        List<Option> menu = initializeMenu();

        app = new Application(console, bookList, bookRepository, customerBooks, menu);
    }

    private List<Option> initializeMenu() {
        ListBooksOption listBooks = new ListBooksOption("1", "List Books");
        CheckoutBookOption checkoutBook = new CheckoutBookOption("2", "Checkout Book");
        ReturnBookOption returnBook = new ReturnBookOption("3", "Return Book");
        QuitOption quit = new QuitOption("4", "Quit");
        return asList(listBooks, checkoutBook, returnBook, quit);
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
        inOrder.verify(console, times(1)).print("1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
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

    @Test
    public void console_should_display_can_checkout_book_list_when_customer_choose_checkout_book_option() throws Exception {
        app.disPlayAvailableBooks();

        inOrder.verify(console, times(1)).print("which book do you want check out:");
        inOrder.verify(console, times(1)).print("1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
    }

    @Test
    public void console_should_display_successful_message_when_customer_checkout_book_success() throws Exception {

        app.checkoutBook(1);

        inOrder.verify(console, times(1)).print("Thank you! Enjoy the book!");
    }

    @Test
    public void console_should_display_notified_message_when_checkout_book_failure() throws Exception {

        app.checkoutBook(4);

        inOrder.verify(console, times(1)).print("That book is not available.");
    }

    @Test
    public void console_should_display_right_message_after_checkout_success_and_chose_checkout_book_option() throws Exception {
        app.checkoutBook(1);
        app.disPlayAvailableBooks();

        inOrder.verify(console, times(1)).print("which book do you want check out:");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
    }

    /*@Test
    public void console_should_display_books_that_coustomer_can_return_when_choose_return_book_option() throws Exception {
        app.displayCanReturnBooks();

        inOrder.verify(console, times(1)).print("which book do you want check out:");
        inOrder.verify(console, times(1)).print("book1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("book2 computer author2 2013");

    }*/
}
