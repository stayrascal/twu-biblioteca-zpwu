package com.twu.biblioteca;


public class BookStock {

    private final Book book;
    private int number;

    public BookStock(Book book, int number) {
        this.book = book;
        this.number = number;
    }

    public Book getBook() {
        return book;
    }

    public int getNumber() {
        return number;
    }

    public boolean checkoutOne() {
        if (getNumber() < 1) {
            return false;
        }
        number--;
        return true;
    }

    public void returnOneBook() {
        number++;
    }

    public boolean isCanCheckout() {
        return getNumber() > 0;
    }
}
