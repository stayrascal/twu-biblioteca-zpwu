package com.twu.biblioteca.book;


import java.util.Objects;

public class Book implements Comparable<Book> {


    private final String author;
    private final String publishYear;
    private final String name;
    private Integer isbn;

    public Book(Integer isbn, String name, String author, String publishYear) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public String getName() {
        return name;
    }

    public Integer getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s", getIsbn(), getName(), getAuthor(), getPublishYear());
    }

    @Override
    public int compareTo(Book compareBook) {
        if (compareBook == null) {
            return 1;
        }
        if (getIsbn() > compareBook.getIsbn()) {
            return 1;
        } else if (Objects.equals(getIsbn(), compareBook.getIsbn())) {
            return 0;
        } else {
            return -1;
        }
    }
}
