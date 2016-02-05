package com.twu.biblioteca;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CheckoutBookLog {

    private static CheckoutBookLog checkoutBookLog;

    private static Map<String, Set<Book>> userBooks;
    private static Map<Integer, Set<User>> bookReaders;

    private CheckoutBookLog(Map<String, Set<Book>> userBooks, Map<Integer, Set<User>> bookReaders) {
        CheckoutBookLog.userBooks = userBooks;
        CheckoutBookLog.bookReaders = bookReaders;
    }

    public static CheckoutBookLog getCheckoutBookLog(Map<String, Set<Book>> userBooks, Map<Integer, Set<User>> bookReaders) {
        if (checkoutBookLog == null) {
            checkoutBookLog = new CheckoutBookLog(userBooks, bookReaders);
        }
        return checkoutBookLog;
    }

    public Set<Book> getUserBooks(User user) {
        return userBooks.get(user.getLibraryNumber()) == null ? new TreeSet<>() : userBooks.get(user.getLibraryNumber());
    }

    public Map<Integer, Set<User>> getBookReaders() {
        return bookReaders;
    }

    public Set<User> getBookReaders(Book book) {
        return bookReaders.get(book.getIsbn()) == null ? new TreeSet<>() : bookReaders.get(book.getIsbn());
    }

    public void checkoutBook(User user, Book book) {
        updateUserBookSet(user, book);
        updateBookReaderSet(user, book);
    }

    private void updateBookReaderSet(User user, Book book) {
        Set<User> bookReaderSet = bookReaders.get(book.getIsbn());
        if (bookReaderSet == null) {
            bookReaderSet = new TreeSet<>();
        }
        bookReaderSet.add(user);
        bookReaders.put(book.getIsbn(), bookReaderSet);
    }

    private void updateUserBookSet(User user, Book book) {
        Set<Book> userBookSet = userBooks.get(user.getLibraryNumber());
        if (userBookSet == null || userBookSet.size() == 0) {
            userBookSet = new TreeSet<>();
        }
        userBookSet.add(book);
        userBooks.put(user.getLibraryNumber(), userBookSet);
    }

    public boolean returnBook(User user, Book book) {
        Set<Book> userBookSet = userBooks.get(user.getLibraryNumber());
        Set<User> bookReaderSet = bookReaders.get(book.getIsbn());
        if (userBookSet == null || !userBookSet.remove(book) || bookReaderSet == null || !bookReaderSet.remove(user)) {
            return false;
        }
        userBooks.put(user.getLibraryNumber(), userBookSet);
        bookReaders.put(book.getIsbn(), bookReaderSet);
        return true;
    }
}
