package org.eclipse.jakarta.hello.Controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jakarta.hello.Models.Product;
import org.eclipse.jakarta.hello.Models.Store;

import java.awt.*;
import java.util.Optional;
import java.util.Set;

@Path("/product")


public class ProductController {

    @Inject
    private Store store;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response entryToProducts()
    {
        return Response.status(Response.Status.OK)
                .entity("{\"messageeeeeeeeeeeeeee\": \"Welcomeeeeeeeeeeeeeee to the Product API\"}").build();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduct(@PathParam("name") String name)
    {
        Optional<Product>product =store.searchToProduct(name);

        if(product.isEmpty())
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.status(Response.Status.OK).entity(product.get()).build();
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public  Response getProducts()
    {
        Set<Product>products=store.getProducts();

        return Response.status(Response.Status.OK).entity(products).build();

    }
    @DELETE
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProduct(@PathParam("name") String name) {

        String message=store.deleteProduct(name);
        if(!message.equals("Product has been deleted successfully"))
        {
            return Response.status(Response.Status.BAD_REQUEST).entity(message).build();
        }
        return Response.status(Response.Status.OK).entity(message).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {


        String message=store.addProduct(product);
        if(!message.equals("Product has been added successfully"))
        {
            return  Response.status(Response.Status.BAD_REQUEST).entity(message).build();
        }
        return Response.status(Response.Status.OK)
                .entity(product)
                .build();
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Product updatedProduct) {
       String message=store.updateProduct(updatedProduct);
       if(!message.equals("Product has been updated successfully"))
       {
        return  Response.status(Response.Status.BAD_REQUEST).entity(message).build();
       }
       return  Response.status(Response.Status.OK).entity(message).build();

    }

}
