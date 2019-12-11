package com.mdongel.javatest.grocery.model;

public class Item {
    private Product product;
    private int amount;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Item(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
}
