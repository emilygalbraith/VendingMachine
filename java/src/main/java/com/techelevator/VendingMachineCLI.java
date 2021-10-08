package com.techelevator;

import com.techelevator.view.Menu;

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
		InventoryHandler newInventory = new InventoryHandler();
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				newInventory.stockInventory();
				for(VendingMachineItem item : newInventory.getInventory()) {
					System.out.println(item.getLocation() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getCategory());
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				String purchaseChoice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);
				MoneyHandler moneyHandler = new MoneyHandler();
				if(purchaseChoice.equals(FEED_MONEY)){
					Scanner input = new Scanner(System.in);
					System.out.println("Please enter money in whole dollar amounts of: $1, $2, $5, or $10.");
					String money = input.nextLine();
					Double moneyAmount = Double.parseDouble(money);
					System.out.println(moneyHandler.customerAmount(moneyAmount));
				} if(purchaseChoice.equals(SELECT_PRODUCT)){
					
					for(VendingMachineItem item : newInventory.getInventory()) {
						System.out.println(item.getLocation() + "|" + item.getName() + "|" + item.getPrice() + "|" + item.getCategory());

					}

				} if(purchaseChoice.equals(FINISH_TRANSACTION)){
					//to do
				}

			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
