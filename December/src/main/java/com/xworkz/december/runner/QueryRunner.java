package com.xworkz.december.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class QueryRunner {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query1 = em.createNamedQuery("findById");
		Object object1 = query1.getSingleResult();
		System.out.println(object1.toString());
		System.out.println("----------------------------------");

		Query query2 = em.createNamedQuery("findByName");
		Object object2 = query2.getSingleResult();
		System.out.println(object2.toString());
		System.out.println("----------------------------------");

		Query query3 = em.createNamedQuery("findByEmail");
		Object object3 = query3.getSingleResult();
		System.out.println(object3.toString());
		System.out.println("----------------------------------");

		Query query4 = em.createNamedQuery("findByPhoneNo");
		Object object4 = query4.getSingleResult();
		System.out.println(object4.toString());
		System.out.println("----------------------------------");

		Query query5 = em.createNamedQuery("findByAddress");
		Object object5 = query5.getSingleResult();
		System.out.println(object5.toString());
		System.out.println("----------------------------------");

		Query query6 = em.createNamedQuery("findByNameAndPhoneNo");
		Object object6 = query6.getSingleResult();
		System.out.println(object6.toString());
		System.out.println("----------------------------------");

		Query query7 = em.createNamedQuery("findByNameAndEmail");
		Object object7 = query7.getSingleResult();
		System.out.println(object7.toString());
		System.out.println("----------------------------------");

		Query query8 = em.createNamedQuery("findByPhoneNoAndEmail");
		Object object8 = query8.getSingleResult();
		System.out.println(object8.toString());
		System.out.println("----------------------------------");

		Query query9 = em.createNamedQuery("findByNameAndAddress");
		Object object9 = query9.getSingleResult();
		System.out.println(object9.toString());
		System.out.println("----------------------------------");

		Query query10 = em.createNamedQuery("findByEmailAndAddress");
		Object object10 = query10.getSingleResult();
		System.out.println(object10.toString());

		try {
			et.begin();
			et.commit();
		} catch (Exception e) {
			e.getMessage();
		} finally {
			emf.close();
			em.close();
		}
	}

}