package com.mdongel.javatest.grocery.discountprocessor;

import com.mdongel.javatest.grocery.model.Item;

import java.time.LocalDate;
import java.util.HashMap;

public class DefaultDiscountProcessor extends DiscountProcessor {

    public DefaultDiscountProcessor() {
        this(1);
    }

    public DefaultDiscountProcessor(double rate) {
        super(rate);
    }

    public DefaultDiscountProcessor(LocalDate startDate, LocalDate endDate, double rate) {
        super(startDate, endDate, rate);
    }

    @Override
    public double process(Item item, HashMap<String, Item> items, LocalDate date) {
        return item.getAmount() * item.getProduct().getCost() * getRate();
    }

}
