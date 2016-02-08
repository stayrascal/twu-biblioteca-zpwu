package com.twu.biblioteca.stock;

public abstract class Stock<T> {

    private final T resource;
    private int quantity;

    public Stock(T resource, int quantity) {
        this.resource = resource;
        this.quantity = quantity;
    }

    public T getResource() {
        return resource;
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

    public boolean isCanCheckout() {
        return getQuantity() > 0;
    }

    public String toString() {
        return String.format("%s %d", getResource().toString(), getQuantity());
    }

    public void returnOneResource() {
        quantity++;
    }
}
