package com.productpro.productweb.rest.client;

import java.util.List;
import com.productpro.productweb.rest.model.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksList {

    List<Book> results;

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> result) {
        results = result;
    }
}