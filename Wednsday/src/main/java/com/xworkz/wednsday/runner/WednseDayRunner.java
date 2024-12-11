package com.xworkz.wednsday.runner;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.xworkz.wednsday.entity.WedEntity;

public class WednseDayRunner {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		List<WedEntity> list =new ArrayList<WedEntity>();
		//list.add(new WedEntity("shanta", "shanta@gmail.com","i currentlu pursuing full stack development", 958741233,50000));
		list.add(new WedEntity("Hitha", "hita@gmail.com","currently staying in bangalore", 958746321,40000));
		list.add(new WedEntity("Renuka","renu@gmail.com","staying in yadgir", 987456321,30000));
		list.add(new WedEntity("Shree","shree@gmail.com","staying in Bnaglore",95876321,41000));
		list.add(new WedEntity("Radha", "radha@gmail.com","staying in maleshwaram",874596321,50000));
		
		
		for(WedEntity wedEntity:list) {
			em.persist(wedEntity);
		}
		
		
		try {
			et.begin();
			et.commit();
		}  catch(Exception e)
		{  if(et.isActive()) {
			et.rollback();
		}
			e.printStackTrace();
		}
		finally {
			em.close();
			emf.close();
		}
	} 

}
