package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.sql.Statement;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String FEED_MONEY = "Feed Money";
	private static final String SELECT_PRODUCT = "Select Product";
	private static final String FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = { FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION };
	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		InventoryHandler newInventory = new InventoryHandler();
		newInventory.stockInventory();
		MoneyHandler moneyHandler = new MoneyHandler();
		Logger logger = new Logger();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				for(VendingMachineItem item : newInventory.getInventory()) {
					System.out.println(item.getLocation() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getCategory());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				boolean isPurchase= true;
				while (isPurchase) {
					String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
					if (purchaseChoice.equals(FEED_MONEY)) {
						System.out.println("Please enter money in whole dollar amounts of: $1, $2, $5, or $10.");
						String money = in.nextLine();
						Double moneyAmount = Double.parseDouble(money);
						System.out.println(moneyHandler.customerAmount(moneyAmount));
						logger.logFeed(moneyAmount, moneyHandler.getBalance());
					}
					while (choice.equals("2")) {
						continue;

					}
					if (purchaseChoice.equals(SELECT_PRODUCT)) {
						for (VendingMachineItem item : newInventory.getInventory()) {
							System.out.println(item.getLocation() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getCategory());
						}
						System.out.println("Please enter the location code: ");
						String locationCode = in.nextLine();
						VendingMachineItem customerChoice = new VendingMachineItem();
						for (VendingMachineItem item : newInventory.getInventory()) {
							if (item.getLocation().equals(locationCode)) {
								customerChoice = item;
							}
						}
						System.out.println(newInventory.selectProduct(locationCode));
						System.out.println(moneyHandler.deductPriceOfSelection(customerChoice.getPrice()));
						logger.logSelection(customerChoice.getPrice(), moneyHandler.getBalance());

					}
					if (purchaseChoice.equals(FINISH_TRANSACTION)) {
						isPurchase =false;
						System.out.println(moneyHandler.makeChange());
						logger.logFinish(moneyHandler.getBalance());
					}
				}

			}else if (choice.equals(MAIN_MENU_OPTION_EXIT)){
				System.exit(0);



			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
