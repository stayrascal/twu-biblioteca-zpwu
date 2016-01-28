package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private final List<BookStock> bookRepository;

    public BookRepository(List<BookStock> bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookStock> getBooks() {
        return bookRepository;
    }

    public List<BookStock> getAvailableBooks() {
        return bookRepository.stream().filter(BookStock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }
}
