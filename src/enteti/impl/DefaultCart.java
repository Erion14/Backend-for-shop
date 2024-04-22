package enteti.impl;

import java.util.Arrays;

import enteti.Cart;
import enteti.Product;

public class DefaultCart implements Cart {

	private static final int PRODUCT_CAPACITY = 10;
	private Product[] products;
	private int lastindex;

	{
		products = new Product[PRODUCT_CAPACITY];
	}

	@Override
	public boolean isempty() {
		if (products == null || products.length == 0) {
			return true;
		}

		for (Product product : products) {
			if (product != null) {
				return false;
			}
		}
		return false;
	}

	@Override
	public void addProduct(Product product) {
		if (product == null) {
			return;
		}
		if (products.length <= lastindex) {
			products = Arrays.copyOf(products, products.length << 1);

		}
		products[lastindex++] = product;
	}

	@Override
	public Product[] getproducts() {
		int nonnull = 0;
		for (Product product : products) {
			if (product != null) {
				nonnull++;
			}
		}
		Product[] nonnulli = new Product[nonnull];
		int index = 0;
		for (Product product : products) {
			if(product != null) {
				nonnulli[index++]=product;
			}
		}
		return nonnulli;
	}

	@Override
	public void clear() {
		products = new Product[PRODUCT_CAPACITY];
	}

}
