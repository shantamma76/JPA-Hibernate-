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
		EntityTransaction et = em.getTransaction();
		
		// find name by Gender

		Query query = em.createNamedQuery("findNameByDob");
		
		query.setParameter("getDob", "06/12/2002");
		Object obj = query.getSingleResult();
		String str = (String) obj;
		System.out.println("Values : " + str);

		try {
			et.begin();
			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}
	}

}
