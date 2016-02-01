package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleTest {

    private Console console;
    private BufferedReader reader;
    private PrintStream printStream;
    private InOrder inOrder;

    @Before
    public void setUp() throws Exception {

        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        console = new Console(reader, printStream);
        inOrder = inOrder(printStream);
    }

    @Test
    public void the_input_from_customer_should_be_1() throws Exception {
        when(reader.readLine()).thenReturn("1");
        assertEquals(console.nextInt(), 1);
    }

    @Test
    public void the_input_from_customer_should_be_string_1_when_input_1() throws Exception {
        when(reader.readLine()).thenReturn("1");

        assertEquals(console.nextLine(), "1");

    }

    @Test
    public void console_should_print_message_in_right_way() throws Exception {

        console.print("1234");
        console.print("5678");

        inOrder.verify(printStream, times(1)).print("1234");
        inOrder.verify(printStream, times(1)).print("5678");
    }
}
