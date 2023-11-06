package com.itbulls.ademi.sect5to10.OOP.EXAM.services;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Product;

public interface ProductManagementService {
	
	Product[] getProducts();
	
	Product getProductbyId(int productIdToAddToCart);


}
