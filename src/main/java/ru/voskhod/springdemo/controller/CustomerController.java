package ru.voskhod.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.voskhod.springdemo.dao.CustomerDAO;
import ru.voskhod.springdemo.entity.Customer;
import ru.voskhod.springdemo.service.CustomerService;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    // inject CustomerService

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/list")
    public String listCustomers(Model model) {

        // get customers from the CustomerService
        List<Customer> customers = customerService.getCustomers();

        // add customers to the model
        model.addAttribute("customers", customers);

        return "list-customers";
    }


}
