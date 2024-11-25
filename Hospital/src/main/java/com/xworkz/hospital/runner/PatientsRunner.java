package com.xworkz.hospital.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.hospital.dto.PatientsDto;


public class PatientsRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager entityManager = emf.createEntityManager();

		EntityTransaction eTransp = entityManager.getTransaction();

		try {
			eTransp.begin();
			PatientsDto patientsDto = new PatientsDto();
			patientsDto.setId(6);
			patientsDto.setFirst_name("Kartik");
			patientsDto.setLast_name("Mahesh");
			patientsDto.setPhone_number(669874532);
			patientsDto.setDob("20/10/2020");
			patientsDto.setAddress("Mandya");

			entityManager.merge(patientsDto);
			eTransp.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			emf.close();
		}
	}
}
