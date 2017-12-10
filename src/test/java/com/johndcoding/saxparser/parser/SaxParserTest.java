package com.johndcoding.saxparser.parser;

import com.johndcoding.saxparser.entity.Book;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class SaxParserTest {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {


        LibraryParser libraryParser = new LibraryParser();

        List<Book> list = libraryParser.parse("doc1.xml");

        System.out.println(list);

    }



}
