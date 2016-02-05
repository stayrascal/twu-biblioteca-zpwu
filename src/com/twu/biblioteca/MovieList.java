package com.twu.biblioteca;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MovieList {

    private final Set<Movie> movies = new TreeSet<>();

    public MovieList(List<Movie> movies) {
        this.movies.addAll(movies);
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void displayMovieListInfo(Console console) {
        console.print("The Movies in library as follow:");
        for (Movie movie : getMovies()) {
            console.print(movie.toString());
        }
    }
}
