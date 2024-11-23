package com.xworkz.market.runner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MarketRunner {
	
	public static void main(String[] args) {
		
		EntityManagerFactory eMF = Persistence.createEntityManagerFactory("TestPersistence");
		
		EntityManager entityManager = eMF.createEntityManager();
		EntityTransaction entityTrans = entityManager.getTransaction();
		
		try {
			entityTrans.begin();
			MarketEntity marketEntity =new MarketEntity();
			marketEntity.setId(5);
			marketEntity.setC_name("Punya");
			marketEntity.setMall_name("lulu mall");
			marketEntity.setItem_name("saare");
			marketEntity.setCost(1000);
			marketEntity.setBrand("meera silk");
			marketEntity.setLocation("rajaji nagar");
			marketEntity.setQuantity(2);
			marketEntity.setDiscount("2%");
			marketEntity.setItem_type("cloth");
			
			entityManager.persist(marketEntity);
			entityTrans.commit();
			
		} catch(Exception e) {
			e.printStackTrace();
		} 
		finally {
			entityManager.clear();
			eMF.close();
		}
	}
}
