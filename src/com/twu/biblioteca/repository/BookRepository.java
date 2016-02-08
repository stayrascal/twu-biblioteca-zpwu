package com.twu.biblioteca.repository;


import com.twu.biblioteca.Console;
import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.resource.ResourceList;
import com.twu.biblioteca.stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository implements Repository<Book> {

    private static BookRepository bookRepository;
    private List<Stock<Book>> bookRepositoryList;
    private ResourceList<Book> bookList;

    private BookRepository(List<Stock<Book>> bookRepositoryList, ResourceList<Book> bookList) {
        this.bookRepositoryList = bookRepositoryList;
        this.bookList = bookList;
    }

    public static BookRepository getBookRepository(List<Stock<Book>> initializeBookRepository, ResourceList<Book> bookList) {
        if (bookRepository == null) {
            bookRepository = new BookRepository(initializeBookRepository, bookList);
        }
        return bookRepository;
    }

    @Override
    public void displayResourceListInfo(Console console) {
        bookList.displayResourceListInfo(console);
    }

    @Override
    public List<Stock<Book>> getAvailableResourceStockList() {
        return bookRepositoryList.stream().filter(Stock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Stock<Book>> getResourceStockList() {
        return bookRepositoryList;
    }

    @Override
    public String getResourceNameById(Integer key) {
        return bookList.getResourceNameById(key);
    }
}
