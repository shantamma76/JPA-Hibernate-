package com.xworkz.hospital.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.hospital.dto.HospitalDto;

public class HospitalRunner {

	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager entityManager = eMF.createEntityManager();
		EntityTransaction eTrans = entityManager.getTransaction();

		try {
			eTrans.begin();
			HospitalDto hospitalDto = new HospitalDto();
			hospitalDto.setId(6);
			hospitalDto.setHospital_name("Sakra Premium Hospital");
			hospitalDto.setNoOfPatience(150);
			hospitalDto.setNoOfDoctores(50);
			hospitalDto.setLocation("Bellandur");

			entityManager.merge(hospitalDto);
			
			eTrans.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			eMF.close();

		}

	}

}
