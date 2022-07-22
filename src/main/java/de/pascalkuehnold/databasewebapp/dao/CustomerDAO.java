package de.pascalkuehnold.databasewebapp.dao;

import de.pascalkuehnold.databasewebapp.entities.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

}
