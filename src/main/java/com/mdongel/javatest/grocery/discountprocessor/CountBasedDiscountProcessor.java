package com.mdongel.javatest.grocery.discountprocessor;

import com.mdongel.javatest.grocery.model.Item;

import java.time.LocalDate;
import java.util.HashMap;

public class CountBasedDiscountProcessor extends DiscountProcessor {

    public CountBasedDiscountProcessor(LocalDate startDate, LocalDate endDate, double rate) {
        super(startDate, endDate, rate);
    }

    @Override
    public double process(Item item, HashMap<String, Item> items, LocalDate date) {
        if (date.isAfter(getStartDate()) && date.isBefore(getEndDate())
                && items.get("soup") != null && items.get("soup").getAmount() >= 2) {
            // One loaf of bread is half price
            return (item.getAmount() - 1) * item.getProduct().getCost() + item.getProduct().getCost() * getRate();
        } else {
            return item.getAmount() * item.getProduct().getCost();
        }

    }


}
