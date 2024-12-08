package com.xworkz.hospital.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query8 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Query query = em.createNamedQuery("updateByName&Email");
			query.setParameter("name", "RMV Hospital");
			query.setParameter("email", "ramesh@gmail.com");
			query.setParameter("weight", 60.96f);
			float result = query.executeUpdate();
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (et.isActive())
				et.rollback();
			em.close();
			emf.close();
		}

	}

}
	
	
	

