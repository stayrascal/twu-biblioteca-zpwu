package com.twu.biblioteca;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserCenter {

    private static UserCenter userCenter;
    private final List<User> userList;
    private Set<User> loginedUserSet;

    private UserCenter(List<User> userList) {
        this.userList = userList;
        loginedUserSet = new HashSet<>();
    }

    public static UserCenter getUserCenter(List<User> userList) {
        if (userCenter == null) {
            userCenter = new UserCenter(userList);
        }
        return userCenter;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Set<User> getLoginedUserSet() {
        return loginedUserSet;
    }

    public User login(String libraryNumber, String password) {
        User user = getUser(libraryNumber);
        if (user != null && user.getPassword().equals(password) && loginedUserSet.add(user)) {
            return user;
        }
        return null;
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
