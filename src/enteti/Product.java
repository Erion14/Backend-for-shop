package enteti;

public interface Product {
	int getId();

	void setId(int id);
	
	String getProductName();
	
	void setProductName(String productName);
	
	String getCategoryName();
	
	void setCategoryName(String categoryName);
	
	double getPrice();
	
	void setPrice(double price);
}
