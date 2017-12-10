package com.johndcoding.saxparser.parser;

import com.johndcoding.saxparser.entity.Author;
import com.johndcoding.saxparser.entity.Book;

public class BookBuilder {

    private Book book;

    public BookBuilder() {
        book = new Book();
    }


    public Book build(){
        Book bookBuilt = book;

        book = new Book();

        return bookBuilt;
    }


    public BookBuilder setTitle(String title){
        book.setTitle(title);
        return this;
    }

    public BookBuilder setIsbn(String isbn){
        book.setIsbn(isbn);
        return this;
    }


    public BookBuilder setAuthor(String authorName){
        Author author = new Author();
        book.setAuthor(author);
        return this;
    }

}
