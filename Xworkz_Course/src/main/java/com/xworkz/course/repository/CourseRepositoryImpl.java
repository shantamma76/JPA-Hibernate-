package com.xworkz.course.repository;

import com.xworkz.course.entity.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Autowired
    private EntityManagerFactory emf;

    public CourseRepositoryImpl() {
        System.out.println("no-arg const in CourseRepositoryImpl");
    }

    @Override
    public boolean valid(CourseEntity courseEntity) {
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
            return false; // Return false if there's an error
        } finally {
            em.close();
        }
        return true;
    }

    @Override
    public CourseEntity getNAme(String name) {
        EntityManager em = emf.createEntityManager();
        CourseEntity entity = null;

        try {
            Query query = em.createNamedQuery("getNameByPassword");
            query.setParameter("name", name);
            entity = (CourseEntity) query.getSingleResult();
    } catch (Exception e) {
        // Log other exceptions e.printStackTrace(); finally {
            em.close();
        }
        return entity;
    }
}
