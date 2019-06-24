package com.productpro.productweb.rest.client;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.productpro.productweb.rest.model.Book;

public class BookService {
	
    private static WebTarget resource = ClientBuilder.newBuilder()
            .build().target("http://localhost:9080/productweb/library/books");
 
    public static List<Book> fetch(int offset, int num) {
//        BooksList res = null;
//        try {
//        	res = resource.request(MediaType.APPLICATION_JSON).get(BooksList.class);
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//        return res.getResults();
  
        List bookList = new ArrayList();
        Book book = new Book();
        book.setId("1");
        book.setName("Building Microservice With Eclipse MicroProfile");
        book.setIsbn("1");
        book.setAuthor("baeldung");
        book.setPages(420);
        bookList.add(book);
        
        book = new Book();
        book.setId("2");
        book.setName("2 Building Microservice With Eclipse MicroProfile");
        book.setIsbn("2");
        book.setAuthor("baeldung");
        book.setPages(4202);
        bookList.add(book);
        
        book = new Book();
        book.setId("3");
        book.setName("3Building Microservice With Eclipse MicroProfile");
        book.setIsbn("3");
        book.setAuthor("baeldung");
        book.setPages(4203);
        bookList.add(book);
        
        return bookList;
    
    } 
}
  