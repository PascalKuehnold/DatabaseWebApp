package de.pascalkuehnold.databasewebapp.controller;

import de.pascalkuehnold.databasewebapp.entities.Customer;
import de.pascalkuehnold.databasewebapp.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 *
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    //need to inject the customer dao
    private CustomerService customerService;

    /**
     *
     * @param model the spring mvc model
     * @return the string value of the needed link
     */
    @GetMapping(value = "/list")
    public String listCustomers(Model model){
        //get the customers by calling the customerService method
        List<Customer> customers = customerService.getCustomers();

        //add the customers to the spring mvc model
        model.addAttribute("customers", customers);

        //return the string for the required url
        return "list-customers";
    }

    //region Getters and Setters

    //Setter for the customer DAO, handled by dependency injection
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    //endregion

}
