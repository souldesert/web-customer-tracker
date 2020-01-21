package ru.voskhod.springdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.voskhod.springdemo.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<Customer> getCustomers() {

        // get entity manager
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // create query
        TypedQuery<Customer> query = entityManager.createQuery("SELECT c FROM Customer c", Customer.class);

        // execute query and get result list

        return query.getResultList();
    }

    // inject entityManagerFactory
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}
