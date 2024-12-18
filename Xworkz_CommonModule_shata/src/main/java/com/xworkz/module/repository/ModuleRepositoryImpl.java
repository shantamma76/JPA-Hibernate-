package com.xworkz.module.repository;

import com.xworkz.module.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository{

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean onModule(ModuleEntity entity) {
        System.out.println("running in repository implementation");
        EntityManager em =emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch(Exception e){
            if(et.isActive()){
                et.rollback();
            }
            e.printStackTrace();
        }
         finally {
            em.close();
        }
        return true;
    }
}

