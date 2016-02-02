package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private final List<BookStock> bookRepository;

    private final BookList bookList;

    public BookRepository(List<BookStock> bookRepository, BookList bookList) {
        this.bookRepository = bookRepository;
        this.bookList = bookList;
    }

    public BookList getBookList() {
        return bookList;
    }

    public List<BookStock> getBooks() {
        return bookRepository;
    }

    public List<BookStock> getAvailableBooks() {
        return bookRepository.stream().filter(BookStock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }
}
