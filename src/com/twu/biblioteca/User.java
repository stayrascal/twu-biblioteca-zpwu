package com.twu.biblioteca;

import com.twu.biblioteca.option.Option;
import com.twu.biblioteca.role.Customer;
import com.twu.biblioteca.role.Role;

import java.util.List;

public class User {

    private final String userName;
    private final String email;
    private final String phoneNumber;
    private String libraryNumber;
    private String password;
    private Role role;

    public User(String libraryNumber, String userName, String password, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = new Customer();
    }

    public User(String libraryNumber, String userName, String password, String email, String phoneNumber, Role role) {
        this(libraryNumber, userName, password, email, phoneNumber);
        this.role = role;
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

    public List<Option> getMenu() {
        return role.getMenu();
    }

    public void displayMenusInfo(Console console) {
        role.displayMenu(console);
    }
}
