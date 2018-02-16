package com.dbbyte.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dbbyte.rest.model.Product;

public class Access {
	public ArrayList<Product> getProducts(Connection con) throws SQLException {
		ArrayList<Product> productList = new ArrayList<Product>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM product");
		ResultSet rs = stmt.executeQuery();
		try {
			while (rs.next()) {
				Product productObj = new Product();
				productObj.setProductId(rs.getInt("prd_id"));
				productObj.setProductName(rs.getString("prd_name"));
				productObj.setProductGroup(rs.getString("prd_group"));
				productObj.setProductPrice(12);
				
				productList.add(productObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;

	}
	
	public ArrayList<Product> insertProduct(Connection con, Product prod) throws SQLException {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		Statement stmt = con.createStatement();
		
		stmt.executeUpdate("insert into product(prd_name,prd_group,prd_price) values('"+prod.getProductName()+"','"+prod.getProductGroup()+"','"+prod.getProductPrice()+"')");

		System.out.println("TRY TO INSERT");
		
		stmt.close();
		con.close();
		
		return productList;
		

	}	
}
