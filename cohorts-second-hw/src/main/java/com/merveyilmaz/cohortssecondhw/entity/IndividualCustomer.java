package com.merveyilmaz.cohortssecondhw.entity;

import java.time.LocalDate;

public class IndividualCustomer extends Customer{

    public IndividualCustomer(String name, String sector, LocalDate registrationDate) {
        super(name, sector, registrationDate);
    }

    @Override
    public void addOrder(Order order) {
        System.out.println("Individual customer order added: " + order.getOrderId());
        super.addOrder(order);
    }
}
