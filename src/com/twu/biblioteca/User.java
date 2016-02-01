package com.twu.biblioteca;

public class User {

    private final String userName;
    private final String email;
    private final String phoneNumber;
    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String userName, String password, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
