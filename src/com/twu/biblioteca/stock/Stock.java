package com.twu.biblioteca.stock;

public interface Stock<T> {

    T getEntity();

    int getQuantity();

    boolean checkoutOne();

    boolean isCanCheckout();

    String toString();

    void returnOneResource();
}
