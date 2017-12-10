package com.johndcoding.saxparser.parser;

import com.johndcoding.saxparser.entity.Book;
import com.sun.org.apache.xerces.internal.parsers.SAXParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LibraryParser {

    Logger LOG = LoggerFactory.getLogger(LibraryParser.class);




    public LibraryParser() {
    }


    List<Book> parse(String pathFile) throws ParserConfigurationException, SAXException, IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(pathFile);
        InputSource inputSource = new InputSource(inputStream);


        Warehouse warehouse = new Warehouse();
        BookBuilder bookBuilder = new BookBuilder();

        BookHandler bookHandler = new BookHandler();
        bookHandler.setWarehouse(warehouse);
        bookHandler.setBookBuilder(bookBuilder);


        XMLReader xmlReader = new SAXParser();
        xmlReader.setContentHandler(bookHandler);


        xmlReader.parse(inputSource);

        return warehouse.getBooks();
    }




}
