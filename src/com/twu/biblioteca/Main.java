package com.twu.biblioteca;


import com.twu.biblioteca.book.*;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.resource.MovieList;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.stock.MovieStock;
import com.twu.biblioteca.resource.BookList;
import com.twu.biblioteca.role.Librarian;
import com.twu.biblioteca.stock.BookStock;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;

import static java.util.Arrays.asList;

public class Main {

    public static void main(String[] args) {

        Console console = new Console(new BufferedReader(new InputStreamReader(System.in)), new PrintStream(System.out));

        UserCenter userCenter = getUserCenter();

        CheckoutBookLog checkoutBookLog = CheckoutBookLog.getCheckoutBookLog(new HashMap<>(), new HashMap<>());

        Application app = new Application(userCenter, console, getBookRepository(), getMovieRepository(), checkoutBookLog);

        app.startByMenu();
    }

    private static UserCenter getUserCenter() {
        User customer = new User("xxx-xxxx", "customer", "password", "email", "phone");
        User librarian = new User("xxx-xxx1", "librarian", "password", "email", "phone", new Librarian());
        return UserCenter.getUserCenter(asList(customer, librarian));
    }

    private static MovieRepository getMovieRepository() {
        Movie movie1 = new Movie(1, "movieName1", 2016, "movieDirector", 9.0f);
        Movie movie2 = new Movie(2, "movieName2", 2016, "movieDirector", 9.0f);
        MovieList movieList = new MovieList(asList(movie1, movie2));
        return MovieRepository.getMovieRepository(asList(new MovieStock(movie1, 1), new MovieStock(movie2, 1)), movieList);
    }

    private static BookRepository getBookRepository() {
        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        return BookRepository.getBookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 1)), bookList);
    }

}
