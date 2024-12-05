package com.xworkz.december.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.december.dto.DecEntity;

public class DecemberRunner {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		List<DecEntity> entity = new ArrayList<DecEntity>();
		entity.add(new DecEntity("shanta", "shanta@gmail.com", 953584644, 22, "Bangalore"));
		entity.add(new DecEntity("Radhika", "radhi@gmail.com", 879456321, 40, "Malleshwaram"));
		entity.add(new DecEntity("Naveen", "naveen@gmail.com", 548796321, 38, "Mandya"));
		entity.add(new DecEntity("Gowri", "gowri@gmail.com", 866953565, 24, "Mangalore"));
		entity.add(new DecEntity("Bhagya", "bhagya@gmail.com", 332145789, 23, "Ram Nagar"));
		entity.add(new DecEntity("Sohita", "sohita@gmail.com", 332145789, 23, "Bidapur colony"));
		entity.add(new DecEntity("Renuka", "renu@gmail.com", 864712391, 22, "Yadgir"));
		entity.add(new DecEntity("Poorna", "poorna@gmail.com", 996633221, 25, "Kuvempu Nagar"));
		entity.add(new DecEntity("Arjun", "arjun@gmail.com", 996644785, 26, "MG Road"));
		entity.add(new DecEntity("Nandini", "nandini@gmail.com", 889977456, 21, "RR Nagar"));
		entity.add(new DecEntity("Leela", "leela@gmail.com", 897456321, 26, "Rajaji Nagar"));
		entity.add(new DecEntity("Krishna", "krish@gmail.com", 987456321, 28, "Dwapara"));
		entity.add(new DecEntity("Radha", "radha@gmail.com", 523698741, 23, "Barsana"));
		entity.add(new DecEntity("Madhava", "madav@gmail.com", 852369741, 27, "Mathura"));
		entity.add(new DecEntity("Ganesha", "ganesh@gmail.com", 996633225, 30, "Kashmira"));

		for (DecEntity decEntity : entity) {

			DecEntity decEntity1 = new DecEntity();

			decEntity1.setId(decEntity.getId());
			decEntity1.setName(decEntity.getName());
			decEntity1.setEmail(decEntity.getEmail());
			decEntity1.setPhoneNo(decEntity.getPhoneNo());
			decEntity1.setAge(decEntity.getAge());
			decEntity1.setAddress(decEntity.getAddress());

			em.persist(decEntity1);

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
			em.close();
		}
	}

}
