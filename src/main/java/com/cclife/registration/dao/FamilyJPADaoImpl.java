/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.dao;

import com.cclife.registration.controller.exceptions.NonexistentEntityException;
import com.cclife.registration.dao.exceptions.PreexistingEntityException;
import com.cclife.registration.dao.exceptions.RollbackFailureException;
import com.cclife.registration.model.Family;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ephesus
 */
@Repository("familyDao")
public class FamilyJPADaoImpl implements GenericJPADao<Family> {

    private static final Logger logger = Logger.getLogger(FamilyJPADaoImpl.class);

    @PersistenceContext(unitName = "registrationDatabase")
    private EntityManager em = null;

//    @PersistenceContext
//    private EntityManager entityManager;
//
//    public EntityManager getEntityManager() {
//        return entityManager;
//    }
//
//    /**
//     *
//     * @param family
//     */
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
//    @Override
//    public void create(Family family) {
//        EntityManager em;
////        try {
//        em = getEntityManager();
////            em.getTransaction().begin();
//        try {
//            if (family.getFamilyID() == null) {
//                entityManager.persist(family);
//            } else {
//                if (!entityManager.contains(family)) {
//                    entityManager.merge(family);
//                }
//            }
//        } catch (DataAccessException e) {
//            logger.error("save:" + e.getMessage());
//        }
//    }
//
//    @Transactional
//    @Override
//    public void edit(Family family) throws NonexistentEntityException, Exception {
//        EntityManager em = null;
//        try {
////            em = getEntityManager();
////            em.getTransaction().begin();
//            family = getEntityManager().merge(family);
////            em.getTransaction().commit();
//        } catch (Exception ex) {
//            String msg = ex.getLocalizedMessage();
//            if (msg == null || msg.length() == 0) {
//                Integer id = family.getFamilyID();
//                if (findFamily(id) == null) {
//                    throw new NonexistentEntityException("The family with id " + id + " no longer exists.");
//                }
//            }
//            throw ex;
////        } finally {
////            if (em != null) {
////                em.close();
//        }
////        }
//    }
//
//    @Transactional
//    @Override
//    public void destroy(Integer id) throws NonexistentEntityException {
//        EntityManager em = null;
////        try {
//        em = getEntityManager();
////            em.getTransaction().begin();
//        Family family;
//        try {
//            family = em.getReference(Family.class, id);
//            family.getFamilyID();
//        } catch (EntityNotFoundException enfe) {
//            throw new NonexistentEntityException("The family with id " + id + " no longer exists.", enfe);
//        }
//        em.remove(family);
////            em.getTransaction().commit();
////        } finally {
////            if (em != null) {
////                em.close();
////            }
////        }
//    }
//
//    @Override
//    public List<Family> findFamilyEntities() {
//        return findFamilyEntities(true, -1, -1);
//    }
//
//    @Override
//    public List<Family> findFamilyEntities(int maxResults, int firstResult) {
//        return findFamilyEntities(false, maxResults, firstResult);
//    }
//
//    private List<Family> findFamilyEntities(boolean all, int maxResults, int firstResult) {
//        EntityManager em = getEntityManager();
//        try {
//            Query q = em.createQuery("select object(o) from Family as o");
//            if (!all) {
//                q.setMaxResults(maxResults);
//                q.setFirstResult(firstResult);
//            }
//            return q.getResultList();
//        } finally {
//            em.close();
//        }
//    }
//
//    @Override
//    public Family findFamily(Integer id) {
//        EntityManager em = getEntityManager();
////        try {
//        return em.find(Family.class, id);
////        } finally {
////            em.close();
////        }
//    }
//
//    @Override
//    public int getFamilyCount() {
//        EntityManager em = getEntityManager();
////        try {
//        Query q = em.createQuery("select count(o) from Family as o");
//        return ((Long) q.getSingleResult()).intValue();
////        } finally {
////            em.close();
////        }
//    }
    /**
     *
     * @param obj
     * @throws PreexistingEntityException
     * @throws RollbackFailureException
     * @throws Exception
     */
    @Transactional
    @Override
    public void create(Family obj) throws PreexistingEntityException, RollbackFailureException, Exception {
        try {
//            em.persist(obj);

            if (obj.getFamilyID() == null) {
                
                em.persist(obj);
            } else {
                if (!em.contains(obj)) {
                    em.merge(obj);
                }
            }
        } catch (Exception ex) {
            logger.error("Create Family ERROR:" + ex.getLocalizedMessage());
            if (find(obj.getFamilyID()) != null) {
                throw new PreexistingEntityException("Family " + obj + " already exists.", ex);
            }
            throw ex;
        }
    }

    @Override
    public void edit(Family obj) throws com.cclife.registration.dao.exceptions.NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Object id) throws com.cclife.registration.dao.exceptions.NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Family> findEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Family> findEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Family find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Family> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
