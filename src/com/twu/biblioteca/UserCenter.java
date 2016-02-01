package com.twu.biblioteca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserCenter {

    private final List<User> userList;
    private Set<User> loginedUserSet;

    public UserCenter(List<User> userList) {
        this.userList = userList;
        loginedUserSet = new HashSet<>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public Set<User> getLoginedUserSet() {
        return loginedUserSet;
    }

    public boolean login(String libraryNumber, String password) {
        User user = getUser(libraryNumber);
        return user != null && user.getPassword().equals(password) && loginedUserSet.add(user);
    }

    private User getUser(String libraryNumber) {
        for (User user : userList) {
            if (libraryNumber.equals(user.getLibraryNumber())) {
                return user;
            }
        }
        return null;
    }
}
