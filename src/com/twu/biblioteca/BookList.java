package com.twu.biblioteca;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BookList {

    private final Set<Book> books = new TreeSet<>();

    public BookList(List<Book> books) {
        this.books.addAll(books);
    }

    public Set<Book> getBooks() {
        return books;
    }
}
