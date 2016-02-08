package com.twu.biblioteca.resource;


import com.twu.biblioteca.Console;
import com.twu.biblioteca.book.Book;

import java.util.List;

public class BookList extends ResourceList<Book> {

    public BookList(List<Book> resources) {
        super(resources);
    }

    @Override
    public void displayResourceListInfo(Console console) {
        console.print("The Books in library as follow:");
        for (Book book : getResources()) {
            console.print(book.toString());
        }
    }

    @Override
    public String getResourceNameById(Integer id) {
        for (Book book : getResources()) {
            if (book.getIsbn().equals(id)) {
                return book.getName();
            }
        }
        return null;
    }
}
