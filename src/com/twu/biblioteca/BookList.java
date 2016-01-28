package com.twu.biblioteca;


import java.util.*;

public class BookList {

    private final Set<Book> books = new HashSet<>();

    public BookList(List<Book> books) {
        this.books.addAll(books);
    }

    public Set<Book> getBooks() {
        return books;
    }
}
