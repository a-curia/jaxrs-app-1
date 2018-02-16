package com.dbbyte.rest.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int productId;
	private String productName;
	private String productGroup;
	private int productPrice;
	private Date productDate;
	
	public Product() {
		super();
	}
	public Product(int productId, String productName, String productGroup, int productPrice, Date productDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productGroup = productGroup;
		this.productPrice = productPrice;
		this.productDate = productDate;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductGroup() {
		return productGroup;
	}
	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public Date getProductDate() {
		return productDate;
	}
	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	
	

}
