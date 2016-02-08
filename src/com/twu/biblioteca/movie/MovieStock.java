package com.twu.biblioteca.movie;

import com.twu.biblioteca.stock.Stock;

public class MovieStock implements Stock<Movie> {

    private final Movie movie;
    private int quantity;

    public MovieStock(Movie movie, int quantity) {
        this.movie = movie;
        this.quantity = quantity;
    }

    /*public Movie getMovie() {
        return movie;
    }*/

    @Override
    public Movie getEntity() {
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

    public boolean isCanCheckout() {
        return getQuantity() > 0;
    }

    @Override
    public String toString() {
        return String.format("%s %d", movie.toString(), getQuantity());
    }

    @Override
    public void returnOneResource() {
        quantity++;
    }
}
