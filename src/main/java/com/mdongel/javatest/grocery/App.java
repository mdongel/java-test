package com.mdongel.javatest.grocery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mdongel.javatest.grocery.exception.UnsupportedProductException;
import com.mdongel.javatest.grocery.service.ShoppingService;

/**
 * Hello world!
 */
public class App {
    public static ShoppingService shoppingBasket = new ShoppingService();

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = "";
        displayMenu();
        while (!command.equals("exit")) {

            command = br.readLine();

            if (command.equals("reset")) {
                shoppingBasket.reset();
                System.out.println("Now shopping basket is clear...");
                displayMenu();
                continue;
            } else if (command.startsWith("add")) {
                addOperation(command);
            } else if (command.startsWith("subTotal")) {
                subTotalOperation();
            }

        }

        System.out.println("Thank you for using this application...");

        System.exit(0);
    }

    private static void subTotalOperation() {
		shoppingBasket.performSubTotal()
    }

    private static boolean addOperation(String command) {
		String[] cmdItems = command.split(" ");

		if (cmdItems.length != 3) {
			System.out.println("Invalid usage of add command!");
			System.out.println("It should be like: add soup 3");
			return false;
		}

		if (!cmdItems[0].trim().equals("add")) {
			System.out.println("Invalid usage of add command!");
			System.out.println("It should be like: add soup 3");
			return false;
		}

		try {
			Integer.parseInt(cmdItems[2]);
		} catch (NumberFormatException e) {
			System.out.println("Amount should be numeric!");
			System.out.println("It should be like: add soup 3");
			return false;
		}

		try {
			shoppingBasket.addItem(cmdItems[1],Integer.parseInt(cmdItems[2]));
		} catch (UnsupportedProductException e) {
			System.out.println("Unsupported product entered!");
			System.out.println("Supported products are:");
			shoppingBasket.getItems().forEach((k,v)->System.out.print(k+", "));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return true;



	}

    public static void displayMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("- To add new item:   add [productName] [amount]");
		System.out.println("-                    : Available products are:");
		System.out.println("-                    -> add soup 1");
		System.out.println("-                    -> add bread 4");
        System.out.println("-                    -> add milk 3");
        System.out.println("-                    -> add apple 2");
        System.out.println("- To get the price the basket: subTotal [day]");
        System.out.println("- To reset the basket: reset");
        System.out.println("- To exit: exit");
        System.out.println("-------------------------------------------------------");
    }
}
