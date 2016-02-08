package com.twu.biblioteca.stock;


import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.stock.Stock;

public class BookStock extends Stock<Book> {

    public BookStock(Book resource, int quantity) {
        super(resource, quantity);
    }
}
