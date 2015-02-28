/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.cclife.registration.domain.BaseObject;
import com.cclife.registration.model.Payment;

/**
 *
 * @author CH1CHOO1
 */
@Repository("paymentDao")
public class JpaPaymentDaoImpl implements PaymentDao {

    private static final Logger logger = Logger.getLogger(JpaPaymentDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
//    @Autowired
//    public JpaPaymentDaoImpl(EntityManagerFactory entityManagerFactory) {
//        super.setEntityManagerFactory(entityManagerFactory);
//    }

//    private static final Logger logger = Logger.getLogger(JpaPaymentDaoImpl.class);
    @SuppressWarnings("unchecked")
    @Override
    public BaseObject findById(long id) {
        return entityManager.find(Payment.class, id);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public BaseObject update(BaseObject obj) {

        Payment p = (Payment) obj;
        return entityManager.merge(p);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void delete(long id) {

        Payment p = (Payment) findById(id);

        if (p != null) {
            entityManager.remove(p);
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    @Override
    public void save(BaseObject obj) {

        logger.info("entering JpaPaymentDaoImpl:save... ");
        Payment p = (Payment) obj;
        try {
            entityManager.persist(p);

        } catch (DataAccessException e) {
            logger.error("save:" + e.getMessage());
        }
    }

    @Override
    public List<BaseObject> findPaymentByQuery(String query) {
        return entityManager.createQuery(query).getResultList();
    }
}
