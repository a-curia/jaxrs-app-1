package com.dbbyte.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import com.dbbyte.rest.dao.AccessManager;
import com.dbbyte.rest.dao.DatabaseClass;
import com.dbbyte.rest.exception.DataNotFoundException;
import com.dbbyte.rest.model.Post;
import com.dbbyte.rest.model.Product;
import com.google.gson.Gson;

public class ProductService {

	Client clientExternalApi = ClientBuilder.newClient();

	String username = "user";
	String password = "pass";
	String usernameAndPassword = username + ":" + password;
	String authorizationHeaderValue = "Basic "
			+ java.util.Base64.getEncoder().encodeToString(usernameAndPassword.getBytes());

	private static final String EXTERNAL_REST_URI = "https://jsonplaceholder.typicode.com/posts";

	private Map<Long, Product> productsMap = DatabaseClass.getProducts();
	
	private Product myProduct;

	public List<Post> getExternalPosts() {

		/* use the List of Objects */
		List<Post> posts = clientExternalApi.target(EXTERNAL_REST_URI)
				// .path(String.valueOf(1)) // with url parameter as integer/string/object
				.request(MediaType.APPLICATION_JSON)
				// .header("Authorization", authorizationHeaderValue) // uncomment this is you
				// have Auth
				.get(new GenericType<List<Post>>() {
				});

		/* can also use Response for fine-grained, if needed */
		// Response response = clientExternalApi.target(EXTERNAL_REST_URI)
		// .request(MediaType.APPLICATION_JSON)
		// .header("Authorization", authorizationHeaderValue) // comment/uncomment this
		// is you have Auth
		// .get();
		// try {
		// if (response.getStatus() == 200) {
		// Post postResponse = response.readEntity(Post.class);
		// }
		// } finally {
		// response.close();
		// /**
		// * Remember to always close() the Response objects. Response objects reference
		// open socket streams.
		// */
		// }

		// here we will use "posts" list
		return posts;

	}

	/**
	 * 
	 * EXEMPLU DE POST CU BODY; se foloseste prima parte de la GET, aceea de client
	 * target si se schimba metoda si se pune body-ul
	 * 
	 * String response = target.request() .post(Entity.entity("test body",
	 * MediaType.TEXT_PLAIN_TYPE), String.class); System.out.println(response);
	 */

	public List<Product> getProducts() {
		return new ArrayList<>(productsMap.values());
	}

	public Product getProductById(long id) {

		myProduct = productsMap.get(id);

		if (myProduct == null) {
			throw new DataNotFoundException("Not finding " + myProduct.getProductId());
		}

		return myProduct;
	}

	/**
	 * get all products from database as String
	 */
	public String getProductsFromDatabase() {
				
		String products = null;
		ArrayList<Product> courseList = new ArrayList<Product>();
		try {
			courseList = new AccessManager().getProducts();
			Gson gson = new Gson();
			products = gson.toJson(courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	/**
	 * 1 - call the external endpoint to get some data - the Posts data
	 * 2 - using the Post entity, parse that data and insert some of it into the PRODUCT table in PostgreSQL
	 */
	public String savePostsToProducts() {
		
		// 1
		/* use the List of Objects */
		List<Post> posts = getExternalPosts();
		
		// 2 - for each document in the list, convert to Post object and map to Product and insert into db
		AccessManager am = new AccessManager();
		
		
		for (Post post : posts) {
			Product myPostToProd = new Product();
			myPostToProd.setProductName(post.getTitle().substring(0, 10));
			myPostToProd.setProductGroup(post.getTitle().substring(5, 10));
			myPostToProd.setProductPrice(Integer.parseInt(post.getUserId()+""));

			System.out.println("from Post will go to Product|| "+post.getTitle()+ "---"+post.getUserId());
			
			am.saveProduct(myPostToProd);
			
		}
		
		return null;
	}

	 public Product addProduct(Product myProduct) {
		 
		 AccessManager am = new AccessManager();
		 am.saveProduct(myProduct);
		 
		 myProduct.setProductId(myProduct.getProductId());
	 
	 return myProduct;
	 }
	//
	// public Product updateProduct(Product product) {
	// if (product.getId() <= 0) {
	// return null;
	// }
	// products.put(product.getId(), product);
	// return product;
	// }
	//
	// public Product removeProduct(long id) {
	// return products.remove(id);
	// }

}
