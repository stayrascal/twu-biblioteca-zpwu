package com.twu.biblioteca.repository;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.resource.ResourceList;
import com.twu.biblioteca.stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository implements Repository<Movie> {

    private static MovieRepository movieRepository;
    private List<Stock<Movie>> movieStocks;
    private ResourceList<Movie> movieList;

    private MovieRepository(List<Stock<Movie>> movieStocks, ResourceList<Movie> movieList) {

        this.movieStocks = movieStocks;
        this.movieList = movieList;
    }

    public static MovieRepository getMovieRepository(List<Stock<Movie>> movieStocks, ResourceList<Movie> movieList) {
        if (movieRepository == null) {
            movieRepository = new MovieRepository(movieStocks, movieList);
        }
        return movieRepository;
    }

    @Override
    public void displayResourceListInfo(Console console) {
        movieList.displayResourceListInfo(console);
    }

    @Override
    public List<Stock<Movie>> getAvailableResourceStockList() {
        return movieStocks.stream().filter(Stock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Stock<Movie>> getResourceStockList() {
        return movieStocks;
    }

    @Override
    public String getResourceNameById(Integer key) {
        return movieList.getResourceNameById(key);
    }
}
