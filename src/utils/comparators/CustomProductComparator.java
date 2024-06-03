package utils.comparators;

import java.util.Comparator;

import enteti.Product;

public class CustomProductComparator implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		int result = o1.getCategoryName().compareTo(o2.getCategoryName());
		if(result == 0) {
			double priceDelta = o1.getPrice() - o2.getPrice();
			result = priceDelta < 0 ? -1 : (priceDelta == 0) ? 0 : 1;
		}
		if (result == 0) {
			result = o1.getProductName().compareTo(o2.getProductName());
		}
		return result;
	}
	
	

}
