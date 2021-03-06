package com.jerin.spin.entity.test;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jerin.spin.entity.customer.Customer;

@Repository
public class CustomerDaoTest {
	
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public List<Customer> getCustomerList() {
        EntityManager em = this.emf.createEntityManager();
        try {
            Query query = em.createQuery("select c from Customer c");
            return (List<Customer>)query.getResultList();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
	public Customer getCustomerById(Integer id) {
        EntityManager em = this.emf.createEntityManager();
        try {
            Query query = em.createQuery("select a from Customer a where customerId = :customerId");
            query.setParameter("customerId", id);
            return (Customer)query.getSingleResult();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
	}


}
