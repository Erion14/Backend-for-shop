package services;

import java.util.List;

import enteti.Product;

public interface ProductManagementService {
	
	List<Product> getProducts();
	
	Product getProductbyId(int productIdToAddToCart);


}
