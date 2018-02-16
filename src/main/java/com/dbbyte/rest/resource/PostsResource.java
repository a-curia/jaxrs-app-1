package com.dbbyte.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dbbyte.rest.model.Post;
import com.dbbyte.rest.service.ProductService;

@Path("mydata")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostsResource {
	
	ProductService productService = new ProductService();
	
	@GET
	@Path("/external-data")
	public List<Post> getAllExternalPosts() {
		return productService.getExternalPosts();
	}
	
}
