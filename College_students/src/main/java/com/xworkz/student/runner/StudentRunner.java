package com.xworkz.student.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.student.Entity.StudentEntity;

public class StudentRunner {

	public static void main(String[] args) {

		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");

		EntityManager entityManager = eMF.createEntityManager();
		EntityTransaction entityTrans = entityManager.getTransaction();

		try {
			entityTrans.begin();
			StudentEntity studentEntity = new StudentEntity();
			studentEntity.setId(5);
			studentEntity.setFirstName("shanta");
			studentEntity.setLastName("siragan");
			studentEntity.setCollegeName("Sharnabasva University");
			studentEntity.setRollNo("017");
			studentEntity.setDob("06/12/2002");
			studentEntity.setGender("female");
			studentEntity.setEmail("shanta@gmail.com");
			studentEntity.setPhone(953584144);
			studentEntity.setAddress("Rajaji Nagar");

			entityManager.persist(studentEntity);
			entityTrans.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			eMF.close();
		}
	}
}


