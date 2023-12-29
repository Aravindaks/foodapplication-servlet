package Quallect.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Quallect.dto.CustomerRegister;

public class CustomerRegisterCrud {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("aravind");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public CustomerRegister save(CustomerRegister signup) {
		et.begin();
		em.persist(signup);
		et.commit();
		return signup;
	}
	public CustomerRegister fetchByEmail(String email) throws Exception{
		 Query query = em.createQuery("select a from CustomerRegister a where a.email=?1");
		query.setParameter(1, email);
		return (CustomerRegister) query.getSingleResult();
	}
	public CustomerRegister fetchById(int customer_id) {
		CustomerRegister customer = em.find(CustomerRegister.class, customer_id);
		return customer;
	}
	public CustomerRegister update(CustomerRegister customer) {
		CustomerRegister db = em.find(CustomerRegister.class, customer.getId());
		if(db!=null) {
			et.begin();
			em.merge(customer);
			et.commit();
		}
		return customer;
	}
}
