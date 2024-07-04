package org.eclipse.jakarta.hello;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/products")
public class ProductResource {
private ProductService productService = new ProductService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProduct(@Valid Product product){
        Product createdProduct = productService.addProduct(product);
    return Response.ok(createdProduct).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllProducts(){
        List<Product> products = productService.findAll();
        return  Response.ok(products).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductById(@PathParam("id")int id){
        Optional<Product>product = productService.findById(id);
        if(product.isPresent()){
            return Response.ok(product.get()).build();
        }else{
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
    }

    @GET
    @Path("/search/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchProduct(@PathParam("name") String name){
        List<Product> products = productService.findByName(name);
        return Response.ok(products).build();
    }
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(@PathParam("id")int id, @Valid Product product){
        Optional<Product>updatedProduct = productService.updateProduct(id,product);
        if(updatedProduct.isPresent()){
            return Response.ok(updatedProduct.get()).build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
    }
@DELETE
    @Path("/{id}")
    public Response deleteProduct(@PathParam("id")int id){
        boolean deleted =productService.deleteProduct(id);
        if(deleted){return Response.noContent().build();
        }else {
            return Response.status(Response.Status.NOT_FOUND).entity("Product not found").build();
        }
}
}
