package com.johndcoding.saxparser.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class BookHandler extends DefaultHandler {

    Logger LOG = LoggerFactory.getLogger(LibraryParser.class);

    private Warehouse warehouse;

    private BookBuilder bookBuilder;

    private String currentTag;

    private Deque<String> tags;



    public BookHandler() {

        tags = new LinkedList<>();

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        currentTag=qName;

        tags.push(currentTag);


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {


        if("book".equals(currentTag)){
            warehouse.getBooks().add(bookBuilder.build());
        }


        String prev = tags.pop();
        currentTag = tags.peek();

        LOG.info("END: {}   NEW: {}", prev, currentTag);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {


        String str = String.copyValueOf(ch, start, length);

        if("title".equals(currentTag)){

            LOG.info("Title: {}", str);

            bookBuilder.setTitle(str);
        }else if("isbn".equals(currentTag)){
            bookBuilder.setIsbn(str);
        }else if("author".equals(currentTag)){
            bookBuilder.setAuthor(str);
        }

    }


    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public void setBookBuilder(BookBuilder bookBuilder) {
        this.bookBuilder = bookBuilder;
    }
}
