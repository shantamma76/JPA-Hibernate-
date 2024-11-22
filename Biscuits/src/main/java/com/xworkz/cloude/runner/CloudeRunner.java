package com.xworkz.cloude.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.cloude.Entity.CloudeEntity;

public class CloudeRunner {

	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager entityManager = eMF.createEntityManager();
		EntityTransaction et = entityManager.getTransaction();

		try {

			et.begin();
			CloudeEntity cloude = new CloudeEntity();
			cloude.setId(5);
			cloude.setBesciutes_name("Burbun");
			cloude.setPrice(30);
			cloude.setTexture("tender");
			cloude.setShape("rectangle");
			cloude.setColor("Brown");
			cloude.setTaste("sweet");
			cloude.setFlavour("chacolote");
			cloude.setManf_date("06-12-2021");
			cloude.setExpired_date("30-04-2023");

			entityManager.persist(cloude);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			eMF.close();
		}
	}
}

