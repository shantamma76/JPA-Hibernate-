package com.xworkz.meshoo.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.meshoo.dto.MeshooDto;

public class MeshooRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		try {
			et.begin();

			MeshooDto meshooDto = new MeshooDto("chipes", 50, 2, "red chilly", "bingo");

			em.persist(meshooDto);
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
