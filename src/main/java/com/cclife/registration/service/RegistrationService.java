/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cclife.registration.service;

import com.cclife.registration.domain.RegistrationForm;
/**
 *
 * @author ch1choo1
 */
public interface RegistrationService {

    public boolean submit(RegistrationForm form) throws Exception;
}
