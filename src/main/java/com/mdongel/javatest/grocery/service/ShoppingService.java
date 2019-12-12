package com.mdongel.javatest.grocery.service;

import com.mdongel.javatest.grocery.discount.CountBasedDiscountProcessor;
import com.mdongel.javatest.grocery.discount.NoDiscountProcessor;
import com.mdongel.javatest.grocery.discount.RateBasedDiscountProcessor;
import com.mdongel.javatest.grocery.exception.UnsupportedProductException;
import com.mdongel.javatest.grocery.model.Item;
import com.mdongel.javatest.grocery.model.Product;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

public class ShoppingService {
    private HashMap<String, Item> items = new HashMap<String, Item>();
    private Map<String, Product> products = Arrays.asList(
            new Product("soup", Product.Unit.tin, 0.65, new NoDiscountProcessor()),
            new Product("bread", Product.Unit.loaf, 0.80, new CountBasedDiscountProcessor(LocalDate.now().plusDays(-1), LocalDate.now().plusDays(7), 0.5)),
            new Product("milk", Product.Unit.bottle, 1.30, new NoDiscountProcessor()),
            new Product("apple", Product.Unit.single, 0.10, new RateBasedDiscountProcessor(LocalDate.now().plusDays(3), LocalDate.now().with(lastDayOfMonth()), 0.1))).
            stream().collect(Collectors.toMap(Product::getName, p -> p));

    public void addItem(String productName, int amount) throws UnsupportedProductException {


        Item existingItem = items.get(productName);
        if (existingItem != null) {
            existingItem.setAmount(existingItem.getAmount() + amount);
        } else {
            Product product = products.get(productName);
            if (product == null)
                throw new UnsupportedProductException("Unsupported product to be added.");

            items.put(productName, new Item(product, amount));
        }

    }

    public double performSubTotal(LocalDate date) {

        return items.entrySet()
                .stream()
                .map(i -> i.getValue().getProduct().getDiscountProcessor().process(i.getValue(), items, date))
                .reduce(0.0, Double::sum);
    }

    public void reset() {
        items.clear();
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public HashMap<String, Item> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Item> items) {
        this.items = items;
    }


}
