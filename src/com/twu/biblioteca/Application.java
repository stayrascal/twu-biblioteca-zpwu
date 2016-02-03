package com.twu.biblioteca;

import com.twu.biblioteca.option.Option;

import java.util.List;
import java.util.Set;

public class Application {

    private UserCenter userCenter;
    private Console console;
    private BookRepository bookRepository;

    private User user;
    private Boolean isContinue = Boolean.FALSE;
    private CheckoutBookLog checkoutBookLog;

    public Application(UserCenter userCenter, Console console, BookRepository bookRepository, CheckoutBookLog checkoutBookLog) {
        this.userCenter = userCenter;
        this.console = console;
        this.bookRepository = bookRepository;
        this.checkoutBookLog = checkoutBookLog;
    }

    public Application(UserCenter userCenter, Console console, BookRepository bookRepository, CheckoutBookLog checkoutBookLog, User user) {
        this(userCenter, console, bookRepository, checkoutBookLog);
        this.user = user;
    }

    public void start() {
        displayWelcomeMessage();
        displayBookListInfo();
    }

    public void startByMenu() {
        displayWelcomeMessage();
        login();

        while (isContinue) {
            displayMenusInfo();
            validateInput(console.nextInt());
        }
    }

    public void validateInput(int input) {
        if (!optionIsValid(input)) {
            console.print("Please select a valid option!");
        }
    }

    private boolean optionIsValid(int input) {
        for (Option option : user.getMenu()) {
            if (option.getId().equals(input)) {
                option.execute(this);
                return true;
            }
        }
        return false;
    }

    public void displayMenusInfo() {
        user.displayMenusInfo(console);
    }

    public void displayBookListInfo() {
        bookRepository.displayBookListInfo(console);
    }

    public void disPlayAvailableBooks() {
        if (bookRepository.getAvailableBooks().size() < 1) {
            console.print("Sorry, there is no book can been checkout!");
        } else {
            console.print("Which book do you want check out:");
            printAvailableBooksAndDealCheckoutBookInput();
        }
    }

    private void printAvailableBooksAndDealCheckoutBookInput() {
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            console.print(bookStock.getBook().toString());
        }
        checkoutBook(console.nextInt());
    }

    public void checkoutBook(int isbn) {
        if (!isCheckoutBookSuccessful(isbn)) {
            console.print("That book is not available.");
        }
    }

    private boolean isCheckoutBookSuccessful(int isbn) {
        for (BookStock bookStock : bookRepository.getAvailableBooks()) {
            if (bookStock.getBook().getIsbn().equals(isbn)) {
                bookStock.checkoutOne();
                //customerBooks.add(bookStock.getBook());

                checkoutBookLog.checkoutBook(user, bookStock.getBook());

                console.print("Thank you! Enjoy the book!");
                return true;
            }
        }
        return false;
    }

    public void displayCanReturnBooks() {
        //if (customerBooks.size() < 1) {
        if (checkoutBookLog.getUserBooks(user).size() < 1) {
            console.print("Sorry, there is no book can been return!");
        } else {
            console.print("Which book do you want return:");
            printCustomerBooksAndDealReturnBookInput();
        }
    }

    private void printCustomerBooksAndDealReturnBookInput() {
        checkoutBookLog.getUserBooks(user).forEach(book -> console.print(book.toString()));
        //customerBooks.forEach(book -> console.print(book.toString()));
        returnBook(console.nextInt());
    }

    public void returnBook(int isbn) {
        if (!isReturnBookSuccessful(isbn)) {
            console.print("That is not a valid book to return.");
        }
    }

    private boolean isReturnBookSuccessful(int isbn) {
        for (BookStock bookStock : bookRepository.getBooks()) {
            if (bookStock.getBook().getIsbn().equals(isbn)) {

                removeBookFromCustomerBooks(bookStock.getBook());

                bookStock.returnOneBook();
                console.print("Thank you for returning the book.");
                return true;
            }
        }
        return false;
    }

    private void removeBookFromCustomerBooks(Book book) {
        if (!checkoutBookLog.returnBook(user, book)) {
            console.print("That is not a valid book to return.");
        }
    }

    private void displayWelcomeMessage() {
        console.print("Welcome to Bangalore Public Library!");
    }

    public void exit() {
        isContinue = Boolean.FALSE;
        console.print("Thank you come to Bangalore Public Library, goodbye!");
    }

    public boolean login() {
        console.print("Please input your library number:");
        String libraryNumber = console.nextLine();

        console.print("Please input your password:");
        String password = console.nextLine();

        user = userCenter.login(libraryNumber, password);

        if (user != null) {
            console.print("login success");

            isContinue = Boolean.TRUE;
            return true;
        } else {
            console.print("login failure");
            return false;
        }
    }

    public void showCheckoutBookForLibrian() {
    }
}
