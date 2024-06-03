package services.impl;

import java.util.List;

import dao.PurchaseDao;
import dao.impl.MySqlJdbcPurchaseDao;
import dto.PurchaseDto;
import dto.converter.PurchaseDtoToPurchaseConverter;
import enteti.Purchase;
import services.PurchaseManagementService;

public class MySqlPurchaseManagementService implements PurchaseManagementService{
	
	private PurchaseDao purchaseDao;
	private PurchaseDtoToPurchaseConverter purchaseConverter;
	
	{
		purchaseDao = new MySqlJdbcPurchaseDao();
		purchaseConverter = new PurchaseDtoToPurchaseConverter();
	}

	@Override
	public void addPurchase(Purchase purchase) {
		purchaseDao.savePurchase(purchaseConverter.convertPurchaseToPurchaseDto(purchase));
		
	}

	@Override
	public List<Purchase> getPurchaseByUserId(int userId) {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchasesByUserId(userId);
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

	@Override
	public List<Purchase> getPurchases() {
		List<PurchaseDto> purchasesDtos = purchaseDao.getPurchases();
		return purchaseConverter.convertPurchaseDtosToPurchases(purchasesDtos);
	}

}
