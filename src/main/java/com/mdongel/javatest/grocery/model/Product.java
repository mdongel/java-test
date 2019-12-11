package com.mdongel.javatest.grocery.model;

public class Product {
    public enum Unit {
        tin, loaf, bottle, single
    }

    private String name;
    private Unit unit;
    private double cost;

    public Product(String name, Unit unit, double cost) {
        this.name = name;
        this.unit = unit;
        this.cost = cost;
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
}
