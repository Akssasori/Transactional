package com.seleniumexpress.trans.spring_transactional_01.model;

public class Product {

	private long id;
	private String name;
	
	public Product() {
	}
	
	public Product(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
