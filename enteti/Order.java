package com.itbulls.ademi.sect5to10.OOP.EXAM.enteti;

public interface Order {

	boolean isCreditCardNumbervalid(String creditcardnumber);
	
	void setcreditcardnumber(String userinput);
	
	void setproducts(Product[]products);
	
	void setCustomerId(int customerid);
	
	int getcustomerid();

}
