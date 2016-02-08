package com.twu.biblioteca;


import com.twu.biblioteca.book.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book algebra;
    private Book computer;

    @Before
    public void setUp() throws Exception {
        algebra = new Book(1, "algebra", "author1", "2012");
        computer = new Book(2, "computer", "author2", "2013");
    }

    @Test
    public void should_return_right_result_when_compare_book1_and_book2() throws Exception {

        assertEquals(computer.compareTo(algebra), 1);
        assertEquals(computer.compareTo(computer), 0);
        assertEquals(algebra.compareTo(computer), -1);
        assertEquals(algebra.compareTo(null), 1);

    }
}
