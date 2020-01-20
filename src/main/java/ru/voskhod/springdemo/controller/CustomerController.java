package ru.voskhod.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.voskhod.springdemo.dao.CustomerDAO;
import ru.voskhod.springdemo.entity.Customer;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerDAO customerDAO;

    // inject Customer DAO

    @Autowired
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        // get customers from the DAO
        List<Customer> customers = customerDAO.getCustomers();

        // add customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }


}
