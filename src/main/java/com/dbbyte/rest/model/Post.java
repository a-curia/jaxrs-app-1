package com.dbbyte.rest.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Post {

	private long id;
	private long userId;
	private String title;
	private String body;
	
	
	public Post() {
		super();
	}


	public Post(long id, long userId, String title, String body) {
		super();
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getBody() {
		return body;
	}


	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
}
