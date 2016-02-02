package com.twu.biblioteca.role;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.option.Option;

import java.util.List;

public interface Role {

    String getName();

    List<Option> getMenu();

    void displayMenu(Console console);

    boolean addOption(Option option);
}
