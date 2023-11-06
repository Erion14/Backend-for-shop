package com.itbulls.ademi.sect5to10.OOP.EXAM.services.impl;

import java.util.Arrays;

import com.itbulls.ademi.sect5to10.OOP.EXAM.enteti.Order;
import com.itbulls.ademi.sect5to10.OOP.EXAM.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService	{
	
	
	private static final int DEFAULT_ORDER_CAPACITY = 10;
	
	private static DefaultOrderManagementService instance;
	private int lastindex;
	private Order[] orders;
	
	{
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}
	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}
	@Override
	public void addOrder(Order order) {
		if (order == null) {
			return;
		}
		if (orders.length <= lastindex) {
			orders = Arrays.copyOf(orders, orders.length<<1);
		}
		orders[lastindex++]=order;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		int amountofUsersOrders=0;
		for (Order order : orders) {
			if(order != null && order.getcustomerid() == userId) {
				amountofUsersOrders++;
			}
		}
		Order[] userOrders = new Order[amountofUsersOrders];
		
		int index=0;
		for(Order order : orders) {
			if(order != null && order.getcustomerid() == userId) {
				userOrders[index++] = order;
				
			}
		}
		return userOrders;
	}

	@Override
	public Order[] getOrders() {
		int nonnullOrdersAmount = 0;
		for(Order order : orders) {
			if (order != null) {
				nonnullOrdersAmount++;
			}
		}
		Order [] nonnullOrders = new Order[nonnullOrdersAmount];
		
		int index =0 ;
		for(Order order : orders) {
			if(order != null) {
				nonnullOrders[index++] = order;
			}
		}
		return nonnullOrders;
		// TODO Auto-generated method stub
		
	}
	void clearServiceState() {
		lastindex=0;
		orders = new Order[DEFAULT_ORDER_CAPACITY];
	}

}
