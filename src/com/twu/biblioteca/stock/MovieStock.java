package com.twu.biblioteca.stock;

import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.stock.Stock;

public class MovieStock extends Stock<Movie> {

    public MovieStock(Movie resource, int quantity) {
        super(resource, quantity);
    }
}
