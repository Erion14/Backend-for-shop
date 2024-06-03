package menu.impl;

import java.util.List;
import java.util.Scanner;

import config.ApplicationContext;
import enteti.Cart;
import enteti.Product;
import menu.Menu;
import services.ProductManagementService;
import services.impl.MySqlProductManagementService;

public class ProductCatalogMenu implements Menu {
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	private static final String CHECKOUT_COMMAND = "checkout";

	{
		context = ApplicationContext.getInstance();
		productManagementService = new MySqlProductManagementService();

	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		while (true) {
			printmenuheader();
			printProductsToConsole();

			String userInput = readUserInput();

			if (context.getloggedinUser() == null) {
				menuToNavigate = new MainMenu();
				System.out.println("You are not logged in, log in or create account");
				break;

			}
			if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
				menuToNavigate = new MainMenu();
				break;
			}

			if (userInput.equalsIgnoreCase(CHECKOUT_COMMAND)) {
				Cart sessionCart = context.getSessioncart();
				if (sessionCart == null || sessionCart.isEmpty()) {
					System.out.println("Your cart is empty. Please, add a product");

				} else {
					menuToNavigate = new CheckoutMenu();
					break;
				}
			} else {
				Product productToAddToCart = fetchProduct(userInput);

				if (productToAddToCart == null) {
					System.out.println("Please, enter produt ID to add product to cart. "
							+ "Or enter 'checkout' to go to checkout menu. "
							+ "Or enter menu if you want to go to main menu");
					continue;
				}
				processAddToCart(productToAddToCart);
			}
		}
		menuToNavigate.start();

	}


	private void processAddToCart(Product productToAddToCart) {
		context.getSessioncart().addProduct(productToAddToCart);
		System.out.printf("Product %s has been added to your cart. "
				+ "If you want to add a new porduct - enter the product id"
				+ "If you want to proceed with checkout - enter word"
				+ "'checkout' to console %n", productToAddToCart.getProductName() );
		

	}

	private Product fetchProduct(String userInput) {
		int productIdToAddToCart = Integer.parseInt(userInput);
		Product productToAddToCart = productManagementService.getProductbyId(productIdToAddToCart);
		return productToAddToCart;
	}

	private String readUserInput() {
		System.out.println("Product ID to add to cart or enter 'checkout' to proceed with checkout :");
		Scanner sc = new Scanner(System.in);
		String userInput = sc.next();
		return userInput;

	}

	private void printProductsToConsole() {
		List<Product> products = productManagementService.getProducts();
		for (Product product : products) {
			System.out.println(product);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void printmenuheader() {
		System.out.println("PRODUCT CATALOG");
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to go back to main menu");

	}

}
