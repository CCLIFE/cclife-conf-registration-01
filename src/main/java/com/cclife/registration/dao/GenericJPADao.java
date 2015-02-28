/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.dao;

import java.util.List;
import java.util.Map;
import com.cclife.registration.dao.exceptions.NonexistentEntityException;
import com.cclife.registration.dao.exceptions.PreexistingEntityException;
import com.cclife.registration.dao.exceptions.RollbackFailureException;

/**
 *
 * @author ch1choo1
 */

public interface GenericJPADao<T> {

    public void create(T obj) throws PreexistingEntityException, RollbackFailureException, Exception;

    public void edit(T obj) throws NonexistentEntityException, RollbackFailureException, Exception;

    public void destroy(Object id) throws NonexistentEntityException, RollbackFailureException, Exception;

    public int getCount();

    public List<T> findEntities();

    public List<T> findEntities(int maxResults, int firstResult);

    public T find(Object id);
    
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams);
    
}
