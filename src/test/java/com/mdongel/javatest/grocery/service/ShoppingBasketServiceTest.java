package com.mdongel.javatest.grocery.service;

import com.mdongel.javatest.grocery.model.Item;
import com.mdongel.javatest.grocery.model.Product;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingBasketServiceTest {

    @Test
    public void shouldAddProductToShoppingBasket() {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService();

        shoppingBasketService.addItem("soup", 3);

        assertEquals(3, shoppingBasketService.getItems().get("soup").getAmount());
        assertEquals("soup", shoppingBasketService.getItems().get("soup").getProduct().getName());


    }

    @Test
    public void shouldAddSameProductToShoppingBasketInDifferentTime() {
        ShoppingBasketService shoppingBasketService = new ShoppingBasketService();

        Product soup = new Product("soup", Product.Unit.tin, 1.2);
        shoppingBasketService.addItem("soup", 3);
        shoppingBasketService.addItem("soup", 8);


        assertEquals(11, shoppingBasketService.getItems().get("soup").getAmount());

    }
}