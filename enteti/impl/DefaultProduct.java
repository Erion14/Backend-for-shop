package com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.impl;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Product;

public class DefaultProduct implements Product{
	
	private int id;
	private String productname;
	private String category;
	private double price;
	
	
	public DefaultProduct() {
		
	}
	public DefaultProduct(int id, String productname, String category, double price) {
		this.id =id;
		this.productname=productname;
		this.category=category;
		this.price=price;
	}
	public String toString() {
		return "Product id=" + id + ", product name= "+productname+", category= "+category+", price = "+price;
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.id;
		
	}

	@Override
	public String getProductname() {
		// TODO Auto-generated method stub
		return this.productname;
	}

}
