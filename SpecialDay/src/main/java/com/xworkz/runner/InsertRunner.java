package com.xworkz.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.xworkz.entity.SpecialEntity;

public class InsertRunner {

	public static void main(String[] args) {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence"); 
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
		
	List<SpecialEntity> entity = new ArrayList<SpecialEntity>();
		
		entity.add(new SpecialEntity("Yashanti", "06/12/2002", "female", 9535841644L, 80000));
		entity.add(new SpecialEntity("Yash", "08/01/1986", "male", 963258741, 70000));
		entity.add(new SpecialEntity("Radhika", "07/03/1984", "female", 852147963, 85000));
		entity.add(new SpecialEntity("Naveen", "30/04/1995", "male", 866098258, 88000));
		entity.add(new SpecialEntity("Gowri", "04/04/2002", "female", 869745123, 60000));
		entity.add(new SpecialEntity("Raj", "08/06/1994", "male", 951487263, 77000));
		entity.add(new SpecialEntity("Sohita", "04/09/2002", "female", 897123654, 65000));
		entity.add(new SpecialEntity("Bhagya", "15/09/2002", "female", 874125963, 70000));
		entity.add(new SpecialEntity("Renuka", "24/10/2002", "female", 158742369, 71000));
		entity.add(new SpecialEntity("Shankuntala", "04/03/2001", "female", 857412369, 75000));

		for (SpecialEntity specialEntity : entity) {
			SpecialEntity specialEntity1 = new SpecialEntity();
			specialEntity1.setName(specialEntity.getName());
			specialEntity1.setDob(specialEntity.getDob());
			specialEntity1.setGender(specialEntity.getGender());
			specialEntity1.setMobile(specialEntity.getMobile());
			specialEntity1.setSalary(specialEntity.getSalary());

			em.persist(specialEntity1);
		}
		try {
			et.begin();
			et.commit();

		} catch (Exception e) {
			if (et.isActive()) {
				et.rollback();
			}
			e.printStackTrace();
		} finally {
			emf.close();
			em.close();
		}

	}
}
