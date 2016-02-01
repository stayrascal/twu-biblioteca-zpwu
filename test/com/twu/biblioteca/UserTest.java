package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    @Test
    public void should_return_right_user_information() throws Exception {

        User user = new User("name", "password", "email address", "phone number");

        assertEquals(user.getUserName(), "name");
        assertEquals(user.getPassword(), "password");
        assertEquals(user.getEmail(), "email address");
        assertEquals(user.getPhoneNumber(), "phone number");
    }
}
