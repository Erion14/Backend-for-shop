package menu.impl;

import java.util.Scanner;

import config.ApplicationContext;
import enteti.Purchase;
import enteti.impl.DefaultPurchase;
import menu.Menu;
import services.PurchaseManagementService;

public class CheckoutMenu implements Menu {
	
	private static final String CONFIRMATION_CREDIT_CARD_WORD = "confirm";
	
	private ApplicationContext context;
	private PurchaseManagementService purchaseManagementService;

	{
		context = ApplicationContext.getInstance();
		purchaseManagementService = new MySqlPurchaseManagementService();
	}

	@Override
	public void start() {
		while (true) {
			printmenuheader();
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();

			if (!createOrder(userInput)) {
				continue;
			}
			context.getSessioncart().clear();
			break;
		}
		System.out.println("Thanks a lot for your purchase. Details about your orders are sent to your email");
		new MainMenu().start();

	}

	private boolean createOrder(String creditCardNumber) {
		Purchase order = new DefaultPurchase();
		
		if (creditCardNumber.equalsIgnoreCase(CONFIRMATION_CREDIT_CARD_WORD)) {
			creditCardNumber = context.getloggedinUser().getCreditCard();
		}
		if (!order.isCreditCardNumbervalid(creditCardNumber)) {
			return false;
		}
		
		order.setcreditcardnumber(creditCardNumber);
		order.setproducts(context.getSessioncart().getProducts());
		order.setCustomerId(context.getloggedinUser().getId());
		purchaseManagementService.addPurchase(order);
		return true;
	}

	@Override
	public void printmenuheader() {
		System.out.println("Checkout menu");
		String creditCard = context.getloggedinUser().getCreditCard();
		if (creditCard != null && !creditCard.isEmpty()) {
			System.out.println("Confirm your credit card number \"" + creditCard + "\" by writing \"" + CONFIRMATION_CREDIT_CARD_WORD + "\": ");
			
		}else {
			System.out.println("Enter your credit card number without spaces and press enter to confirm purchase");;

		}

	}

}
