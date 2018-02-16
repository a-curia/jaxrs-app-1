package com.dbbyte.rest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.dbbyte.rest.model.Product;

public class DatabaseClass {

	private static Map<Long, Product> productsMap = new HashMap<>();

	public static Map<Long, Product> getProducts() {
		return productsMap;
	}

	public Connection getConnection() throws Exception {
		try {
			String connectionURL = "my-jdbc-conn-string";
			Connection connection = null;
			Class.forName("org.postgresql.Driver").newInstance();
			connection = DriverManager.getConnection(connectionURL, "postgres", "postgres");
			return connection;
		} catch (Exception e) {
			throw e;
		}

	}
}
