/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.dao;

import java.util.List;
import com.cclife.registration.domain.BaseObject;

/**
 *
 * @author ch1choo1
 */
/**
 * @author CH1JMOH2
 *
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface PaymentDao {

    public BaseObject findById(long id);

    public BaseObject update(BaseObject obj);

    public void delete(long obj);

    public void save(BaseObject obj);

    List<BaseObject> findPaymentByQuery(String query);
}
