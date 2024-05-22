package services;

import java.util.List;

import enteti.Purchase;

public interface PurchaseManagementService {
	
	void addPurchase(Purchase purchase);
	
	List<Purchase> getPurchaseByUserId(int userId);
	
	List<Purchase> getPurchases();

}
