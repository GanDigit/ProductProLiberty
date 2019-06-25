package com.productpro.productapi.controller;

import com.productpro.productapi.model.Product;
import com.productpro.productapi.repo.ProductManager;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("products")
@RequestScoped
public class ProductController {

    @Inject
    private ProductManager productManager;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("id") String id) {
        Product product = productManager.get(id);
        return Response.ok(product).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts() {
        return Response.ok(productManager.getAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Product product) {
        String productId = productManager.add(product);
        return Response.created(
                UriBuilder.fromResource(this.getClass()).path(productId).build())
                .build();
    }

}
