package enteti.impl;

import enteti.Product;

public class ComparableProduct implements Product, Comparable<Product> {
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;
	
	public ComparableProduct(){
		
	}

	
	
	public ComparableProduct(int id, String productName, String categoryName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}



	@Override
	public String toString() {
		return "ComparableProduct [id=" + id + ", productName=" + productName + ", categoryName=" + categoryName
				+ ", price=" + price + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public int compareTo(Product otherProduct) {
		return this.id - otherProduct.getId();
	}

	

}
