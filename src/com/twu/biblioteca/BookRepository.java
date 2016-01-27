package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRepository {

    private final List<Book> bookRepository = new ArrayList<Book>();

    public void addBooks(List<Book> books) {
        bookRepository.addAll(books);
    }

    public List<Book> getBooks() {
        return bookRepository;
    }
}
