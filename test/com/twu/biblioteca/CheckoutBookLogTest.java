package com.twu.biblioteca;

import com.twu.biblioteca.book.CheckoutBookLog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckoutBookLogTest {
    @Test
    public void the_return_checkout_book_log_should_be_same_when_create_two_times() throws Exception {

        CheckoutBookLog checkoutBookLog1 = CheckoutBookLog.getCheckoutBookLog(null, null);
        CheckoutBookLog checkoutBookLog2 = CheckoutBookLog.getCheckoutBookLog(null, null);

        assertEquals(checkoutBookLog1, checkoutBookLog2);
    }
}
