package com.mdongel.javatest.grocery.discount;

import com.mdongel.javatest.grocery.model.Item;

import java.time.LocalDate;
import java.util.HashMap;

public abstract class DiscountProcessor {
    private LocalDate startDate;
    private LocalDate endDate;
    private double rate;

    public DiscountProcessor() {
    }

    public DiscountProcessor(double rate) {
        this.rate = rate;
    }

    public DiscountProcessor(LocalDate startDate, LocalDate endDate, double rate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public abstract double process(Item item, HashMap<String,Item> items,LocalDate date);
}
