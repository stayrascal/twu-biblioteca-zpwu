package com.twu.biblioteca;


public class Book {


    private final String author;
    private final String publishYear;
    private final String name;

    public Book(String name, String author, String publishYear) {
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

    @Override
    public String toString() {
        return String.format("%s %s %s", getName(), getAuthor(), getPublishYear());
    }
}
