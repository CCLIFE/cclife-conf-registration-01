/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.controller;

import com.cclife.registration.domain.RegistrationForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;
import ws.cccm.application.model.Person;

/**
 *
 * @author Ephesus
 */
@Component
public class RegistrationController {

    public RegistrationForm initializeForm() {
        RegistrationForm registrationForm = new RegistrationForm();
//        registrationForm.setQuantity(1);
        registrationForm.setRegistrationDate(new Date());
        return registrationForm;
    }
    
    public Person createNewPerson(RegistrationForm form) {
        if (form.getRegistrants() == null) {
            ArrayList<Person> plist = new ArrayList<Person>() ;
            form.setRegistrants(plist);
        }
        
        Person p = new Person();
        p.setFirstName("New");
        form.getRegistrants().add(p) ;
        
        return p;      
    }
}
