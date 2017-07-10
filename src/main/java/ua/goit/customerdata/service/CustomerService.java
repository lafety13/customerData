package ua.goit.customerdata.service;

import ua.goit.customerdata.model.Customer;

import java.util.List;

public interface CustomerService {
    List findAll();
    Customer findById(Long id);
    void add(Customer customer);
    void update(Customer customer);
}
