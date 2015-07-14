/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.service;

import com.cclife.registration.dao.GenericJPADao;
import com.cclife.registration.domain.RegistrationForm;
import com.cclife.registration.model.Family;
import com.cclife.registration.model.Mealplan;
import com.cclife.registration.model.Person;
import com.cclife.registration.model.Profile;
import com.cclife.registration.util.UID;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author Ephesus
 */
public class RegistrationServiceImplTest {

    private static final Logger logger = Logger.getLogger(RegistrationServiceImplTest.class);
    ApplicationContext applicationContext = null;
    private final Integer testId = 53;

    public RegistrationServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        String[] xmlFiles = {
            "src\\main\\webapp\\WEB-INF\\spring\\appServlet\\config\\web-application-config.xml"
        };

        try {
            applicationContext = new FileSystemXmlApplicationContext(xmlFiles);

        } catch (org.springframework.beans.factory.BeanCreationException e) {
            logger.error(e.getMessage());
        } catch (BeansException ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of submit method, of class RegistrationServiceImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSubmit() throws Exception {

        GenericJPADao<Family> familyDao = (GenericJPADao<Family>) applicationContext.getBean("familyDao");

        Family family = new Family();
        logger.debug(family.getHomeAddress());

        Integer fid = UID.generateUniqueId();
        logger.debug("Number:" + fid);
//        family.setFamilyID(fid);
        family.setChurchID("10");
        family.setFamilyName("Hoo");
        family.setHomeAddress("133 President Drive");
        family.setHomeCity("Chicago");

        familyDao.create(family);

        GenericJPADao<Person> personDao = (GenericJPADao<Person>) applicationContext.getBean("personDao");

        logger.debug("Family ID:" + family.getFamilyID());
        Person person = new Person();
//        person.setPersonID(testId);
        person.setFamilyID(family.getFamilyID());
        person.setFirstName("Ace");
        person.setLastName("Last");
        person.setLastModified(new Date());

        personDao.create(person);

        logger.debug("Person ID:" + person.getPersonID());
        logger.debug("Family ID:" + person.getFamilyID());
        GenericJPADao<Profile> profileDao = (GenericJPADao<Profile>) applicationContext.getBean("profileDao");

        Profile profile = new Profile();
        
        profile.setRegistrationID(fid.toString());
        profile.setFamilyID(person.getFamilyID());
        profile.setPersonID(person.getPersonID());
        profile.setNeedHotel(Boolean.TRUE);
        profile.setLastModified(new Date());
        profileDao.create(profile);
        
        GenericJPADao<Mealplan> mealplanDao = (GenericJPADao<Mealplan>) applicationContext.getBean("mealplanDao");
        Mealplan mealPlan = new Mealplan();
        
        mealPlan.setRegistrationID(profile.getRegistrationID());
        mealPlan.setBreakfast1(2);
        
        mealplanDao.create(mealPlan);
        
//        System.out.println("submit");
//        RegistrationForm form = null;
//        RegistrationServiceImpl instance = new RegistrationServiceImpl();
//        boolean expResult = false;
//        boolean result = instance.submit(form);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of sendConfirmationEmail method, of class RegistrationServiceImpl.
     */
//    @Test
    public void testSendConfirmationEmail() {
        System.out.println("sendConfirmationEmail");
//        RegistrationForm form = null;
//        RegistrationServiceImpl instance = new RegistrationServiceImpl();
//        instance.sendConfirmationEmail(form);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}
