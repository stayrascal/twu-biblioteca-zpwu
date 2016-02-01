package com.twu.biblioteca;

import java.util.List;

public class UserCenter {

    private final List<User> userList;

    public UserCenter(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
