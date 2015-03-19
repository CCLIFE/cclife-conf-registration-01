/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.dao;

import com.cclife.registration.controller.exceptions.NonexistentEntityException;
import com.cclife.registration.domain.BaseObject;
import com.cclife.registration.model.Family;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

/**
 *
 * @author CHEH
 */
public interface FamilyDao {

    public void create(Family family);

    public void edit(Family family) throws NonexistentEntityException, Exception;

    public void destroy(Integer id) throws NonexistentEntityException;

    public List<Family> findFamilyEntities();

    public List<Family> findFamilyEntities(int maxResults, int firstResult);

    public Family findFamily(Integer id);

    public int getFamilyCount();

}
