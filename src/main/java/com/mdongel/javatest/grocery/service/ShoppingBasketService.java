package com.mdongel.javatest.grocery.service;

import com.mdongel.javatest.grocery.exception.UnsupportedProductException;
import com.mdongel.javatest.grocery.model.Item;
import com.mdongel.javatest.grocery.model.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShoppingBasketService {
    private HashMap<String, Item> items = new HashMap<String, Item>();
    private Map<String, Product> products = Arrays.asList(new Product("soup", Product.Unit.tin, 0.65),
            new Product("bread", Product.Unit.loaf, 0.80),
            new Product("milk", Product.Unit.bottle, 1.30),
            new Product("apple", Product.Unit.single, 0.10)).stream().collect(Collectors.toMap(Product::getName, p -> p));

    public void addItem(String productName, int amount) {


        Item existingItem = items.get(productName);
        if (existingItem != null) {
            existingItem.setAmount(existingItem.getAmount() + amount);
        } else {
            Product product = products.get(productName);
            if (product == null)
                throw new UnsupportedProductException("Unsupported product to be added.");

            items.put(productName, new Item(product,amount));
        }

    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
}
