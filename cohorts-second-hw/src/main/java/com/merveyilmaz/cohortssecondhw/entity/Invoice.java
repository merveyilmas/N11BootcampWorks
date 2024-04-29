package com.merveyilmaz.cohortssecondhw.entity;

import java.time.LocalDate;

public class Invoice {

    private int amount;
    private LocalDate date;

    public Invoice(int amount, LocalDate date) {
        this.amount = amount;
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
