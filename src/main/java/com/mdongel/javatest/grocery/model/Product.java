package com.mdongel.javatest.grocery.model;

import com.mdongel.javatest.grocery.discount.DiscountProcessor;

public class Product {
    public enum Unit {
        tin, loaf, bottle, single
    }

    private String name;
    private Unit unit;
    private double cost;
    private DiscountProcessor discountProcessor;

    public Product(String name, Unit unit, double cost, DiscountProcessor discountProcessor) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
        this.discountProcessor = discountProcessor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public DiscountProcessor getDiscountProcessor() {
        return discountProcessor;
    }

    public void setDiscountProcessor(DiscountProcessor discountProcessor) {
        this.discountProcessor = discountProcessor;
    }
}
