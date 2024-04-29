package com.merveyilmaz.cohortssecondhw.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer extends Person{

    private LocalDate registrationDate;
    private String sector;
    private List<Invoice> invoices;
    private List<Order> orders;


    public Customer(String name, String sector, LocalDate registrationDate) {
        super(name);
        this.registrationDate = registrationDate;
        this.sector = sector;
        this.invoices = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getSector() {
        return sector;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
