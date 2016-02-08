package com.twu.biblioteca;

import com.twu.biblioteca.movie.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void should_return_right_result_when_compare_movie1_and_movie2() throws Exception {
        Movie movie1 = new Movie(1, "movieName1", 2016, "movieDirector", 9.0f);
        Movie movie2 = new Movie(2, "movieName2", 2016, "movieDirector", 9.0f);

        assertEquals(movie2.compareTo(movie1), 1);
        assertEquals(movie2.compareTo(movie2), 0);
        assertEquals(movie1.compareTo(movie2), -1);
        assertEquals(movie1.compareTo(null), 1);
    }

    @Test
    public void should_return_right_movie_information() throws Exception {
        Movie movie1 = new Movie(1, "movieName1", 2016, "movieDirector", 9.0f);

        assertEquals(movie1.toString(), "1 movieName1 2016 movieDirector 9.0");
    }
}
