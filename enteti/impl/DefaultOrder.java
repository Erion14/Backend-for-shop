package com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.impl;

import java.util.Arrays;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Order;
import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Product;

public class DefaultOrder implements Order {

	private static final int DIGITS_IN_CREDIT_CARD = 16;

	private String creditcardnumber;
	private Product[] products;
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
	public void setproducts(Product[] products) {
		this.products=products;

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
		return "Order : customer id -" + this.customerid + "\t" + "credit card number- " +this.creditcardnumber+"\t"+"products- " +Arrays.toString(this.products);
	}
	
}
