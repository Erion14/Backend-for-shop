package services;

import java.util.List;

public interface PurchaseManagementService {
	
	void addPurchase(Purchase purchase);
	
	List<Purchase> getPurchaseByUserId(int userId);
	
	List<Purchase> getPurchases();

}
