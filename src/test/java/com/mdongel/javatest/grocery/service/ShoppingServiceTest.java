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
    public void shouldPriceBasketWithItems3TinsOfSoapAnd2LoavesOfBreadBoughtToday() {
        // Given
        ShoppingService shoppingService = new ShoppingService();

        // Then
        shoppingService.addItem("soup", 3);
        shoppingService.addItem("bread", 2);

        // Expected
        assertEquals(3.15,shoppingService.performSubTotal(LocalDate.now()),1e-15);

    }

    @Test
    public void shouldPriceBasketWithItems6ApplesAnd1BottleOfMilkBoughtToday() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 6);
        shoppingService.addItem("milk", 1);

        assertEquals(1.90,shoppingService.performSubTotal(LocalDate.now()),1e-15);

    }

    @Test
    public void shouldPriceBasketWithItems6ApplesAnd1BottleOfMilkBoughtIn5DaysTime() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 6);
        shoppingService.addItem("milk", 1);

        assertEquals(1.84,shoppingService.performSubTotal(LocalDate.now().plusDays(5)),1e-15);

    }

    @Test
    public void shouldPriceBasketWithItems3Apples2TinsOfSoupAndALoafOfBreadBoughtIn5DaysTime() {
        ShoppingService shoppingService = new ShoppingService();

        shoppingService.addItem("apple", 3);
        shoppingService.addItem("soup", 2);
        shoppingService.addItem("bread", 1);

        assertEquals(1.97,shoppingService.performSubTotal(LocalDate.now().plusDays(5)),1e-15);

    }
}