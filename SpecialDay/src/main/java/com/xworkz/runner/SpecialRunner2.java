package com.xworkz.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class SpecialRunner2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction eTrans = em.getTransaction();
		// find name by Email

		Query query = em.createNamedQuery("findNameByGender");
		
		query.setParameter("getGender", "female");
		Object obj = query.getSingleResult();
		String str = (String) obj;
		System.out.println("Values : " + str);

	}

}
