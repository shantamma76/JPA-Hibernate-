package com.xworkz.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SpacialRunner4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		// find mobileNo By Name

		Query query = (Query) em.createNamedQuery("findMobileNoByName");

		query.setParameter("setName", "Yash");
		Object obj = query.getSingleResult();
		Long ref = (Long) obj;
		System.out.println("Value of the mobileNo :" + ref);

		try

		{
			et.begin();
			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}