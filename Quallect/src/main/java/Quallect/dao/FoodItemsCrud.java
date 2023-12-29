package Quallect.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Quallect.dto.FoodItems;
import Quallect.dto.OwnerRegister;

public class FoodItemsCrud {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("aravind");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public List<FoodItems> fetchAll() {
		 Query query = em.createQuery("select a from FoodItems a");
		return query.getResultList();

	}
	
	
//	public void save(FoodItems fooditems, int i) {
//		OwnerRegister owner1 = em.find(OwnerRegister.class, i);
//
//		if (owner1 != null) {
//			et.begin();
//			FoodItems db = em.merge(fooditems);
//			et.commit();
//			
//			List<FoodItems> list =new ArrayList<FoodItems>();
//			list.add(db);
//			list.addAll(owner1.getFood());
//			owner1.setFood(list);
//			
//			et.begin();
//			em.merge(owner1);
//			et.commit();
//			
//
//		}
//
//	}
	
	
	public FoodItems save(FoodItems food) {
		et.begin();
		em.persist(food);
		et.commit();
		return food;
	}
	
	public void foodClear(FoodItems food) {
		et.begin();
		em.remove(food);
		et.commit();
	}
	public FoodItems fetchById(int id) {
		FoodItems db = em.find(FoodItems.class, id);
		if(db!=null) {
			return db;
			
		}
		return null;
	}
	
//	public List<FoodItems> fetchById(int id) {
//
//		OwnerRegister db = em.find(OwnerRegister.class, id);
//		List<FoodItems> db1 = db.getFood();
//
//		if(db!=null) {
//			return  db1;
//		}
//		return null;	
//		}
//	

	public FoodItems updateFood(FoodItems food) {
		FoodItems db = em.find(FoodItems.class, food.getId());
		if(db!=null) {
			et.begin();
			em.merge(food);
			et.commit();
			return food;
		}
		else
			return null;
	}

		public List<FoodItems> fetchByOwnerId(int id){
			Query query = em.createQuery("select a from FoodItems a where a.owner_Id=?1");
			query.setParameter(1, id);
			List<FoodItems> food = query.getResultList();
			if(food!=null) {
				return food;
			}
			return null;
		}

	public FoodItems fetchByIdNo(int id) {
		FoodItems db = em.find(FoodItems.class, id);
		if(db!=null) {
			return db;
		}
		else
		return null;
	}


//	public FoodItems deletFood(int id) {
//		FoodItems db = em.find(FoodItems.class, id);
//		if(db!= null) {
//			et.begin();
//			em.remove(db);
//			et.commit();
//		}
//		return db;
//	}

	public void deleteFood(FoodItems food) {
		FoodItems db = em.find(FoodItems.class, food.getId());
		if(db!=null) {
			et.begin();
			em.remove(db);
			et.commit();
		}
	}
	

}
