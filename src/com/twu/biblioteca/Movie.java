package com.twu.biblioteca;

import java.util.Objects;

public class Movie implements Comparable<Movie> {

    private final int id;
    private final String name;
    private final String director;
    private final String rating;

    public Movie(int id, String name, String director, float rating) {
        this.id = id;
        this.name = name;
        this.director = director;
        if (rating > 10) {
            this.rating = "10.0";
        } else if (rating < 1) {
            this.rating = "unrated";
        } else {
            this.rating = String.valueOf(rating);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s", getId(), getName(), getDirector(), getRating());
    }

    @Override
    public int compareTo(Movie movie) {
        if (movie == null) {
            return 1;
        }
        if (getId() > movie.getId()) {
            return 1;
        } else if (Objects.equals(getId(), movie.getId())) {
            return 0;
        } else {
            return -1;
        }
    }
}