package com.twu.biblioteca;

import java.util.List;

public class MovieRepository {

    private static MovieRepository movieRepository;
    private static List<MovieStock> movieStocks;
    private static MovieList movieList;

    public MovieRepository(List<MovieStock> movieStocks, MovieList movieList) {

        MovieRepository.movieStocks = movieStocks;
        MovieRepository.movieList = movieList;
    }

    public static MovieRepository getMovieRepository(List<MovieStock> movieStocks, MovieList movieList) {
        if (movieRepository == null) {
            movieRepository = new MovieRepository(movieStocks, movieList);
        }
        return movieRepository;
    }

    public void displayMovieListInfo(Console console) {
        movieList.displayMovieListInfo(console);
    }
}
