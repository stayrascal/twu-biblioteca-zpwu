package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository {

    private static BookRepository bookRepository;

    private static List<BookStock> bookRepositoryList;

    private static BookList bookList;

    private BookRepository(List<BookStock> bookRepositoryList, BookList bookList) {
        BookRepository.bookRepositoryList = bookRepositoryList;
        BookRepository.bookList = bookList;
    }

    public static BookRepository getBookRepository(List<BookStock> initializeBookRepository, BookList bookList) {
        if (bookRepository == null) {
            bookRepository = new BookRepository(initializeBookRepository, bookList);
        }
        return bookRepository;
    }

    public BookList getBookList() {
        return bookList;
    }

    public List<BookStock> getBooks() {
        return bookRepositoryList;
    }

    public List<BookStock> getAvailableBooks() {
        return bookRepositoryList.stream().filter(BookStock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }

    public void displayBookListInfo(Console console) {
        bookList.displayBookListInfo(console);
    }
}
