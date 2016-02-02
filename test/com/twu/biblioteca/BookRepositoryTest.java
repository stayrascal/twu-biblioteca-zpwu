package com.twu.biblioteca;


import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void the_reutrn_list_size_should_be_1() throws Exception {
        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = new BookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 0)), bookList);

        assertEquals(bookRepository.getAvailableBooks().size(), 1);
        assertEquals(bookRepository.getAvailableBooks().get(0).getBook().getName(), "algebra");

    }
}
