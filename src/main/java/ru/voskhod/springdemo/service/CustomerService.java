package ru.voskhod.springdemo.service;

import org.springframework.transaction.annotation.Transactional;
import ru.voskhod.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    @Transactional
    void saveCustomer(Customer customer);
}
