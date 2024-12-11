package com.xworkz.wednseday.repository;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.wednsday.entity.WedEntity;

public class WedRepositoryImpl implements WedRepository {

	@Override
	public List<WedEntity> getNameById(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<WedEntity> list = null;
		try {
			et.begin();
			Query query = em.createNamedQuery("getNameById");
			query.setParameter("id", id);

			list = query.getResultList();

			for (WedEntity wedEntity : list) {
				em.persist(wedEntity);
			}
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
		return list;
	}
	

	@Override
	public Object getEmailAndDescriptionByPhone(long phone) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		 List<Object[]> list1= null;
		 
		 Query query = em.createNamedQuery("getEmailAndDescriptionByPhone");
		 query.setParameter("phone", phone);
		 
		 Object[] obj = (Object[])query.getSingleResult();
		 
		
		return obj;
	}

}
