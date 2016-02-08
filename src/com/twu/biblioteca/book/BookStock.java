package com.twu.biblioteca.book;


import com.twu.biblioteca.stock.Stock;

public class BookStock implements Stock<Book> {

    private final Book book;
    private int quantity;

    public BookStock(Book book, int number) {
        this.book = book;
        this.quantity = number;
    }

    /*public Book getBook() {
        return book;
    }*/

    @Override
    public Book getEntity() {
        return book;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean checkoutOne() {
        if (getQuantity() < 1) {
            return false;
        }
        quantity--;
        return true;
    }

    /*public void returnOneBook() {
        quantity++;
    }*/

    public boolean isCanCheckout() {
        return getQuantity() > 0;
    }

    @Override
    public void returnOneResource() {
        quantity++;
    }
}
