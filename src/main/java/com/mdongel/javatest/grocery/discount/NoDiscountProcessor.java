package com.mdongel.javatest.grocery.discount;

import com.mdongel.javatest.grocery.model.Item;

import java.time.LocalDate;
import java.util.HashMap;

public class NoDiscountProcessor extends DiscountProcessor {

    public NoDiscountProcessor() {
        this(1);
    }

    public NoDiscountProcessor(double rate) {
        super(rate);
    }

    public NoDiscountProcessor(LocalDate startDate, LocalDate endDate, double rate) {
        super(startDate, endDate, rate);
    }

    @Override
    public double process(Item item, HashMap<String, Item> items, LocalDate date) {
        return item.getAmount() * item.getProduct().getCost() * getRate();
    }

}
