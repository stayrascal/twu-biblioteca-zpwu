package com.twu.biblioteca;


import com.twu.biblioteca.book.*;
import com.twu.biblioteca.movie.Movie;
import com.twu.biblioteca.resource.MovieList;
import com.twu.biblioteca.movie.MovieRepository;
import com.twu.biblioteca.movie.MovieStock;
import com.twu.biblioteca.resource.BookList;
import com.twu.biblioteca.role.Librarian;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ApplicationTest {

    private Console console;
    private Application app;
    private InOrder inOrder;
    private User user;
    private UserCenter userCenter;
    private CheckoutBookLog checkoutBookLog;
    private Book algebra;
    private Book computer;
    private BookList bookList;

    @Before
    public void setUp() throws Exception {

        console = mock(Console.class);
        inOrder = inOrder(console);

        app = new Application(getUserCenter(), console, getBookRepository(), getMovieRepository(), getCheckoutBookLog(), user);
        when(console.nextInt()).thenReturn(1);
    }

    private CheckoutBookLog getCheckoutBookLog() {
        checkoutBookLog = CheckoutBookLog.getCheckoutBookLog(new HashMap<>(), new HashMap<>());
        return checkoutBookLog;
    }

    private UserCenter getUserCenter() {
        user = new User("xxx-xxxx", "name", "password", "email", "phone");
        userCenter = UserCenter.getUserCenter(Collections.singletonList(user));
        return userCenter;
    }

    private MovieRepository getMovieRepository() {
        Movie movie1 = new Movie(1, "movieName1", 2016, "movieDirector", 9.0f);
        Movie movie2 = new Movie(2, "movieName2", 2016, "movieDirector", 9.0f);
        MovieList movieList = new MovieList(asList(movie1, movie2));
        return MovieRepository.getMovieRepository(asList(new MovieStock(movie1, 1), new MovieStock(movie2, 1)), movieList);
    }

    private BookRepository getBookRepository() {
        algebra = new Book(1, "algebra", "author1", "2012");
        computer = new Book(2, "computer", "author2", "2013");
        bookList = new BookList(asList(algebra, computer));
        return BookRepository.getBookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 1)), bookList);
    }


    @Test
    public void console_should_display_welcome_message_when_start_application() throws Exception {
        app.start();

        inOrder.verify(console, times(1)).print("Welcome to Bangalore Public Library!");
    }

    @Test
    public void console_should_display_book_list_after_welcome_message() throws Exception {
        app.start();

        inOrder.verify(console, times(1)).print("The Books in library as follow:");
        inOrder.verify(console, times(1)).print("1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
    }

    @Test
    public void console_should_display_main_menu_information_when_start_application() throws Exception {

        app.displayMenusInfo();

        inOrder.verify(console, times(1)).print("Please choose options as follow:");
        inOrder.verify(console, times(1)).print("1 List Books");
        inOrder.verify(console, times(1)).print("2 Checkout Book");
        inOrder.verify(console, times(1)).print("3 Return Book");
        inOrder.verify(console, times(1)).print("4 Checkout Movie");
        inOrder.verify(console, times(1)).print("5 Quit");
    }

    @Test
    public void console_should_notified_select_a_valid_opetion_when_customer_choose_wrong() throws Exception {

        app.validateInput(0);
        inOrder.verify(console, times(1)).print("Please select a valid option!");
    }

    @Test
    public void console_should_display_can_checkout_book_list_when_customer_choose_checkout_book_option() throws Exception {
        app.disPlayAvailableBooks();

        inOrder.verify(console, times(1)).print("Which book do you want check out:");
        inOrder.verify(console, times(1)).print("1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
    }

    @Test
    public void console_should_display_successful_message_when_customer_checkout_book_success() throws Exception {
        //there is a problem that the test depend on the up test that execute checkoutBook(1) method,
        // lead to the book whose isbn is 1 is not exist, when execute checkoutBook(1) again, there is no book which isbn is 1.
        // That`s a abnormal phenomenon that the test case depend on other test case
        //app.checkoutBook(1);
        app.checkoutBook(2);

        inOrder.verify(console, times(1)).print("Thank you! Enjoy the book!");
    }

    @Test
    public void console_should_display_notified_message_when_checkout_book_failure() throws Exception {

        app.checkoutBook(4);

        inOrder.verify(console, times(1)).print("That book is not available.");
    }

    @Test
    public void console_should_display_right_message_after_checkout_success_and_chose_checkout_book_option() throws Exception {
        app.checkoutBook(1);
        app.disPlayAvailableBooks();

        inOrder.verify(console, times(1)).print("Which book do you want check out:");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");
    }

    @Test
    public void console_should_display_books_that_coustomer_can_return_when_choose_return_book_option() throws Exception {
        checkoutBookLog.checkoutBook(user, new Book(1, "algebra", "author1", "2012"));
        checkoutBookLog.checkoutBook(user, new Book(2, "computer", "author2", "2013"));
        app.displayCanReturnBooks();

        inOrder.verify(console, times(1)).print("Which book do you want return:");
        inOrder.verify(console, times(1)).print("1 algebra author1 2012");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");

    }

    @Test
    public void console_should_display_successful_message_when_return_book_success() throws Exception {
        checkoutBookLog.checkoutBook(user, new Book(1, "algebra", "author1", "2012"));
        app.returnBook(1);

        inOrder.verify(console, times(1)).print("Thank you for returning the book.");
    }

    @Test
    public void console_should_display_notified_message_when_customer_return_invalid_book() throws Exception {
        checkoutBookLog.checkoutBook(user, new Book(1, "algebra", "author1", "2012"));
        app.returnBook(2);

        inOrder.verify(console, times(1)).print("That is not a valid book to return.");
    }

    @Test
    public void console_should_display_other_book_that_can_be_return_after_return_one_and_choose_return_book() throws Exception {
        checkoutBookLog.checkoutBook(user, new Book(1, "algebra", "author1", "2012"));
        checkoutBookLog.checkoutBook(user, new Book(2, "computer", "author2", "2013"));
        app.returnBook(1);

        app.displayCanReturnBooks();

        inOrder.verify(console, times(1)).print("Which book do you want return:");
        inOrder.verify(console, times(1)).print("2 computer author2 2013");

    }

    @Test
    public void console_should_display_thank_message_when_customer_choose_quit_option() throws Exception {

        app.exit();

        inOrder.verify(console, times(1)).print("Thank you come to Bangalore Public Library, goodbye!");
    }

    @Test
    public void console_should_display_right_information_when_customer_login() throws Exception {

        when(console.nextLine()).thenReturn(user.getLibraryNumber(), user.getPassword());

        assertEquals(app.login(), true);

        inOrder.verify(console, times(1)).print("Please input your library number:");
        inOrder.verify(console, times(1)).print("Please input your password:");
        inOrder.verify(console, times(1)).print("name login success");
    }

    @Test
    public void console_should_display_five_option_when_librarian_login() throws Exception {
        User user = new User("xxx-xxxx", "name", "password", "email", "phone", new Librarian());
        UserCenter userCenter = UserCenter.getUserCenter(Collections.singletonList(user));

        app = new Application(userCenter, console, null, null, null, user);

        app.displayMenusInfo();

        inOrder.verify(console, times(1)).print("Please choose options as follow:");
        inOrder.verify(console, times(1)).print("1 List Books");
        inOrder.verify(console, times(1)).print("2 Checkout Book");
        inOrder.verify(console, times(1)).print("3 Return Book");
        inOrder.verify(console, times(1)).print("4 Show checkouted book");
        inOrder.verify(console, times(1)).print("5 Checkout Movie");
        inOrder.verify(console, times(1)).print("6 Quit");
    }

    @Test
    public void console_should_display_two_user_who_are_checkout_this_book() throws Exception {
        BookRepository bookRepository = BookRepository.getBookRepository(asList(new BookStock(algebra, 2), new BookStock(computer, 1)), bookList);

        Application application = new Application(userCenter, console, bookRepository, null, checkoutBookLog, user);
        application.checkoutBook(1);
        application.checkoutBook(2);
        //checkoutBookLog.checkoutBook(user, new Book(1, "algebra", "author1", "2012"));
        checkoutBookLog.checkoutBook(new User("xxx-xxx1", "name1", "password1", "email1", "phone1"), new Book(1, "algebra", "author1", "2012"));

        application.displayCheckoutBookForLibrarian();

        inOrder.verify(console, times(1)).print("algebra xxx-xxx1 name1 email1 phone1");
        inOrder.verify(console, times(1)).print("algebra xxx-xxxx name email phone");
        inOrder.verify(console, times(1)).print("computer xxx-xxxx name email phone");
    }

    @Test
    public void console_should_display_movies_that_can_be_checkout_when_customer_choose_list_movie_option() throws Exception {

        app.displayAvailableMovieList();

        inOrder.verify(console, times(1)).print("Which movie do you want checkout:");
        inOrder.verify(console, times(1)).print("1 movieName1 2016 movieDirector 9.0 1");
        inOrder.verify(console, times(1)).print("2 movieName2 2016 movieDirector 9.0 1");
    }

    @Test
    public void console_should_display_success_message_when_checkout_movie_success() throws Exception {

        app.checkoutMovie(2);

        inOrder.verify(console, times(1)).print("movieName2 checkout success. Enjoy the movie.");
    }

    @Test
    public void console_should_notified_wrong_message_when_checkout_movie_failure() throws Exception {

        app.checkoutMovie(3);
        inOrder.verify(console, times(1)).print("That movie is not available.");

    }
}
