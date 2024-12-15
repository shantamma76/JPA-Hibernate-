package com.xworkz.course.repository;

import com.xworkz.course.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class CourseRepositoryImpl  implements CourseRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean save(CourseEntity courseEntity) {
        System.out.println("data in repositoryImpl====" + courseEntity);

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(courseEntity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
            //emf.close();
        }

        return false;
    }

    @Override
    public String getNameByEmailAndPassword(String email, String password) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String name = null;
        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getNameByEmailAndPassword");
            query.setParameter("byEmail", email).setParameter("byPassword", password);
            name = (String) query.getSingleResult();


            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        } finally {
            entityManager.close();
        }
        return name;
    }
}


