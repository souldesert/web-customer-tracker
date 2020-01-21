package ru.voskhod.springdemo.service;

import ru.voskhod.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
}
