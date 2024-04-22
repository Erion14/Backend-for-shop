package enteti;

import java.util.List;

public interface Purchase {

	boolean isCreditCardNumbervalid(String creditcardnumber);
	
	void setcreditcardnumber(String userinput);
	
	
	List<Product> getProducts();
	
	void setCustomerId(int customerid);
	
	int getcustomerid();

	void setproducts(List<Product> products);

}
