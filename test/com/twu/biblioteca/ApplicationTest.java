package com.twu.biblioteca;


import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ApplicationTest {

    @Test
    public void console_should_display_welcome_message() throws Exception {
        ConsolePrinter console = mock(ConsolePrinter.class);
        Application app = new Application(console);

        app.start();

        verify(console).print("Welcome to Bangalore Public Library");
    }


}
