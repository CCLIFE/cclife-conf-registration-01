package ws.cccm.registration.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.util.StringUtils;
import ws.cccm.application.model.*;
import ws.cccm.application.util.DateUtil;
import ws.cccm.registration.dao.GenericJPADao;
import ws.cccm.registration.dao.RegistrationDao;
import ws.cccm.registration.utils.RegistrationAssessment;
import ws.cccm.registration.utils.RegistrationUtil;
import ws.cccm.registration.utils.SearchCriteria;

/**
 * A JPA-based implementation of the Registration Service. Delegates to a JPA
 * entity manager to issue data access calls against the backing repository. The
 * EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
public class JpaRegistrationServiceImpl implements RegistrationService {

    private static final Logger logger = Logger.getLogger(JpaRegistrationServiceImpl.class);
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private GenericJPADao<Mealplan> mealplanDao;
    @Autowired
    private GenericJPADao<Consent> consentDao;
//    private MailEngine mailEngine = null;
//    private String templateName = null;

//    public void setRegistrationDao(RegistrationDao dao) {
//        this.registrationDao = dao;
//    }
    public JpaRegistrationServiceImpl() {
    }

    @Override
    public List<Registration> findRegistrationes(String familyId) {
        String searchString = "select r from Registration r where r.formID = '" + familyId + "'";
        return registrationDao.findRegistrationByQuery(searchString);
    }
//
//    public List<Registration> findRegistrationes(SearchCriteria criteria) {
//        String pattern = getSearchPattern(criteria);
//        return registrationDao.findRegistrationesByQuery("select c from Registration c where lower(c.registrationNameEng) like " + pattern + " or lower(c.city) like " + pattern
//                + " or lower(c.zip) like " + pattern + " or lower(c.region) like " + pattern);
//    }

    public Registration createRegistration(Registration c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Registration findRegistrationById(Long id) {
        return registrationDao.get(id);
    }
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Registration> findRegistrationes(String cname) {
//        if (cname != null) {
//            return em.createQuery("select c from Registration c where c.acronym = :acronym order by b.checkinDate").setParameter("acronym", cname).getResultList();
//        } else {
//            return null;
//        }
//    }

    public List<Registration> findRegistrationByCriteria(SearchCriteria criteria) {

        String searnString = null;

        if (criteria.getHomePhone() != null && criteria.getHomePhone().length() > 0) {
            searnString = "select r from Registration r where lower(r.homePhone) = '" + criteria.getHomePhone() + "' and lower(r.homeZipCode) = '" + criteria.getHomeZipCode() + "'";
        } else if (criteria.getRegistrationId() != null && criteria.getRegistrationId().length() > 0) {
            searnString = "select r from Registration r where lower(r.formID) = '" + criteria.getRegistrationId() + "'";
        }

        return registrationDao.findRegistrationByQuery(searnString);

    }

    @Override
    public List<Consent> findConsents(String familyId) {
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("registrationID", familyId);
                
        return consentDao.findByNamedQuery("Consent.findByRegistrationID", map);
    }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Registration createRegistration(Registration c) {
//        return registrationDao.save(c);
//     }
//
//    @Transactional(readOnly = true)
//    @Override
//    public Registration findRegistrationById(Long id) {
//        return em.find(Registration.class, id);
//    }
//
    // helpers

    private String getSearchPattern(SearchCriteria criteria) {
        if (StringUtils.hasText(criteria.getSearchString())) {
            return "'%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%'";
        } else {
            return "'%'";
        }
    }

    public List<Registration> findAllRegistrationes() {
        return registrationDao.getAll();
    }

//    public boolean submit1(BaseObject form) throws Exception {
//
//        logger.info("Registration submit entering");
//
//        Form f = (Form) form;
//        Registration savedReg = null;
//        String rnames = "";
//
//        String generatedId = DateUtil.getDateTime("MMddHHmmss", new Date());
//        logger.debug("Generated Form ID  =" + generatedId);
//        f.setFormID(Long.valueOf(generatedId));
//
//        try {
//
//            Registration r = null;
//
//            if ((r = setParticipantData(f)) != null) {
//                savedReg = registrationDao.save(r);
//                rnames = savedReg.getFirstName() + " " + savedReg.getLastName() + " " + (savedReg.getChineseName() != null ? savedReg.getChineseName() : "");
//
//                if (f.getTotalRegistrationFee() != 0 && f.getTotalRegistrationFee() > 0) {
//                    Payment p = new Payment();
//
//                    // Initialize 
//                    p.setCreditCard(false);
//                    p.setPersonalCheck(false);
//                    p.setRefund(false);
//                    p.setCash(false);
//                    p.setPaidByConference(true);
//                    p.setAmount(f.getTotalRegistrationFee());
//                    p.setRemarks("");
//                    p.setRegistrationID(Long.valueOf(generatedId));
//
//                    paymentDao.save(p);
//                }
//
//            }
//
//        } catch (Exception e) {
//            logger.error("Save Data Error:" + e);
//        }
//
//        if (mailEngine != null && savedReg != null) {
//
//            logger.debug("Mail Engine:" + mailEngine.toString());
//            SimpleMailMessage mailMessage = null;
//
//            mailMessage = new SimpleMailMessage();
//
//            mailMessage.setFrom("Registration@cccm.ws");
//            mailMessage.setBcc("cheh.cccm@gmail.com");
//            mailMessage.setTo(savedReg.getEmail());
//
////            if (f.getEmail() != null) {
////                mailMessage.setReplyTo(f.getEmail());
////            }
//            String subject = "CCCM Registration Confirmation";
//            String event = "CCCM event";
//
////            if (f.getEventID() == 201201) {
////                subject = "Disciple Training Registration Confirmation";
////                event = "Disciple Training 2012";
////            } else if (f.getEventID() == 201203) {
//            subject = "AIMU Registration Confirmation";
//            event = "Muslim Awareness Weekend 2013";
////            }
//
//            mailMessage.setSubject(subject);
//
//            Map<String, Object> m = new HashMap<String, Object>();
//            m.put("registrationID", savedReg.getFormID());
////            m.put("rname", savedReg.getFirstName() + " " + savedReg.getLastName());
//            m.put("rnames", rnames);
//            m.put("event", event);
////            m.put("gfee", gfee);
////            m.put("mfee", mfee);
////            m.put("subsidy", rfee);
////            m.put("FrDinner", f.getTotalMeal1Fee());
////            m.put("SaLunch", f.getTotalMeal2Fee());
////            m.put("SaDinner", f.getTotalMeal3Fee());
////            m.put("SuLunch", f.getTotalMeal4Fee());
////            m.put("LodgingTotal", f.getTotalLodgingFee());
////            m.put("fsupport", f.getSubsidyAmount());
//            m.put("gTotal", f.getGrandTotal());
//
////            setTemplateName("confirmationLetterChinese.vm");
//            mailEngine.sendMessage(mailMessage, "confirmationLetterTraining.vm", m);
//            logger.debug("Message Sent :" + mailMessage.toString());
//
//        }
//
//        return true;
//    }
    @Override
    public boolean submit(BaseObject form) throws Exception {

        logger.info("Registration submit entering");

        Form f = (Form) form;

        // Setup Form ID (Registration ID)
        String generatedId = DateUtil.getDateTime("MMddHHmmss", new Date());
        logger.debug("Generated Form ID  =" + generatedId);
        f.setFormID(Long.valueOf(generatedId));

        Registration savedReg = null;
//        Double gfee = 0.0;
//        Double mfee = 0.0;
//        Double rfee = 0.0;
//        String rnames = "";
//        Integer fsupport = 0;
//        Integer btotal = 0;
//        Integer ltotal = 0;
//        Integer dtotal = 0;
//
//        Integer atotal = 0;
//        Integer ctotal = 0;
//        Integer ntotal = 0;

        try {

            Registration r = null;
            ArrayList<Long> list = new ArrayList<Long>();

            if ((r = setParticipantData(f)) != null) {

                savedReg = registrationDao.save(r);
//                rnames = savedReg.getFirstName() + " " + savedReg.getLastName() + " " + (savedReg.getChineseName() != null ? savedReg.getChineseName() : "");
                list.add(savedReg.getRegistrationID());

                if ((r = setParticipantData2(f)) != null) {
                    registrationDao.save(r);
                    list.add(r.getRegistrationID());
//                    rnames += "<br/>\n" + r.getFirstName() + " " + r.getLastName() + " " + (r.getChineseName() != null ? r.getChineseName() : "");
                }

                if ((r = setParticipantData3(f)) != null) {
                    registrationDao.save(r);
                    list.add(r.getRegistrationID());
//                    rnames += "<br/>\n" + r.getFirstName() + " " + r.getLastName() + " " + (r.getChineseName() != null ? r.getChineseName() : "");
                }

                if ((r = setParticipantData4(f)) != null) {
                    registrationDao.save(r);
                    list.add(r.getRegistrationID());
//                    rnames += "<br/>\n" + r.getFirstName() + " " + r.getLastName() + " " + (r.getChineseName() != null ? r.getChineseName() : "");
                }

                if ((r = setParticipantData5(f)) != null) {
                    registrationDao.save(r);
                    list.add(r.getRegistrationID());
//                    rnames += "<br/>\n" + r.getFirstName() + " " + r.getLastName() + " " + (r.getChineseName() != null ? r.getChineseName() : "");
                }

                if ((r = setParticipantData6(f)) != null) {
                    registrationDao.save(r);
                    list.add(r.getRegistrationID());
//                    rnames += "<br/>\n" + r.getFirstName() + " " + r.getLastName() + " " + (r.getChineseName() != null ? r.getChineseName() : "");
                }

//                if (f.getSubsidyAmount() != null && f.getSubsidyAmount().length() > 0) {
//
//                    Payment p = new Payment();
//
//                    // Initialize 
//                    p.setCreditCard(false);
//                    p.setPersonalCheck(false);
//                    p.setRefund(false);
//                    p.setCash(false);
//                    p.setPaidByConference(true);
//                    p.setAmount(0.0);
//                    p.setRemarks("Apply financial support " + f.getSubsidyAmount() + "% of $" + f.getGrandTotal());
//
////                    if (f.getPaymentMethod() != null && f.getPaymentMethod().values().length > 0) {
////                        switch (f.getPaymentMethod()) {
////                            case CREDIT_CARD:
////                                p.setCreditCard(true);
////                                break;
////                            case PERSONAL_CHECK:
////                                p.setPersonalCheck(false);
////                                break;
////                            default:
////
////                        }
////                    }
//                    p.setRegistrationID(Long.valueOf(generatedId));
//
//                    paymentDao.save(p);
//                }
                Mealplan plan = new Mealplan();

                plan.setRegistrationID(Long.valueOf(generatedId));

                plan.setBreakfast1(f.getBreakfast1());
                plan.setBreakfast2(f.getBreakfast2());
                plan.setBreakfast3(f.getBreakfast3());
                plan.setBreakfast4(f.getBreakfast4());
                plan.setBreakfast5(f.getBreakfast5());

                plan.setLunch1(f.getLunch1());
                plan.setLunch2(f.getLunch2());
                plan.setLunch3(f.getLunch3());
                plan.setLunch4(f.getLunch4());
                plan.setLunch5(f.getLunch5());

                plan.setDinner1(f.getDinner1());
                plan.setDinner2(f.getDinner2());
                plan.setDinner3(f.getDinner3());
                plan.setDinner4(f.getDinner4());
                plan.setDinner5(f.getDinner5());

                mealplanDao.create(plan);

                if (f.isConsentNeeded()) {

                    Iterator<Long> it = list.iterator();
                    while (it.hasNext()) {
                        Long tid = it.next();

                        Consent consent = new Consent();
                        consent.setGuardianFullName(f.getGuardianFullName());
                        consent.setGuardianEmail(f.getGuardianEmail());
                        consent.setGuardianPhoneNumber(f.getGuardianPhoneNumber());
                        consent.setRegistrationID(Long.valueOf(generatedId));
                        consent.setPersonID(tid);
                        consentDao.create(consent);
                    }
                }
//                if (f.getTotalRegistrationFee() != 0 && f.getTotalRegistrationFee() > 0) {
//                    Payment p = new Payment();
//
//                    // Initialize 
//                    p.setCreditCard(false);
//                    p.setPersonalCheck(false);
//                    p.setRefund(false);
//                    p.setCash(false);
//                    p.setPaidByConference(true);
//                    p.setAmount(f.getTotalRegistrationFee());
//                    p.setRemarks("Church Subsidy");
//                    p.setRegistrationID(Long.valueOf(generatedId));
//
//                    paymentDao.save(p);
//                }
//                gfee = f.getGrandTotal();
//                mfee = (f.getTotalMealsFee() != null ? (double) f.getTotalMealsFee() : 0.0);
//                rfee = (f.getTotalRegistrationFee() != null ? (double) f.getTotalRegistrationFee() : 0.0);
//
//                ltotal = f.getLunchTotal();
//                btotal = f.getBreakfastTotal();
//                dtotal = f.getDinnerTotal();
//
//                atotal = f.getAdultTotal();
//                ctotal = f.getChildrenTotal();
//                ntotal = f.getBabyTotal();

            }

        } catch (DataAccessException de) {
            //cannot create database state
            logger.error("Data Access Error when trying to save Registration form:" + de);
//            Exception e = new Exception("Data Access Error when trying to save Overage Protection request", de);
//            throw e;
            return false;
        }

//        if (mailEngine != null && savedReg != null) {
//
//            logger.debug("Mail Engine:" + mailEngine.toString());
////            SimpleMailMessage mailMessage = null;
////
////            mailMessage = new SimpleMailMessage();
////
////            mailMessage.setFrom("registration@cccm.ws");
////            mailMessage.setBcc("cheh.cccm@gmail.com");
////            mailMessage.setTo(savedReg.getEmail());
//
//            String recipients[] = new String[1];
//            recipients[0] = savedReg.getEmail();
//
//            String subject = "CCCC/GRACE 2012 Registration Confirmation";
////            mailMessage.setSubject(subject);
//
//            Map<String, Object> m = new HashMap<String, Object>();
//            m.put("registrationID", savedReg.getFormID());
////            m.put("rname", savedReg.getFirstName() + " " + savedReg.getLastName());
//            m.put("rnames", rnames);
//            m.put("gfee", gfee);
//            m.put("mfee", mfee);
//            m.put("subsidy", rfee);
//            m.put("brFee", f.getTotalBreakfastFee());
//            m.put("luFee", f.getTotalLunchFee());
//            m.put("diFee", f.getTotalDinnerFee());
////            m.put("LodgingTotal", f.getTotalLodgingFee());
//            m.put("fsupport", f.getSubsidyAmount());
//            m.put("btotal", btotal);
//            m.put("ltotal", ltotal);
//            m.put("dtotal", dtotal);
//            m.put("atotal", atotal);
//            m.put("ntotal", ctotal + ntotal);
//
//            logger.debug(">>>>>>>>>>>> EVENT:" + f.getEventID());
//
//            if (f.getEventID().compareTo(201205) == 0) {
//                if (f.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
//                    setTemplateName("graceConfirmEmail_1.htm");
//                } else {
//                    setTemplateName("graceConfirmEmail_2.htm");
//                }
//
//            } else {
//                if (f.getPaymentMethod() == PaymentMethod.PERSONAL_CHECK) {
//                    setTemplateName("confirmationLetterPayByCheck.htm");
//                } else {
//                    setTemplateName("confirmationLetterPayByCC.htm");
//                }
//            }
//
////            mailEngine.sendMessage(mailMessage, templateName, m);
////            mailEngine.sendMessage(recipients, "registration@cccm.ws", subject, templateName, m);
////            logger.debug("Message Sent :" + savedReg.getEmail());
//        }
        logger.info("Registration submit exiting");

        return true;
    }

    public RegistrationAssessment getRegistrationAssessment(List<Registration> list) {

        RegistrationAssessment a = new RegistrationAssessment();

        if (list.size() > 0) {
            Iterator<Registration> it = list.iterator();

            while (it.hasNext()) {
                Registration r = it.next();

                if (r.getAge().charAt(0) == 'A') {
                    a.setTotalAdult(a.getTotalAdult() + 1);
                } else if (Integer.valueOf(r.getAge()) >= 4) {
                    a.setTotalNonAdult(a.getTotalNonAdult() + 1);
                } else {
                    a.setTotalBaby(a.getTotalBaby() + 1);
                }
            }

            a.setRegistrationDate(list.get(0).getRegistrationDate());
            a.setRegistrationID(list.get(0).getFormID().longValue());

            a.setHomeStreetAddress(list.get(0).getHomeStreetAddress());
            a.setHomeCity(list.get(0).getHomeCity());
            a.setHomeState(list.get(0).getHomeState());
            a.setHomeZipCode(list.get(0).getHomeZipCode());
            a.setHomePhone(list.get(0).getHomePhone());
            a.setEmail(list.get(0).getEmail());

            a.setTotalBreakfast1(list.get(0).getBreakfast1());
            a.setTotalBreakfast2(list.get(0).getBreakfast2());
            a.setTotalBreakfast3(list.get(0).getBreakfast3());
            a.setTotalBreakfast4(list.get(0).getBreakfast4());

            a.setTotalLunch1(list.get(0).getLunch1());
            a.setTotalLunch2(list.get(0).getLunch2());
            a.setTotalLunch3(list.get(0).getLunch3());
            a.setTotalLunch4(list.get(0).getLunch4());

            a.setTotalDinner1(list.get(0).getDinner1());
            a.setTotalDinner2(list.get(0).getDinner2());
            a.setTotalDinner3(list.get(0).getDinner3());
            a.setTotalDinner4(list.get(0).getDinner4());

            // Meals Fee
            a.setBreakfastTotal(a.getTotalBreakfast2() + a.getTotalBreakfast3() + a.getTotalBreakfast4());
            a.setTotalBreakfastFee(a.getBreakfastTotal() * 3);

            a.setLunchTotal(a.getTotalLunch2() + a.getTotalLunch3() + a.getTotalLunch4());
            a.setTotalLunchFee(a.getLunchTotal() * 6);

            a.setDinnerTotal(a.getTotalDinner1() + a.getTotalDinner2() + a.getTotalDinner3());
            a.setTotalDinnerFee(a.getDinnerTotal() * 7);

            a.setTotalMealsFee(a.getTotalBreakfastFee() + a.getTotalLunchFee() + a.getTotalDinnerFee());

//            // Registration Fee Calculation
//            Date now = a.getRegistrationDate();
//            Date regularRegistrationDate = new GregorianCalendar(2010, 12, 07, 23, 59).getTime();
//            Date lateRegistrationDate = new GregorianCalendar(2010, 12, 21, 23, 59).getTime();
//            Integer adultRegistrationFee = 20;
//            Integer nonAdultRegistrationFee = 10;
//            logger.debug("Registration Date:" + now.toString());
//            logger.debug("Regular Registration Date:" + regularRegistrationDate.toString());
//            logger.debug("Late Registration Date:" + lateRegistrationDate.toString());
//
//            if (now.after(lateRegistrationDate)) {
//                adultRegistrationFee = 50;
//                nonAdultRegistrationFee = 25;
//            } else if (now.after(regularRegistrationDate)) {
//                adultRegistrationFee = 40;
//                nonAdultRegistrationFee = 20;
//            }
            a.setTotalAdultRegistrationFee(a.getTotalAdult() * RegistrationUtil.getAdultRegistrationFee(a.getRegistrationDate()).intValue());
            a.setTotalNonAdultRegistrationFee(a.getTotalNonAdult() * RegistrationUtil.getNonAdultRegistrationFee(a.getRegistrationDate()).intValue());
            a.setTotalRegistrationFee(a.getTotalAdultRegistrationFee() + a.getTotalNonAdultRegistrationFee());

            a.setGrandTotal(a.getTotalRegistrationFee() + a.getTotalMealsFee());

        }

        return a;
    }

    public Paypal createPaypalRequest(RegistrationAssessment f) {

        logger.info("createPaypalRequest entering");

        Paypal p = new Paypal();

        p.setCmd("_ext-enter");
        p.setRedirect_cmd("_xclick");
        p.setBusiness("Registration@cccm.ws");
//        p.setBusiness("clhoo_1288811245_biz@msn.com");
        p.setItem_name("Grace 2012/CCCC 2012");
        p.setItem_number(String.valueOf(f.getRegistrationID().longValue()));
//        p.setAmount(String.valueOf(f.getGrandTotal().doubleValue()));
        p.setCustom(String.valueOf(f.getGrandTotal().doubleValue()));
        p.setNo_shipping("0");
        p.setNo_note("1");
        p.setCurrency_code("USD");
        p.setLc("US");
        p.setBn("PP-BuyNowBF");
//        p.setReturn("http://localhost:9090/Registration/confirm.htm");
        p.setReturn("http://cccm.biz/Registration/confirm.htm");
        p.setRm("2");
        p.setEmail(f.getEmail());
        p.setFirst_name("");
        p.setLast_name("");
        p.setAddress1(f.getHomeStreetAddress());
        p.setAddress2("");
        p.setCity(f.getHomeCity());
        p.setState(f.getHomeState());
        p.setZip(f.getHomeZipCode());

        logger.info("createPaypalRequest exiting");

        return p;
    }

    public Paypal createPaypalRequest(Form f) {

        logger.info("createPaypalRequest entering");

        Paypal p = new Paypal();

        p.setCmd("_ext-enter");
//        p.setRedirect_cmd("_xclick");
//        p.setBusiness("Registration@cccm.ws");
////        p.setBusiness("clhoo_1288811245_biz@msn.com");
        p.setItem_name("Toronto Gospel Conference 2015");
//        p.setItem_number(String.valueOf(f.getFormID().longValue()));
//        p.setAmount(String.valueOf(f.getGrandTotal().doubleValue()));
//        p.setCustom(String.valueOf(f.getGrandTotal().doubleValue()));
//        p.setNo_shipping("0");
//        p.setNo_note("1");
//        p.setCurrency_code("USD");
//        p.setLc("US");
//        p.setBn("PP-BuyNowBF");
////        p.setReturn("http://localhost:9090/Registration/confirm.htm");
//        p.setReturn("http://cccm.biz:8084/registration/confirm.htm");
//        p.setNotify_url("http://cccm.biz:8084/registration/instantPaymentNotification.htm");
//        p.setRm("2");
//        p.setEmail(f.getEmail());
//        p.setFirst_name("");
//        p.setLast_name("");
//        p.setAddress1(f.getHomeStreetAddress());
//        p.setAddress2("");
//        p.setCity(f.getHomeCity());
//        p.setState(f.getHomeState());
//        p.setZip(f.getHomeZipCode());
//
//        if (f.getEventID().compareTo(201403) == 0) {
//            p.setReturn("http://cccm.biz:8084/registration/confirmGrace.htm");
//        }
//        logger.info("createPaypalRequest exiting");

        return p;
    }

    public Form initializeForm() {

        logger.info("initialize Form  entering");

        Form f = new Form();
        List<LabelValue> ageGroup;
        ageGroup = new ArrayList<LabelValue>();

        ageGroup.add(new LabelValue("18-29", "A2"));
        ageGroup.add(new LabelValue("30-39", "A3"));
        ageGroup.add(new LabelValue("40-49", "A4"));
        ageGroup.add(new LabelValue("50-59", "A5"));
        ageGroup.add(new LabelValue("60+", "A6"));
        ageGroup.add(new LabelValue("17", "17"));
        ageGroup.add(new LabelValue("16", "16"));
        ageGroup.add(new LabelValue("15", "15"));
        ageGroup.add(new LabelValue("14", "14"));
        ageGroup.add(new LabelValue("13", "13"));
        ageGroup.add(new LabelValue("12", "12"));
        ageGroup.add(new LabelValue("11", "11"));
        ageGroup.add(new LabelValue("10", "10"));
        ageGroup.add(new LabelValue("9", "9"));
        ageGroup.add(new LabelValue("8", "8"));
        ageGroup.add(new LabelValue("7", "7"));
        ageGroup.add(new LabelValue("6", "6"));
        ageGroup.add(new LabelValue("5", "5"));
        ageGroup.add(new LabelValue("4", "4"));
        ageGroup.add(new LabelValue("3", "3"));
        ageGroup.add(new LabelValue("2", "2"));
        ageGroup.add(new LabelValue("1", "1"));
        ageGroup.add(new LabelValue("0", "0"));

        f.setAgeGroup(ageGroup);

        List<LabelValue> months;
        months = new ArrayList<LabelValue>();

        months.add(new LabelValue("January", "01"));
        months.add(new LabelValue("February", "02"));
        months.add(new LabelValue("March", "03"));
        months.add(new LabelValue("April", "04"));
        months.add(new LabelValue("May", "05"));
        months.add(new LabelValue("June", "06"));
        months.add(new LabelValue("July", "07"));
        months.add(new LabelValue("August", "08"));
        months.add(new LabelValue("September", "09"));
        months.add(new LabelValue("October", "10"));
        months.add(new LabelValue("November", "11"));
        months.add(new LabelValue("December", "12"));

        f.setMonths(months);

        List<LabelValue> days;
        days = new ArrayList<LabelValue>();
        days.add(new LabelValue("1", "01"));
        days.add(new LabelValue("2", "02"));
        days.add(new LabelValue("3", "03"));
        days.add(new LabelValue("4", "04"));
        days.add(new LabelValue("5", "05"));
        days.add(new LabelValue("6", "06"));
        days.add(new LabelValue("7", "07"));
        days.add(new LabelValue("8", "08"));
        days.add(new LabelValue("9", "09"));
        days.add(new LabelValue("10", "10"));
        days.add(new LabelValue("11", "11"));
        days.add(new LabelValue("12", "12"));
        days.add(new LabelValue("13", "13"));
        days.add(new LabelValue("14", "14"));
        days.add(new LabelValue("15", "15"));
        days.add(new LabelValue("16", "16"));
        days.add(new LabelValue("17", "17"));
        days.add(new LabelValue("18", "18"));
        days.add(new LabelValue("19", "19"));
        days.add(new LabelValue("20", "20"));
        days.add(new LabelValue("21", "21"));
        days.add(new LabelValue("22", "22"));
        days.add(new LabelValue("23", "23"));
        days.add(new LabelValue("24", "24"));
        days.add(new LabelValue("25", "25"));
        days.add(new LabelValue("26", "26"));
        days.add(new LabelValue("27", "27"));
        days.add(new LabelValue("28", "28"));
        days.add(new LabelValue("29", "29"));
        days.add(new LabelValue("30", "30"));
        days.add(new LabelValue("31", "31"));

        f.setDayOfMonth(days);

        List<LabelValue> relationshipGroup;
        relationshipGroup = new ArrayList<LabelValue>();

        relationshipGroup.add(new LabelValue("H(\u592B)", "H")); // H(?)
        relationshipGroup.add(new LabelValue("W(\u59BB)", "W")); // W(?)
        relationshipGroup.add(new LabelValue("S(\u5B50)", "S")); // S(?)
        relationshipGroup.add(new LabelValue("D(\u5973)", "D")); // D(?) 
        relationshipGroup.add(new LabelValue("F(\u7236)", "F")); // F(?)
        relationshipGroup.add(new LabelValue("M(\u6BCD)", "M")); // M(?)
        relationshipGroup.add(new LabelValue("B(\u5144\u5F1F)", "B")); // B(??)
        relationshipGroup.add(new LabelValue("T(\u59CA\u59B9)", "T")); // T(??)
        relationshipGroup.add(new LabelValue("C(\u540C\u5B66)", "C")); // C(??)
        relationshipGroup.add(new LabelValue("O(\u540C\u4E8B)", "O")); // O(??)

        f.setRelationshipGroup(relationshipGroup);

        List<LabelValue> statusGroup;
        statusGroup = new ArrayList<LabelValue>();

        statusGroup.add(new LabelValue("F(\u5168\u8077\u50B3\u9053)", "F"));
        statusGroup.add(new LabelValue("P(\u6559\u6703\u7267\u8005)", "P"));
        statusGroup.add(new LabelValue("T(\u795E\u5B78\u751F)", "T"));
        statusGroup.add(new LabelValue("N(\u6A5F\u69CB\u540C\u5DE5)", "N"));
        statusGroup.add(new LabelValue("C(\u6821\u5712\u540C\u5DE5)", "C"));
        statusGroup.add(new LabelValue("E(\u6559\u6703\u9577\u57F7)", "E"));
        statusGroup.add(new LabelValue("O(\u6559\u6703\u540C\u5DE5)", "O"));

        f.setStatusGroup(statusGroup);

        List<LabelValue> statusGroup2;
        statusGroup2 = new ArrayList<LabelValue>();

        statusGroup2.add(new LabelValue("Married", "M"));
        statusGroup2.add(new LabelValue("Engaged", "EN"));
        statusGroup2.add(new LabelValue("Single", "S"));
        statusGroup2.add(new LabelValue("Graduate School", "G"));
        statusGroup2.add(new LabelValue("Undergrad   - Sr", "CS"));
        statusGroup2.add(new LabelValue("Undergrad   - Jr", "CJ"));
        statusGroup2.add(new LabelValue("Undergrad   - So", "CO"));
        statusGroup2.add(new LabelValue("Undergrad   - Fr", "CF"));
        statusGroup2.add(new LabelValue("Senior High - Sr", "SS"));
        statusGroup2.add(new LabelValue("Senior High - Jr", "SJ"));
        statusGroup2.add(new LabelValue("Senior High - So", "SO"));
        statusGroup2.add(new LabelValue("Senior High - Fr", "SF"));
        statusGroup2.add(new LabelValue("Junior High - 6th grade", "J6"));
        statusGroup2.add(new LabelValue("Junior High - 7th grade", "J7"));
        statusGroup2.add(new LabelValue("Junior High - 8th grade", "J8"));
        statusGroup2.add(new LabelValue("Toddlers (age 0-3)", "TO"));
        statusGroup2.add(new LabelValue("Elementary (K-5)", "EL"));
        statusGroup2.add(new LabelValue("Other", "O"));
        f.setStatusGroup2(statusGroup2);

        List<LabelValue> stateList;
        stateList = new ArrayList<LabelValue>();

        stateList.add(new LabelValue("Illinois", "IL"));
        stateList.add(new LabelValue("Wisconsin", "WI"));
        stateList.add(new LabelValue("Indiana", "IN"));
        stateList.add(new LabelValue("--------------", "ZZ"));
        stateList.add(new LabelValue("Alabama", "AL"));
        stateList.add(new LabelValue("Alaska", "AK"));
        stateList.add(new LabelValue("Alberta", "AB"));
        stateList.add(new LabelValue("American Samoa", "AS"));
        stateList.add(new LabelValue("Arizona", "AZ"));
        stateList.add(new LabelValue("Arkansas", "AR"));
//        stateList.add(new LabelValue("Armed Forces (AE)", "AE"));
//        stateList.add(new LabelValue("Armed Forces Americas", "AA"));
//        stateList.add(new LabelValue("Armed Forces Pacific", "AP"));
        stateList.add(new LabelValue("British Columbia", "BC"));
        stateList.add(new LabelValue("California", "CA"));
        stateList.add(new LabelValue("Colorado", "CO"));
        stateList.add(new LabelValue("Connecticut", "CT"));
        stateList.add(new LabelValue("Delaware", "DE"));
        stateList.add(new LabelValue("District Of Columbia", "DC"));
        stateList.add(new LabelValue("Florida", "FL"));
        stateList.add(new LabelValue("Georgia", "GA"));
        stateList.add(new LabelValue("Guam", "GU"));
        stateList.add(new LabelValue("Hawaii", "HI"));
        stateList.add(new LabelValue("Idaho", "ID"));
        stateList.add(new LabelValue("Illinois", "IL"));
        stateList.add(new LabelValue("Indiana", "IN"));
        stateList.add(new LabelValue("Iowa", "IA"));
        stateList.add(new LabelValue("Kansas", "KS"));
        stateList.add(new LabelValue("Kentucky", "KY"));
        stateList.add(new LabelValue("Louisiana", "LA"));
        stateList.add(new LabelValue("Maine", "ME"));
        stateList.add(new LabelValue("Manitoba", "MB"));
        stateList.add(new LabelValue("Maryland", "MD"));
        stateList.add(new LabelValue("Massachusetts", "MA"));
        stateList.add(new LabelValue("Michigan", "MI"));
        stateList.add(new LabelValue("Minnesota", "MN"));
        stateList.add(new LabelValue("Mississippi", "MS"));
        stateList.add(new LabelValue("Missouri", "MO"));
        stateList.add(new LabelValue("Montana", "MT"));
        stateList.add(new LabelValue("Nebraska", "NE"));
        stateList.add(new LabelValue("Nevada", "NV"));
        stateList.add(new LabelValue("New Brunswick", "NB"));
        stateList.add(new LabelValue("New Hampshire", "NH"));
        stateList.add(new LabelValue("New Jersey", "NJ"));
        stateList.add(new LabelValue("New Mexico", "NM"));
        stateList.add(new LabelValue("New York", "NY"));
//        stateList.add(new LabelValue("Newfoundland", "NF"));
        stateList.add(new LabelValue("North Carolina", "NC"));
        stateList.add(new LabelValue("North Dakota", "ND"));
//        stateList.add(new LabelValue("Northwest Territories", "NT"));
//        stateList.add(new LabelValue("Nova Scotia", "NS"));
//        stateList.add(new LabelValue("Nunavut", "NU"));
        stateList.add(new LabelValue("Ohio", "OH"));
        stateList.add(new LabelValue("Oklahoma", "OK"));
        stateList.add(new LabelValue("Ontario", "ON"));
        stateList.add(new LabelValue("Oregon", "OR"));
        stateList.add(new LabelValue("Pennsylvania", "PA"));
//        stateList.add(new LabelValue("Prince Edward Island", "PE"));
//        stateList.add(new LabelValue("Puerto Rico", "PR"));
//        stateList.add(new LabelValue("Quebec", "PQ"));
        stateList.add(new LabelValue("Rhode Island", "RI"));
//        stateList.add(new LabelValue("Saskatchewan", "SK"));
        stateList.add(new LabelValue("South Carolina", "SC"));
        stateList.add(new LabelValue("South Dakota", "SD"));
        stateList.add(new LabelValue("Tennessee", "TN"));
        stateList.add(new LabelValue("Texas", "TX"));
        stateList.add(new LabelValue("Utah", "UT"));
        stateList.add(new LabelValue("Vermont", "VT"));
        stateList.add(new LabelValue("Virgin Islands", "VI"));
        stateList.add(new LabelValue("Virginia", "VA"));
        stateList.add(new LabelValue("Washington", "WA"));
        stateList.add(new LabelValue("West Virginia", "WV"));
        stateList.add(new LabelValue("Wisconsin", "WI"));
        stateList.add(new LabelValue("Wyoming", "WY"));
//        stateList.add(new LabelValue("Yukon Territory", "YT"));

        f.setStateList(stateList);

        try {
            Date d = DateUtil.getToday().getTime();
            f.setRegistrationDate(d);
        } catch (ParseException ex) {
            logger.error("Error generating Registration ID");
        }
        
        Person person = new Person();
        f.setRegistrants(new ArrayList<Person>());
        f.getRegistrants().add(person);

        logger.info("initialize Form exiting");

        return f;
    }

    public Registration setParticipantData(Form f) {

        if ((f.getFirstName() != null && f.getFirstName().length() > 0)
                && (f.getLastName() != null && f.getLastName().length() > 0) //                && (f.getAge() != null && f.getAge().length() > 0) //                && (f.getBirthDayOfMonth() != null && f.getBirthDayOfMonth().length() > 0)
                //                                && (f.getBirthMonth() != null && f.getBirthMonth().length() > 0)
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName());
            reg.setFirstName(f.getFirstName());
            reg.setChineseName(f.getChineseName());
            reg.setAge(f.getAge());
            reg.setGender(f.getGender());
            reg.setStatus(f.getStatus());

            reg.setLanguage(f.getLanguage());
            reg.setFaith(f.getFaith() != null && f.getFaith() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear());
            reg.setMisc1(f.getMisc1());
            reg.setMisc2(f.getMisc2());
//            logger.info(f.getSeminars().toString());
            reg.setPersonID(f.getLastName() + f.getBirthMonth() + f.getBirthDayOfMonth());

            String se = ((f.getSeminar1() != null && !f.getSeminar1().isEmpty()) ? f.getSeminar1() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar2() != null && !f.getSeminar2().isEmpty()) ? f.getSeminar2() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar3() != null && !f.getSeminar3().isEmpty()) ? f.getSeminar3() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar4() != null && !f.getSeminar4().isEmpty()) ? f.getSeminar4() : "");

            reg.setSeminar(se);

            return reg;
        } else {
            return null;
        }
    }

    public Registration setParticipantData2(Form f) {

        if ((f.getFirstName2() != null && f.getFirstName2().length() > 0)
                && (f.getLastName2() != null && f.getLastName2().length() > 0)
                && (f.getAge2() != null && f.getAge2().length() > 0) //                && (f.getBirthDayOfMonth2() != null && f.getBirthDayOfMonth2().length() > 0)
                //                && (f.getBirthMonth2() != null && f.getBirthMonth2().length() > 0)
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName2());
            reg.setFirstName(f.getFirstName2());
            reg.setChineseName(f.getChineseName2());
            reg.setAge(f.getAge2());
            reg.setGender(f.getGender2());
            reg.setStatus(f.getStatus2());

            reg.setLanguage(f.getLanguage2());
            reg.setFaith(f.getFaith2() != null && f.getFaith2() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear2());

//            reg.setPersonID(f.getLastName2() + f.getBirthMonth2() + f.getBirthDayOfMonth2());

//            if (f.getSeminars2() != null && !f.getSeminars2().isEmpty()) {
//                Iterator<Seminar> i = f.getSeminars2().iterator();
//                String se = "";
//                while (i.hasNext()) {
//                    if (!se.isEmpty()) {
//                        se += ",";
//                    }
//                    se += (Seminar) i.next();
//                }
//                reg.setSeminar(se);
//            }
            String se = ((f.getSeminar21() != null && !f.getSeminar21().isEmpty()) ? f.getSeminar21() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar22() != null && !f.getSeminar22().isEmpty()) ? f.getSeminar22() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar23() != null && !f.getSeminar23().isEmpty()) ? f.getSeminar23() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar24() != null && !f.getSeminar24().isEmpty()) ? f.getSeminar24() : "");

            reg.setSeminar(se);

            return reg;
        } else {
            return null;
        }
    }

    public Registration setParticipantData3(Form f) {

        if ((f.getFirstName3() != null && f.getFirstName3().length() > 0)
                && (f.getLastName3() != null && f.getLastName3().length() > 0)
                && (f.getAge3() != null && f.getAge3().length() > 0) //                && (f.getBirthDayOfMonth3() != null && f.getBirthDayOfMonth3().length() > 0)
                //                && (f.getBirthMonth3() != null && f.getBirthMonth3().length() > 0) 
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName3());
            reg.setFirstName(f.getFirstName3());
            reg.setChineseName(f.getChineseName3());
            reg.setAge(f.getAge3());
            reg.setGender(f.getGender3());
            reg.setStatus(f.getStatus3());

            reg.setLanguage(f.getLanguage3());
            reg.setFaith(f.getFaith3() != null && f.getFaith3() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear3());

//            reg.setPersonID(f.getLastName3() + f.getBirthMonth3() + f.getBirthDayOfMonth3());

//            if (f.getSeminars3() != null && !f.getSeminars3().isEmpty()) {
//                Iterator<Seminar> i = f.getSeminars3().iterator();
//                String se = "";
//                while (i.hasNext()) {
//                    if (!se.isEmpty()) {
//                        se += ",";
//                    }
//                    se += (Seminar) i.next();
//                }
//                reg.setSeminar(se);
//            }
            String se = ((f.getSeminar31() != null && !f.getSeminar31().isEmpty()) ? f.getSeminar31() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar32() != null && !f.getSeminar32().isEmpty()) ? f.getSeminar32() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar33() != null && !f.getSeminar33().isEmpty()) ? f.getSeminar33() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar34() != null && !f.getSeminar34().isEmpty()) ? f.getSeminar34() : "");

            reg.setSeminar(se);
            return reg;
        } else {
            return null;
        }
    }

    public Registration setParticipantData4(Form f) {

        if ((f.getFirstName4() != null && f.getFirstName4().length() > 0)
                && (f.getLastName4() != null && f.getLastName4().length() > 0)
                && (f.getAge4() != null && f.getAge4().length() > 0) //                && (f.getBirthDayOfMonth4() != null && f.getBirthDayOfMonth4().length() > 0)
                //                && (f.getBirthMonth4() != null && f.getBirthMonth4().length() > 0)
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName4());
            reg.setFirstName(f.getFirstName4());
            reg.setChineseName(f.getChineseName4());
            reg.setAge(f.getAge4());
            reg.setGender(f.getGender4());
            reg.setStatus(f.getStatus4());

            reg.setLanguage(f.getLanguage4());
            reg.setFaith(f.getFaith4() != null && f.getFaith4() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear4());

//            reg.setPersonID(f.getLastName4() + f.getBirthMonth4() + f.getBirthDayOfMonth4());

//            if (f.getSeminars4() != null && !f.getSeminars4().isEmpty()) {
//                Iterator<Seminar> i = f.getSeminars4().iterator();
//                String se = "";
//                while (i.hasNext()) {
//                    if (!se.isEmpty()) {
//                        se += ",";
//                    }
//                    se += (Seminar) i.next();
//                }
//                reg.setSeminar(se);
//            }
            String se = ((f.getSeminar41() != null && !f.getSeminar41().isEmpty()) ? f.getSeminar41() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar42() != null && !f.getSeminar42().isEmpty()) ? f.getSeminar42() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar43() != null && !f.getSeminar43().isEmpty()) ? f.getSeminar43() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar44() != null && !f.getSeminar44().isEmpty()) ? f.getSeminar44() : "");

            reg.setSeminar(se);

            return reg;
        } else {
            return null;
        }
    }

    public Registration setParticipantData5(Form f) {

        if ((f.getFirstName5() != null && f.getFirstName5().length() > 0)
                && (f.getLastName5() != null && f.getLastName5().length() > 0)
                && (f.getAge5() != null && f.getAge5().length() > 0) //                && (f.getBirthDayOfMonth5() != null && f.getBirthDayOfMonth5().length() > 0)
                //                && (f.getBirthMonth5() != null && f.getBirthMonth5().length() > 0)
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName5());
            reg.setFirstName(f.getFirstName5());
            reg.setChineseName(f.getChineseName5());
            reg.setAge(f.getAge5());
            reg.setGender(f.getGender5());
            reg.setStatus(f.getStatus5());

            reg.setLanguage(f.getLanguage5());
            reg.setFaith(f.getFaith5() != null && f.getFaith5() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear5());

//            reg.setPersonID(f.getLastName5() + f.getBirthMonth5() + f.getBirthDayOfMonth5());

//            if (f.getSeminars5() != null && !f.getSeminars5().isEmpty()) {
//                Iterator<Seminar> i = f.getSeminars5().iterator();
//                String se = "";
//                while (i.hasNext()) {
//                    if (!se.isEmpty()) {
//                        se += ",";
//                    }
//                    se += (Seminar) i.next();
//                }
//                reg.setSeminar(se);
//            }
            String se = ((f.getSeminar51() != null && !f.getSeminar51().isEmpty()) ? f.getSeminar51() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar52() != null && !f.getSeminar52().isEmpty()) ? f.getSeminar52() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar53() != null && !f.getSeminar53().isEmpty()) ? f.getSeminar53() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar54() != null && !f.getSeminar54().isEmpty()) ? f.getSeminar54() : "");

            reg.setSeminar(se);

            return reg;
        } else {
            return null;
        }
    }

    public Registration setParticipantData6(Form f) {

        if ((f.getFirstName6() != null && f.getFirstName6().length() > 0)
                && (f.getLastName6() != null && f.getLastName6().length() > 0)
                && (f.getAge6() != null && f.getAge6().length() > 0) //                && (f.getBirthDayOfMonth6() != null && f.getBirthDayOfMonth6().length() > 0)
                //                && (f.getBirthMonth6() != null && f.getBirthMonth6().length() > 0)
                ) {

            Registration reg = setupCommonData(f);

            reg.setLastName(f.getLastName6());
            reg.setFirstName(f.getFirstName6());
            reg.setChineseName(f.getChineseName6());
            reg.setAge(f.getAge6());
            reg.setGender(f.getGender6());
            reg.setStatus(f.getStatus6());

            reg.setLanguage(f.getLanguage6());
            reg.setFaith(f.getFaith6() != null && f.getFaith6() == Faith.BELIEVER ? true : false);
            reg.setFaithYear(f.getFaithYear6());

//            reg.setPersonID(f.getLastName6() + f.getBirthMonth6() + f.getBirthDayOfMonth6());

//            if (f.getSeminars6() != null && !f.getSeminars6().isEmpty()) {
//                Iterator<Seminar> i = f.getSeminars6().iterator();
//                String se = "";
//                while (i.hasNext()) {
//                    if (!se.isEmpty()) {
//                        se += ",";
//                    }
//                    se += (Seminar) i.next();
//                }
//                reg.setSeminar(se);
//            }
            String se = ((f.getSeminar61() != null && !f.getSeminar61().isEmpty()) ? f.getSeminar61() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar62() != null && !f.getSeminar62().isEmpty()) ? f.getSeminar62() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar63() != null && !f.getSeminar63().isEmpty()) ? f.getSeminar63() : "");
            if (se != null && !se.isEmpty()) {
                se += ",";
            }
            se += ((f.getSeminar64() != null && !f.getSeminar64().isEmpty()) ? f.getSeminar64() : "");

            reg.setSeminar(se);

            return reg;
        } else {
            return null;
        }

    }

    public Registration setupCommonData(Form f) {
        // Registration Profile
        Registration r = new Registration();
        r.setEventID(f.getEventID());
        // Family Part
        r.setHomeStreetAddress(f.getHomeStreetAddress());
        r.setHomeCity(f.getHomeCity());
        r.setHomeState(f.getHomeState());
        r.setHomeZipCode(f.getHomeZipCode());
        r.setHomePhone(f.getHomePhone());
        // Church data
        r.setChurchID(BigDecimal.valueOf(f.getChurchID()));
        r.setChurchName(f.getChurchName());
        r.setChurchCity(f.getChurchCity());
        r.setChurchState(f.getChurchState());
        r.setCoordinator(f.getCoordinator());
        // Profile Data
        r.setRegistrationDate(f.getRegistrationDate());
//        r.setPersonID(BigInteger.valueOf(f.getId()));
        r.setFormID(BigDecimal.valueOf(f.getFormID()));
        // Personal data
//        r.setChineseName(f.getChineseName());
        r.setLastName("");
        r.setFirstName("");
//        r.setAge(f.getAge());
//        r.setGender(f.getGender());
//        r.setRelationship(f.getRelationship());
//        r.setStatus(f.getStatus());
//        r.setSeeker(f.getSeeker());
//        r.setFaith(f.getFaith() == Faith.BELIEVER ? true : false);
        r.setCellPhone(f.getCellPhone());
        r.setEmail(f.getEmail());

        r.setBreakfast1(f.getBreakfast1());
        r.setBreakfast2(f.getBreakfast2());
        r.setBreakfast3(f.getBreakfast3());
        r.setBreakfast4(f.getBreakfast4());
        r.setBreakfast5(f.getBreakfast5());

        r.setLunch1(f.getLunch1());
        r.setLunch2(f.getLunch2());
        r.setLunch3(f.getLunch3());
        r.setLunch4(f.getLunch4());
        r.setLunch5(f.getLunch5());

        r.setDinner1(f.getDinner1());
        r.setDinner2(f.getDinner2());
        r.setDinner3(f.getDinner3());
        r.setDinner4(f.getDinner4());
        r.setDinner5(f.getDinner5());
//
        if (f.getVolunteerJobs() != null && !f.getVolunteerJobs().isEmpty()) {
            Iterator<Serve> i = f.getVolunteerJobs().iterator();
            String volunteerJobs = "";
            while (i.hasNext()) {
                volunteerJobs += (Serve) i.next();
                volunteerJobs += " ";
            }
            r.setRemarks(volunteerJobs);
        }

        r.setLodging1(f.getLodging1());
        r.setLodging2(f.getLodging2());
//        r.setLodging3(f.getLodging3());
//        r.setLodging4(f.getLodging4());
//
//        r.setRemarks(f.getRemarks());
        r.setSaturdayPartTime(f.getSaturdayPartTime());
        r.setSundayPartTime(f.getSundayPartTime());
        r.setMondayPartTime(f.getMondayPartTime());
//        if (f.getDiscountCode() != null && f.getDiscountCode().equalsIgnoreCase("cccm11")) {
//            r.setDiscount(true);
//        }
        return r;
    }

//    /**
//     * @param mailEngine the mailEngine to set
//     */
//    public void setMailEngine(MailEngine mailEngine) {
//        this.mailEngine = mailEngine;
//    }
//
//    /**
//     * @param templateName the templateName to set
//     */
//    public void setTemplateName(String templateName) {
//        this.templateName = templateName;
//    }
    /**
     * * RETREAT
     *
     */
    public Registration setRetreatParticipantData(Form f) {

        if ((f.getChineseName() != null && f.getChineseName().length() > 0)
                && (f.getAge() != null && f.getAge().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName());
            reg.setAge(f.getAge());

            reg.setDinner1(Integer.parseInt(f.getSeminar1()));
            reg.setLunch2(Integer.parseInt(f.getSeminar2()));
            reg.setDinner2(Integer.parseInt(f.getSeminar3()));
            reg.setLunch3(Integer.parseInt(f.getSeminar4()));

            return reg;
        } else {
            return null;
        }
    }

    public Registration setRetreatParticipantData2(Form f) {

        if ((f.getChineseName2() != null && f.getChineseName2().length() > 0)
                && (f.getAge2() != null && f.getAge2().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName2());
            reg.setAge(f.getAge2());

            reg.setDinner1(Integer.parseInt(f.getSeminar21()));
            reg.setLunch2(Integer.parseInt(f.getSeminar22()));
            reg.setDinner2(Integer.parseInt(f.getSeminar23()));
            reg.setLunch3(Integer.parseInt(f.getSeminar24()));

            return reg;
        } else {
            return null;
        }
    }

    public Registration setRetreatParticipantData3(Form f) {

        if ((f.getChineseName3() != null && f.getChineseName3().length() > 0)
                && (f.getAge3() != null && f.getAge3().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName3());
            reg.setAge(f.getAge3());

            reg.setDinner1(Integer.parseInt(f.getSeminar31()));
            reg.setLunch2(Integer.parseInt(f.getSeminar32()));
            reg.setDinner2(Integer.parseInt(f.getSeminar33()));
            reg.setLunch3(Integer.parseInt(f.getSeminar34()));

            return reg;
        } else {
            return null;
        }
    }

    public Registration setRetreatParticipantData4(Form f) {

        if ((f.getChineseName4() != null && f.getChineseName4().length() > 0)
                && (f.getAge4() != null && f.getAge4().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName4());
            reg.setAge(f.getAge4());

            reg.setDinner1(Integer.parseInt(f.getSeminar41()));
            reg.setLunch2(Integer.parseInt(f.getSeminar42()));
            reg.setDinner2(Integer.parseInt(f.getSeminar43()));
            reg.setLunch3(Integer.parseInt(f.getSeminar44()));

            return reg;
        } else {
            return null;
        }
    }

    public Registration setRetreatParticipantData5(Form f) {

        if ((f.getChineseName5() != null && f.getChineseName5().length() > 0)
                && (f.getAge5() != null && f.getAge5().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName5());
            reg.setAge(f.getAge5());

            reg.setDinner1(Integer.parseInt(f.getSeminar51()));
            reg.setLunch2(Integer.parseInt(f.getSeminar52()));
            reg.setDinner2(Integer.parseInt(f.getSeminar53()));
            reg.setLunch3(Integer.parseInt(f.getSeminar54()));

            return reg;
        } else {
            return null;
        }
    }

    public Registration setRetreatParticipantData6(Form f) {

        if ((f.getChineseName6() != null && f.getChineseName6().length() > 0)
                && (f.getAge6() != null && f.getAge6().length() > 0)) {

            Registration reg = setupCommonData(f);

            reg.setChineseName(f.getChineseName6());
            reg.setAge(f.getAge6());

            reg.setDinner1(Integer.parseInt(f.getSeminar61()));
            reg.setLunch2(Integer.parseInt(f.getSeminar62()));
            reg.setDinner2(Integer.parseInt(f.getSeminar63()));
            reg.setLunch3(Integer.parseInt(f.getSeminar64()));

            return reg;
        } else {
            return null;
        }
    }

    @Override
    public Fee calculateFee(String familyId) {

        Fee fee = new Fee();

        String searchString = "select r from Registration r where r.formID = '" + familyId + "'";
        List<Registration> list = registrationDao.findRegistrationByQuery(searchString);

        if (list.size() > 0) {

            Iterator<Registration> it = list.iterator();

            while (it.hasNext()) {
                Registration r = it.next();

                if (r.getAge().charAt(0) == 'A') {
                    fee.setAdultHeadcount(fee.getAdultHeadcount() + 1);
                } else if (Integer.valueOf(r.getAge()) >= 4) {
                    fee.setNonAdultHeadcount(fee.getNonAdultHeadcount() + 1);
                } else {
                    fee.setNonAdultXHeadcount(fee.getNonAdultXHeadcount() + 1);
                }
            }

            Double adultRegistrationFee = RegistrationUtil.getAdultRegistrationFee(list.get(0).getRegistrationDate());
            Double nonAdultRegistrationFee = RegistrationUtil.getNonAdultRegistrationFee(list.get(0).getRegistrationDate());
//            }

            fee.setTotalAdultRegistrationFee(fee.getAdultHeadcount() * adultRegistrationFee);
            fee.setTotalNonAdultRegistrationFee(fee.getNonAdultHeadcount() * nonAdultRegistrationFee);

            Mealplan mp = mealplanDao.find(list.get(0).getFormID().longValue());

            fee.setBreakfastCount(mp.getBreakfast1() + mp.getBreakfast2() + mp.getBreakfast3() + mp.getBreakfast4() + mp.getBreakfast5());
            fee.setLunchCount(mp.getLunch1() + mp.getLunch2() + mp.getLunch3() + mp.getLunch4() + mp.getLunch5());
            fee.setDinnerCount(mp.getDinner1() + mp.getDinner2() + mp.getDinner3() + mp.getDinner4() + mp.getDinner5());

            fee.setTotalBreakfastFee(fee.getBreakfastCount() * 5.0);
            fee.setTotalLunchFee(fee.getLunchCount() * 5.0);
            fee.setTotalDinnerFee(fee.getDinnerCount() * 8.0);
        }

        return fee;
    }

}
