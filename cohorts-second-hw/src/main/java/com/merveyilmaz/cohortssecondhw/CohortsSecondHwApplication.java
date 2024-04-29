package com.merveyilmaz.cohortssecondhw;

import com.merveyilmaz.cohortssecondhw.entity.*;
import com.merveyilmaz.cohortssecondhw.service.CustomerService;
import com.merveyilmaz.cohortssecondhw.service.InvoiceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class CohortsSecondHwApplication {

    public static void main(String[] args) {
        SpringApplication.run(CohortsSecondHwApplication.class, args);

        CustomerService customerService = new CustomerService();
        InvoiceService invoiceService = new InvoiceService();

        List<Customer> customers = createCustomers();
        customers.forEach(customerService::addCustomer);

        addInvoicesToCustomers(customers);
        addOrdersToCustomers(customers);

        System.out.println("All customers: ");
        printCustomers(customerService.getCustomers());

        performCustomerOperations(customerService, customers);
        performInvoiceOperations(invoiceService, customers);
    }

    private static List<Customer> createCustomers() {

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Caner", "Technology", LocalDate.of(2023, 6, 1)));
        customers.add(new Customer("Ersin", "Finance", LocalDate.of(2023, 2, 15)));
        customers.add(new CorporateCustomer("Sude", "Healthcare ", LocalDate.of(2023, 6, 1)));
        customers.add(new IndividualCustomer("Merve", "Education ", LocalDate.of(2023, 3, 15)));

        return customers;
    }

    private static void addInvoicesToCustomers(List<Customer> customers) {

        for (Customer customer : customers) {

            customer.addInvoice(new Invoice(450, LocalDate.of(2022, 1, 1)));
            customer.addInvoice(new Invoice(2700, LocalDate.of(2023, 3, 3)));
        }
    }

    private static void addOrdersToCustomers(List<Customer> customers) {

        for (Customer customer : customers) {

            Order order = new Order(customer.getOrders().size() + 1);

            for (int i = 1; i <= 2; i++) {
                order.addProduct(new Product("Product " + i, i * 500));
            }
            customer.addOrder(order);
        }
    }

    private static void printCustomers(List<Customer> customers) {

        customers.forEach(customer -> {
            addBlank();
            System.out.println("Customer Name: " + customer.getName());
            System.out.println("Sector: " + customer.getSector());
            System.out.println("Registration Date: " + customer.getRegistrationDate());

            System.out.println("Invoices:");
            customer.getInvoices().forEach(invoice -> {
                System.out.println(" - Amount: " + invoice.getAmount());
                System.out.println(" - Date: " + invoice.getDate());
            });

            System.out.println("Orders:");
            customer.getOrders().forEach(order -> {
                System.out.println(" - Order ID: " + order.getOrderId());

                System.out.println("Products:");
                order.getProducts().forEach(product -> {
                    System.out.println(" - Product: " + product.getName() + ", Price: " + product.getPrice());
                });
            });
        });
        addBlank();
    }

    private static void performCustomerOperations(CustomerService customerService, List<Customer> customers) {

        List<Customer> filteredCustomers = customerService.filterCustomersByName(customers, "C");
        System.out.println("Customers with 'C':");
        filteredCustomers.forEach(c -> System.out.println("Name: " + c.getName()
                + " Sector: " + c.getSector()
                + " Registration Date: " + c.getRegistrationDate()));
        addBlank();

        System.out.println("Customer who name is Merve:");
        Customer customer = customerService.getCustomerByName("Merve");
        System.out.println("Name: " + customer.getName()
                + " Sector: " + customer.getSector()
                + " Registration Date: " + customer.getRegistrationDate());
        addBlank();

        System.out.println("Customers whose name is unique:");
        Set<String> uniqueCustomerNames = customerService.getUniqueCustomerNames();
        uniqueCustomerNames.forEach(name -> System.out.println("Name: " + name));
        addBlank();
    }

    private static void performInvoiceOperations(InvoiceService invoiceService, List<Customer> customers) {

        double totalInvoicesAmountForJune = invoiceService.getTotalInvoicesAmountForJuneRegistrations(customers);
        System.out.println("Total invoices amount for June registrations: " + totalInvoicesAmountForJune);
        addBlank();

        List<Invoice> allInvoices = invoiceService.getAllInvoices(customers);
        System.out.println("All invoices:");
        allInvoices.forEach(i -> System.out.println("Amount: " + i.getAmount() + " Date: " + i.getDate()));
        addBlank();

        List<Invoice> invoicesAbove1500 = invoiceService.getInvoicesAboveAmount(customers, 1500);
        System.out.println("Invoices above 1500:");
        invoicesAbove1500.forEach(i -> System.out.println("Amount: " + i.getAmount() + " Date: " + i.getDate()));
        addBlank();

        double averageAmountAbove1500 = invoiceService.getAverageAmountOfInvoicesAbove(customers, 1500);
        System.out.println("Average amount of invoices above 1500: " + averageAmountAbove1500);
        addBlank();

        List<String> customersWithInvoicesBelow500 = invoiceService.getCustomersWithInvoicesBelowAmount(customers, 500);
        System.out.println("Customers with invoices below 500:");
        customersWithInvoicesBelow500.forEach(System.out::println);
        addBlank();

        List<String> industriesWithJuneInvoicesAverageBelow750 = invoiceService.getCustomerIndustriesWithJuneInvoicesAverageBelow(customers, 750);
        System.out.println("Industries with June invoices average below 750:");
        industriesWithJuneInvoicesAverageBelow750.forEach(System.out::println);
        addBlank();

        Customer customer = customers.get(0);
        double totalInvoiceAmountForCustomer = invoiceService.calculateTotalInvoiceAmount(customer);
        System.out.println("Total invoice amount for " + customer.getName() + ": " + totalInvoiceAmountForCustomer);
        addBlank();

        double totalInvoiceAmountForAllCustomers = invoiceService.calculateTotalInvoiceAmount(customers);
        System.out.println("Total invoice amount for all customers: " + totalInvoiceAmountForAllCustomers);
        addBlank();
    }

    private static void addBlank() {
        System.out.println();
    }

}
