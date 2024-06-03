package dao;

import java.util.List;

import dto.PurchaseDto;

public interface PurchaseDao {
	
	void savePurchase(PurchaseDto purchase);
	
	List<PurchaseDto> getPurchasesByUserId(int userId);
	
	List<PurchaseDto> getPurchases();

}
