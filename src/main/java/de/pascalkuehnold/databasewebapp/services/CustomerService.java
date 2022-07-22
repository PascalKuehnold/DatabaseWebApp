package de.pascalkuehnold.databasewebapp.services;

import de.pascalkuehnold.databasewebapp.entities.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

}
