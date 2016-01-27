package com.twu.biblioteca;


public class Book {


    private final String author;
    private final String publishYear;
    private final String name;
    private String isbn;

    public Book(String isbn, String name, String author, String publishYear) {
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

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", getIsbn(), getName(), getAuthor(), getPublishYear());
    }
}
