package com.dbbyte.rest.resource;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.dbbyte.rest.model.Product;
import com.dbbyte.rest.service.ProductService;

@Path("products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
	
	ProductService productService = new ProductService();

	/**
	 * 
	 * @return string of Products from database
	 */
	@GET
	public String getAllExternalPosts() {
		System.out.println("CALLING getAllExternalPosts");
		
		return productService.getProductsFromDatabase();
	}
	
	@GET
	@Path("posts-to-products-db")
	public String saveProstsIntoProductsDb() {
		return productService.savePostsToProducts();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMessage(Product product, @Context UriInfo uriInfo) throws URISyntaxException {

		Product myProduct = productService.addProduct(product);

		// // the good way - use the uri
		// String newId = String.valueOf(myMessage.getId());
		// URI myUri = uriInfo.getAbsolutePathBuilder().path(newId).build();

		Response response = Response
				// .status(Status.CREATED)
				// .created(new URI("/jax-rs-demo1/webapi/messages/"+myMessage.getId()))
				.created(new URI(uriInfo.getAbsolutePath().toString() + myProduct.getProductId() )).entity(myProduct).build();

		return response;
		
	}
	
}
