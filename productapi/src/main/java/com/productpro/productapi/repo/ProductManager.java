package com.productpro.productapi.repo;

import com.productpro.productapi.model.Product;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ProductManager {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMM");
    private AtomicInteger productIdGenerator = new AtomicInteger(0);

    private ConcurrentMap<String, Product> inMemoryStore = new ConcurrentHashMap();

    public ProductManager() {
    	loadData();
    }

    
    public void loadData() {
        
    	Product product = new Product();
        product.setId(1);
        product.setName("Samsung TV");
        product.setCategory("TV");
        product.setPrice(50000);
        inMemoryStore.put(product.getId()+ "", product);
        
        product = new Product();
        product.setId(2);
        product.setName("Dell");
        product.setCategory("Monitor");
        product.setPrice(10000);
        inMemoryStore.put(product.getId()+ "", product);
        
        product = new Product();
        product.setId(3);
        product.setName("Sony TV");
        product.setCategory("TV");
        product.setPrice(60000);
        inMemoryStore.put(product.getId()+ "", product);
        
        product = new Product();
        product.setId(3);
        product.setName("Sony TV");
        product.setCategory("TV");
        product.setPrice(20000);
        inMemoryStore.put(product.getId()+ "", product);
        
        
        product = new Product();
        product.setId(4);
        product.setName("Samsung");
        product.setCategory("Monitor");
        product.setPrice(20000);
        inMemoryStore.put(product.getId()+ "", product);
        
        product = new Product();
        product.setId(5);
        product.setName("LG TV");
        product.setCategory("TV");
        product.setPrice(40000);
        inMemoryStore.put(product.getId()+ "", product);
    }

    private String getNextId() {
        String date = LocalDate.now().format(formatter);
        return String.format("%04d-%s", productIdGenerator.incrementAndGet(), date);
    }

    public String add(Product product) {
    	int id = productIdGenerator.incrementAndGet();
        product.setId(id);
        inMemoryStore.put(id+ "", product);
        return id+ "";
    }

    public Product get(String id) {
        return inMemoryStore.get(id);
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList();
        products.addAll(inMemoryStore.values());
        return products;
    }
}
