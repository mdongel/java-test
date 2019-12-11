package com.mdongel.javatest.grocery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mdongel.javatest.grocery.service.ShoppingBasketService;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		
		ShoppingBasketService shoppingBasket = new ShoppingBasketService();
		
		System.out.println("Hello World!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String command = "";
		display();
		while (!command.equals("exit")) {

			command = br.readLine();

			if (command.equals("help")) {
				display();
				continue;
			} else if (command.startsWith("add")) {

			} else if (command.startsWith("priceBasket")) {

			}

		}

		System.out.println("Thank you for using this application...");

	}

	public static void display() {
		System.out.println("- To add new item: add [productName] [amount]");
		System.out.println("-                : add soup 1");
		System.out.println("- To get the price the basket: priceBasket");
		System.out.println("- To exit: exit");
		System.out.println("- To get help: help");
	}
}
