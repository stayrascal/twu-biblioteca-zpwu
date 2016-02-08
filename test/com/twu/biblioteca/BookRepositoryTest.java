package com.twu.biblioteca;


import com.twu.biblioteca.book.Book;
import com.twu.biblioteca.resource.BookList;
import com.twu.biblioteca.book.BookRepository;
import com.twu.biblioteca.stock.BookStock;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class BookRepositoryTest {

    @Test
    public void the_return_list_size_should_be_1() throws Exception {
        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository = BookRepository.getBookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 0)), bookList);

        //assertEquals(bookRepository.getAvailableBooks().size(), 1);
        assertEquals(bookRepository.getAvailableResourceStockList().size(), 1);
        //assertEquals(bookRepository.getAvailableBooks().get(0).getBook().getName(), "algebra");
        assertEquals(bookRepository.getAvailableResourceStockList().get(0).getResource().getName(), "algebra");
    }

    @Test
    public void the_return_book_repository_should_be_same_when_create_two_times() throws Exception {
        Book algebra = new Book(1, "algebra", "author1", "2012");
        Book computer = new Book(2, "computer", "author2", "2013");
        BookList bookList = new BookList(asList(algebra, computer));
        BookRepository bookRepository1 = BookRepository.getBookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 0)), bookList);
        BookRepository bookRepository2 = BookRepository.getBookRepository(asList(new BookStock(algebra, 1), new BookStock(computer, 0)), bookList);

        assertEquals(bookRepository1, bookRepository2);
    }
}
