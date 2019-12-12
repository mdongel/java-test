package com.mdongel.javatest.grocery.service;

import com.mdongel.javatest.grocery.model.Product;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ShoppingServiceTest {

    @Test
    public void shouldAddProductToShoppingBasket() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("soup", 3);

        assertEquals(3, shoppingService.getItems().get("soup").getAmount());
        assertEquals("soup", shoppingService.getItems().get("soup").getProduct().getName());


    }

    @Test
    public void shouldAddSameProductToShoppingBasketInDifferentTime() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("soup", 3);
        shoppingService.addItem("soup", 8);


        assertEquals(11, shoppingService.getItems().get("soup").getAmount());

    }

    @Test
    public void shouldAddProductToShoppingBasketAndCalculateBasket1() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("soup", 3);
        shoppingService.addItem("bread", 2);



        assertEquals(3.15,shoppingService.performSubTotal(LocalDate.now()),1e-15);




    }

    @Test
    public void shouldAddProductToShoppingBasketAndCalculateBasket2() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 6);
        shoppingService.addItem("milk", 1);

        assertEquals(1.90,shoppingService.performSubTotal(LocalDate.now()),1e-15);

    }

    @Test
    public void shouldAddProductToShoppingBasketAndCalculateBasket3() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 6);
        shoppingService.addItem("milk", 1);

        assertEquals(1.84,shoppingService.performSubTotal(LocalDate.now().plusDays(5)),1e-15);

    }

    @Test
    public void shouldAddProductToShoppingBasketAndCalculateBasket4() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 3);
        shoppingService.addItem("soup", 2);
        shoppingService.addItem("bread", 1);

        assertEquals(1.97,shoppingService.performSubTotal(LocalDate.now().plusDays(5)),1e-15);

    }
}