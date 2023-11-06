package com.itbulls.ademi.sect5to10.OOP.EXAM.services;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Order;

public interface OrderManagementService {
	void addOrder(Order order);
	
	Order[] getOrdersByUserId(int userId);
	
	Order[] getOrders();

}
