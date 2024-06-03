package dao;

import java.util.List;

import dto.ProductDto;

public interface ProductDao {
	
	List<ProductDto> getProducts();
	
	ProductDto getProductById(int productId);
	

}
