package com.xworkz.hospital.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query9 {
	
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createNamedQuery("getCountByName&Email");
		query.setParameter("hospitalName", "jeams");
		query.setParameter("email", "rahul@gmail.com");
		Long ref = (Long)query.getSingleResult();
		System.out.println("count is: " + ref);
	
	}
}





