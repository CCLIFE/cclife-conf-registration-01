/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.service;

import com.cclife.registration.dao.FamilyDao;
import com.cclife.registration.dao.GenericJPADao;
import com.cclife.registration.dao.PaymentDao;
import com.cclife.registration.domain.Registrant;
import com.cclife.registration.domain.RegistrationForm;
import com.cclife.registration.model.Family;
import com.cclife.registration.model.Payment;
import com.cclife.registration.model.Person;
import com.cclife.registration.util.UID;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 *
 * @author ch1choo1
 */
@Service("registrationService")
public class RegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = Logger.getLogger(RegistrationServiceImpl.class);
    @Autowired
    private GenericJPADao<Family> familyDao;
    @Autowired
    private GenericJPADao<Person> personDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private MailEngine mailEngine;

    @Override
    public boolean submit(RegistrationForm form) throws Exception {

        Family family = form.getAddress();
        logger.debug(family.getHomeAddress());

        Integer fid = UID.generateUniqueId();
        logger.debug("Number:" + fid);
//        family.setFamilyID(fid);
        familyDao.create(family);
        logger.debug("Family ID:" + family.getFamilyID());

        Iterator<Registrant> it = form.getRegistrants().iterator();

        while (it.hasNext()) {
            Registrant registrant = it.next();
            Person person = registrant.getPerson();

            logger.debug("PersonID:" + person.getPersonID());
            logger.debug("AcceptedChrist:" + person.getAcceptedChrist());
            logger.debug("AcceptedChristDate:" + person.getAcceptedChristDate());
            logger.debug("AcceptedChristLocation:" + person.getAcceptedChristLocation());
            logger.debug("Age[5]:" + person.getAge());
            logger.debug("Baptized:" + person.getBaptized());
            logger.debug("BaptizedDate:" + person.getBaptizedDate());
            logger.debug("CellPhone:" + person.getCellPhone());
            logger.debug("ChineseName[50]:" + person.getChineseName());
            logger.debug("ChurchAdmin:" + person.getChurchAdmin());
            logger.debug("ChurchID:" + person.getChurchID());
            logger.debug("CommitServe[50]:" + person.getCommitServe());
            logger.debug("Email[50]:" + person.getEmail());
            logger.debug("FamilyAdmin:" + person.getFamilyAdmin());
            logger.debug("FamilyID:" + person.getFamilyID());
            logger.debug("FirstName[20]:" + person.getFirstName());
            logger.debug("Gender[2]:" + person.getGender());
            logger.debug("LastModified:" + person.getLastModified());
            logger.debug("LastName[20]:" + person.getLastName());
            logger.debug("LoginID[50]:" + person.getLoginID());
            logger.debug("Misc1[50]:" + person.getMisc1());
            logger.debug("Misc2[50]:" + person.getMisc2());
            logger.debug("Misc3[50]:" + person.getMisc3());
            logger.debug("Password[50]:" + person.getPassword());
            logger.debug("Phone[15]:" + person.getPhone());
            logger.debug("PRC[50]:" + person.getPrc());
            logger.debug("PreferredLanguage[50]:" + person.getPreferredLanguage());
            logger.debug("Relationship[2]:" + person.getRelationship());
            logger.debug("Remarks[255]:" + person.getRemarks());
            logger.debug("Searchable:" + person.getSearchable());
            logger.debug("Seeker:" + person.getSeeker());
            logger.debug("ServingRole[50]:" + person.getServingRole());
            logger.debug("Status[5]:" + person.getStatus());
            logger.debug("Title[50]:" + person.getTitle());
            logger.debug("VolunteerCode:" + person.getVolunteerCode());
            logger.debug("WillingToAttendCCCMTraining:" + person.getWillingToAttendCCCMTraining());
            logger.debug("WillingToBeVolunteer:" + person.getWillingToBeVolunteer());
            logger.debug("WorkPhone:" + person.getWorkPhone());
            person.setFamilyID(family.getFamilyID());
//            person.setPersonID(fid);
            person.setLastModified(new Date());
            personDao.create(person);
        }

        Payment payment = new Payment();
        payment.setAmount(22.30);
        payment.setPaymentDate(new Date());

        paymentDao.save(payment);
        try {
            logger.debug("Mail Engine:" + mailEngine.toString());
//            SimpleMailMessage mailMessage ;
//            mailMessage = new SimpleMailMessage();
//
//            mailMessage.setFrom("cclife@gmail.com");
//            mailMessage.setBcc("cheh.cccm@gmail.com");
//            mailMessage.setTo(form.getAddress().getMisc1());

            String recipients[] = new String[1];
            recipients[0] = form.getAddress().getMisc1();
            String subject = "Gospel for Chinese Christian Conference Toronto 2015";
//            mailMessage.setSubject(subject);

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("registrationId", fid);
            params.put("amountPaid", payment.getAmount());

            mailEngine.sendMessage(recipients, "cclife@gmail.com", subject, "CCLIFE_2015_Registration_Confirmation.html", params);
            
            logger.debug("Message Sent :" + form.getAddress().getMisc1());
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return true;
    }
}
