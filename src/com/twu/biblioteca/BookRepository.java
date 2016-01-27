package com.twu.biblioteca;


import java.util.List;

public class BookRepository {

    private final List<Book> bookRepository;

    public BookRepository(List<Book> bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository;
    }
}
