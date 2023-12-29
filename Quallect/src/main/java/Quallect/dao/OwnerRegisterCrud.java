package Quallect.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Quallect.dto.CustomerRegister;
import Quallect.dto.OwnerRegister;

public class OwnerRegisterCrud {
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("aravind");
	EntityManager em=emf.createEntityManager();
	EntityTransaction et=em.getTransaction();
	
	public OwnerRegister save(OwnerRegister signup) {
		et.begin();
		em.persist(signup);
		et.commit();
		return signup;
	}
	public OwnerRegister fetchByEmail(String email) throws Exception{
		 Query query = em.createQuery("select a from OwnerRegister a where a.email=?1");
		query.setParameter(1, email);
		return (OwnerRegister) query.getSingleResult();
	}
	public OwnerRegister fetchById(int owner_id) {
		OwnerRegister owner = em.find(OwnerRegister.class, owner_id);
		if(owner!=null) {
			return owner;
		}
		else
			return null;
	}
	public OwnerRegister update(OwnerRegister owner) {
		OwnerRegister db = em.find(OwnerRegister.class, owner.getId());
		if(db!=null) {
			et.begin();
			em.merge(owner);
			et.commit();
		}
		return owner;
	}
	public OwnerRegister fetchAll() {
		Query query = em.createQuery(" select a from OwnerRegister a");
		return (OwnerRegister)query.getResultList();
	}
}
