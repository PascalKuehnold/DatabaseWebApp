package de.pascalkuehnold.databasewebapp.services;

import de.pascalkuehnold.databasewebapp.dao.CustomerDAO;
import de.pascalkuehnold.databasewebapp.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{


    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers(int sortValue) {
        return customerDAO.getCustomers(sortValue);
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Override
    @Transactional
    public List<Customer> searchCustomers(String customerName) {
        return customerDAO.searchCustomers(customerName);
    }

    //inject the customerDAO
    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

}
