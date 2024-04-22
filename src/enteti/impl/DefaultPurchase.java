package enteti.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enteti.Product;
import enteti.Purchase;

public class DefaultPurchase implements Purchase {

	private static final int DIGITS_IN_CREDIT_CARD = 16;

	private String creditcardnumber;
	private List<Product> products;
	private int customerid;

	@Override
	public boolean isCreditCardNumbervalid(String creditcardnumber) {
		return creditcardnumber.toCharArray().length == DIGITS_IN_CREDIT_CARD && !creditcardnumber.contains(" ")
				&& Long.parseLong(creditcardnumber) > 0;
	}

	@Override
	public void setcreditcardnumber(String creditnumber) {
		if(creditnumber==null) {
			return;
	
	}
		this.creditcardnumber = creditnumber;
	}

	@Override
	public void setproducts(List<Product> products) {
		this.products=new ArrayList<>(products);

	}

	@Override
	public void setCustomerId(int customerid) {
		this.customerid=customerid;

	}

	@Override
	public int getcustomerid() {
		return this.customerid;
	}

	@Override
	public String toString() {
		return "Order : customer id -" + this.customerid + "\t" + "credit card number- " +this.creditcardnumber+"\t"+"products- "
	+this.products;
	}

	@Override
	public List<Product> getProducts() {
		
		ArrayList<Product> copy = new ArrayList<Product>(this.products);
		return copy;
	}
	
}
