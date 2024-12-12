package com.xworkz.product.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.xworkz.product.entity.ProductEntity;


@Repository
public class ProductRepoImple implements ProductRepo{

	@Override
	public boolean save(ProductEntity productEntity) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			em.persist(productEntity);
			System.out.println("this is saved in db");
			et.commit();
			
		} 
		catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
				e.printStackTrace();
			}
		} 
		finally {
			em.close();
			emf.close();
		}
		return true;
	}

}
