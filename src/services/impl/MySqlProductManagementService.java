package services.impl;

import java.util.List;

import dao.ProductDao;
import dao.impl.MySqlJdbcProductDao;
import dto.ProductDto;
import dto.converter.ProductDtoToProductConverter;
import enteti.Product;
import services.ProductManagementService;

public class MySqlProductManagementService implements ProductManagementService{
	
	private ProductDao productDao;
	private ProductDtoToProductConverter productConverter;
	
	{
		productDao = new MySqlJdbcProductDao();
		productConverter = new ProductDtoToProductConverter();
	}

	@Override
	public List<Product> getProducts() {
		List<ProductDto> productDtos = productDao.getProducts();
		return productConverter.convertProductDtosToProducts(productDtos);
	}

	@Override
	public Product getProductbyId(int	id) {
		ProductDto productDto = productDao.getProductById(id);
		return productConverter.convertProductDtoToProduct(productDto);
	}

}
