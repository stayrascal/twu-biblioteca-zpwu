package com.twu.biblioteca.book;


import com.twu.biblioteca.Console;
import com.twu.biblioteca.repository.Repository;
import com.twu.biblioteca.resource.BookList;
import com.twu.biblioteca.resource.ResourceList;
import com.twu.biblioteca.stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepository implements Repository<Book> {

    private static BookRepository bookRepository;

    //private List<BookStock> bookRepositoryList;
    private List<Stock<Book>> bookRepositoryList;

    private ResourceList<Book> bookList;

    private BookRepository(List<Stock<Book>> bookRepositoryList, BookList bookList) {
        this.bookRepositoryList = bookRepositoryList;
        this.bookList = bookList;
    }
    /*private BookRepository(List<BookStock> bookRepositoryList, BookList bookList) {
        this.bookRepositoryList = bookRepositoryList;
        this.bookList = bookList;
    }*/

    public static BookRepository getBookRepository(List<Stock<Book>> initializeBookRepository, BookList bookList) {
        if (bookRepository == null) {
            bookRepository = new BookRepository(initializeBookRepository, bookList);
        }
        return bookRepository;
    }

    /*public List<BookStock> getBooks() {
        return bookRepositoryList;
    }*/

    /*public List<BookStock> getAvailableBooks() {
        return bookRepositoryList.stream().filter(BookStock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }*/

    /*public void displayBookListInfo(Console console) {
        bookList.displayBookListInfo(console);
    }*/

    /*public String getBookNameByIsbn(Integer isbn) {
        return bookList.getBookNameByIsbn(isbn);
    }*/

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
