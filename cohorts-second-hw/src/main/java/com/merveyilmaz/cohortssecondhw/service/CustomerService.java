package com.merveyilmaz.cohortssecondhw.service;

import com.merveyilmaz.cohortssecondhw.entity.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerService {

    private List<Customer> customers;
    private Map<String, Customer> customerMap;
    private Set<String> customerNames;

    public CustomerService() {
        customers = new ArrayList<>();
        customerMap = new HashMap<>();
        customerNames = new HashSet<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
        customerMap.put(customer.getName(), customer);
        customerNames.add(customer.getName());
    }

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public Customer getCustomerByName(String name) {
        return customerMap.get(name);
    }

    public Set<String> getUniqueCustomerNames() {
        return Collections.unmodifiableSet(customerNames);
    }

    public List<Customer> filterCustomersByName(List<Customer> customers, String letter) {
        return customers.stream()
                .filter(c -> c.getName().contains(letter))
                .collect(Collectors.toList());
    }
}
