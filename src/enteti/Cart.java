package enteti;

import java.util.List;

public interface Cart {

	
	boolean isEmpty();
	
	void addProduct(Product productbyID);
	
	List<Product> getProducts();
	
	
	 void clear();
		// TODO Auto-generated method stub
		
	

}
