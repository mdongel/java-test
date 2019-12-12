package com.mdongel.javatest.grocery;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import com.mdongel.javatest.grocery.exception.UnsupportedProductException;
import com.mdongel.javatest.grocery.model.Product;
import com.mdongel.javatest.grocery.service.ShoppingService;
import com.mdongel.javatest.grocery.util.RoundUtil;

import static com.mdongel.javatest.grocery.util.RoundUtil.*;

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
            } else if (command.startsWith("add")) {
                if (!addOperation(command)) displayMenu();
            } else if (command.startsWith("sub")) {
                if (!subOperation(command)) displayMenu();
            } else {
                System.out.println("Usupported Command!");
                displayMenu();
            }

        }

        System.out.println("Thank you for using this application...");

        System.exit(0);
    }

    private static boolean subOperation(String command) {
        String[] cmdItems = command.split(" ");
        double sub = 0;
        if (cmdItems.length == 1) {
            sub = shoppingBasket.performSubTotal(LocalDate.now());
        } else {
            try {
                Integer.parseInt(cmdItems[1]);
            } catch (NumberFormatException e) {
                System.out.println("Day must be numeric!");
                System.out.println("It must be like: sub 5");
                return false;
            }
            sub = shoppingBasket.performSubTotal(LocalDate.now().plusDays(Integer.parseInt(cmdItems[1])));
        }

        displayShoppingBasket();
        System.out.printf("Expected total cost = %.2f \n", round(sub, 2));

        return true;
    }

    private static boolean addOperation(String command) {
        String[] cmdItems = command.split(" ");

        if (cmdItems.length != 3) {
            System.out.println("Invalid usage of add command!");
            System.out.println("It must be like: add soup 3");
            return false;
        }

        if (!cmdItems[0].trim().equals("add")) {
            System.out.println("Invalid usage of add command!");
            System.out.println("It must be like: add soup 3");
            return false;
        }

        try {
            Integer.parseInt(cmdItems[2]);
        } catch (NumberFormatException e) {
            System.out.println("Amount must be numeric!");
            System.out.println("It must be like: add soup 3");
            return false;
        }

        try {
            shoppingBasket.addItem(cmdItems[1], Integer.parseInt(cmdItems[2]));
        } catch (UnsupportedProductException e) {
            System.out.println("Unsupported product entered!");
            System.out.println("Supported products are:");
            shoppingBasket.getProducts().forEach((k, v) -> System.out.println("- " + k));
            return false;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        Product product = shoppingBasket.getProducts().get(cmdItems[1]);
        System.out.println(cmdItems[2] + " " + product.getUnit() + " of " + cmdItems[1] + " successfully added to shopping basket.");
        return true;


    }

    public static void displayShoppingBasket() {
        System.out.println("---------------------------------------");
        System.out.println("Content of Shopping Basket:");
        System.out.println("");
        shoppingBasket.getItems().forEach((k, v) -> System.out.println(v.getAmount() + " " + v.getProduct().getUnit() + " of " + v.getProduct().getName()));
        System.out.println("---------------------------------------");

    }

    public static void displayMenu() {
        System.out.println("-------------------------------------------------------");
        System.out.println("- To add new item:   add [productName] [amount]");
        System.out.println("-                    Available products are:");
        System.out.println("-                    -> add soup 1");
        System.out.println("-                    -> add bread 4");
        System.out.println("-                    -> add milk 3");
        System.out.println("-                    -> add apple 2");
        System.out.println("- To get the price the basket   : sub or sub [day]");
        System.out.println("     For current day            : sub                   ");
        System.out.println("  For s specific day after today: sub  [day]            ");
        System.out.println("- To reset the basket: reset");
        System.out.println("- To exit: exit");
        System.out.println("-------------------------------------------------------");
    }
}
