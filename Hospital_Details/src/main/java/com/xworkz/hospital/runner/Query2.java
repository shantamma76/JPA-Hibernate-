package com.xworkz.hospital.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Query2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createNamedQuery("getById");
		query.setParameter("id", 2);

		List<Object[]> list = query.getResultList();
		for (Object[] obj : list) {
			System.out.println("Name:" + obj[0] + " " + "Email:" + obj[1]);
		}

	}

}
