package com.xworkz.hospital.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.xworkz.hospital.entity.HospitalEntity;

public class Query4 {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Query query = em.createNamedQuery("getSingleAll");
		query.setParameter("id", 5);

		List<HospitalEntity> str = (List<HospitalEntity>) query.getResultList();
		str.forEach(ref -> System.out.println(ref));

	}
}
