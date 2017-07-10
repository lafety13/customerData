package ua.goit.customerdata.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.goit.customerdata.model.Customer;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.load(Customer.class, id);
        LOGGER.info("Customer successfully loaded. Customer details: " + customer);

        return customer;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> findAllCustomer() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        LOGGER.info("Customer list" + customerList);

        return customerList;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
        LOGGER.info("Customer successfully saved. Customer details: " + customer);
    }

    @Override
    public void update(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
        LOGGER.info("Customer successfully updated. Customer details: " + customer);
    }

    @Override
    public void delete(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(customer);
        LOGGER.info("Customer successfully deleted. Customer details: " + customer);
    }

}
