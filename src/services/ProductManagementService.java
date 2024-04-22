package services;

import enteti.Product;

public interface ProductManagementService {
	
	Product[] getProducts();
	
	Product getProductbyId(int productIdToAddToCart);


}
