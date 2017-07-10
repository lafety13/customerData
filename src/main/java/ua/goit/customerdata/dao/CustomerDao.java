package ua.goit.customerdata.dao;

import ua.goit.customerdata.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer findById(Long id);

    List findAllCustomer();

    void save(Customer customer);

    void update(Customer customer);

    void delete(Customer customer);
}
