package dto.converter;

import java.util.ArrayList;
import java.util.List;

import dto.PurchaseDto;
import enteti.Purchase;
import enteti.impl.DefaultPurchase;

public class PurchaseDtoToPurchaseConverter {
	
	
	private ProductDtoToProductConverter productConverter;
	private UserDtoToUserConverter userConverter;
	
	{
		productConverter = new ProductDtoToProductConverter();
		userConverter = new UserDtoToUserConverter();
	}
	
	public Purchase convertPurchaseDtoToPurchase(PurchaseDto purchaseDto) {
		Purchase purchase = new DefaultPurchase();
		purchase.setcreditcardnumber(purchaseDto.getUserDto().getCreditCard());
		purchase.setCustomerId(purchaseDto.getUserDto().getId());
		purchase.setproducts(productConverter.convertProductDtosToProducts(purchaseDto.getProductDtos()));
		
		return purchase;
		
	}
	
	public PurchaseDto convertPurchaseToPurchaseDto(Purchase purchase) {
		PurchaseDto purchaseDto = new PurchaseDto();
		purchaseDto.setProductDtos(productConverter.convertProductsToProductDtos(purchase.getProducts()));
		purchaseDto.setUserDto(userConverter.convertUserIdToUserDtoWithOnlyId(purchase.getcustomerid()));
		
		return purchaseDto;
	}
	
	public List<Purchase> convertPurchaseDtosToPurchases(List<PurchaseDto> purchasesDtos){
		List<Purchase> purchases = new ArrayList<>();
		if (purchasesDtos != null) {
			for (PurchaseDto purchaseDto : purchasesDtos) {
				purchases.add(convertPurchaseDtoToPurchase(purchaseDto));
				
			}
		}
		return purchases;
	}

}
