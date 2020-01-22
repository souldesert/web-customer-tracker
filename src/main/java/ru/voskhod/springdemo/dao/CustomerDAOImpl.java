package ru.voskhod.springdemo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.voskhod.springdemo.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.joinTransaction();
        return entityManager.createQuery("SELECT c FROM Customer c ORDER BY lastName", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // todo выяснить почему автоматически не подхватывается транзакция
        // (а если сделать unwrap и получить Session все работает ок)
        entityManager.joinTransaction();

        // save or update the customer
        entityManager.merge(customer);

    }

    @Override
    public Customer getCustomer(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.joinTransaction();
        return entityManager.find(Customer.class, id);
    }

}
