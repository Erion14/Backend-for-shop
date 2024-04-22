package services.impl;

import enteti.Product;
import enteti.impl.DefaultProduct;
import services.ProductManagementService;

public class DefaultProductManagementService implements ProductManagementService{
	private static DefaultProductManagementService instance;
	private static Product[] products;
	static {
		initProducts();
	}


	

	private static void initProducts() {
		products = new Product[] {
				new DefaultProduct(1,"Gaming Computer Low end","Computers",300.99),
				new DefaultProduct(2,"Gaming Computer Medium","Computers",455.99),
				new DefaultProduct(3,"Gaming Computer Medium-high","Computers",569.99),
				new DefaultProduct(4,"Gaming Computer High end","Computers",899.99),

				
		};
		
		
		// TODO Auto-generated method stub
		
	}
	private DefaultProductManagementService() {
		
	}
	
	public static ProductManagementService getInstance() {
		if(instance==null) {
			instance =new DefaultProductManagementService();
		}
		return instance;
	}
	
	@Override
	public Product[] getProducts() {
		
		return products;
	}

	@Override
	public Product getProductbyId(int productIdToAddToCart) {
			for (Product product:products) {
				if(product != null && product.getID() == productIdToAddToCart) {
					return product;
				}
			}
			return null;
			
	}

}
