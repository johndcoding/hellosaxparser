package com.johndcoding.saxparser.parser;

import com.johndcoding.saxparser.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {


    private List<Book> books;

    private BookBuilder bookBuilder;


    public Warehouse() {
        books = new ArrayList<>();
    }

    public BookBuilder getBookBuilder() {
        return bookBuilder;
    }

    public void setBookBuilder(BookBuilder bookBuilder) {
        this.bookBuilder = bookBuilder;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
