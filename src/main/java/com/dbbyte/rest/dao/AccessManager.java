package com.dbbyte.rest.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.dbbyte.rest.model.Product;

public class AccessManager {
	
	
	// get all PRODUCT from database
	public ArrayList<Product> getProducts() throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		DatabaseClass db = new DatabaseClass();
		Connection con = db.getConnection();
		Access access = new Access();
		productList = access.getProducts(con);
		return productList;
	}
	
	// save Product to database
	public boolean saveProduct(Product prod) {
		boolean hasErrors = false;
		
		Product myProduct = prod;
		
		try {
			DatabaseClass db = new DatabaseClass();
			Connection con = db.getConnection();
			Access access = new Access();
			access.insertProduct(con, myProduct);
			 
		} catch (Exception e) {
			// TODO: handle exception
			hasErrors = true;
		} 
		
		
		return hasErrors;
	}
}