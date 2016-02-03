package com.twu.biblioteca;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CheckoutBookLog {

    private Map<String, Set<Book>> userBooks;
    private Map<Integer, Set<User>> bookReaders;

    public CheckoutBookLog(Map<String, Set<Book>> userBooks, Map<Integer, Set<User>> bookReaders) {
        this.userBooks = userBooks;
        this.bookReaders = bookReaders;
    }

    public Set<Book> getUserBooks(User user) {
        return userBooks.get(user.getLibraryNumber()) == null ? new TreeSet<>() : userBooks.get(user.getLibraryNumber());
    }

    public Set<User> getBookReaders(Book book) {
        return bookReaders.get(book.getIsbn()) == null ? new TreeSet<>() : bookReaders.get(book.getIsbn());
    }

    public boolean checkoutBook(User user, Book book) {
        Set<Book> userBookSet = userBooks.get(user.getLibraryNumber());
        if (userBookSet == null || userBookSet.size() == 0) {
            userBookSet = new TreeSet<>();
        }
        userBookSet.add(book);
        userBooks.put(user.getLibraryNumber(), userBookSet);

        Set<User> bookReaderSet = bookReaders.get(book.getIsbn());
        if (bookReaderSet == null) {
            bookReaderSet = new TreeSet<>();
        }
        bookReaderSet.add(user);
        bookReaders.put(book.getIsbn(), bookReaderSet);
        return true;
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
