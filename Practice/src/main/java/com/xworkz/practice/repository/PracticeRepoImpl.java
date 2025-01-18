package com.xworkz.practice.repository;

import com.xworkz.practice.Entity.PracticeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class PracticeRepoImpl implements PracticeRepo{

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean save(PracticeEntity practiceEntity) {
        System.out.println("running save method in PracticeRepoImpl");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try{
            et.begin();
            em.persist(practiceEntity);
            et.commit();
            return true;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return  false;
        }
            finally {
                em.close();
            }

    }

    @Override
    public boolean getNameByEmail(String email,String password) {
        System.out.println("Running getNameByEmail in PracticeRepoImpl");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            Query query = em.createNamedQuery("getNameByEmail");
            query.setParameter("byEmail", email);
            query.setParameter("byPassword", password);
            Object singleResult = query.getSingleResult();
            et.commit();

            if (singleResult != null) {
                System.out.println("it is not null");
                return true;
            }
            System.out.println("it is null");
            return false;
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            return false;
        } finally {
            em.close();
        }
    }
}




