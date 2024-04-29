package com.merveyilmaz.cohortssecondhw.entity;

import java.time.LocalDate;

public class CorporateCustomer extends Customer{

    public CorporateCustomer(String name, String sector, LocalDate registrationDate) {
        super(name, sector, registrationDate);
    }

    @Override
    public void addOrder(Order order) {
        System.out.println("Corporate customer order added: " + order.getOrderId());
        super.addOrder(order);
    }

    public void addOrder(Order order, String note) {
        System.out.println("Corporate customer order added with note: " + note + ", Order ID: " + order.getOrderId());
        super.addOrder(order);
    }
}
