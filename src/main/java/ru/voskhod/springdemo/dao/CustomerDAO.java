package ru.voskhod.springdemo.dao;

import ru.voskhod.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> getCustomers();
}