package com.mdongel.javatest.grocery.discount;

import com.mdongel.javatest.grocery.model.Item;

import java.time.LocalDate;
import java.util.HashMap;

public class RateBasedDiscountProcessor extends DiscountProcessor {

    public RateBasedDiscountProcessor() {
        this(1);
    }

    public RateBasedDiscountProcessor(double rate) {
        super(rate);
    }

    public RateBasedDiscountProcessor(LocalDate startDate, LocalDate endDate, double rate) {
        super(startDate, endDate, rate);
    }

    @Override
    public double process(Item item, HashMap<String, Item> items, LocalDate date) {
        if (date.isAfter(getStartDate()) && date.isBefore(getEndDate())) {
            return item.getAmount() * item.getProduct().getCost() * (1 - getRate());
        } else {
            return item.getAmount() * item.getProduct().getCost();
        }


    }

}
