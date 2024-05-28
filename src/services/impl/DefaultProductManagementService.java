package services.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import enteti.Product;
import enteti.impl.DefaultProduct;
import services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService {

	private static final String PRODUCTS_INFO_STORAGE = "products.csv";
	private static final String CURRENT_TASK_RESOURCE_FOLDER = "finaltask";
	private static final String RESOURCE_FOLDER = "resources";
	private static final int PRODUCT_PRICE_INDEX = 3;
	private static final int PRODUCT_CATEGORY_INDEX = 2;
	private static final int PRODUCT_NAME_INDEX = 1;
	private static final int PRODUCT_ID_INDEX = 0;

	private static DefaultProductManagementService instance;
	private static List<Product> products;
	 {
		loadProductsFromStorage();
	}

	private DefaultProductManagementService() {

	}

	private void loadProductsFromStorage() {
		products = loadProducts();

	};

	private static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

	private static void initProducts() {
		products = new ArrayList<>(Arrays.asList(new DefaultProduct(1, "Green Door", "Doors", 109.99),
				new DefaultProduct(2, "Oak Door", "Doors", 189.99),
				new DefaultProduct(1, "Cottage Door", "Doors", 209.99),
				new DefaultProduct(1, "Gaming Laptop", "Laptops", 1009.99),
				new DefaultProduct(1, "Office Laptop", "Laptops", 799.99),
				new DefaultProduct(1, "Green Mouse", "Mouses", 49.99),
				new DefaultProduct(1, "Gaming Light Mouse", "Mouses", 329.99)));
	}

	public List<Product> getProducts() {
		return products;

	}

	public Product getProductbyId(int productIdToAddToCart) {
		for (Product product : products) {
			if (product != null && product.getId() == productIdToAddToCart) {
				return product;
			}
		}
		return null;
	}
	
	private  List<Product> loadProducts(){
		try (var stream = Files.lines(Paths.get(RESOURCE_FOLDER, CURRENT_TASK_RESOURCE_FOLDER, PRODUCTS_INFO_STORAGE ))){
			return stream 
						.filter(Objects::nonNull)
						.filter(line -> !line.isEmpty())
						.map(line -> {
							String[] productElements = line.split(",");
							return new DefaultProduct(Integer.valueOf(productElements[PRODUCT_ID_INDEX]),
																	productElements[PRODUCT_NAME_INDEX],
																	productElements[PRODUCT_CATEGORY_INDEX],
																	Double.valueOf(productElements[PRODUCT_PRICE_INDEX]));
						}).collect(Collectors.toList());
		}catch (IOException e) {
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}

	
}