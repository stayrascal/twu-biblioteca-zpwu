package com.twu.biblioteca;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class UserCenterTest {

    @Test
    public void the_user_list_size_should_be_one_when_add_one_user() throws Exception {
        User user = new User("name", "password", "email", "phone");

        UserCenter userCenter = new UserCenter(Arrays.asList(user));

        assertEquals(userCenter.getUserList().size(), 1);
        assertEquals(userCenter.getUserList().get(0), user);
    }
}
