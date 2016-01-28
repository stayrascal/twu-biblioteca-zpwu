package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BookStockTest {

    private BookStock bookStock;

    @Before
    public void setUp() throws Exception {
        Book algebra = new Book(1, "algebra", "author1", "2012");
        bookStock = new BookStock(algebra, 1);
    }

    @Test
    public void should_return_true_when_check_algebra_is_checkout() throws Exception {

        assertThat(bookStock.isCanCheckout(), is(true));
    }

    @Test
    public void the_algebra_number_should_be_0_after_checkouted() throws Exception {
        bookStock.checkoutOne();

        assertEquals(bookStock.getNumber(), 0);
        assertEquals(bookStock.isCanCheckout(), false);
    }

    @Test
    public void the_algebra_number_should_be_2_after_return_one() throws Exception {
        bookStock.returnOneBook();

        assertEquals(bookStock.getNumber(), 2);

    }
}
