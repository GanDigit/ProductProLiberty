package com.productpro.productapi.controller;

import com.productpro.productapi.jpa.ProductJPA;
import com.productpro.productapi.model.Product;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("products")
@RequestScoped
public class ProductController {

    @Inject
    private ProductJPA productJPA;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") int id) {
        Product product = productJPA.find(id);
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        return Response.ok(productJPA.findAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
    	product = productJPA.create(product);
    	 return Response.ok(product).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Product product) {
    	product = productJPA.update(product);
    	return Response.ok(product).build();
    }

        
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
    	boolean result = productJPA.delete(id);
    	return Response.ok(result).build();
    }
}

