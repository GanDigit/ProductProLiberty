package com.productpro.productweb.products.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.productpro.productweb.products.model.Product;

public class ProductService {
	
	public static String ENV_KEY_API_SERVICE_URL = "PRODUCTPRO_API_SERVER_URL";
	public static String API_SERVICE_URL_Local = "http://localhost:9080/productapi/rest-api/products";
	
	private static WebTarget getWebTarget() {
    	
    	String apiURL = System.getenv(ENV_KEY_API_SERVICE_URL);
    	if (apiURL == null || apiURL.isEmpty()) {
    		apiURL = API_SERVICE_URL_Local;
    	}
    	
    	System.out.println("ProductService : getResource :apiURL: " + apiURL);
    	
    	WebTarget resource = ClientBuilder.newBuilder() .build().target(apiURL);
    	
    	return resource;
     }
    
    public static List<Product> products() {
    	
    	List<Product> list = new ArrayList();
        try {
        	list = getWebTarget().request(MediaType.APPLICATION_JSON).get(  new GenericType<List<Product>>() { });
        } catch (Exception e) {
        	e.printStackTrace();
        }
        
        return list;
    } 
}
  