package com.twu.biblioteca.resource;

import com.twu.biblioteca.Console;
import com.twu.biblioteca.movie.Movie;

import java.util.List;

public class MovieList extends ResourceList<Movie> {


    public MovieList(List<Movie> resources) {
        super(resources);
    }

    @Override
    public void displayResourceListInfo(Console console) {
        console.print("The Movies in library as follow:");
        for (Movie movie : getResources()) {
            console.print(movie.toString());
        }
    }

    @Override
    public String getResourceNameById(Integer id) {
        for (Movie movie : getResources()) {
            if (movie.getId() == id) {
                return movie.getName();
            }
        }
        return null;
    }

}
