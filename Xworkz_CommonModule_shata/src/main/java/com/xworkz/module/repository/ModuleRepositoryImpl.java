package com.xworkz.module.repository;

import com.xworkz.module.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

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
    public ModuleEntity getName(String email, String password) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);
            List<ModuleEntity> result = query.getResultList();

            if (result != null && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
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
            e.printStackTrace();
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
                    .setParameter("SetAlterPhone", alterPhone)
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

    @Override
    public boolean update(ModuleEntity entity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.merge(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public ModuleEntity findByEmail(String email) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findbyemail");
            query.setParameter("emailid", email);
            Object singleResult =query.getSingleResult();
            return (ModuleEntity) singleResult;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            entityManager.close();
        }

    }
}

