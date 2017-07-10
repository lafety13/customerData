package ua.goit.customerdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.customerdata.model.Customer;
import ua.goit.customerdata.dao.CustomerDao;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @SuppressWarnings("unchecked")
    @Transactional
    public List<Customer> findAll() {
        return customerDao.findAllCustomer();
    }

    @Override
    @Transactional
    public Customer findById(Long id) {
        return customerDao.findById(id);
    }

    @Override
    @Transactional
    public void add(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerDao.update(customer);
    }
}
