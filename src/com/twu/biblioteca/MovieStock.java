package com.twu.biblioteca;

public class MovieStock {

    private final Movie movie;
    private int quantity;

    public MovieStock(Movie movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    public Movie getMovie() {
        return movie;
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

    public void returnOneMovie() {
        quantity++;
    }

    public boolean isCanCheckout() {
        return getQuantity() > 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d", movie.toString(), getQuantity());
    }
}
