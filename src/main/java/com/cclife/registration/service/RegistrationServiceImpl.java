/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cclife.registration.service;

import com.cclife.registration.dao.GenericJPADao;
import com.cclife.registration.dao.PaymentDao;
import com.cclife.registration.domain.PaymentMethod;
import com.cclife.registration.domain.Registrant;
import com.cclife.registration.domain.RegistrationForm;
import com.cclife.registration.domain.Server;
import com.cclife.registration.model.Family;
import com.cclife.registration.model.Person;
import com.cclife.registration.model.Profile;
import com.cclife.registration.model.Mealplan;
import com.cclife.registration.model.Payment;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
    GenericJPADao<Profile> profileDao;
    @Autowired
    GenericJPADao<Mealplan> mealplanDao;
    @Autowired
    private PaymentDao paymentDao;
    @Autowired
    private MailEngine mailEngine;

    /**
     *
     * @param form
     * @return
     * @throws Exception
     */
    @Override
    public boolean submit(RegistrationForm form) throws Exception {

        Family family = form.getAddress();
        logger.debug(family.getHomeAddress());

        familyDao.create(family);

        Mealplan mealPlan = new Mealplan();
        mealPlan.setRegistrationID(form.getFormID().toString());
        mealPlan.setLunch1(0);
        mealPlan.setLunch2(0);
        mealPlan.setLunch3(0);
        mealPlan.setLunch4(0);
        mealPlan.setDinner1(0);
        mealPlan.setDinner2(0);
        mealPlan.setDinner3(0);
        mealPlan.setDinner4(0);

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
            person.setLastModified(new Date());

            personDao.create(person);

            logger.debug("Person ID:" + person.getPersonID());
            logger.debug("Family ID:" + person.getFamilyID());

            Profile profile = new Profile();

            if (form.getChurchName() != null) {
                profile.setChucrhName(form.getChurchName());
            }
            profile.setPersonID(person.getPersonID());
            profile.setFamilyID(person.getFamilyID());
            profile.setRegistrationID(form.getFormID().toString());
            if (form.getAddress().getHotel() != null) {
                profile.setNeedHotel(form.getAddress().getHotel());
            }

            if (registrant.getVolunteerJobs() != null) {
                for (Server serve : registrant.getVolunteerJobs()) {
                    if (profile.getVolunteerJobs() == null || profile.getVolunteerJobs().isEmpty()) {
                        profile.setVolunteerJobs(serve.name());
                    } else {
                        String volunteerJobs = profile.getVolunteerJobs();
                        volunteerJobs += "|";
                        volunteerJobs += serve.name();
                        profile.setVolunteerJobs(volunteerJobs);
                    }
                }
            }
            profile.setRegisteredDate(form.getRegistrationDate());
            profile.setLastModified(new Date());

            profileDao.create(profile);

            mealPlan.setLunch1(mealPlan.getLunch1() + (registrant.getMealplan().getLunch1() == null ? 0 : registrant.getMealplan().getLunch1()));
            mealPlan.setLunch2(mealPlan.getLunch2() + (registrant.getMealplan().getLunch2() == null ? 0 : registrant.getMealplan().getLunch2()));
            mealPlan.setLunch3(mealPlan.getLunch3() + (registrant.getMealplan().getLunch3() == null ? 0 : registrant.getMealplan().getLunch3()));
            mealPlan.setLunch4(mealPlan.getLunch4() + (registrant.getMealplan().getLunch4() == null ? 0 : registrant.getMealplan().getLunch4()));

            mealPlan.setDinner1(mealPlan.getDinner1() + (registrant.getMealplan().getDinner1() == null ? 0 : registrant.getMealplan().getDinner1()));
            mealPlan.setDinner2(mealPlan.getDinner2() + (registrant.getMealplan().getDinner2() == null ? 0 : registrant.getMealplan().getDinner2()));
            mealPlan.setDinner3(mealPlan.getDinner3() + (registrant.getMealplan().getDinner3() == null ? 0 : registrant.getMealplan().getDinner3()));
            mealPlan.setDinner4(mealPlan.getDinner4() + (registrant.getMealplan().getDinner4() == null ? 0 : registrant.getMealplan().getDinner4()));
        }

        mealplanDao.create(mealPlan);

        Payment payment = new Payment();
        
        payment.setCash(Boolean.FALSE);
        payment.setCreditCard(Boolean.FALSE);
        payment.setPersonalCheck(Boolean.FALSE);
        payment.setPaidByConference(Boolean.FALSE);
        payment.setRefund(Boolean.FALSE);
        payment.setAmount(0.0);
        
        if (form.getPaymentMethod() == PaymentMethod.CREDIT_CARD) {
            payment.setCreditCard(Boolean.TRUE);
        } else if (form.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
            payment.setPersonalCheck(Boolean.TRUE);
        }
        
        payment.setRegistrationFee(form.getExpense().getTotalRegistrationFee());
        payment.setMealFee(form.getExpense().getTotalMealsFee());
        payment.setRegistrationID(form.getFormID());

        paymentDao.save(payment);

        return true;
    }

    /**
     *
     * @param form
     * @param params
     * @param template
     */
    @Override
    public void sendEmail(RegistrationForm form, Map<String, Object> params, String template) {
        try {
            logger.debug("Mail Engine:" + mailEngine.toString());

            String recipients[] = new String[1];
            recipients[0] = form.getAddress().getMisc1();
            String subject = form.getEvent().getName();
//            mailMessage.setSubject(subject);
            logger.debug("Message Sender :" + form.getEvent().getContactEmail());
            mailEngine.sendMessage(recipients, form.getEvent().getContactEmail(), subject, template, params);

            logger.debug("Message Recipient :" + recipients[0]);
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(RegistrationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
