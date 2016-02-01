package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UserCenterTest {

    private UserCenter userCenter;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("xxx-xxxx", "name", "password", "email", "phone");
        userCenter = new UserCenter(Collections.singletonList(user));

    }

    @Test
    public void the_user_list_size_should_be_one_when_add_one_user() throws Exception {
        assertEquals(userCenter.getUserList().size(), 1);
        assertEquals(userCenter.getUserList().get(0), user);
    }

    @Test
    public void should_return_true_when_login_success() throws Exception {

        assertEquals(userCenter.login(user.getLibraryNumber(), user.getPassword()), true);
        assertEquals(userCenter.getLoginedUserSet().size(), 1);
    }

    @Test
    public void should_return_false_when_login_success() throws Exception {

        assertEquals(userCenter.login(user.getLibraryNumber(), "wrong password"), false);
        assertEquals(userCenter.login("not exist user", user.getPassword()), false);
        assertEquals(userCenter.getLoginedUserSet().size(), 0);
    }
}
