package com.twu.biblioteca.movie;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.repository.Repository;
import com.twu.biblioteca.resource.MovieList;
import com.twu.biblioteca.resource.ResourceList;
import com.twu.biblioteca.stock.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository implements Repository<Movie> {

    private static MovieRepository movieRepository;
    private List<Stock<Movie>> movieStocks;
    private ResourceList<Movie> movieList;

    private MovieRepository(List<Stock<Movie>> movieStocks, MovieList movieList) {

        this.movieStocks = movieStocks;
        this.movieList = movieList;
    }

    public static MovieRepository getMovieRepository(List<Stock<Movie>> movieStocks, MovieList movieList) {
        if (movieRepository == null) {
            movieRepository = new MovieRepository(movieStocks, movieList);
        }
        return movieRepository;
    }
    /*private MovieRepository(List<MovieStock> movieStocks, MovieList movieList) {

        this.movieStocks = movieStocks;
        this.movieList = movieList;
    }

    public static MovieRepository getMovieRepository(List<MovieStock> movieStocks, MovieList movieList) {
        if (movieRepository == null) {
            movieRepository = new MovieRepository(movieStocks, movieList);
        }
        return movieRepository;
    }*/

    /*public void displayMovieListInfo(Console console) {
        movieList.displayMovieListInfo(console);
    }*/

    /*public List<MovieStock> getAvailableMovieList() {
        return movieStocks.stream().filter(MovieStock::isCanCheckout).collect(Collectors.toCollection(ArrayList::new));
    }*/

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
