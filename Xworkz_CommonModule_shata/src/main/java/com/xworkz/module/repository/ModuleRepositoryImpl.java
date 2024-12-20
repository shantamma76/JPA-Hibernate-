package com.xworkz.module.repository;

import com.xworkz.module.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository{

    @Autowired
    EntityManagerFactory emf;

    @Autowired
    private ModuleRepository repository;

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

    @Override
    public ModuleEntity getName(String name) {
        EntityManager em = emf.createEntityManager();
        ModuleEntity entity = null;
        try{
            Query query = em.createNamedQuery("getNameByPassword");
            query.setParameter("name",name);
            entity= (ModuleEntity) query.getSingleResult();

        } catch(Exception e){
            em.close();
        }
        return entity;
    }

    @Override
    public Long countName(String name) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        Long count= (Long)em.createNamedQuery("countName").setParameter("SetName",name).getSingleResult();
        try{
            et.begin();
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }
        }
        finally {
            em.close();

        }
        return count;

    }

    @Override
    public Long countByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByEmail")
                    .setParameter("SetEmail", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countByAltEmail(String alterEmail) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltEmail")
                    .setParameter("SetAltEmail", alterEmail)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;

    }

    @Override
    public Long countByPhone(long phone) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByPhone")
                    .setParameter("SetPhone", phone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;

    }

    @Override
    public Long countByAltPhone(long alterPhone) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltPhone")
                    .setParameter("SetAltPhone", alterPhone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;

    }

    @Override
    public Long countByLocation(String location) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByLocation")
                    .setParameter("SetLocation", location)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

}

