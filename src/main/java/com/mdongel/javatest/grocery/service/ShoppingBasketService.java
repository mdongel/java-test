package com.mdongel.javatest.grocery.service;

import com.mdongel.javatest.grocery.model.Item;

import java.util.HashMap;

public class ShoppingBasketService {
    private HashMap<String, Item> items = new HashMap<String, Item>();

    public void addItem(Item item) {
        Item existingItem = items.get(item.getProduct().getName());
        if (existingItem !=null) {
            existingItem.setAmount(existingItem.getAmount()+item.getAmount());
        } else {
            items.put(item.getProduct().getName(), item);
        }

    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }
}
