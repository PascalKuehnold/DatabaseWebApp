package de.pascalkuehnold.databasewebapp.services;

import de.pascalkuehnold.databasewebapp.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers(int sortValue);

    void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);

    List<Customer> searchCustomers(String customerName);
}
