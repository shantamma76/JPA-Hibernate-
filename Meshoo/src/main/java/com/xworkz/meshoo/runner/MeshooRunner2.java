package com.xworkz.meshoo.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.meshoo.dto.MeshooDto;

public class MeshooRunner2 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager em = emf.createEntityManager();

		EntityTransaction et = em.getTransaction();

		try {
			et.begin();
			Integer id = 6;
			MeshooDto meshooDto = new MeshooDto();

			MeshooDto meshooValue = em.find(MeshooDto.class, id);

			em.remove(meshooValue);
			et.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}

	}
}
