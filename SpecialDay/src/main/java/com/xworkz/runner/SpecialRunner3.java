package com.xworkz.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SpecialRunner3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// finding salary by Id
		Query query = em.createNamedQuery("findSalaryById");
		query.setParameter("setId", 10);
		Object obj = query.getSingleResult();
		Double ref = (Double) obj;
		System.out.println("Salary :" + ref);

	}

}
