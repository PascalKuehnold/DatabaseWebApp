package de.pascalkuehnold.databasewebapp.controller;

import de.pascalkuehnold.databasewebapp.entities.Customer;
import de.pascalkuehnold.databasewebapp.services.CustomerService;
import de.pascalkuehnold.databasewebapp.util.SortUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for the customers
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    //declaration for customer service
    private CustomerService customerService;

    /**
     *
     * @param model the spring mvc model
     * @return the string value of the desired link
     */
    @GetMapping(value = "/list")
    public String listCustomers(Model model, @RequestParam(required = false) String sort){
        //initialize the customers list
        List<Customer> customers = null;

        //check for sort field
        if(sort != null){
            int sortField = Integer.parseInt(sort);
            //get the customers by calling the customerService method
            customers = customerService.getCustomers(sortField);
        } else {
            //not sort field provided, default sorting by lastname
            customers = customerService.getCustomers(SortUtils.LAST_NAME);
        }

        //add the customers to the spring mvc model
        model.addAttribute("customers", customers);

        //return the string for the required url
        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        //create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        //save the customer using our service
        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id, Model model){
        //get the customer from the customer service
        Customer tempCustomer = customerService.getCustomer(id);

        //set customer as model attribute to pre-populate the form
        model.addAttribute("customer", tempCustomer);

        //send over to form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int id){
        //delete the custmer
        customerService.deleteCustomer(id);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("customerNameToSearch") String customerName, Model model){
        //search the customers from the service
        List<Customer> tempCustomers = customerService.searchCustomers(customerName);

        //add customers to the model
        model.addAttribute("customers", tempCustomers);

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
