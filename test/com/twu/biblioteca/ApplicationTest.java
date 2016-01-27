package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;


import java.util.Arrays;

import static org.mockito.Mockito.*;

public class ApplicationTest {

    private ConsolePrinter console;
    private Application app;
    private BookRepository bookRepository;
    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {
        console = mock(ConsolePrinter.class);
        inOrder = inOrder(console);

        Book algebra = new Book("book1", "algebra", "author1", "2012");
        Book computer = new Book("book2", "computer", "author2", "2013");
        bookRepository = new BookRepository(Arrays.asList(algebra, computer));
        app = new Application(console, bookRepository);
    }

    @Test
    public void console_should_display_welcome_message() throws Exception {
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
}
