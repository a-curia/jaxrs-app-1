package com.dbbyte.rest.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
// creates new instance on each request
// use @Singleton if needed
public class MyStartResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getTest() {
		return "This is a test";
	}

}
