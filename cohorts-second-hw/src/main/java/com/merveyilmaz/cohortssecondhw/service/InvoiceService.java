package com.merveyilmaz.cohortssecondhw.service;

import com.merveyilmaz.cohortssecondhw.entity.Customer;
import com.merveyilmaz.cohortssecondhw.entity.Invoice;

import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    private static final int JUNE_MONTH = 6;

    public List<Invoice> getAllInvoices(List<Customer> customers) {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .collect(Collectors.toList());
    }

    public List<Invoice> getInvoicesAboveAmount(List<Customer> customers, int amount) {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getAmount() > amount)
                .collect(Collectors.toList());
    }

    public double getAverageAmountOfInvoicesAbove(List<Customer> customers, int amount) {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getAmount() > amount)
                .mapToInt(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public double getTotalInvoicesAmountForJuneRegistrations(List<Customer> customers) {
        return customers.stream()
                .filter(c -> c.getRegistrationDate().getMonthValue() == JUNE_MONTH)
                .flatMap(c -> c.getInvoices().stream())
                .mapToInt(Invoice::getAmount)
                .sum();
    }

    public List<String> getCustomersWithInvoicesBelowAmount(List<Customer> customers, int amount) {
        return customers.stream()
                .filter(c -> c.getInvoices().stream().anyMatch(i -> i.getAmount() < amount))
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    public List<String> getCustomerIndustriesWithJuneInvoicesAverageBelow(List<Customer> customers, int average) {
        return customers.stream()
                .filter(c -> c.getRegistrationDate().getMonthValue() == JUNE_MONTH
                        && c.getInvoices().stream().mapToInt(Invoice::getAmount).average().orElse(0) < average)
                .map(Customer::getSector)
                .collect(Collectors.toList());
    }

    public double calculateTotalInvoiceAmount(Customer customer) {
        return customer.getInvoices().stream()
                .mapToInt(Invoice::getAmount)
                .sum();
    }

    public double calculateTotalInvoiceAmount(List<Customer> customers) {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .mapToInt(Invoice::getAmount)
                .sum();
    }
}
